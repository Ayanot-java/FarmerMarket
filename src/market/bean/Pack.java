package market.bean;

import javax.persistence.*;

/**
 * Created by Helen on 17.01.2017.
 */
@Entity
@Table(name= "pack")
public class Pack {
<<<<<<< HEAD
	String test = "fest";
=======

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    public Pack() {
    }

    public Pack(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

>>>>>>> origin/master
}
