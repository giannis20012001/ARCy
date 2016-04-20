package com.lumi.myspringapp.worker;

import java.net.URL;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.lumi.myspringapp.model.Cryptocurrency;
import com.lumi.myspringapp.model.Market;

public class MasterDataLoader extends Thread{
	private URL url = null;
	private SessionFactory sessionFactory = HibernateAnnotationUtil.getSessionFactory();
	private Session session = null;
	private Transaction tx = null;
	//====================================================================================
	private Cryptocurrency bitCoin = new Cryptocurrency();
	private Cryptocurrency ripple = new Cryptocurrency();
	private Cryptocurrency liteCoin = new Cryptocurrency();
	private Cryptocurrency bitShares = new Cryptocurrency();
	private Cryptocurrency counterParty = new Cryptocurrency();
	private Cryptocurrency dogeCoin = new Cryptocurrency();
	private Cryptocurrency NXT = new Cryptocurrency();
	private Cryptocurrency peerCoin = new Cryptocurrency();
	private Cryptocurrency darkCoin = new Cryptocurrency();
	private Cryptocurrency nameCoin = new Cryptocurrency();
	private Cryptocurrency stellar = new Cryptocurrency();
	private Cryptocurrency banxShares = new Cryptocurrency();
	private Cryptocurrency monero = new Cryptocurrency();
	private Cryptocurrency blackCoin = new Cryptocurrency();
	private Cryptocurrency nubits = new Cryptocurrency();
	private Cryptocurrency bitCoinDark = new Cryptocurrency();
	private Cryptocurrency fuelCoin = new Cryptocurrency();
	private Cryptocurrency masterCoin = new Cryptocurrency();
	private Cryptocurrency featherCoin = new Cryptocurrency();
	private Cryptocurrency byteCoin = new Cryptocurrency();
	//====================================================================================
	//====================================================================================
	@Override
	public void run(){
		bitCoin.setMarkets(new ArrayList<Market>());
		ripple.setMarkets(new ArrayList<Market>());
		liteCoin.setMarkets(new ArrayList<Market>());
		bitShares.setMarkets(new ArrayList<Market>());
		counterParty.setMarkets(new ArrayList<Market>());
		dogeCoin.setMarkets(new ArrayList<Market>());
		NXT.setMarkets(new ArrayList<Market>());
		peerCoin.setMarkets(new ArrayList<Market>());
		darkCoin.setMarkets(new ArrayList<Market>());
		nameCoin.setMarkets(new ArrayList<Market>());
		stellar.setMarkets(new ArrayList<Market>());
		banxShares.setMarkets(new ArrayList<Market>());
		monero.setMarkets(new ArrayList<Market>());
		blackCoin.setMarkets(new ArrayList<Market>());
		nubits.setMarkets(new ArrayList<Market>());
		bitCoinDark.setMarkets(new ArrayList<Market>());
		fuelCoin.setMarkets(new ArrayList<Market>());
		masterCoin.setMarkets(new ArrayList<Market>());
		featherCoin.setMarkets(new ArrayList<Market>());
		byteCoin.setMarkets(new ArrayList<Market>());
		try {
			firstRun();

		}
		catch (Exception e) {
			System.out.println(e.getMessage());

		}
		while(true){
			try {
				updateDB();
				Thread.sleep(30000);

			}
			catch (Exception e) {
			System.out.println(e.getMessage());

			}

		}

	}

