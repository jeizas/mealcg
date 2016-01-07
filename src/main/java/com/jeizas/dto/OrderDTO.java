package com.jeizas.dto;

import com.jeizas.entity.Food;
import com.jeizas.entity.Like;
import com.jeizas.entity.Order;
import com.jeizas.entity.User;

public class OrderDTO {
	
	private Integer id;
	private String name;
	private String url;
	private String addr;
	private String dsc;
	private Integer money;
	private String user;
	private String state;
	
	public OrderDTO(){
		super();
	}
	 
	public OrderDTO(Order o, Food food, User user){
		this.id = o.getId();
		this.name = food.getName();
		this.dsc = food.getDsc();
		this.money = food.getMoney();
		this.url = "/resource/mealface/"+food.getId()+"/"+food.getImg();
		this.user = user.getNick()+" "+user.getPhone();
		this.addr = user.getAddr();
		switch(o.getState()){
		    case 0: this.state = "待店铺接单";break;
		    case 1: this.state = "店铺已接单";break;
		    case 2: this.state = "订单已完成";break;
		    case 3: this.state = "店铺已拒单";break;
		}
	}
	
	public OrderDTO(Like l, Food food, User user){
		this.id = l.getId();
		this.name = food.getName();
		this.dsc = food.getDsc();
		this.money = food.getMoney();
		this.url = "/resource/mealface/"+food.getId()+"/"+food.getImg();
		this.user = user.getNick()+" "+user.getPhone();
		this.addr = user.getAddr();
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

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
