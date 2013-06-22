/*******************************************************************************
 * This file is part of MagentoJConnector
 *  
 *  Copyright (C) 2004 - 2013 Altic sarl - http://altic.org
 * 
 *  contact : opensource @ altic . org
 *  
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU Affero General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *  
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU Affero General Public License for more details.
 *  
 *   You should have received a copy of the GNU Affero General Public License
 *   along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package org.altic.magentojconnector.service.util;

import java.util.HashMap;

import org.altic.magentojconnector.magento.pojo.ConfigurableProduct;
import org.json.simple.JSONArray;
import org.lorecraft.phparser.JSONTransformer;
import org.lorecraft.phparser.SerializedPhpParser;

/**
 * 
 * @author ccharly
 * @see http://code.google.com/p/serialized-php-parser
 */

public class JsonToConfigurableProduct {
	
	public static ConfigurableProduct toCfgPdt(String jsonObj){
		

		if(jsonObj == null || jsonObj.length() == 0 )
			return null;
		
		JSONArray oJson = (JSONArray) JSONTransformer.toJSON((new SerializedPhpParser(jsonObj)).parse());
		
		if (oJson == null)
			return null;
		
		try{
			ConfigurableProduct cfgPdt = new ConfigurableProduct();
			
			if(oJson.get(0) != null){
				cfgPdt.setIbUenc(((String)((JSONArray)oJson.get(0)).get(0)));
				cfgPdt.setIbProductId(((String)((JSONArray)oJson.get(0)).get(1)));
				cfgPdt.setIbRelatedProduct(((String)((JSONArray)oJson.get(0)).get(2)));
				cfgPdt.setIbSuperAttribute(((JSONArray)((JSONArray)oJson.get(0)).get(3)).toString());
				cfgPdt.setIbQuantity(((String)((JSONArray)oJson.get(0)).get(4)));
			}	
			
			HashMap<String, String> attributes = null;
			if(oJson.get(1) != null){
				attributes = new HashMap<String, String>();
				JSONArray jsonAtts = (JSONArray)oJson.get(1);
				for (Object oJsonAtt : jsonAtts) {
					JSONArray jsonAtt = (JSONArray)oJsonAtt;
					
					attributes.put((String)jsonAtt.get(0), (String)jsonAtt.get(1));
				}
			}
			cfgPdt.setAttributes(attributes);
			
			if(oJson.get(2) != null){
				cfgPdt.setPdtName((String)oJson.get(2));
			}
			
			if(oJson.get(3) != null){
				cfgPdt.setPdtSku((String)oJson.get(3));
			}
			
			if(oJson.get(4) != null){
				cfgPdt.setPdtCalculation((Integer)oJson.get(4));
			}
			
			if(oJson.get(5) != null){
				cfgPdt.setPdtShipmentType((Integer)oJson.get(5));
			}
		
			return cfgPdt;
		}catch (NullPointerException e) {
			//TODO manage loging
			
			return null;
		}
	}

}
