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

import java.util.HashMap;
import java.util.Map;

import org.altic.magentojconnector.service.OutputOperation;
import org.altic.magentojconnector.service.Session;
import org.altic.magentojconnector.service.impl.OutputOperationImpl;
import org.altic.magentojconnector.service.impl.SessionImpl;
import org.junit.Test;


public class OutputOperationProductTest {

	/*
	@Test
	public void testCreateProduct() {
		try{
			String baseUrl = "http://bmage.dev";
			String servicePath = "index.php/api/v2_soap/?wsdl";
			Session s = new SessionImpl(baseUrl, servicePath);
			
			System.out.println("Service is created : " + s.toString());
			
			assertTrue("Service is succefully created", s != null);
			
			String sKey = s.open("ycornec", "ycornec");
			System.out.println("Session is opened session key is : " +  sKey);			
			assertTrue("Service is succefully opened", (sKey != null && !"".equals(sKey)));
			
			//Output Service 
			OutputOperation outMageServ = new OutputOperationImpl();
			outMageServ.setOutSession(s);
			assertTrue("OutPut Service  succefully created", outMageServ != null);
			
			Map<String,String> product = new HashMap<String, String>();

			
			
			// product
			product.put("name", "TESTCDJ1000 MK3");
			product.put("description", "description: Mettez vos platines vinyles au placard et entrez dans le 21ème siècle! Ce lecteur CD compatible MP3 dispose de nombreuses fonctions pour contrôler votre mix avec une précision rarement atteinte. En plus de son look futuriste, il est l'outil idéal pour chaque DJ cherchant à gagner du temps, de l'argent et de l'espace!");
			product.put("short_description", "short_description: Mettez vos platines vinyles au placard et entrez dans le 21ème siècle! Ce lecteur CD compatible MP3 dispose de nombreuses fonctions pour contrôler votre mix avec une précision rarement atteinte. En plus de son look futuriste, il est l'outil idéal pour chaque DJ cherchant à gagner du temps, de l'argent et de l'espace!");
			product.put("weight", "1.1");
			product.put("status", "1");
			product.put("url_key", "TESTCDJ1000MK3");
			product.put("url_path", "");
			product.put("visibility", "4");
			product.put("categoryId_1", "4");
			product.put("websiteId_1", "9");
			product.put("has_options", "true");
			product.put("gift_message_available", null);
			product.put("price", "10.0");
			product.put("special_price", null);
			product.put("special_from_date", null);
			product.put("special_to_date", null);
			product.put("tax_class_id", "default");
			product.put("meta_title", "meta_title: TESTCDJ1000MK3");
			product.put("meta_keyword", "meta_keyword: TESTCDJ1000MK3");
			product.put("meta_description", "meta_description: TESTCDJ1000MK3");
			product.put("custom_design", null);
			product.put("custom_layout_update", null);
			product.put("options_container", null);
			

			product.put("type", "simple");
			product.put("set", "4");
			product.put("sku", "TESTCDJ1000MK3");
			
			// stock
			product.put("stock_qty","100");
			product.put("stock_is_in_stock", "1");
			product.put("stock_manage_stock", "1");
			product.put("stock_use_config_manage_stock", "1");
			product.put("stock_min_qty", "10");
			product.put("stock_use_config_min_qty", "1");
			product.put("stock_min_sale_qty", "1");
			product.put("stock_use_config_min_sale_qty","1");
			product.put("stock_max_sale_qty", "5");
			product.put("stock_use_config_max_sale_qty","1");
			product.put("stock_is_qty_decimal","0");
			product.put("stock_backorders",null);
			product.put("stock_use_config_backorders","0");
			product.put("stock_notify_stock_qty","11");
			product.put("stock_use_config_notify_stock_qty","1");



			outMageServ.setId("TESTCDJ1000MK3");			
			outMageServ.setObject(product);
			
			int ret = outMageServ.createProduct();
			
			assertTrue("product stock updated ok", ret == 1);
			
			s.close(sKey);
			
		}catch(Exception e){
			fail("test :: testCreateProduct failed" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testUpdateProduct() {
		try{
			String baseUrl = "http://bmage.dev";
			String servicePath = "index.php/api/v2_soap/?wsdl";
			Session s = new SessionImpl(baseUrl, servicePath);
			
			System.out.println("Service is created : " + s.toString());
			
			assertTrue("Service is succefully created", s != null);
			
			String sKey = s.open("ycornec", "ycornec");
			System.out.println("Session is opened session key is : " +  sKey);			
			assertTrue("Service is succefully opened", (sKey != null && !"".equals(sKey)));
			
			//Output Service 
			OutputOperation outMageServ = new OutputOperationImpl();
			outMageServ.setOutSession(s);
			assertTrue("OutPut Service  succefully created", outMageServ != null);
			
			Map<String,String> product = new HashMap<String, String>();

			
			
			// product
			product.put("name", "TESTCDJ1000 MK3 Modified");
			product.put("description", "description: Mettez vos platines vinyles au placard et entrez dans le 21ème siècle! Ce lecteur CD compatible MP3 dispose de nombreuses fonctions pour contrôler votre mix avec une précision rarement atteinte. En plus de son look futuriste, il est l'outil idéal pour chaque DJ cherchant à gagner du temps, de l'argent et de l'espace! Modified");
			product.put("short_description", "short_description: Mettez vos platines vinyles au placard et entrez dans le 21ème siècle! Ce lecteur CD compatible MP3 dispose de nombreuses fonctions pour contrôler votre mix avec une précision rarement atteinte. En plus de son look futuriste, il est l'outil idéal pour chaque DJ cherchant à gagner du temps, de l'argent et de l'espace! Modified");
			product.put("weight", "1.2");
			product.put("status", "1");
			product.put("url_key", "TESTCDJ1000MK3Modified");
			product.put("url_path", "");
			product.put("visibility", "4");
			product.put("categoryId_1", "4");
			product.put("websiteId_1", "9");
			product.put("has_options", "false");
			product.put("gift_message_available", null);
			product.put("price", "11.0");
			product.put("special_price", null);
			product.put("special_from_date", null);
			product.put("special_to_date", null);
			product.put("tax_class_id", "default");
			product.put("meta_title", "meta_title: TESTCDJ1000MK3");
			product.put("meta_keyword", "meta_keyword: TESTCDJ1000MK3");
			product.put("meta_description", "meta_description: TESTCDJ1000MK3");
			product.put("custom_design", null);
			product.put("custom_layout_update", null);
			product.put("options_container", null);
			

			product.put("type", "simple");
			product.put("set", "4");
			product.put("sku", "TESTCDJ1000MK3");
			
			// stock
			product.put("stock_qty","110");
			product.put("stock_is_in_stock", "1");
			product.put("stock_manage_stock", "1");
			product.put("stock_use_config_manage_stock", "1");
			product.put("stock_min_qty", "10");
			product.put("stock_use_config_min_qty", "1");
			product.put("stock_min_sale_qty", "1");
			product.put("stock_use_config_min_sale_qty","1");
			product.put("stock_max_sale_qty", "5");
			product.put("stock_use_config_max_sale_qty","1");
			product.put("stock_is_qty_decimal","0");
			product.put("stock_backorders",null);
			product.put("stock_use_config_backorders","0");
			product.put("stock_notify_stock_qty","11");
			product.put("stock_use_config_notify_stock_qty","1");



			outMageServ.setId("TESTCDJ1000MK3");			
			outMageServ.setObject(product);
			
			int ret = outMageServ.updateProduct();
			
			assertTrue("product stock updated ok", ret == 1);
			
			s.close(sKey);
			
		}catch(Exception e){
			fail("test :: testUpdateProduct failed" + e.getMessage());
			e.printStackTrace();
		}
	}
	*/
	/*
	@Test
	public void testDeleteProduct() {
		try{
			String baseUrl = "http://bmage.dev";
			String servicePath = "index.php/api/v2_soap/?wsdl";
			Session s = new SessionImpl(baseUrl, servicePath);
			
			System.out.println("Service is created : " + s.toString());
			
			assertTrue("Service is succefully created", s != null);
			
			String sKey = s.open("ycornec", "ycornec");
			System.out.println("Session is opened session key is : " +  sKey);			
			assertTrue("Service is succefully opened", (sKey != null && !"".equals(sKey)));
			
			//Output Service 
			OutputOperation outMageServ = new OutputOperationImpl();
			outMageServ.setOutSession(s);
			assertTrue("OutPut Service  succefully created", outMageServ != null);
			

			outMageServ.setId("TESTCDJ1000MK3");
			//outMageServ.setStoreView();
			
			//outMageServ.setObject(product);
			
			int ret = outMageServ.deleteProduct();
			
			assertTrue("product is deleted", ret == 1);
			
			s.close(sKey);
			
		}catch(Exception e){
			fail("test :: testUpdateProduct failed" + e.getMessage());
			e.printStackTrace();
		}
	}
*/
	
