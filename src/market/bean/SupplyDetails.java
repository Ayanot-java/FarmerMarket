package market.bean;

import javax.persistence.*;

/**
 * Created by Tane4ka on 17.01.2017.
 */
@Entity
@Table(name = "supplydetails")
public class SupplyDetails {

    private int id;
    private float qnt;
    private float price;
    private int productId;
    private int supplyId;

    public SupplyDetails() {
    }

    public SupplyDetails(int id, float qnt, float price, Product product, Supply supply) {
        this.id = id;
        this.qnt = qnt;
        this.price = price;
        this.productId = productId;
        this.supplyId = supplyId;
    }

    @Id @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "qnt")
    public float getQnt() {
        return qnt;
    }

    public void setQnt(float qnt) {
        this.qnt = qnt;
    }

    @Column(name = "price")
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Column(name = "product")
    public int getProductId() {
        return productId;
    }

    public void setProduct(int product) {
        this.productId = productId;
    }

    @Column(name = "supply")
    public int getSupplyId() {
        return supplyId;
    }

    public void setSupplyId(int supply) {
        this.supplyId = supplyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SupplyDetails)) return false;

        SupplyDetails that = (SupplyDetails) o;

        if (id != that.id) return false;
        if (Float.compare(that.qnt, qnt) != 0) return false;
        if (Float.compare(that.price, price) != 0) return false;
        if (productId != that.productId) return false;
        return supplyId == that.supplyId;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (qnt != +0.0f ? Float.floatToIntBits(qnt) : 0);
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        result = 31 * result + productId;
        result = 31 * result + supplyId;
        return result;
    }
}
