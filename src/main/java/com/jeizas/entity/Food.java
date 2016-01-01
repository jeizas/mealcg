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

@Entity
@Table(name="food", catalog="meal")
public class Food implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public static final String FIELD_ID = "id";
	public static final String FIELD_BUSID = "busId";
	
	public static final Integer PUBLISH_NO = 0;
	public static final Integer PUBLISH_YES = 1;
 
	private Integer id;
	private Integer busId;
	private String  busName;
	private String name;
	private String dsc;
	private Integer money;
	private Integer isNew;
	private Date adate;
	private String img;
	private String addr;
	private Integer publish;
	private Integer deleted;
	
	public Food(){
		super();
	}
	
	public Food(User user){
		this.adate = new Date();
		this.addr = user.getAddr();
		this.busId = user.getId();
		this.busName = user.getName();
		this.publish = PUBLISH_NO;
		this.deleted = Constants.DELETED_NO;
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
	@Column(name="bus_id")
	public Integer getBusId() {
		return busId;
	}

	public void setBusId(Integer busId) {
		this.busId = busId;
	}
	@Column(name="bus_name",length=32)
	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}
	@Column(name="name",length=32)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name="dsc",length=64)
	public String getDsc() {
		return dsc;
	}

	public void setDsc(String dsc) {
		this.dsc = dsc;
	}
	@Column(name="money")
	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}
	@Column(name="is_new")
	public Integer getIsNew() {
		return isNew;
	}

	public void setIsNew(Integer isNew) {
		this.isNew = isNew;
	}
	@Column(name="adate")
	public Date getAdate() {
		return adate;
	}

	public void setAdate(Date adate) {
		this.adate = adate;
	}
	@Column(name="deleted")
	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	@Column(name="img")
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	@Column(name="publish")
	public Integer getPublish() {
		return publish;
	}

	public void setPublish(Integer publish) {
		this.publish = publish;
	}
	@Column(name="addr",length=64)
	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}
