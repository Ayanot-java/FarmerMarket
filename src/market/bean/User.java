package market.bean;
@Entity
@Table(name = "user")
public class User {

	public User(String loginName, String password, String type) {
		super();
		this.userName = userName;
		this.password = password;
		this.type = type;
	}
	@Id
	@GeneratedValue
	@column(name = "id")
	private int id;
	@column(name = "userName")

	private String userName;
	
	@Column(name = "password")
	private String password;
	@Column(name = "type")
	private String type;

	public String getLoginName() {
		return userName;
	}

	public void setLoginName(String loginName) {
		this.userName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
