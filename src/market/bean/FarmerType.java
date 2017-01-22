package market.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "farmertype")
public class FarmerType {
	@Override
	public String toString() {
		return "FarmerType [id=" + id + ", name=" + name + "]";
	}
	public FarmerType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FarmerType(String name) {
		super();
		this.name = name;
	}
	public FarmerType(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	private String name;
	
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

}