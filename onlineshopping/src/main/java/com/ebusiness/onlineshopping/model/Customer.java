package com.ebusiness.onlineshopping.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;;

@Entity(name = "Customer")
public class Customer implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long id;
	private String fname;
	private String lname;
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "customer_id")
	private List<Address> addressList;
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval = false)
	private Address address;
	@JsonFormat(pattern="MM-dd-yyyy")
	private Date birthDate;
	private String emailAddress;
	@OneToOne(fetch = FetchType.LAZY)
	private Login login;

	@JsonIgnore 
	@ManyToMany(targetEntity = Product.class, cascade = { CascadeType.ALL })
	@JoinTable(name = "CustomerProduct_Mapping", joinColumns = {
			@JoinColumn(name = "ID_Customer") }, inverseJoinColumns = { @JoinColumn(name = "ID_Product") })
	private List<Product> productList;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((addressList == null) ? 0 : addressList.hashCode());
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lname == null) ? 0 : lname.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
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
		Customer other = (Customer) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (addressList == null) {
			if (other.addressList != null)
				return false;
		} else if (!addressList.equals(other.addressList))
			return false;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		if (fname == null) {
			if (other.fname != null)
				return false;
		} else if (!fname.equals(other.fname))
			return false;
		if (id != other.id)
			return false;
		if (lname == null) {
			if (other.lname != null)
				return false;
		} else if (!lname.equals(other.lname))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
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
		return "Customer [id=" + id + ", fname=" + fname + ", lname=" + lname + ", addressList=" + addressList
				+ ", address=" + address + ", birthDate=" + birthDate + ", emailAddress=" + emailAddress + ", login="
				+ login + ", productList=" + productList + "]";
	}



	
}
