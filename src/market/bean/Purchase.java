package market.bean;
import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Helen on 17.01.2017.
 */
@Entity
@Table(name = "purchase")
public class Purchase {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer purchaseId;

    @ManyToOne
    @Column(name = "buyer_id")
    private Buyer buyer;

    @Column(name = "purchase_date")
    private Date purchaseDate;

    public Purchase() {
    }

    public Purchase(Buyer buyer, Date purchaseDate) {
        this.buyer = buyer;
        this.purchaseDate = purchaseDate;
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        return purchaseDate+"\nBuyer: "+buyer.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Purchase)) return false;

        Purchase purchase = (Purchase) o;

        if (!getPurchaseId().equals(purchase.getPurchaseId())) return false;
        if (!getBuyer().equals(purchase.getBuyer())) return false;
        return getPurchaseDate().equals(purchase.getPurchaseDate());
    }

    @Override
    public int hashCode() {
        int result = getPurchaseId().hashCode();
        result = 31 * result + getBuyer().hashCode();
        result = 31 * result + getPurchaseDate().hashCode();
        return result;
    }
}

