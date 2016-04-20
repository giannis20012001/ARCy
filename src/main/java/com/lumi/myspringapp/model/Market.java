package com.lumi.myspringapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Market")
public class Market {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "marketID")
	// , unique = true, nullable = false)
	private long marketID;

	@ManyToOne
	@JoinColumn(name = "cryptocurrencyID", nullable = false)
	private Cryptocurrency cryptocurrency;

	@Column(name = "market")
	private String market; // Name of the exchange

	@Column(name = "marketPrice")
	private double marketPrice; // Price on this exchange

	@Column(name = "marketVolume")
	private double marketVolume; // 24h trade volume on this exchange

	@Column(name = "indx")
	private int indx;

	// =======================================================================
	public Market() {
		// Dummy Constructor

	}

	public Market(Long marketID, Cryptocurrency cryptocurrency, String market,
			double marketPrice, double marketVolume) {
		this.marketID = marketID;
		this.cryptocurrency = cryptocurrency;
		this.market = market;
		this.marketPrice = marketPrice;
		this.marketVolume = marketVolume;

	}

	// =======================================================================
	// =======================================================================
	public long getMarketID() {
		return marketID;

	}

	public void setMarketID(long marketID) {
		this.marketID = marketID;

	}

	public Cryptocurrency getCryptocurrency() {
		return cryptocurrency;

	}

	public void setCryptocurrency(Cryptocurrency cryptocurrency) {
		this.cryptocurrency = cryptocurrency;

	}

	public String getMarket() {
		return market;

	}

	public void setMarket(String market) {
		this.market = market;

	}

	public double getMarketPrice() {
		return marketPrice;

	}

	public void setMarketPrice(double marketPrice) {
		this.marketPrice = marketPrice;

	}

	public double getMarketVolume() {
		return marketVolume;

	}

	public void setMarketVolume(double marketVolume) {
		this.marketVolume = marketVolume;

	}

	public void setIndx(int indx) {
		this.indx = indx;

	}

	public int getIndx() {
		return indx;

	}

	@Override
	public String toString() {
		return (market + ", " + marketPrice + ", " + marketVolume);

	}

	@Override
	public boolean equals(Object obj) {
		Market market = (Market) obj;
		if (market.getMarket().equals(this.getMarket()))
			return true;

		return false;
	}

}
