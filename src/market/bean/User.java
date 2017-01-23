package market.bean;


import javax.persistence.*;


@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "username")
	private String username;

	@Column(name = "passwd")
	private String  passwd;

	@Column(name = "utype")
	private String type;

	public User(String username, String  passwd, String type) {
		super();
		this.username = username;
		this. passwd =  passwd;
		this.type = type;
	}
	
	public User(String username, String passwd){
		this.username = username;
		this.passwd =  passwd;
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
		return  passwd;
	}

	public void setPassword(String password) {
		this. passwd = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
