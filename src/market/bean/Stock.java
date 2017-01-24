package market.bean;



import javax.persistence.*;


/**
 * Created by LazeL (Valentyn Shapiro) on 22.01.2017.
 */
@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "supplydetails")
    private SupplyDetails supplyDetails;

    @Column(name = "available")
    private Float availableQnt;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SupplyDetails getSupplyDetails() {
        return supplyDetails;
    }

    public void setSupplyDetails(SupplyDetails supplyDetails) {
        this.supplyDetails = supplyDetails;
    }

    public Float getAvailableQnt() {
        return availableQnt;
    }

    public void setAvailableQnt(Float availableQnt) {
        this.availableQnt = availableQnt;
    }


}