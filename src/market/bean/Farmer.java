package market.bean;

import javax.persistence.*;

/**
 * Created by hp comp on 18.01.2017.
 */
@Entity
@Table(name = "farmer", schema = "farmermarket")
public class Farmer {

    private Integer id;
    private String name;
    private String address;
    private String phone;
    private FarmerType ftype;

    public Farmer(String name, FarmerType ftype) {
        this.name = name;
        this.ftype = ftype;
    }

    public Farmer(String name) {
        this.name = name;
        this.address = "121423";
        this.phone = "4fdsgs45";
        this.ftype = null;
    }

    public Farmer() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
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
    @JoinColumn (name = "ftype")
    public FarmerType getFtype() {
        return ftype;
    }

    public void setFtype(FarmerType type) {
        this.ftype = type;
    }

    @Override
    public String toString() {
        return "Farmer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adress='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", type=" + ftype +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Farmer that = (Farmer) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (ftype != null ? !ftype.equals(that.ftype) : that.ftype != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (ftype != null ? ftype.hashCode() : 0);
        return result;
    }
}