package market.bean;


import java.beans.ConstructorProperties;

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
	
	@Column(name = "userid")
	private int userid;

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


	public User(Integer id, String username, String pass, String utype, int userid) {
		super();
		this.id = id;
		this.username = username;
		this.pass = pass;
		this.utype = utype;
		this.userid = userid;
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

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

}