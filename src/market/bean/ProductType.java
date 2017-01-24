package market.bean;

import javax.persistence.*;

/**
 * Created by Geraltsx on 23.01.2017.
 */
@Entity
@Table(name = "producttype")
public class ProductType {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    //@Column(name = "image")
    private String image;

    public ProductType() {
    }

    public ProductType(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductType that = (ProductType) o;

        if (!name.equals(that.name)) return false;
        if (!id.equals(that.id)) return false;
        return image != null ? image.equals(that.image) : that.image == null;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + (image != null ? image.hashCode() : 0);
        return result;
    }
}