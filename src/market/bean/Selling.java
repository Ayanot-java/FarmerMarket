package market.bean;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Tane4ka on 17.01.2017.
 */
@Entity
@Table(name = "selling")
public class Selling {
    private int id;
    private Farmer farmer;
    private Date data;
    private Double total;
    private Double paid;

    @Id @GeneratedValue
    @Column(name = "id")
    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    @Basic
    @Column(name = "farmer")
    public Farmer getFarmer() {
        return farmer;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }

    @Basic
    @Column(name = "data")
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Basic
    @Column(name = "total")
    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Basic
    @Column(name = "paid")
    public Double getPaid() {
        return paid;
    }

    public void setPaid(Double paid) {
        this.paid = paid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Selling that = (Selling) o;

        if (id != that.id) return false;
        if (farmer != null ? !farmer.equals(that.farmer) : that.farmer != null) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (total != null ? !total.equals(that.total) : that.total != null) return false;
        if (paid != null ? !paid.equals(that.paid) : that.paid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (farmer != null ? farmer.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (paid != null ? paid.hashCode() : 0);
        return result;
    }
}
