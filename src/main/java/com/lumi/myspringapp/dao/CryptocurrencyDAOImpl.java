package com.lumi.myspringapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.lumi.myspringapp.model.Cryptocurrency;

@Repository
public class CryptocurrencyDAOImpl implements CryptocurrencyDAO {
	private static final Logger logger = LoggerFactory.getLogger(CryptocurrencyDAOImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;

	}

	@Override
	public void addCryptocurrency(Cryptocurrency cryptocurrency) {
		Session session = this.sessionFactory.getCurrentSession();
        session.persist(cryptocurrency);
        logger.info("Cryptocurrency saved successfully, Cryptocurrency Details=" + cryptocurrency);

	}

	@Override
	public void updateCryptocurrency(Cryptocurrency cryptocurrency) {
		Session session = this.sessionFactory.getCurrentSession();
        session.update(cryptocurrency);
        logger.info("Cryptocurrency updated successfully, Cryptocurrency Details=" + cryptocurrency);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cryptocurrency> listCryptocurrencies() {
		Session session = this.sessionFactory.getCurrentSession();
        List<Cryptocurrency> cryptocurrenciesList = session.createQuery("from Cryptocurrency").list();
        for(Cryptocurrency cryptocurrency : cryptocurrenciesList){
            logger.info("CryptocurrenciesList List::" + cryptocurrency);

        }

        return cryptocurrenciesList;

	}

	@Override
	public Cryptocurrency getCryptocurrencyByName(int id) {
		Session session = this.sessionFactory.getCurrentSession();
        Cryptocurrency cryptocurrency = (Cryptocurrency) session.load(Cryptocurrency.class, new Integer(id));
        logger.info("Cryptocurrency loaded successfully, Cryptocurrency details=" + cryptocurrency);

        return cryptocurrency;

	}

	@Override
	public void removeCryptocurrency(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Cryptocurrency cryptocurrency = (Cryptocurrency) session.load(Cryptocurrency.class, new Integer(id));
        if(null != cryptocurrency){
            session.delete(cryptocurrency);

        }
        logger.info("Cryptocurrency deleted successfully, Cryptocurrency details=" + cryptocurrency);

	}

}
