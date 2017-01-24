package market.bean;

import javax.persistence.*;

/**
 * Created by Helen on 17.01.2017.
 */
@Entity
@Table(name = "purchasedetails")
public class PurchaseDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "qnt")
    private Double quantity;

    @Column(name = "pprice")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "pack")
    private Pack pack;

    @ManyToOne
    @JoinColumn(name = "purchase")
    private Purchase purchase;

    @ManyToOne
    @JoinColumn(name = "stock")
    private Stock stock;

    public PurchaseDetails() {
    }

    public PurchaseDetails(Double quantity, Double price, Pack pack, Purchase purchase, Stock stock) {
        this.quantity = quantity;
        this.price = price;
        this.pack = pack;
        this.purchase = purchase;
        this.stock = stock;
    }

    public PurchaseDetails(Purchase purchase) {
        this.purchase = purchase;
    }

    public PurchaseDetails(Stock stock) {
        this.stock = stock;
    }

    public PurchaseDetails(Purchase purchase, Stock stock) {
        this.purchase = purchase;
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Pack getPack() {
        return pack;
    }

    public void setPack(Pack pack) {
        this.pack = pack;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return purchase.toString()+"\n"+ stock.getSupplyDetails().getProduct().getName()+"\n"+getQuantity()+" "+pack.getName()
                +"\nPrice: "+getPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PurchaseDetails)) return false;

        PurchaseDetails that = (PurchaseDetails) o;

        if (!getId().equals(that.getId())) return false;
        if (!getQuantity().equals(that.getQuantity())) return false;
        if (!getPrice().equals(that.getPrice())) return false;
        if (!getPack().equals(that.getPack())) return false;
        if (!getPurchase().equals(that.getPurchase())) return false;
        return getStock().equals(that.getStock());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getQuantity().hashCode();
        result = 31 * result + getPrice().hashCode();
        result = 31 * result + getPack().hashCode();
        result = 31 * result + getPurchase().hashCode();
        result = 31 * result + getStock().hashCode();
        return result;
    }
}
