package market.bean;



import javax.persistence.*;


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
    @Column(name = "product_id")
    private Product product;


    @ManyToMany
    @Column(name = ("farmer_id"))
    private Farmer farmer;

    @ManyToMany
    @Column(name = ("available_qnt"))
    private Float available_qnt;

    @ManyToMany
    @Column(name = ("sDate"))
    private Date sDate;

    @ManyToMany
    @Column(name = ("sPrice"))
    private Float sPrice;

    public Integer getStockId() {
        return stockId;
    }

    public Float getAvailable_qnt() {

        return available_qnt;
    }

    public void setAvailable_qnt(Float available_qnt) {
        this.available_qnt = available_qnt;
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

    public Product getProduct() {
        return product;
    public SupplyDetails getSupplyDetails() {
        return supplyDetails;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Farmer getFarmer() {
        return farmer;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;

    }


}
