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
package org.altic.magentojconnector.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.altic.magentojconnector.magento.api.*;
import org.altic.magentojconnector.service.*;
import org.altic.magentojconnector.service.exception.MJConnectorServiceException;
import org.altic.magentojconnector.service.impl.*;
import org.altic.magentojconnector.magento.pojo.*;

public class InputOperationProductInventoryTest {

	//String baseUrl = "http://tmage.dev/index.php";
	String baseUrl = "http://recette.boutique-artisans-du-monde.com";
	//String baseUrl = "http://bmage.dev";
	String servicePath = "api/v2_soap/?wsdl";
	Session s = new SessionImpl(baseUrl);
	String u = "recette_ws_user_adm";
	String p = "56f7431I14";
	String sKey;
	
	InputOperation inMageServ = new InputOperationImpl();
	
	SalesOrderEntity order;
	
	@Test
	public void testReadProduct() {
		try{
			
			System.out.println("Service is created : " + s.toString());
			
			assertTrue("Service is succefully created", s != null);
			
			sKey = s.open(u, p);
			System.out.println("Session is opened session key is : " +  sKey);			
			assertTrue("Service is succefully opened", (sKey != null && !"".equals(sKey)));
			
			//Output Service 
			inMageServ.setInSession(s);
			assertTrue("OutPut Service  succefully created", inMageServ != null);
			
			String[] atts =  {
					//"tier_price",
					"final_price",
					 "price",
					 "url_key",
					 "url_path",
					/*"cost",
                    "price",
                    "final_price",
				    "special_price",
				    "special_from_date",
				    "special_to_date",
                    "marge",
                    "marge_mini",
                    "spe_price_modifiable",
                    "current_schema_line"*/
					"has_options",
					"options_container"
				};
			
			
			inMageServ.setAttributes(atts);
			inMageServ.setId("000321");
			inMageServ.setStoreView("2");
			
			inMageServ.readProduct();
			
			CatalogProductReturnEntity pdt = inMageServ.getProduct();
			
			
			//assertTrue("Produt is ok", pdt != null && Integer.valueOf(pdt.getPrice()) > 0);
			
			ProductCategories pdtCategories[] = inMageServ.getProductCategories();
			
			assertTrue("Produt Categorie is ok", pdtCategories != null && pdtCategories.length > 0);
			
			ProductWebsites pdtWebsutes[] = inMageServ.getProductWebsites();
			
			assertTrue("Produt Website is ok", pdtWebsutes != null && pdtWebsutes.length > 0);
			
			ProductTiersPrices pdtTiers[] = inMageServ.getProductTierPrices();
			
			//assertTrue("Produc tTiers Prices is ok", pdtTiers != null);
			
			System.out.println(pdt.getPrice());
			System.out.println(pdt.getUrl_key());
			System.out.println(pdt.getUrl_path());
			
			System.out.println(pdtTiers);
			

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	
	@Test
	public void testClose() {
		try {
			s.close(sKey);
			
			assertTrue("conection is now closed", true);
			
		} catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
