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
/**
 * 
 */
package org.altic.magentojconnector.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.altic.magentojconnector.service.impl.OutputOperationImpl;
import org.altic.magentojconnector.service.impl.SessionImpl;
import org.junit.Test;

/**
 * @author ccharly
 *
 */
public class CopyOfOutputOperationTest {
	
	
	/**
	 * Test method for {@link org.altic.magentojconnector.service.impl.OutputOperationImpl#updateProductSpecialPrice()}.
	 */
	@Test
	public void testUpdateProductSpecialPrice() {
		try{
			String baseUrl = "http://adm.dev";
			String servicePath = "index.php/api/v2_soap/?wsdl";
			Session s = new SessionImpl(baseUrl, servicePath);
			
			System.out.println("Service is created : " + s.toString());
			
			assertTrue("Service is succefully created", s != null);
			
			String sKey = s.open("admin", "123123");
			System.out.println("Session is opened session key is : " +  sKey);			
			assertTrue("Service is succefully opened", (sKey != null && !"".equals(sKey)));
			
			//Output Service 
			OutputOperation outMageServ = new OutputOperationImpl();
			outMageServ.setOutSession(s);
			
		
			assertTrue("OutPut Service  succefully created", outMageServ != null);
			
			Map<String,String> updateSpecialPrice = new HashMap<String, String>();

			outMageServ.setStoreView("2");
			outMageServ.setId("00321");

			//
			// $result = $proxy->catalogProductSetSpecialPrice($sessionId, '2', '77.5', '2012-03-29 12:30:51', '2012-04-29 12:30:51');
			//
			updateSpecialPrice.put("special_price", "20.5");
			updateSpecialPrice.put("special_from_date", "2012-09-29 12:30:51");
			updateSpecialPrice.put("special_to_date", "2012-10-29 12:30:51");
			
			
			outMageServ.setObject(updateSpecialPrice);
			
			int ret = outMageServ.updateProductSpecialPrice();
			
			assertTrue("special price updated ok", ret == 1);
			
		}catch(Exception e){
			fail("test :: testUpdateProductSpecialPrice failed" + e.getMessage());
		}
	}


	
	/**
	 * Test method for {@link org.altic.magentojconnector.service.impl.OutputOperationImpl#updateProductStock()}.
	 
	@Test
	public void testUpdateProductStock() {
		try{
			String baseUrl = "http://adm.dev";
			String servicePath = "index.php/api/v2_soap/?wsdl";
			Session s = new SessionImpl(baseUrl, servicePath);
			
			System.out.println("Service is created : " + s.toString());
			
			assertTrue("Service is succefully created", s != null);
			
			String sKey = s.open("admin", "123123");
			System.out.println("Session is opened session key is : " +  sKey);			
			assertTrue("Service is succefully opened", (sKey != null && !"".equals(sKey)));
			
			//Output Service 
			OutputOperation outMageServ = new OutputOperationImpl();
			outMageServ.setOutSession(s);
			assertTrue("OutPut Service  succefully created", outMageServ != null);
			
			outMageServ.setId("MEM031");
			outMageServ.setStoreView("1");
			
			Map<String,String> stock = new HashMap<String, String>();

			 
			stock.put("qty", "5");
			stock.put("manage_stock", "1");
			stock.put("is_in_stock", "1");

			outMageServ.setObject(stock);
			
			int ret = outMageServ.updateProductStock();
			
			assertTrue("product stock updated ok", ret == 1);
			
			s.close(sKey);
			
		}catch(Exception e){
			fail("test :: testUpdateProductStock failed" + e.getMessage());
			e.printStackTrace();
		}
	}

		
	/**
	 * Test method for {@link org.altic.magentojconnector.service.impl.OutputOperationImpl#updateProduct()}.
	 *
	@Test
	public void testUpdateProduct() {
		try{
			String baseUrl = "http://adm.dev";
			String servicePath = "index.php/api/v2_soap/?wsdl";
			Session s = new SessionImpl(baseUrl, servicePath);
			
			System.out.println("Service is created : " + s.toString());
			
			assertTrue("Service is succefully created", s != null);
			
			String sKey = s.open("admin", "123123");
			System.out.println("Session is opened session key is : " +  sKey);			
			assertTrue("Service is succefully opened", (sKey != null && !"".equals(sKey)));
			
			//Output Service 
			OutputOperation outMageServ = new OutputOperationImpl();
			outMageServ.setOutSession(s);
			assertTrue("OutPut Service  succefully created", outMageServ != null);
			
			outMageServ.setId("MEM031");
			outMageServ.setStoreView("1");
			
			Map<String,String> product = new HashMap<String, String>();

			 
			//product.put("type", "simple");
			//product.put("set", "38");
			product.put("sku", "MEM031");
			
			//product.put("website_1","base");
			//product.put("website_2","egwada");
			
			//product.put("name", "HTC G1 Red Promo2");
			
			//product.put("description", "C'est un tel trop cool");
			//product.put("short_description", "C'est un tel trop cool, L'OS Android est vraiment au top");
			//product.put("weight", "350");
			//product.put("status", "2");
			//product.put("url_key", "htc-g1 2");
			//product.put("url_path", "htc-g1-2.html");
			//product.put("visibility", "4");
			//product.put("categoryId_1", "8");
			//product.put("has_options", "0");
			//product.put("price", "299.90");
			//product.put("special_price", "");
			//product.put("special_from_date"),
			//product.put("special_to_date"),
			//product.put("tax_class_id", "Taxable Goods");
			//tierPrices,
			//product.put("meta_title", "HTC G1 ANDROID");
			//product.put("meta_keyword", "HTC G1 ANDROID");
			//product.put("meta_description", "HTC G1 ANDROID");
			//product.put("custom_design"),
			//product.put("custom_layout_update"),
			//product.put("options_container"),
			//attributes
			//product.put("att_dimension", "4.1 x 1.7 x 0.7 inches");
			//product.put("att_activation_information", "4.1 x 1.7 x 0.7 inches");
			//product.put("att_color", "60");
			
			//product.put("notify", "true");
			
			product.put("stock_qty", "5");
			product.put("stock_manage_stock", "1");
			product.put("stock_is_in_stock", "1");
			
			outMageServ.setObject(product);
			
			int ret = outMageServ.updateProduct();
			
			assertTrue("product created ok", ret == 1);
			
			s.close(sKey);
			
		}catch(Exception e){
			fail("test :: testUpdateProduct failed" + e.getMessage());
			e.printStackTrace();
		}
	}
	

	/**
	 * Test method for {@link org.altic.magentojconnector.service.impl.OutputOperationImpl#deleteProduct()}.
	 *
	
	@Test
	public void testDeleteProduct() {
		try{
			String baseUrl = "http://mage1.1.e-gwada.gotdns.org";
			String servicePath = "index.php/api/v2_soap/?wsdl";
			Session s = new SessionImpl(baseUrl, servicePath);
			
			System.out.println("Service is created : " + s.toString());
			
			assertTrue("Service is succefully created", s != null);
			
			String sKey = s.open("admin", "123123");
			System.out.println("Session is opened session key is : " +  sKey);			
			assertTrue("Service is succefully opened", (sKey != null && !"".equals(sKey)));
			
			//Output Service 
			OutputOperation outMageServ = new OutputOperationImpl();
			outMageServ.setOutSession(s);
			assertTrue("OutPut Service  succefully created", outMageServ != null);
			
			outMageServ.setId("G1 ANDROIDE 4");
			
			int ret = outMageServ.deleteProduct();
			
			assertTrue("product deleted ok", ret == 1);
			
			s.close(sKey);
			
		}catch(Exception e){
			fail("test :: testDeleteProduct failed" + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link org.altic.magentojconnector.service.impl.OutputOperationImpl#createProduct()}.
	 *
	@Test
	public void testCreateProduct() {
		try{
			String baseUrl = "http://mage1.1.e-gwada.gotdns.org";
			String servicePath = "index.php/api/v2_soap/?wsdl";
			Session s = new SessionImpl(baseUrl, servicePath);
			
			System.out.println("Service is created : " + s.toString());
			
			assertTrue("Service is succefully created", s != null);
			
			String sKey = s.open("admin", "123123");
			System.out.println("Session is opened session key is : " +  sKey);			
			assertTrue("Service is succefully opened", (sKey != null && !"".equals(sKey)));
			
			//Output Service 
			OutputOperation outMageServ = new OutputOperationImpl();
			outMageServ.setOutSession(s);
			assertTrue("OutPut Service  succefully created", outMageServ != null);
			
			Map<String,String> product = new HashMap<String, String>();

			 
			product.put("type", "simple");
			product.put("set", "38");
			product.put("sku", "G1 ANDROIDE 5");
			
			product.put("website_1","base");
			product.put("website_2","egwada");
			
			product.put("name", "HTC G1 Red");
			
			product.put("description", "C'est un tel trop cool");
			product.put("short_description", "C'est un tel trop cool, L'OS Android est vraiment au top");
			product.put("weight", "350");
			product.put("status", "2");
			product.put("url_key", "htc-g1 5");
			product.put("url_path", "htc-g1-5.html");
			product.put("visibility", "4");
			product.put("categoryId_1", "8");
			product.put("has_options", "0");
			product.put("price", "299.90");
			//product.put("special_price"),
			//product.put("special_from_date"),
			//product.put("special_to_date"),
			product.put("tax_class_id", "Taxable Goods");
			//tierPrices,
			product.put("meta_title", "HTC G1 ANDROID");
			product.put("meta_keyword", "HTC G1 ANDROID");
			product.put("meta_description", "HTC G1 ANDROID");
			//product.put("custom_design"),
			//product.put("custom_layout_update"),
			//product.put("options_container"),
			//attributes
			product.put("att_dimension", "4.1 x 1.7 x 0.7 inches");
			product.put("att_activation_information", "4.1 x 1.7 x 0.7 inches");
			product.put("att_color", "26");
			
			product.put("notify", "true");	
			
			outMageServ.setObject(product);
			
			int ret = outMageServ.createProduct();
			
			assertTrue("product created ok", ret == 1);
			
			s.close(sKey);
			
		}catch(Exception e){
			fail("test :: testCreateProduct failed" + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Test method for {@link org.altic.magentojconnector.service.impl.OutputOperationImpl#createOrderComment()}.
	 *
	@Test
	public void testCreateOrderComment() {
		try{
			String baseUrl = "http://adm.dev";
			String servicePath = "index.php/api/v2_soap/?wsdl";
			Session s = new SessionImpl(baseUrl, servicePath);
			
			System.out.println("Service is created : " + s.toString());
			
			assertTrue("Service is succefully created", s != null);
			
			String sKey = s.open("admin", "123123");
			System.out.println("Session is opened session key is : " +  sKey);			
			assertTrue("Service is succefully opened", (sKey != null && !"".equals(sKey)));
			
			//Output Service 
			OutputOperation outMageServ = new OutputOperationImpl();
			outMageServ.setOutSession(s);
			
		
			assertTrue("OutPut Service  succefully created", outMageServ != null);
			
			Map<String,String> commentOrder = new HashMap<String, String>();

			outMageServ.setStoreView("1");
			
			commentOrder.put("orderIncrementId", "100001244");
			commentOrder.put("status", "processing");
			commentOrder.put("comment", "processing test depuis l'api");
			commentOrder.put("notify", "false");			
			outMageServ.setObject(commentOrder);
			
			int ret = outMageServ.createOrderComment();
			
			assertTrue("Comment created ok", ret == 1);
			
		}catch(Exception e){
			fail("test :: testCreateOrderComment failed" + e.getMessage());
		}
	}

	*/ 
 /**
	 * Test method for {@link org.altic.magentojconnector.service.impl.OutputOperationImpl#setId(java.lang.String)}.
	 *
	@Test
	public void testSetId() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.altic.magentojconnector.service.impl.OutputOperationImpl#setOutSession(org.altic.magentojconnector.service.Session)}.
	 *
	@Test
	public void testSetOutSession() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.altic.magentojconnector.service.impl.OutputOperationImpl#setStoreView(java.lang.String)}.
	 *
	@Test
	public void testSetStoreView() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.altic.magentojconnector.service.impl.OutputOperationImpl#setObject(java.util.Map)}.
	 *
	@Test
	public void testSetObject() {
		fail("Not yet implemented");
	}
 
	/**
	 * Test method for {@link org.altic.magentojconnector.service.impl.OutputOperationImpl#createProduct()}.
	 *
	@Test
	public void testCreateProduct() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.altic.magentojconnector.service.impl.OutputOperationImpl#getOutSession()}.
	 *
	@Test
	public void testGetOutSession() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.altic.magentojconnector.service.impl.OutputOperationImpl#updateProductPrice()}.
	 *
	@Test
	public void testUpdateProductPrice() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.altic.magentojconnector.service.impl.OutputOperationImpl#updateProductSpecialPrice()}.
	 *
	@Test
	public void testUpdateProductSpecialPrice() {
		fail("Not yet implemented");
	}
*/

}
