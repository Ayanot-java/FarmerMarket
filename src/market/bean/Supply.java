package market.bean;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Tane4ka on 17.01.2017.
 */
@Entity
@Table(name = "supply")
public class Supply {


    private Integer id;
    private Date sDate;
    private Farmer farmer;
    private Float total;

    public Supply() {
    }

    public Supply(Farmer farmer) {
        sDate = new Date();
        this.farmer = farmer;
    }

    public Supply(Integer id, Date sDate, Farmer farmer) {
        this.id = id;
        this.sDate = sDate;
        this.farmer = farmer;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "sdate")
    public Date getSdate() {
        return sDate;
    }

    public void setSdate(Date sDate) {
        this.sDate = sDate;
    }

    @ManyToOne
    @JoinColumn(name = "farmer")
    public Farmer getFarmer() {
        return farmer;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }

    @Column(name = "total")
    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Supply)) return false;

        Supply supply = (Supply) o;

        if (id != supply.id) return false;
        if (Float.compare(supply.total, total) != 0) return false;
        if (!sDate.equals(supply.sDate)) return false;
        return farmer.equals(supply.farmer);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + sDate.hashCode();
        result = 31 * result + farmer.hashCode();
        result = 31 * result + (total != +0.0f ? Float.floatToIntBits(total) : 0);
        return result;
    }
}