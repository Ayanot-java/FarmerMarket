package market.bean;

import javax.persistence.*;

@Entity
@Table(name = "farmertype")
public class FarmerType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	public FarmerType() {}

	public FarmerType(String name) {
		super();
		this.name = name;
	}
	public FarmerType(Integer id, String name) {
		super();
		this.id = id;
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

	@Override
	public String toString() {
		return "FarmerType [id=" + id + ", name=" + name + "]";
	}
}