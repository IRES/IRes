package cnpm.com.ires.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by dinht on 15/04/2017.
 */

public class Menu {
    private String id;
    private Double cost;
    private int countMeal;
    private ArrayList<Meal> listMeal;
    private Date date;
    private  String EmployeeID;

    public Menu() {
    }

    public Menu(String id, Double cost, int countMeal, ArrayList<Meal> listMeal, Date date, String employeeID) {
        this.id = id;
        this.cost = cost;
        this.countMeal = countMeal;
        this.listMeal = listMeal;
        this.date = date;
        EmployeeID = employeeID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public int getCountMeal() {
        return countMeal;
    }

    public void setCountMeal(int countMeal) {
        this.countMeal = countMeal;
    }

    public ArrayList<Meal> getListMeal() {
        return listMeal;
    }

    public void setListMeal(ArrayList<Meal> listMeal) {
        this.listMeal = listMeal;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }
}
