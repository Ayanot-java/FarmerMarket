package market.bean;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Tane4ka on 17.01.2017.
 */
@Entity
@Table(name = "supply")
public class Supply {


    private int id;
    private String date;
    private int idFarmer;
    private float total;

    public Supply() {
    }

    public Supply(int id, String date, Farmer farmer) {
        this.id = id;
        this.date = date;
        this.idFarmer = idFarmer;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "sDate")
    public String getDate() {
        return date;
    }

    public void setDate(String  date) {
        this.date = date;
    }

    @Column(name = "farmer")
    public int getFarmer() {
        return idFarmer;
    }

    public void setFarmer(int idFarmer) {
        this.idFarmer= idFarmer;
    }

    @Column(name = "total")
    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Supply)) return false;

        Supply supply = (Supply) o;

        if (id != supply.id) return false;
        if (idFarmer != supply.idFarmer) return false;
        if (Float.compare(supply.total, total) != 0) return false;
        return date.equals(supply.date);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + date.hashCode();
        result = 31 * result + idFarmer;
        result = 31 * result + (total != +0.0f ? Float.floatToIntBits(total) : 0);
        return result;
    }
}
