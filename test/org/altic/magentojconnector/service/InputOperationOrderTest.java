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

public class InputOperationOrderTest {

		
	//String baseUrl = "http://tmage.dev/index.php";
	//String baseUrl = "http://adm.altic.pro/";
	String baseUrl = "http://boutique-artisans-du-monde.com";
	
	String servicePath = "api/v2_soap/?wsdl";
	Session s = new SessionImpl(baseUrl);
	//String u = "admin";
	String u = "ws_user_adm";
	//String p = "admin123";
	String p = "56f7431I14";
	String sKey;
	
	InputOperation inMageServ = new InputOperationImpl();
	
	SalesOrderEntity order;
	
	@Test
	public void testReadOrders() {
		try{
			
			System.out.println("Service is created : " + s.toString());
			
			assertTrue("Service is succefully created", s != null);
			
			sKey = s.open(u, p);
			System.out.println("Session is opened session key is : " +  sKey);			
			assertTrue("Service is succefully opened", (sKey != null && !"".equals(sKey)));
			
			//Output Service 
			inMageServ.setInSession(s);
			assertTrue("OutPut Service  succefully created", inMageServ != null);
			
			AssociativeEntity ae = new AssociativeEntity();
			ae.setKey("like");
			ae.setValue("%pending%");
			
			
			ComplexFilter cf = new ComplexFilter();
			cf.setKey("status");
			cf.setValue(ae);
			
			ComplexFilter[] cfs = {cf};
			
			Filters f = new Filters();
			f.setComplex_filter(cfs);
			
			inMageServ.setFilters(null);
					
			inMageServ.readOrders();
			
			
			assertTrue("read order is ok", true);
			
			// orders
			SalesOrderEntity[] orders  = inMageServ.getOrders();
			assertTrue("orders are ok", orders != null && orders.length> 0);
			
			// order
			inMageServ.setId(orders[0].getIncrement_id());
			inMageServ.readOrder();
			order  = inMageServ.getOrder();			
			assertTrue("order is ok", order != null && Integer.valueOf(order.getIncrement_id()) > 0);
			
			// order payment
			assertTrue("order payment is ok", inMageServ.getOrderPayment() != null && inMageServ.getOrderPayment().getMethod() != null);
			
			// order history
			assertTrue("order payment is ok", inMageServ.getOrderHistories() != null && inMageServ.getOrderHistories().length  > 0);
			
			// order Address
			assertTrue("order payment is ok", inMageServ.getOrderAddress() != null && inMageServ.getOrderAddress().length  > 0);
			
			// order items
			assertTrue("order payment is ok", inMageServ.getOrderItems() != null && inMageServ.getOrderItems().length  > 0);
			
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
	
	//@Test
	//public void test

}
