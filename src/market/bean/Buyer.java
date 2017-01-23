package market.bean;


import javax.persistence.*;

@Entity
@Table(name = "buyer", schema = "farmermarket")
public class Buyer {
    private Integer id;
    private String name;
    private String address;
    private String phone;
    private BuyerType type;

    public Buyer() {
    }

    public Buyer(String name) {
        this.name = name;
    }

    public Buyer(Integer id, String name, String address, String phone, BuyerType type) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.type = type;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
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

    public void setAddress(String address) {
        this.address = address;
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
    @JoinColumn(name = "type")
    public BuyerType getType() {
        return type;
    }

    public void setType(BuyerType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Buyer)) return false;

        Buyer buyer = (Buyer) o;

        if (id != buyer.id) return false;
        if (name != null ? !name.equals(buyer.name) : buyer.name != null) return false;
        if (address != null ? !address.equals(buyer.address) : buyer.address != null) return false;
        if (phone != null ? !phone.equals(buyer.phone) : buyer.phone != null) return false;
        return type != null ? type.equals(buyer.type) : buyer.type == null;
    }

    @Override
    public int hashCode() {
        Integer result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
