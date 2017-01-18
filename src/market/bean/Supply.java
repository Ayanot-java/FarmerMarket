package bean;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Tane4ka on 17.01.2017.
 */
@Entity
@Table(name = "supply")
public class Supply {

    private int id;
    private Date date;
    private Farmer farmer;
    private float total;

    @Id @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "sDate")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "farmer")
    public Farmer getFarmer() {
        return farmer;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
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
        if (Float.compare(supply.total, total) != 0) return false;
        if (!date.equals(supply.date)) return false;
        return farmer.equals(supply.farmer);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + date.hashCode();
        result = 31 * result + farmer.hashCode();
        result = 31 * result + (total != +0.0f ? Float.floatToIntBits(total) : 0);
        return result;
    }
}
