package com.jeizas.dto;

import com.jeizas.entity.Food;
import com.jeizas.entity.Order;

public class CartDTO {
	
	private Integer id;
	private String name;
	private String dsc;
	private Integer count;
	private Integer money;
	 
	public CartDTO(Order o, Food food){
		this.id = o.getId();
		this.name = food.getName();
		this.dsc = food.getDsc();
		this.money = food.getMoney();
		this.count = o.getCount();
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

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	

}
