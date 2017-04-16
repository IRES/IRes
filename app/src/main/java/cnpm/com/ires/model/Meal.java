package cnpm.com.ires.model;

import android.graphics.drawable.Drawable;
import android.media.Image;

/**
 * Created by dinht on 15/04/2017.
 */

public class Meal {
    private String id;
    private String name;
    private String detail;
    private Double cost;
    private Drawable image;
    private String sale;
    private int count;


    public Meal() {
    }

    public Meal(String id, String name, String detail, Double cost, Drawable image, String sale) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.cost = cost;
        this.image = image;
        this.sale = sale;
        this.count = 0;
    }


    public Meal(String id, String name, String detail, Double cost, Drawable image, String sale, int count) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.cost = cost;
        this.image = image;
        this.sale = sale;
        this.count = count;
    }

    public Meal(String id, String name, String detail, Double cost,  String sale, int count) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.cost = cost;
        this.image = null;
        this.sale = sale;
        this.count = count;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
