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

    private Product product;
}
