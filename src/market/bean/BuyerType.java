package market.bean;

import javax.persistence.*;

@Entity
@Table(name = "buyertype")
public class BuyerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String name;

    public BuyerType() {
        super();
    }

    public BuyerType(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public BuyerType(String name) {
        super();
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BuyerType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