	public void updateDB() throws Exception {
		//===================================================================================
		//===================================================================================
		try {

			//Bitcoin Feed
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			url = new URL(CryptocurrencyFeeds.BITCOIN_FEED);
			bitCoin = JsonToObject.startTransform(bitCoin, url);
			session.saveOrUpdate(bitCoin);
			tx.commit();

			//Ripple Feed
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			url = new URL(CryptocurrencyFeeds.RIPPLE_FEED);
			ripple = JsonToObject.startTransform(ripple, url);
			session.saveOrUpdate(ripple);
			tx.commit();

			//Litecoin Feed
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			url = new URL(CryptocurrencyFeeds.LITECOIN_FEED);
			liteCoin = JsonToObject.startTransform(liteCoin, url);
			session.saveOrUpdate(liteCoin);
			tx.commit();

			//Bitshares Feed
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			url = new URL(CryptocurrencyFeeds.BITSHARES_FEED);
			bitShares = JsonToObject.startTransform(bitShares, url);
			session.saveOrUpdate(bitShares);
			tx.commit();

			//Counterparty Feed
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			url = new URL(CryptocurrencyFeeds.COUNTERPARTY_FEED);
			counterParty = JsonToObject.startTransform(counterParty, url);
			session.saveOrUpdate(counterParty);
			tx.commit();

			//Dogecoin Feed
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			url = new URL(CryptocurrencyFeeds.DOGECOIN_FEED);
			dogeCoin = JsonToObject.startTransform(dogeCoin, url);
			session.saveOrUpdate(dogeCoin);
			tx.commit();

			//NXT Feed
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			url = new URL(CryptocurrencyFeeds.NXT_FEED);
			NXT = JsonToObject.startTransform(NXT, url);
			session.saveOrUpdate(NXT);
			tx.commit();

			//Peercoin Feed
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			url = new URL(CryptocurrencyFeeds.PEERCOIN_FEED);
			peerCoin = JsonToObject.startTransform(peerCoin, url);
			session.saveOrUpdate(peerCoin);
			tx.commit();

			//Darkcoin Feed
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			url = new URL(CryptocurrencyFeeds.DARKCOIN_FEED);
			darkCoin = JsonToObject.startTransform(darkCoin, url);
			session.saveOrUpdate(darkCoin);
			tx.commit();

			//Namecoin Feed
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			url = new URL(CryptocurrencyFeeds.NAMECOIN_FEED);
			nameCoin = JsonToObject.startTransform(nameCoin, url);
			session.saveOrUpdate(nameCoin);
			tx.commit();

			//Stellar Feed
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			url = new URL(CryptocurrencyFeeds.STELLAR_FEED);
			stellar = JsonToObject.startTransform(stellar, url);
			session.saveOrUpdate(stellar);
			tx.commit();

			//Banxshares Feed
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			url = new URL(CryptocurrencyFeeds.BANXSHARES_FEED);
			banxShares = JsonToObject.startTransform(banxShares, url);
			session.saveOrUpdate(banxShares);
			tx.commit();

			//Monero Feed
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			url = new URL(CryptocurrencyFeeds.MONERO_FEED);
			monero = JsonToObject.startTransform(monero, url);
			session.saveOrUpdate(monero);
			tx.commit();

			//Blackcoin Feed
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			url = new URL(CryptocurrencyFeeds.BLACKCOIN_FEED);
			blackCoin = JsonToObject.startTransform(blackCoin, url);
			session.saveOrUpdate(blackCoin);
			tx.commit();

			//Nubits Feed
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			url = new URL(CryptocurrencyFeeds.NUBITS_FEED);
			nubits = JsonToObject.startTransform(nubits, url);
			session.saveOrUpdate(nubits);
			tx.commit();

			//BitcoinDark Feed
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			url = new URL(CryptocurrencyFeeds.BITCOINDARK_FEED);
			bitCoinDark = JsonToObject.startTransform(bitCoinDark, url);
			session.saveOrUpdate(bitCoinDark);
			tx.commit();

			//Fuelcoin Feed
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			url = new URL(CryptocurrencyFeeds.FUELCOIN_FEED);
			fuelCoin = JsonToObject.startTransform(fuelCoin, url);
			session.saveOrUpdate(fuelCoin);
			tx.commit();

			//Mastercoin Feed
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			url = new URL(CryptocurrencyFeeds.MASTERCOIN_FEED);
			masterCoin = JsonToObject.startTransform(masterCoin, url);
			session.saveOrUpdate(masterCoin);
			tx.commit();

			//Feathercoin Feed
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			url = new URL(CryptocurrencyFeeds.FEATHERCOIN_FEED);
			featherCoin = JsonToObject.startTransform(featherCoin, url);
			session.saveOrUpdate(featherCoin);
			tx.commit();

			//Bytecoin Feed
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			url = new URL(CryptocurrencyFeeds.BYTECOIN_FEED);
			byteCoin = JsonToObject.startTransform(byteCoin, url);
			session.saveOrUpdate(byteCoin);
			tx.commit();

		}
		catch (Exception ex) {
		    // Log the exception here
		    tx.rollback();
		    throw ex;

		}
		finally {
			//HibernateAnnotationUtil.closeSessionFactory();

		}

	}

