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

public class OutputOperationProductImgTest {

	
	/*
	@Test
	public void testCreateProductImage() {
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
			
			Map<String,String> productImg = new HashMap<String, String>();

			
			
			// product
			productImg.put("uri", "/home/ccharly/Images/juste pour rigoler.jpg");
			productImg.put("mime", "image/png");
			productImg.put("name", "juste_pour_rigoler.jpg");
			productImg.put("label", "juste_pour_rigoler.jpg");
			productImg.put("position", "1");
			productImg.put("types", "thumbnail,small_image,image");
			productImg.put("exclude", "false");



			outMageServ.setId("ESPGEHORINT2RT");			
			outMageServ.setObject(productImg);
			
			int ret = outMageServ.createProductImage();
			
			assertTrue("product stock updated ok", ret == 1);
			
			s.close(sKey);
			
		}catch(Exception e){
			fail("test :: testUpdateProduct failed" + e.getMessage());
			e.printStackTrace();
		}
	}*/
	
	/*
	public void testCreateProductImageFromUrl() {
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
			
			Map<String,String> productImg = new HashMap<String, String>();

			
			
			// product
			productImg.put("uri", "https://k.bstatic.com/static/img/b25logo/beeldmerk-full.gif");
			productImg.put("mime", "image/gif");
			productImg.put("name", "beeldmerk.gif");
			productImg.put("label", "beeldmerk");
			productImg.put("position", "1");
			productImg.put("types", "thumbnail,small_image,image");
			productImg.put("exclude", "false");



			outMageServ.setId("ESPGEHORINT2RT");			
			outMageServ.setObject(productImg);
			
			int ret = outMageServ.createProductImage();
			
			assertTrue("product stock updated ok", ret == 1);
			
			s.close(sKey);
			
		}catch(Exception e){
			fail("test :: testUpdateProduct failed" + e.getMessage());
			e.printStackTrace();
		}
	}
	*/

	
	@Test
	public void testUpdateProductImage() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteProductImage() {
		fail("Not yet implemented");
	}

}
