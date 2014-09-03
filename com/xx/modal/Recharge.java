package com.xx.modal;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_Recharge")
public class Recharge {

	private int id;//id
	private Cardinfo card;
	private BigDecimal money;
	private String time;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@ManyToOne( fetch = FetchType.EAGER,cascade = {CascadeType.REFRESH})
	@JoinColumn(name="card",nullable = false)   
	public Cardinfo getCard() {
		return card;
	}
	public void setCard(Cardinfo card) {
		this.card = card;
	}
	
	@Column(precision=10,scale=2,nullable = true)
	public BigDecimal getMoney() {
		return money;
	}
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	
	@Column(length=20)
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
}
