package cnpm.com.ires.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

import cnpm.com.ires.model.Employee;

/**
 * Created by dinht on 05/05/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "IresDB";

    // Contacts table name
    private static final String TABLE_EMPLOYEES = "employees";


    // Contacts Table Columns names
    private static final String KEY_EMPLOYEE_ID = "id";
    private static final String KEY_EMPLOYEE_NAME = "name";
    private static final String KEY_EMPLOYEE_PHONE = "phone_number";
    private static final String KEY_EMPLOYEE_AVATAR = "avatar";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_EMPLOYEES + "("
                + KEY_EMPLOYEE_ID + " INTEGER PRIMARY KEY," + KEY_EMPLOYEE_NAME + " TEXT,"
                + KEY_EMPLOYEE_PHONE + " TEXT, " + KEY_EMPLOYEE_AVATAR + " INTEGER)";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EMPLOYEES);

        // Create tables again
        onCreate(db);
    }

    // Adding new contact
    public void addEmployee(Employee employee) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_EMPLOYEE_NAME, employee.getName()); // Contact Name
        values.put(KEY_EMPLOYEE_PHONE, employee.getPhoneNumber()); // Contact Phone Number
        values.put(KEY_EMPLOYEE_AVATAR, employee.getAvatar());
        // Inserting Row
        db.insert(TABLE_EMPLOYEES, null, values);
        db.close(); // Closing database connection
    }

    // Updating single contact
    public int updateEmployee(Employee employee) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_EMPLOYEE_NAME, employee.getName());
        values.put(KEY_EMPLOYEE_PHONE, employee.getPhoneNumber());
        values.put(KEY_EMPLOYEE_AVATAR, employee.getAvatar());
        // updating row
        return db.update(TABLE_EMPLOYEES, values, KEY_EMPLOYEE_ID + " = ?",
                new String[]{String.valueOf(employee.getId())});
    }

    // Deleting single contact
    public void deleteEmployee(Employee employee) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_EMPLOYEES, KEY_EMPLOYEE_ID + " = ?",
                new String[]{String.valueOf(employee.getId())});
        db.close();
    }

    public void deleteAllEmployee() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + TABLE_EMPLOYEES);
        db.close();
    }

    // Getting single contact
    public Employee getEmployee(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_EMPLOYEES, new String[]{KEY_EMPLOYEE_ID,
                        KEY_EMPLOYEE_NAME, KEY_EMPLOYEE_PHONE}, KEY_EMPLOYEE_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Employee employee = new Employee(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), Integer.parseInt(cursor.getString(3)));
        // return contact
        return employee;
    }

    // Getting All Contacts
    public ArrayList<Employee> getAllEmployee() {
        ArrayList<Employee> employeeList = new ArrayList<Employee>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_EMPLOYEES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Employee employee = new Employee();
                employee.setId(Integer.parseInt(cursor.getString(0)));
                employee.setName(cursor.getString(1));
                employee.setPhoneNumber(cursor.getString(2));
                employee.setAvatar(Integer.parseInt(cursor.getString(3)));
                // Adding contact to list
                employeeList.add(employee);
            } while (cursor.moveToNext());
        }

        // return contact list
        return employeeList;
    }


    // Getting contacts Count
    public int getEmployeesCount() {
        String countQuery = "SELECT  * FROM " + TABLE_EMPLOYEES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }


}
