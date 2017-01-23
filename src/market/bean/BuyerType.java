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
    }

    public BuyerType(int id, String name) {
        this.id = id;
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