	@Test
	public void testUpdateProductTierPrice() {
		try{
			
		
			
			
			String baseUrl = "http://recette.boutique-artisans-du-monde.com";
			String servicePath = "index.php/api/v2_soap/?wsdl";
			String u = "recette_ws_user_adm";
			String p = "56f7431I14";
			Session s = new SessionImpl(baseUrl, servicePath);
			
			System.out.println("Service is created : " + s.toString());
			
			assertTrue("Service is succefully created", s != null);
			
			String sKey = s.open(u, p);
			System.out.println("Session is opened session key is : " +  sKey);			
			assertTrue("Service is succefully opened", (sKey != null && !"".equals(sKey)));
			
			//Output Service 
			OutputOperation outMageServ = new OutputOperationImpl();
			outMageServ.setOutSession(s);
			
			
			outMageServ.setId(String.valueOf("000321"));
			//outMageServ.setStoreView("2");
			//outMageServ.put("sku", row1.sku);
			
			Map<String,String> productTiersPrice = new HashMap<String, String>();
			
			productTiersPrice.put("tiersprice", "11;2;1;2.50;|4;2;1;2.50;");

			outMageServ.setObject(productTiersPrice);
			
			int ret = outMageServ.updateProductTierPrice();
			System.out.println("ret : " +  ret);			

			assertTrue("product is updated", ret == 1);
			
			
			s.close(sKey);
			
		}catch(Exception e){
			//fail("test :: testUpdateProduct failed " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	
}
