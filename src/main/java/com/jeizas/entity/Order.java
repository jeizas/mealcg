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
 * 购物车
 * @author jeizas
 *
 */
@Entity
@Table(name = "order", catalog = "meal")
public class Order implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public static final String FIELD_ID = "id";
	public static final String FIELD_USR_ID = "usrId";

	private Integer id;
	private Integer usrId;
	private Integer foodId;
	private Integer count;
	private Date adate;
	private Integer isPay;
	private Integer deleted;
	
	public Order(){
		super();
	}
	
	public Order(Integer usrId, Integer foodId){
		this.usrId = usrId;
		this.foodId = foodId;
		this.count = 1;
		this.adate = new Date();
		this.isPay = Constants.NO;
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
	@Column(name="usr_id")
	public Integer getUsrId() {
		return usrId;
	}

	public void setUsrId(Integer usrId) {
		this.usrId = usrId;
	}
	@Column(name="food_id")
	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}
	@Column(name="count")
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	@Column(name="adate")
	public Date getAdate() {
		return adate;
	}

	public void setAdate(Date adate) {
		this.adate = adate;
	}
	@Column(name="is_pay")
	public Integer getIsPay() {
		return isPay;
	}

	public void setIsPay(Integer isPay) {
		this.isPay = isPay;
	}
	@Column(name="deleted")
	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	
	
}
