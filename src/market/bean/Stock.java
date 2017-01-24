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
    private Integer stockId;

    @ManyToMany
    @Column(name = "supply_details_id")
    private Integer supplyDetailsId;


    @ManyToMany
    @Column(name = ("farmer_id"))
    private Integer farmerId;

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

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public Integer getSupplyDetailsId() {
        return supplyDetailsId;
    }

    public void setSupplyDetailsId(Integer supplyDetailsId) {
        this.supplyDetailsId = supplyDetailsId;
    }

    public Integer getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(Integer farmerId) {
        this.farmerId = farmerId;
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stock)) return false;

        Stock stock = (Stock) o;

        if (getStockId() != null ? !getStockId().equals(stock.getStockId()) : stock.getStockId() != null) return false;
        if (getSupplyDetailsId() != null ? !getSupplyDetailsId().equals(stock.getSupplyDetailsId()) : stock.getSupplyDetailsId() != null)
            return false;
        if (getFarmerId() != null ? !getFarmerId().equals(stock.getFarmerId()) : stock.getFarmerId() != null)
            return false;
        if (getAvailableQnt() != null ? !getAvailableQnt().equals(stock.getAvailableQnt()) : stock.getAvailableQnt() != null)
            return false;
        if (getsDate() != null ? !getsDate().equals(stock.getsDate()) : stock.getsDate() != null) return false;
        if (getsPrice() != null ? !getsPrice().equals(stock.getsPrice()) : stock.getsPrice() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = getStockId() != null ? getStockId().hashCode() : 0;
        result = 31 * result + (getSupplyDetailsId() != null ? getSupplyDetailsId().hashCode() : 0);
        result = 31 * result + (getFarmerId() != null ? getFarmerId().hashCode() : 0);
        result = 31 * result + (getAvailableQnt() != null ? getAvailableQnt().hashCode() : 0);
        result = 31 * result + (getsDate() != null ? getsDate().hashCode() : 0);
        result = 31 * result + (getsPrice() != null ? getsPrice().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockId=" + stockId +
                ", supplyDetailsId=" + supplyDetailsId +
                ", farmerId=" + farmerId +
                ", availableQnt=" + availableQnt +
                ", sDate=" + sDate +
                ", sPrice=" + sPrice +
                '}';
    }
}
