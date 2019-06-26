package com.ebusiness.onlineshopping.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity(name="Review")
public class Review implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long id;
	@OneToOne(fetch=FetchType.LAZY)
	private Product product;
	@OneToOne(fetch=FetchType.LAZY)
	private Customer customer;
	@OneToOne(fetch=FetchType.LAZY, orphanRemoval = false)
	private OrderDetails order;
	private int rating;
	private String comments;
	private boolean isActive;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public OrderDetails getOrder() {
		return order;
	}
	public void setOrder(OrderDetails order) {
		this.order = order;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + rating;
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
		Review other = (Review) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (id != other.id)
			return false;
		if (isActive != other.isActive)
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (rating != other.rating)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Review [id=" + id + ", product=" + product + ", customer=" + customer + ", order=" + order + ", rating="
				+ rating + ", comments=" + comments + ", isActive=" + isActive + "]";
	}

	

}