	public void firstRun() throws Exception {
		//===================================================================================
		//===================================================================================
		try {

			//Bitcoin Feed
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			url = new URL(CryptocurrencyFeeds.BITCOIN_FEED);
			bitCoin = JsonToObject.startFirtTimeTransform(bitCoin, url);
			session.saveOrUpdate(bitCoin);
			tx.commit();

			//Ripple Feed
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			url = new URL(CryptocurrencyFeeds.RIPPLE_FEED);
			ripple = JsonToObject.startFirtTimeTransform(ripple, url);
			session.saveOrUpdate(ripple);
			tx.commit();

			//Litecoin Feed
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			url = new URL(CryptocurrencyFeeds.LITECOIN_FEED);
			liteCoin = JsonToObject.startFirtTimeTransform(liteCoin, url);
			session.saveOrUpdate(liteCoin);
			tx.commit();

			//Bitshares Feed
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			url = new URL(CryptocurrencyFeeds.BITSHARES_FEED);
			bitShares = JsonToObject.startFirtTimeTransform(bitShares, url);
			session.saveOrUpdate(bitShares);
			tx.commit();

			//Counterparty Feed
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			url = new URL(CryptocurrencyFeeds.COUNTERPARTY_FEED);
			counterParty = JsonToObject.startFirtTimeTransform(counterParty, url);
			session.saveOrUpdate(counterParty);
			tx.commit();

			//Dogecoin Feed
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			url = new URL(CryptocurrencyFeeds.DOGECOIN_FEED);
			dogeCoin = JsonToObject.startFirtTimeTransform(dogeCoin, url);
			session.saveOrUpdate(dogeCoin);
			tx.commit();

			//NXT Feed
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			url = new URL(CryptocurrencyFeeds.NXT_FEED);
			NXT = JsonToObject.startFirtTimeTransform(NXT, url);
			session.saveOrUpdate(NXT);
			tx.commit();

			//Peercoin Feed
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			url = new URL(CryptocurrencyFeeds.PEERCOIN_FEED);
			peerCoin = JsonToObject.startFirtTimeTransform(peerCoin, url);
			session.saveOrUpdate(peerCoin);
			tx.commit();

			//Darkcoin Feed
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			url = new URL(CryptocurrencyFeeds.DARKCOIN_FEED);
			darkCoin = JsonToObject.startFirtTimeTransform(darkCoin, url);
			session.saveOrUpdate(darkCoin);
			tx.commit();

			//Namecoin Feed
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			url = new URL(CryptocurrencyFeeds.NAMECOIN_FEED);
			nameCoin = JsonToObject.startFirtTimeTransform(nameCoin, url);
			session.saveOrUpdate(nameCoin);
			tx.commit();

			//Stellar Feed
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			url = new URL(CryptocurrencyFeeds.STELLAR_FEED);
			stellar = JsonToObject.startFirtTimeTransform(stellar, url);
			session.saveOrUpdate(stellar);
			tx.commit();

			//Banxshares Feed
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			url = new URL(CryptocurrencyFeeds.BANXSHARES_FEED);
			banxShares = JsonToObject.startFirtTimeTransform(banxShares, url);
			session.saveOrUpdate(banxShares);
			tx.commit();

			//Monero Feed
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			url = new URL(CryptocurrencyFeeds.MONERO_FEED);
			monero = JsonToObject.startFirtTimeTransform(monero, url);
			session.saveOrUpdate(monero);
			tx.commit();

			//Blackcoin Feed
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			url = new URL(CryptocurrencyFeeds.BLACKCOIN_FEED);
			blackCoin = JsonToObject.startFirtTimeTransform(blackCoin, url);
			session.saveOrUpdate(blackCoin);
			tx.commit();

			//Nubits Feed
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			url = new URL(CryptocurrencyFeeds.NUBITS_FEED);
			nubits = JsonToObject.startFirtTimeTransform(nubits, url);
			session.saveOrUpdate(nubits);
			tx.commit();

			//BitcoinDark Feed
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			url = new URL(CryptocurrencyFeeds.BITCOINDARK_FEED);
			bitCoinDark = JsonToObject.startFirtTimeTransform(bitCoinDark, url);
			session.saveOrUpdate(bitCoinDark);
			tx.commit();

			//Fuelcoin Feed
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			url = new URL(CryptocurrencyFeeds.FUELCOIN_FEED);
			fuelCoin = JsonToObject.startFirtTimeTransform(fuelCoin, url);
			session.saveOrUpdate(fuelCoin);
			tx.commit();

			//Mastercoin Feed
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			url = new URL(CryptocurrencyFeeds.MASTERCOIN_FEED);
			masterCoin = JsonToObject.startFirtTimeTransform(masterCoin, url);
			session.saveOrUpdate(masterCoin);
			tx.commit();

			//Feathercoin Feed
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			url = new URL(CryptocurrencyFeeds.FEATHERCOIN_FEED);
			featherCoin = JsonToObject.startFirtTimeTransform(featherCoin, url);
			session.saveOrUpdate(featherCoin);
			tx.commit();

			//Bytecoin Feed
			session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
			url = new URL(CryptocurrencyFeeds.BYTECOIN_FEED);
			byteCoin = JsonToObject.startFirtTimeTransform(byteCoin, url);
			session.saveOrUpdate(byteCoin);
			tx.commit();

		}
		catch (Exception ex) {
		    // Log the exception here
		    tx.rollback();
		    throw ex;

		}
		finally {
			//HibernateAnnotationUtil.closeSessionFactory();

		}

	}

}
