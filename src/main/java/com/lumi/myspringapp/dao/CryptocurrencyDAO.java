package com.lumi.myspringapp.dao;

import java.util.List;

import com.lumi.myspringapp.model.Cryptocurrency;

public interface CryptocurrencyDAO {
	public void addCryptocurrency(Cryptocurrency cryptocurrency);
    public void updateCryptocurrency(Cryptocurrency cryptocurrency);
    public List<Cryptocurrency> listCryptocurrencies();
    public Cryptocurrency getCryptocurrencyByName(int id);
    public void removeCryptocurrency(int id);

}
