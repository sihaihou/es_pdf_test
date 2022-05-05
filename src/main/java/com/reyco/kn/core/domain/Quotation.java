package com.reyco.kn.core.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/** 
 * @author  reyco
 * @date    2022.03.21
 * @version v1.0.1 
 */
public class Quotation implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5772993646319654357L;
	/**
	 * 年
	 */
	private String year;
	/**
	 * 月
	 */
	private String month;
	/**
	 * 日
	 */
	private String day;
	/**
	 * 客户名称
	 */
	private String customerName;
	/**
	 * 机型
	 */
	private String modeDetail;
	private String customerRequirements;
	/**
	 * 销售团队成员
	 */
	private String salesTeamMember;
	/**
	 * 单位电话
	 */
	private String cellNumber;
	/**
	 * 邮件地址
	 */
	private String emailAddress;
	/**
	 * 销售人
	 */
	private String salesPerson;
	/**
	 * 公司名称
	 */
	private String companyName;
	/**
	 * 报价单时间
	 */
	private String date;
	/**
	 * 报价单过期时间
	 */
	private String quoteExpiry;
	/**
	 * 报价单号
	 */
	private String quoteNumber;
	/**
	 * 
	 */
	private String reference;
	/**
	 * 税码
	 */
	private String gstNumber;
	/**
	 * 商品列表
	 */
	private List<Product> products;
	/**
	 * 商品金额
	 */
	private BigDecimal productAmount;
	/**
	 * 税金额
	 */
	private BigDecimal gstAmount;
	/**
	 * 总金额
	 */
	private BigDecimal totalAmount;
	
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getModeDetail() {
		return modeDetail;
	}
	public void setModeDetail(String modeDetail) {
		this.modeDetail = modeDetail;
	}
	public String getCustomerRequirements() {
		return customerRequirements;
	}
	public void setCustomerRequirements(String customerRequirements) {
		this.customerRequirements = customerRequirements;
	}
	public String getSalesTeamMember() {
		return salesTeamMember;
	}
	public void setSalesTeamMember(String salesTeamMember) {
		this.salesTeamMember = salesTeamMember;
	}
	public String getCellNumber() {
		return cellNumber;
	}
	public void setCellNumber(String cellNumber) {
		this.cellNumber = cellNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getSalesPerson() {
		return salesPerson;
	}
	public void setSalesPerson(String salesPerson) {
		this.salesPerson = salesPerson;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getQuoteExpiry() {
		return quoteExpiry;
	}
	public void setQuoteExpiry(String quoteExpiry) {
		this.quoteExpiry = quoteExpiry;
	}
	public String getQuoteNumber() {
		return quoteNumber;
	}
	public void setQuoteNumber(String quoteNumber) {
		this.quoteNumber = quoteNumber;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getGstNumber() {
		return gstNumber;
	}
	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public BigDecimal getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(BigDecimal productAmount) {
		this.productAmount = productAmount;
	}
	public BigDecimal getGstAmount() {
		return gstAmount;
	}
	public void setGstAmount(BigDecimal gstAmount) {
		this.gstAmount = gstAmount;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	public static class Product implements Serializable {
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
} 
