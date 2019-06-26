package com.ebusiness.onlineshopping.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "orderdetails")
public class OrderDetails implements Serializable{
	
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue
	private long id;
	@OneToOne(fetch=FetchType.LAZY)
	@MapsId
	private Customer customer;
	//@ManyToMany(targetEntity = Product.class, cascade = { CascadeType.ALL })  
	//@JoinTable(name = "OrderDetailsProduct_Mapping",   
	 //           joinColumns = { @JoinColumn(name = "ID_OrderDetails") },   
	  //          inverseJoinColumns = { @JoinColumn(name = "ID_Product") }) 
	@OneToMany(	cascade = CascadeType.ALL, orphanRemoval = false)
	private List<Product> productList;
	private String notes;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + ((productList == null) ? 0 : productList.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetails other = (OrderDetails) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (id != other.id)
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (productList == null) {
			if (other.productList != null)
				return false;
		} else if (!productList.equals(other.productList))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OrderDetails [id=" + id + ", customer=" + customer + ", productList=" + productList
				 + ", notes=" + notes + "]";
	}

	
}
