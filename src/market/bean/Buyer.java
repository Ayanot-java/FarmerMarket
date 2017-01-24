package market.bean;


import javax.persistence.*;

@Entity
@Table(name = "buyer", schema = "farmermarket")
public class Buyer {
    private Integer id;
    private String name;
    private String address;
    private String phone;
    private BuyerType btype;

    public Buyer() {
        super();
    }

    public Buyer(String name) {
        super();
        this.name = name;
    }

    public Buyer(Integer id, String name, String address, String phone, BuyerType btype) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.btype = btype;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @ManyToOne
    @JoinColumn(name = "btype")
    public BuyerType getBtype() {
        return btype;
    }

    public void setBtype(BuyerType btype) {
        this.btype = btype;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", type=" + btype +
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
        return btype != null ? btype.equals(buyer.btype) : buyer.btype == null;
    }

    @Override
    public int hashCode() {
        Integer result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (btype != null ? btype.hashCode() : 0);
        return result;
    }
}
