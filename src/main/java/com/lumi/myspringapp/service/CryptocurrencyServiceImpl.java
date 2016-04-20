package com.lumi.myspringapp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lumi.myspringapp.dao.CryptocurrencyDAO;
import com.lumi.myspringapp.model.Cryptocurrency;

@Service
public class CryptocurrencyServiceImpl implements CryptocurrencyService {

	private CryptocurrencyDAO cryptocurrencyDAO;

	 public void setCryptocurrencyDAO(CryptocurrencyDAO cryptocurrencyDAO) {
	        this.cryptocurrencyDAO = cryptocurrencyDAO;

	 }

	@Override
	@Transactional
	public void addCryptocurrency(Cryptocurrency cryptocurrency) {
		this.cryptocurrencyDAO.addCryptocurrency(cryptocurrency);

	}

	@Override
	@Transactional
	public void updateCryptocurrency(Cryptocurrency cryptocurrency) {
		this.cryptocurrencyDAO.updateCryptocurrency(cryptocurrency);

	}

	@Override
	@Transactional
	public List<Cryptocurrency> listCryptocurrencies() {
		return this.cryptocurrencyDAO.listCryptocurrencies();

	}

	@Override
	@Transactional
	public Cryptocurrency getCryptocurrencyByID(int id) {
		return this.cryptocurrencyDAO.getCryptocurrencyByName(id);

	}

	@Override
	@Transactional
	public void removeCryptocurrency(int id) {
		this.cryptocurrencyDAO.removeCryptocurrency(id);

	}

}
