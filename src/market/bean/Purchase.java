package market.bean;
import javax.persistence.*;
import java.util.*;


/**
 * Created by Helen on 17.01.2017.
 */
@Entity
@Table(name = "purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "buyer")
    private Buyer buyer;

    @Column(name = "pdate")
    private Date pDate;

    @Column(name = "total")
    private Float total;

    public Purchase() {
        this.pDate = new Date();
    }

    public Purchase(Buyer buyer) {
        this.pDate = new Date();
        this.buyer = buyer;
    }

    public Purchase(Buyer buyer, Date pDate, Float total) {
        this.buyer = buyer;
        this.pDate = pDate;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Date getPDate() {
        return pDate;
    }

    public void setPDate(Date pDate) {
        this.pDate = pDate;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "";// purchaseDate+"\nBuyer: "+buyer.getBuyerName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Purchase)) return false;

        Purchase purchase = (Purchase) o;

        if (!getId().equals(purchase.getId())) return false;
        if (!getBuyer().equals(purchase.getBuyer())) return false;
        return getPDate().equals(purchase.getPDate());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getBuyer().hashCode();
        result = 31 * result + getPDate().hashCode();
        return result;
    }
}

