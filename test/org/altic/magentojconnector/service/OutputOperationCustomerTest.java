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

public class OutputOperationCustomerTest {

	/*
	@Test
	public void testCreateCustomer() {
				
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
			
			Map<String,String> customer = new HashMap<String, String>();

			
			// Customer
			customer.put("email","charly2.clairmont@altic.org");
			customer.put("firstname","charly");
			customer.put("lastname","clairmont");
			customer.put("password","toto123");
			customer.put("store_id","1");
			customer.put("website_id","1");
			customer.put("group_id","1");
					
			outMageServ.setObject(customer);
			
			int ret = outMageServ.createCustomer();
			
			System.out.println("id customer :" + ret);
			
			assertTrue("product stock updated ok", ret > 0);
			
			s.close(sKey);
			
		}catch(Exception e){
			fail("test :: testCreateCustomer failed" + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void testUpdateCustomer() {
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
			
			Map<String,String> customer = new HashMap<String, String>();

			
			// Customer
			customer.put("email","charly2.clairmont@altic.org");
			customer.put("firstname","charly2");
			customer.put("lastname","clairmont2");
			customer.put("password","testtest24");
			customer.put("store_id","1");
			customer.put("website_id","1");
			customer.put("group_id","1");
					
			outMageServ.setObject(customer);
			outMageServ.setId("3436");
			
			int ret = outMageServ.updateCustomer();
			
			System.out.println("ret : " + ret);
			
			assertTrue("product stock updated ok", ret > 0);
			
			s.close(sKey);
			
		}catch(Exception e){
			fail("test :: testUpdateCustomer failed" + e.getMessage());
			e.printStackTrace();
		}
	}


	@Test
	public void testDeleteCustomer() {
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
			
			Map<String,String> customer = new HashMap<String, String>();
			
			outMageServ.setId("3436");
			
			int ret = outMageServ.deleteCustomer();
			
			System.out.println("ret : " + ret);
			
			assertTrue("customer is deleted ", ret > 0);
			
			s.close(sKey);
			
		}catch(Exception e){
			fail("test :: testDeleteCustomer failed" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	
	@Test
	public void testCreateCustomerAddress() {
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
			
			
			// customer address
			Map<String,String> customerAddress = new HashMap<String, String>();

			
			customerAddress.put("customer_id", "3439");
			customerAddress.put("city","Ivry-Sur-Seine");
			customerAddress.put("company","Altic");
			customerAddress.put("country_id","FR");
			customerAddress.put("fax","0146789023");
			customerAddress.put("firstname","charly");
			customerAddress.put("lastname","clairmont");
			//customerAddress.put("middlename",null);
			customerAddress.put("postcode","94200");
			customerAddress.put("prefix","Mr.");
			
			customerAddress.put("region_id","257");
			
			//customerAddress.put("region","Paris");
			
			customerAddress.put("street", "83 rue Victor Hugo\n3ème étage gauche");
			
			//customerAddress.put("suffix","Ivry-Sur-Seine");
			customerAddress.put("telephone","0346789023");
			
			customerAddress.put("is_default_billing","true");
			customerAddress.put("is_default_shipping","true");
			
			outMageServ.setObject(customerAddress);
			
			int ret = outMageServ.createCustomerAddress();
			
			System.out.println("id customer Address:" + ret);
			
			assertTrue("customer Address is created", ret > 0);
			
			s.close(sKey);
			
		}catch(Exception e){
			//fail("test :: testCreateCustomerAddress failed" + e.getMessage());
			e.printStackTrace();
		}
	}*/

	/*
	@Test
	public void testUpdateCustomerAddress() {
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
			
			
			// customer address
			Map<String,String> customerAddress = new HashMap<String, String>();
	
			
			customerAddress.put("customer_id", "3439");
			customerAddress.put("city","Ivry-Sur-Seine2");
			customerAddress.put("company","Altic2");
			customerAddress.put("country_id","FR");
			customerAddress.put("fax","0146789023222");
			customerAddress.put("firstname","charly2");
			customerAddress.put("lastname","clairmont2");
			//customerAddress.put("middlename",null);
			customerAddress.put("postcode","94202");
			customerAddress.put("prefix","Mr.");
			
			customerAddress.put("region_id","258");
			
			//customerAddress.put("region","Paris");
			
			customerAddress.put("street", "856 rue Victor Hugo\n3ème étage gauche2");
			
			//customerAddress.put("suffix","Ivry-Sur-Seine");
			customerAddress.put("telephone","034678902322");
			
			customerAddress.put("is_default_billing","true");
			customerAddress.put("is_default_shipping","false");
			
			outMageServ.setObject(customerAddress);
			outMageServ.setId("3648");
			
			int ret = outMageServ.updateCustomerAddress();
			
			System.out.println("id customer Address:" + ret);
			
			assertTrue("customer Address is created", ret > 0);
			
			s.close(sKey);
			
		}catch(Exception e){
			//fail("test :: testUpdateCustomerAddress failed" + e.getMessage());
			e.printStackTrace();
		}
	}*/

	
	@Test
	public void testDeleteCustomerAddtess() {
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
			
			
			// customer address
			outMageServ.setId("3648");
			
			int ret = outMageServ.deleteCustomerAddress();
			
			assertTrue("customer Address is deleted", ret > 0);
			
			s.close(sKey);
			
		}catch(Exception e){
			//fail("test :: testUpdateCustomerAddress failed" + e.getMessage());
			e.printStackTrace();
		}
	}

	
}
