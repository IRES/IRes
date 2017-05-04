package cnpm.com.ires.model;



/**
 * Created by thuan on 4/21/2017.
 */

public class Employee {
    private int Id;
    private String name;
    private String phoneNumber;
    private  int avatar;


    public Employee(){}
    public Employee(int Id, String name, String phoneNumber, int avatar )
    {
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.Id = Id;
        this.avatar = avatar;
    }
    public Employee( String name, String phoneNumber, int avatar )
    {
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.Id = Id;
        this.avatar = avatar;
    }
    public int getId() {
        return Id;
    }

    public void setId(int employeeId) {
        this.Id = employeeId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }
}
