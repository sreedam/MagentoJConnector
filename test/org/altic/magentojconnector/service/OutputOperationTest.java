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
public class OutputOperationTest {
	
	
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
			outMageServ.setId("000321");

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

}
