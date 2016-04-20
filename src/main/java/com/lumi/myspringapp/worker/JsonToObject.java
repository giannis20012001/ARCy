package com.lumi.myspringapp.worker;

import java.net.URL;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.lumi.myspringapp.model.Cryptocurrency;
import com.lumi.myspringapp.model.Market;


public class JsonToObject {
	public JsonToObject() {
		//Dummy Constructor

	}
	//=====================================================================================================
	//=====================================================================================================
	public static Cryptocurrency startTransform(Cryptocurrency cryptocurrency, URL url)
			throws Exception {
		JsonFactory f = new JsonFactory();
    	JsonParser jp = f.createParser(url.openStream());
    	jp.nextToken();
    	while (jp.nextToken() != JsonToken.END_OBJECT) {
    		String fieldNameOne = jp.getCurrentName();
    		jp.nextToken();
    		if ("ticker".equals(fieldNameOne)) {
    			while (jp.nextToken() != JsonToken.END_OBJECT) {
    				String fieldNameTwo = jp.getCurrentName();
             		jp.nextToken();
    				if ("base".equals(fieldNameTwo)) {
    					if (jp.getText().isEmpty()) {
    						cryptocurrency.setBase("");

    					}
    					else {
    						cryptocurrency.setBase(jp.getText());

    					}

             		}
    				else if ("target".equals(fieldNameTwo)) {
    					if (jp.getText().isEmpty()) {
    						cryptocurrency.setTarget("");

    					}
    					else {
    						cryptocurrency.setTarget(jp.getText());

    					}

    				}
    				else if ("price".equals(fieldNameTwo)) {
    					if (jp.getText().isEmpty()){
    						cryptocurrency.setPrice(0);

    					}
    					else{
    						cryptocurrency.setPrice(Double.parseDouble(jp.getText()));

    					}

    				}
    				else if ("volume".equals(fieldNameTwo)) {
    					if (jp.getText().isEmpty()){
    						cryptocurrency.setVolume(0);

    					}
    					else {
    						cryptocurrency.setVolume(Double.parseDouble(jp.getText()));

						}

    				}
    				else if ("change".equals(fieldNameTwo)) {
    					if (jp.getText().isEmpty()){
    						cryptocurrency.setChange(0);

    					}
    					else {
    						cryptocurrency.setChange(Double.parseDouble(jp.getText()));

						}

    				}
    				else if ("markets".equals(fieldNameTwo)) {
    					Integer index = -1;
    					while(jp.nextToken() != JsonToken.END_ARRAY){
    						while(jp.nextToken() != JsonToken.END_OBJECT) {
    							Market temp = new Market();
    							String fieldNameThree = jp.getCurrentName();
    							jp.nextToken();
        	             		if ("market".equals(fieldNameThree)){
        	             			temp.setMarket(jp.getText());
        	             			index = cryptocurrency.getMarkets().indexOf(temp);
        	             			if (jp.getText().isEmpty()) {
        	             				cryptocurrency.getMarkets().get(index).setMarket("");
        	             				//market.setMarket("");

        	             			}
        	             			else {
        	             				cryptocurrency.getMarkets().get(index).setMarket(jp.getText());
        	             				//market.setMarket(jp.getText());

        	             			}

        	             		}
        	             		else if ("price".equals(fieldNameThree)){
        	             			if (jp.getText().isEmpty()) {
        	             				cryptocurrency.getMarkets().get(index).setMarketPrice(0);
        	             				//market.setMarketPrice(0);

									}
        	             			else {
        	             				cryptocurrency.getMarkets().get(index)
        	             				.setMarketPrice(Double.parseDouble(jp.getText()));
        	             				//market.setMarketPrice(Double.parseDouble(jp.getText()));

									}

    							}
        	             		else if ("volume".equals(fieldNameThree)) {
        	             			if (jp.getText().isEmpty()) {
        	             				cryptocurrency.getMarkets().get(index).setMarketVolume(0);
        	             				//market.setMarketVolume(0);

        	             			}
        	             			else {
        	             				cryptocurrency.getMarkets().get(index)
        	             				.setMarketVolume(Double.parseDouble(jp.getText()));
        	             				//market.setMarketVolume(Double.parseDouble(jp.getText()));

									}

        	             		}
        	             		else {
        	    					throw new IllegalStateException("Unrecognized field '" + fieldNameThree + "'!");

        	    				}

    						}
    						//cryptocurrency.getMarkets().add(market);
    						index = -1;

    					}

    				}
    				else {
    					throw new IllegalStateException("Unrecognized field '" + fieldNameTwo + "'!");

    				}

    			}

    		}
    		else if ("timestamp".equals(fieldNameOne)) {
    			if (jp.getText().isEmpty()) {
    				cryptocurrency.setTimestamp(0);

				}
				else {
					cryptocurrency.setTimestamp(jp.getLongValue());

				}

    		}
    		else if ("success".equals(fieldNameOne)) {
    			if (jp.getText().isEmpty()) {
    				cryptocurrency.setSuccess(false);

				}
				else {
					cryptocurrency.setSuccess(jp.getBooleanValue());

				}

    		}
    		else if ("error".equals(fieldNameOne)) {
    			if (jp.getText().isEmpty()) {
    				cryptocurrency.setError("");

				}
				else {
					cryptocurrency.setError(jp.getCurrentName());

				}

    		}
    		else {
    			throw new IllegalStateException("Unrecognized field '" + fieldNameOne + "'!");

    		}
       }
       jp.close();

		return cryptocurrency;

	}
	//=====================================================================================================
	//=====================================================================================================
	public static Cryptocurrency startFirtTimeTransform(Cryptocurrency cryptocurrency, URL url)
			throws Exception {
		JsonFactory f = new JsonFactory();
    	JsonParser jp = f.createParser(url.openStream());
    	jp.nextToken();
    	while (jp.nextToken() != JsonToken.END_OBJECT) {
    		String fieldNameOne = jp.getCurrentName();
    		jp.nextToken();
    		if ("ticker".equals(fieldNameOne)) {
    			while (jp.nextToken() != JsonToken.END_OBJECT) {
    				String fieldNameTwo = jp.getCurrentName();
             		jp.nextToken();
    				if ("base".equals(fieldNameTwo)) {
    					if (jp.getText().isEmpty()) {
    						cryptocurrency.setBase("");

    					}
    					else {
    						cryptocurrency.setBase(jp.getText());

    					}

             		}
    				else if ("target".equals(fieldNameTwo)) {
    					if (jp.getText().isEmpty()) {
    						cryptocurrency.setTarget("");

    					}
    					else {
    						cryptocurrency.setTarget(jp.getText());

    					}

    				}
    				else if ("price".equals(fieldNameTwo)) {
    					if (jp.getText().isEmpty()){
    						cryptocurrency.setPrice(0);

    					}
    					else{
    						cryptocurrency.setPrice(Double.parseDouble(jp.getText()));

    					}

    				}
    				else if ("volume".equals(fieldNameTwo)) {
    					if (jp.getText().isEmpty()){
    						cryptocurrency.setVolume(0);

    					}
    					else {
    						cryptocurrency.setVolume(Double.parseDouble(jp.getText()));

						}

    				}
    				else if ("change".equals(fieldNameTwo)) {
    					if (jp.getText().isEmpty()){
    						cryptocurrency.setChange(0);

    					}
    					else {
    						cryptocurrency.setChange(Double.parseDouble(jp.getText()));

						}

    				}
    				else if ("markets".equals(fieldNameTwo)) {
    					while(jp.nextToken() != JsonToken.END_ARRAY){
    						Market market =  new Market();
    						market.setCryptocurrency(cryptocurrency);
    						while(jp.nextToken() != JsonToken.END_OBJECT) {
        						String fieldNameThree = jp.getCurrentName();
        	             		jp.nextToken();
        	             		if ("market".equals(fieldNameThree)){
        	             			if (jp.getText().isEmpty()) {
        	             				market.setMarket("");

        	             			}
        	             			else {
        	             				market.setMarket(jp.getText());

        	             			}

        	             		}
        	             		else if ("price".equals(fieldNameThree)){
        	             			if (jp.getText().isEmpty()) {
        	             				market.setMarketPrice(0);

									}
        	             			else {
        	             				market.setMarketPrice(Double.parseDouble(jp.getText()));

									}

    							}
        	             		else if ("volume".equals(fieldNameThree)) {
        	             			if (jp.getText().isEmpty()) {
        	             				market.setMarketVolume(0);

        	             			}
        	             			else {
        	             				market.setMarketVolume(Double.parseDouble(jp.getText()));

									}

        	             		}
        	             		else {
        	    					throw new IllegalStateException("Unrecognized field '" + fieldNameThree + "'!");

        	    				}

    						}
    						cryptocurrency.getMarkets().add(market);

    					}

    				}
    				else {
    					throw new IllegalStateException("Unrecognized field '" + fieldNameTwo + "'!");

    				}

    			}

    		}
    		else if ("timestamp".equals(fieldNameOne)) {
    			if (jp.getText().isEmpty()) {
    				cryptocurrency.setTimestamp(0);

				}
				else {
					cryptocurrency.setTimestamp(jp.getLongValue());

				}

    		}
    		else if ("success".equals(fieldNameOne)) {
    			if (jp.getText().isEmpty()) {
    				cryptocurrency.setSuccess(false);

				}
				else {
					cryptocurrency.setSuccess(jp.getBooleanValue());

				}

    		}
    		else if ("error".equals(fieldNameOne)) {
    			if (jp.getText().isEmpty()) {
    				cryptocurrency.setError("");

				}
				else {
					cryptocurrency.setError(jp.getCurrentName());

				}

    		}
    		else {
    			throw new IllegalStateException("Unrecognized field '" + fieldNameOne + "'!");

    		}
       }
       jp.close();

		return cryptocurrency;

	}

}
