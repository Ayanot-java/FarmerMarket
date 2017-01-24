package market.bean;

import javax.persistence.*;

/**
 * Created by Tane4ka on 17.01.2017.
 */
@Entity
@Table(name = "supplydetails")
public class SupplyDetails {

    private Integer id;
    private Float qnt;
    private Float sprice;
    private Product product;
    private Supply supply;
    private Pack pack;

    public SupplyDetails() {
    }

    public SupplyDetails(Integer id, Float qnt, Float sprice, Product product, Supply supply, Pack pack) {
        this.id = id;
        this.qnt = qnt;
        this.sprice = sprice;
        this.product = product;
        this.supply = supply;
        this.pack = pack;
    }

    public SupplyDetails(Float qnt, Float sprice, Product product, Supply supply, Pack pack) {
        this.qnt = qnt;
        this.sprice = sprice;
        this.product = product;
        this.supply = supply;
        this.pack = pack;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "qnt")
    public Float getQnt() {
        return qnt;
    }

    public void setQnt(Float qnt) {
        this.qnt = qnt;
    }

    @Column(name = "sprice")
    public Float getSprice() {
        return sprice;
    }

    public void setSprice(Float price) {
        this.sprice = price;
    }

    @ManyToOne
    @JoinColumn(name = "product")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne
    @JoinColumn(name = "supply")
    public Supply getSupply() {
        return supply;
    }

    public void setSupply(Supply supply) {
        this.supply = supply;
    }

    @ManyToOne
    @JoinColumn(name = "pack")
    public Pack getPack() {
        return pack;
    }

    public void setPack(Pack pack) {
        this.pack = pack;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SupplyDetails)) return false;

        SupplyDetails that = (SupplyDetails) o;

        if (id != that.id) return false;
        if (Float.compare(that.qnt, qnt) != 0) return false;
        if (Float.compare(that.sprice, sprice) != 0) return false;
        if (!product.equals(that.product)) return false;
        if (!pack.equals(that.pack)) return false;
        return supply.equals(that.supply);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (qnt != +0.0f ? Float.floatToIntBits(qnt) : 0);
        result = 31 * result + (sprice != +0.0f ? Float.floatToIntBits(sprice) : 0);
        result = 31 * result + product.hashCode();
        result = 31 * result + supply.hashCode();
        result = 31 * result + pack.hashCode();
        return result;
    }
}