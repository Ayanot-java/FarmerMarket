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
    @Column(name = "supply_details_id")
    private SupplyDetails supplyDetails;


    @ManyToMany
    @Column(name = ("farmer_id"))
    private Farmer farmer;

    public SupplyDetails getSupplyDetails() {
        return supplyDetails;
    }

    public void setSupplyDetails(SupplyDetails supplyDetails) {
        this.supplyDetails = supplyDetails;
    }

    public Farmer getFarmer() {
        return farmer;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;

    }


}
