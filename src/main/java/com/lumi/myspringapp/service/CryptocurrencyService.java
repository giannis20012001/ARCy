package com.lumi.myspringapp.service;

import java.util.List;

import com.lumi.myspringapp.model.Cryptocurrency;

public interface CryptocurrencyService {
    public void addCryptocurrency(Cryptocurrency cryptocurrency);
    public void updateCryptocurrency(Cryptocurrency cryptocurrency);
    public List<Cryptocurrency> listCryptocurrencies();
    public Cryptocurrency getCryptocurrencyByID(int id);
    public void removeCryptocurrency(int id);

}
