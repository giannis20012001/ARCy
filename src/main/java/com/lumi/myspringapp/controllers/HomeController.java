package com.lumi.myspringapp.controllers;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lumi.myspringapp.model.Cryptocurrency;
import com.lumi.myspringapp.service.CryptocurrencyService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController{

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private CryptocurrencyService cryptocurrencyService;

    @Autowired(required=true)
    @Qualifier(value="cryptocurrencyService")
    public void setCryptocurrencyService(CryptocurrencyService cryptocurrencyService) {
        this.cryptocurrencyService = cryptocurrencyService;

    }

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listCryptocurrencies(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		model.addAttribute("cryptocurrency", new Cryptocurrency());
        model.addAttribute("listCryptocurrencies", this.cryptocurrencyService.listCryptocurrencies());

		return "home";

	}

	public static void logger(String var){
		logger.info(var);

	}

}
