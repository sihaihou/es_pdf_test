package com.reyco.kn.core.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/** 
 * @author  reyco
 * @date    2022.03.21
 * @version v1.0.1 
 */
public class Product1 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 830771277104167405L;
	private String name;
	private Integer quantity;
	private BigDecimal unitPrice;
	private BigDecimal discount;
	private BigDecimal amount;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public BigDecimal getDiscount() {
		return discount;
	}
	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}
