package market.bean;

import javax.persistence.*;

/**
 * Created by Tane4ka on 17.01.2017.
 */
@Entity
@Table (name = "product")
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "Ptype")
    @ManyToOne
    private ProductType ptype;

    @Column(name = "image")
    private String image;

    public Product() {
    }

    public Product(String name, ProductType ptype, String image) {
        this.name = name;
        this.ptype = ptype;
        this.image = image;
    }

    public Product(String name, ProductType ptype) {
        this.name = name;
        this.ptype = ptype;
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

    public ProductType getPtype() {
        return ptype;
    }

    public void setPtype(ProductType ptype) {
        this.ptype = ptype;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String img) {
        this.image = img;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (!name.equals(product.name)) return false;
        if (!ptype.equals(product.ptype)) return false;
        return image.equals(product.image);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        result = 31 * result + ptype.hashCode();
        result = 31 * result + image.hashCode();
        return result;
    }
}