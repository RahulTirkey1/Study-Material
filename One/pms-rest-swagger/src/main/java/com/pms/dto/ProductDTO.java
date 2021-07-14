package com.pms.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@XmlRootElement(name="product")
@XmlAccessorType(XmlAccessType.NONE)
@ApiModel(description="This DTO is used to transfer a product data")
public class ProductDTO   implements  java.io.Serializable {
	
	@XmlElement
	@ApiModelProperty(notes="This is id of a product, which uniquely identifies a product")
	private  Integer  productId;

	@XmlElement
	@ApiModelProperty(notes="This is a name of a product")
	private  String  productName;
	
	@XmlElement
	@ApiModelProperty(notes="price of a product")
	private  Double  price;
	
	@XmlElement
	@ApiModelProperty(notes="manufacturing company of a product")
	private  String   manufacturer;

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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	

}
