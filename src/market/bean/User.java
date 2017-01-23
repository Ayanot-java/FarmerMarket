package market.bean;


import javax.persistence.*;


import javax.persistence.*;



@Entity
@Table(name = "user")
public class User {

	public User(String userName, String  passwd, String type) {
		super();
		this.userName = userName;
		this. passwd =  passwd;
		this.type = type;
	}
	
	public User(String userName, String passwd){
		this.userName = userName;
		this.passwd =  passwd;
	}
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	
	@Column(name = "userName")


	private String userName;
	
	@Column(name = "passwd")
	private String  passwd;
	@Column(name = "type")
	private String type;

	public String getLoginName() {
		return userName;
	}

	public void setLoginName(String loginName) {
		this.userName = loginName;
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
