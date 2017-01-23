package market.bean;

import javax.persistence.*;

/**
 * Created by hp comp on 18.01.2017.
 */
@Entity
@Table(name = "farmer", schema = "farmermarket")
public class Farmer {
    private int id;
    private String name;
    private String adress;
    private String phone;
    private FarmerType type;

    public Farmer(String name, FarmerType type) {
        this.name = name;
        this.type = type;
    }

    public Farmer(String name) {
        this.name = name;
    }

    public Farmer() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "adress")
    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @ManyToOne
    @JoinColumn (name = "type")
    public FarmerType getType() {
        return type;
    }

    public void setType(FarmerType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Farmer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", phone='" + phone + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Farmer that = (Farmer) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (adress != null ? !adress.equals(that.adress) : that.adress != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
