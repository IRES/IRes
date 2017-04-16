package cnpm.com.ires.model;

/**
 * Created by dinht on 15/04/2017.
 */

public class Table {
    private String id;
    private String name;
    private int status;
    private Menu menu;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Table(String id, String name, Menu menu) {
        this.id = id;
        this.name = name;
        this.menu = menu;
    }

    public Table(String id, String name, int status, Menu menu) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.menu = menu;
    }


    public Table() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
