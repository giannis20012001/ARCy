package com.lumi.myspringapp.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "Cryptocurrency")
public class Cryptocurrency {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cryptocurrencyID")
	private long cryptocurrencyID;

	@Column(name = "base")
	private String base; //Base currency code

	@Column(name = "target")
	private String target; //Target currency code

	@Column(name = "price")
	private double price; //Volume-weighted price

	@Column(name = "volume")
	private double volume; //Total trade volume for the last 24 hours

	@Column(name = "change")
	private double change; //Past hour price change

	@Column(name = "time_stamp")
	private long timestamp; //Update time in Unix timestamp format

	@Column(name = "success")
	private boolean success; //True or false

	@Column(name = "error")
	private String error; //Error description

	@OneToMany
	@Cascade(value = org.hibernate.annotations.CascadeType.ALL)
	@JoinColumn(name = "cryptocurrencyID")
	@OrderColumn(name = "indx")
	private List<Market> markets;
	//===================================================================
	public Cryptocurrency() {
		//Dummy Constructor

	}

	public Cryptocurrency(long cryptocurrencyID, String base, String target, double price,
			double volume, double change, long timestamp, boolean success, String error, List<Market> markets) {
		this.cryptocurrencyID = cryptocurrencyID;
		this.base = base;
		this.target = target;
		this.price = price;
		this.volume = volume;
		this.change = change;
		this.timestamp = timestamp;
		this.success = success;
		this.error = error;
		this.markets = markets;

	}
	//===================================================================
	//===================================================================
	public long getCryptocurrencyID() {
		return cryptocurrencyID;

	}

	public void setCryptocurrencyID(long cryptocurrencyID) {
		this.cryptocurrencyID = cryptocurrencyID;

	}

	public String getBase() {
		return base;

	}

	public void setBase(String base) {
		this.base = base;

	}

	public String getTarget() {
		return target;

	}

	public void setTarget(String target) {
		this.target = target;

	}

	public double getPrice() {
		return price;

	}

	public void setPrice(double price) {
		this.price = price;

	}

	public double getVolume() {
		return volume;

	}

	public void setVolume(double volume) {
		this.volume = volume;

	}

	public double getChange() {
		return change;

	}

	public void setChange(double change) {
		this.change = change;

	}

	public long getTimestamp() {
		return timestamp;

	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;

	}

	public boolean getSuccess() {
		return success;

	}

	public void setSuccess(boolean success) {
		this.success = success;

	}

	public String getError() {
		return error;

	}

	public void setError(String error) {
		this.error = error;

	}

	public List<Market> getMarkets() {
		return markets;

	}

	public void setMarkets(List<Market> markets) {
		this.markets = markets;

	}

	 @Override
	 public String toString(){
		 return (base + ", " + target + ", " + price +", " + volume + ", " + change + ", "
		 		+ "" + timestamp + ", " + success + ", " + error);

	 }

}






