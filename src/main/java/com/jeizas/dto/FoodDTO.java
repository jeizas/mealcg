package com.jeizas.dto;

import com.jeizas.entity.Food;
import com.jeizas.entity.Like;
import com.jeizas.entity.Order;
import com.jeizas.entity.User;
import com.jeizas.utils.Constants;

public class FoodDTO {
	
	private Integer id;
	private String name;
	private String url;
	private String addr;
	private String dsc;
	private Integer money;
	private String isCart;
	
	public FoodDTO(){
		super();
	}
	 
	public FoodDTO(Food f){
		this.id = f.getId();
		this.name = f.getName();
		this.dsc = f.getDsc();
		this.money = f.getMoney();
		this.url = Constants.FOOD_URL + f.getId()+"/"+f.getImg();
		this.addr = f.getAddr();
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
	public String getDsc() {
		return dsc;
	}
	public void setDsc(String dsc) {
		this.dsc = dsc;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getIsCart() {
		return isCart;
	}

	public void setIsCart(String isCart) {
		this.isCart = isCart;
	}
	
}
