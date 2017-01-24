package market.bean;



import javax.persistence.*;
import java.sql.Date;


/**
 * Created by LazeL (Valentyn Shapiro) on 22.01.2017.
 */
@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "supplydetails")
    private SupplyDetails supplyDetails;

    @ManyToOne
    @JoinColumn(name = "farmer")
    private Farmer farmer;

    @Column(name = "availableqnt")
    private Float availableQnt;


    @Column(name = "sdate")
    private Date sDate;


    @Column(name = ("sPrice"))
    private Float sPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SupplyDetails getSupplyDetails() {
        return supplyDetails;
    }

    public void setSupplyDetails(SupplyDetails supplyDetails) {
        this.supplyDetails = supplyDetails;
    }

    public Farmer getFarmer() {
        return farmer;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }

    public Float getAvailableQnt() {
        return availableQnt;
    }

    public void setAvailableQnt(Float availableQnt) {
        this.availableQnt = availableQnt;
    }

    public Date getsDate() {
        return sDate;
    }

    public void setsDate(Date sDate) {
        this.sDate = sDate;
    }

    public Float getsPrice() {
        return sPrice;
    }

    public void setsPrice(Float sPrice) {
        this.sPrice = sPrice;
    }
}