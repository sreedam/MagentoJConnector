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

import org.altic.magentojconnector.service.impl.SessionImpl;
import org.junit.Test;

public class InputOperationProductLinkedTest {
	
	@Test
	public void testGetProductLinkTypes() {
		
		
		try{
			
			
			//String baseUrl ="http://bmage.dev";
			String baseUrl ="http://adm.altic.pro";
			String servicePath = "/api/v2_soap/?wsdl";
			Session s = new SessionImpl(baseUrl, servicePath);
			
			System.out.println("Service is created : " + s.toString());
			
			
			String sKey = s.open("admin", "admin123");
			System.out.println("Session is opened session key is : " +  sKey);			
	
			//Output Service 
			InputOperation mageServ = new org.altic.magentojconnector.service.impl.InputOperationImpl();
			mageServ.setInSession(s);
			
			mageServ.readProductLinkTypes();
			
			String[] linkType = mageServ.getProductLinkTypes();
			for (int i = 0; i < linkType.length; i++) {
				System.out.println(mageServ.getProductLinkTypes()[i]);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

/*
	@Test
	public void testReadProductLinks() {
	
		
		try{
						
			//String baseUrl ="http://bmage.dev";
			String baseUrl ="http://adm.altic.pro";
			String servicePath = "/api/v2_soap/?wsdl";
			Session s = new SessionImpl(baseUrl, servicePath);
			
			System.out.println("Service is created : " + s.toString());
			
			
			String sKey = s.open("admin", "admin123");
			System.out.println("Session is opened session key is : " +  sKey);			
	
			//Output Service 
			InputOperation mageServ = new org.altic.magentojconnector.service.impl.InputOperationImpl();
			mageServ.setInSession(s);
			
			//TODO must set the link type
			mageServ.setParamValue("product_type", "super");
			
			mageServ.setId("NDE083-084-085");
			mageServ.readProductLinks();
			
			System.out.println(mageServ.getProductLinks()[0]);
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
*/
}
