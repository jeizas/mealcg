package com.jeizas.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jeizas.utils.Constants;

/**
 * 用户表
 */
@Entity
@Table(name = "user", catalog = "meal")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	public static final String FIELD_ID = "id";
	
	public static final Integer TYPE_DEFAULT = 0;
	public static final Integer TYPE_USER = 1;
	public static final Integer TYPE_BUSINESS = 2;
	
	public static final Integer FLAG_NO = 0;
	public static final Integer FLAG_YES = 1;
	
	private Integer id;
	private String name;
	private String nick;
	private String pwd;
	private String addr;
	private String phone;
	private String email;
	private String loginIp;
	private Date sdate;
	private Integer grpId;
	private Integer flag;
	private Integer deleted;
	
	public User(){
		super();
	}
	public User(String email, String pwd, String loginIp){
		this.email = email;
		this.pwd = pwd;
		this.grpId = 0;
		this.loginIp = loginIp;
		this.sdate = new Date();
		this.deleted = Constants.DELETED_NO;
		this.nick = email.split("@")[0];
		this.grpId = TYPE_DEFAULT;
		this.flag = FLAG_NO;
		this.phone = "130000000";
		this.addr = "沈阳";
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "name",length=64)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "nick",length=32)
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	@Column(name = "pwd")
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Column(name = "addr",length=64)
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	@Column(name = "phone",length=11)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Column(name = "email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "login_ip")
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
			this.loginIp = loginIp;
	}
	@Column(name = "grp_id")
	public Integer getGrpId() {
		return grpId;
	}
	public void setGrpId(Integer grpId) {
		this.grpId = grpId;
	}
	@Column(name = "flag")
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	@Column(name = "sdate")
	public Date getSdate() {
		return sdate;
	}
	public void setSdate(Date sdate) {
		this.sdate = sdate;
	}
	@Column(name = "deleted")
	public Integer getDeleted() {
		return deleted;
	}
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
}
