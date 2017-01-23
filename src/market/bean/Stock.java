package market.bean;



import javax.persistence.*;
import java.util.Date;


/**
 * Created by LazeL (Valentyn Shapiro) on 22.01.2017.
 */
@Entity
@Table(name = "stock")
public class Stock {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer stockId;

    @ManyToMany
    @Column(name = "supply_details_id")
    private SupplyDetails supplyDetails;


    @ManyToMany
    @Column(name = ("farmer_id"))
    private Farmer farmer;

    @ManyToMany
    @Column(name = ("available_qnt"))
    private Float availableQnt;

    @ManyToMany
    @Column(name = ("sDate"))
    private Date sDate;

    @ManyToMany
    @Column(name = ("sPrice"))
    private Float sPrice;

    public Integer getStockId() {
        return stockId;
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

    public SupplyDetails getSupplyDetails() {
        return supplyDetails;
    }

    public Farmer getFarmer() {
        return farmer;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stock)) return false;

        Stock stock = (Stock) o;

        if (getStockId() != null ? !getStockId().equals(stock.getStockId()) : stock.getStockId() != null) return false;
        if (getSupplyDetails() != null ? !getSupplyDetails().equals(stock.getSupplyDetails()) : stock.getSupplyDetails() != null)
            return false;
        if (getFarmer() != null ? !getFarmer().equals(stock.getFarmer()) : stock.getFarmer() != null) return false;
        if (getAvailableQnt() != null ? !getAvailableQnt().equals(stock.getAvailableQnt()) : stock.getAvailableQnt() != null)
            return false;
        if (getsDate() != null ? !getsDate().equals(stock.getsDate()) : stock.getsDate() != null) return false;
        return getsPrice() != null ? getsPrice().equals(stock.getsPrice()) : stock.getsPrice() == null;
    }

    @Override
    public int hashCode() {
        int result = getStockId() != null ? getStockId().hashCode() : 0;
        result = 31 * result + (getSupplyDetails() != null ? getSupplyDetails().hashCode() : 0);
        result = 31 * result + (getFarmer() != null ? getFarmer().hashCode() : 0);
        result = 31 * result + (getAvailableQnt() != null ? getAvailableQnt().hashCode() : 0);
        result = 31 * result + (getsDate() != null ? getsDate().hashCode() : 0);
        result = 31 * result + (getsPrice() != null ? getsPrice().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockId=" + stockId +
                ", supplyDetails=" + supplyDetails +
                ", farmer=" + farmer +
                ", availableQnt=" + availableQnt +
                ", sDate=" + sDate +
                ", sPrice=" + sPrice +
                '}';
    }
}
