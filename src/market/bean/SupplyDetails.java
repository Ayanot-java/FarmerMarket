package bean;

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
    private Product product;

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
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SupplyDetails)) return false;

        SupplyDetails that = (SupplyDetails) o;

        if (id != that.id) return false;
        if (Float.compare(that.qnt, qnt) != 0) return false;
        if (Float.compare(that.price, price) != 0) return false;
        return product.equals(that.product);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (qnt != +0.0f ? Float.floatToIntBits(qnt) : 0);
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        result = 31 * result + product.hashCode();
        return result;
    }
}
