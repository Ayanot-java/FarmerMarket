package market.bean;

import javax.persistence.*;

/**
 * Created by Helen on 17.01.2017.
 */
@Entity
@Table(name = "purchase_details")
public class PurchaseDetails {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer Id;

    @Column(name = "quantity")
    private Double quantity;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    @Column(name = "pack_id")
    private Pack pack;

    @ManyToOne
    @Column(name = "purchase_id")
    private Purchase purchase;

    @ManyToOne
    @Column(name = "purchase_id")
    private SupplyDetails supplyDetails;

    public PurchaseDetails() {
    }

    public PurchaseDetails(Double quantity, Double price, Pack pack, Purchase purchase, SupplyDetails supplyDetails) {
        this.quantity = quantity;
        this.price = price;
        this.pack = pack;
        this.purchase = purchase;
        this.supplyDetails = supplyDetails;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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

    public SupplyDetails getSupplyDetails() {
        return supplyDetails;
    }

    public void setSupplyDetails(SupplyDetails supplyDetails) {
        this.supplyDetails = supplyDetails;
    }

    @Override
    public String toString() {
        return purchase.toString()+"\n"+supplyDetails.getProduct().getName()+"\n"+getQuantity()+" "+pack.getName()
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
        return getSupplyDetails().equals(that.getSupplyDetails());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getQuantity().hashCode();
        result = 31 * result + getPrice().hashCode();
        result = 31 * result + getPack().hashCode();
        result = 31 * result + getPurchase().hashCode();
        result = 31 * result + getSupplyDetails().hashCode();
        return result;
    }
}
