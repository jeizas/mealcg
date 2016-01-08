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
 * 用户收藏
 * @author jeizas
 *
 */
@Entity
@Table(name="like", catalog="meal")
public class Like implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer usrId;
	private Integer foodId;
	private Date adate;
	private Integer deleted;
	
	public Like(){
		super();
	}
	
	public Like(Integer usrId, Integer foodId){
		this.usrId = usrId;
		this.deleted = Constants.DELETED_NO;
		this.adate = new Date();
		this.foodId = foodId;
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
	@Column(name="food_id")
	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
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
	@Column(name="usr_id")
	public Integer getUsrId() {
		return usrId;
	}

	public void setUsrId(Integer usrId) {
		this.usrId = usrId;
	}
	
}
