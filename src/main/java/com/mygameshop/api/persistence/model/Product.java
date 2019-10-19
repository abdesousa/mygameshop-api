package com.mygameshop.api.persistence.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TBL_PRODUCT")
public class Product {

	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	
	@Column(name = "product_nm")
	private String productName;
	
	@Column(name = "create_user_id")
	private String createUserId;

	@Column(name = "product_vl")
	private BigDecimal productValue;
	
	@Column(name = "create_ts")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTs;

	@Column(name = "last_updt_user_id")
	private String lastUpdtUserId;

	@Column(name = "last_updt_ts")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdtTs;
	
	public Product() {
		super();
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public Date getCreateTs() {
		return createTs;
	}

	public void setCreateTs(Date createTs) {
		this.createTs = createTs;
	}

	public String getLastUpdtUserId() {
		return lastUpdtUserId;
	}

	public void setLastUpdtUserId(String lastUpdtUserId) {
		this.lastUpdtUserId = lastUpdtUserId;
	}

	public Date getLastUpdtTs() {
		return lastUpdtTs;
	}

	public void setLastUpdtTs(Date lastUpdtTs) {
		this.lastUpdtTs = lastUpdtTs;
	}

	public BigDecimal getProductValue() {
		return productValue;
	}

	public void setProductValue(BigDecimal productValue) {
		this.productValue = productValue;
	}

}
