package market.bean;


import javax.persistence.*;


@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "username")
	private String username;

	@Column(name = "pass")
	private String pass;

	@Column(name = "utype")
	private String utype;

	public User(String username, String pass, String utype) {
		super();
		this.username = username;
		this.pass = pass;
		this.utype = utype;
	}

	public User(String username, String pass){
		this.username = username;
		this.pass = pass;
	}

	public User() {
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String loginName) {
		this.username = loginName;

	}

	public String getPassword() {
		return pass;
	}

	public void setPassword(String password) {
		this.pass = password;
	}

	public String getUtype() {
		return utype;
	}

	public void setUtype(String type) {
		this.utype = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}