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
import junit.framework.TestCase;

import org.altic.magentojconnector.service.impl.SessionImpl;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author ccharly
 *
 */
public class SessionTest extends TestCase {
	


	/**
	 * Test method for {@link org.altic.magentojconnector.service.impl.SessionImpl#SessionImpl(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testSessionImpl() {
		
		try{
			String baseUrl = "http://bmusic.dev";
			String servicePath = "index.php/api/v2_soap/?wsdl";
			Session s = new SessionImpl(baseUrl, servicePath);
			
			System.out.println("Service is created : " + s.toString());
			
			assertTrue("Service is succefully created", s != null);
			
		}catch(Exception e){
			fail("Not yet implemented" + e.getMessage());
		}
		
	}
	
	/**
	 * Test method for {@link org.altic.magentojconnector.service.impl.SessionImpl#open(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testOpen() {
		
		try{
			String baseUrl = "http://bmusic.dev";
			String servicePath = "index.php/api/v2_soap/?wsdl";
			Session s = new SessionImpl(baseUrl, servicePath);
			
			System.out.println("Service is created : " + s.toString());			
			assertTrue("Service is succefully created", s != null);
			
			String sKey = s.open("admin", "123123");
			System.out.println("Session is opened session key is : " +  sKey);			
			assertTrue("Service is succefully opened", (sKey != null && !"".equals(sKey)));
			
		}catch(Exception e){
			e.printStackTrace();
			fail("Not yet implemented" + e.getMessage());
		}
	}
	/**
	 * Test method for {@link org.altic.magentojconnector.service.impl.SessionImpl#getSession()}.
	 */
	@Test
	public void testGetSession() {
		try{
			String baseUrl = "http://bmusic.dev";
			String servicePath = "index.php/api/v2_soap/?wsdl";
			Session s = new SessionImpl(baseUrl, servicePath);
			
			System.out.println("Service is created : " + s.toString());			
			assertTrue("Service is succefully created", s != null);
			
			String sKey = s.open("admin", "123123");
			System.out.println("Session is opened session key is : " +  sKey);			
			assertTrue("Service is succefully opened", (sKey != null && !"".equals(sKey)));
			
			String sKey2 = s.getSession();
			System.out.println("the session key is : " +  sKey2);			
			assertTrue("key is good", (sKey != null && !"".equals(sKey)) && (sKey2 != null && !"".equals(sKey2)) && (sKey2.equals(sKey)));
			
			
		}catch(Exception e){
			e.printStackTrace();
			fail("Not yet implemented" + e.getMessage());
		}
	}

	/**
	 * Test method for {@link org.altic.magentojconnector.service.impl.SessionImpl#close(java.lang.String)}.
	 */
	@Test
	public void testClose() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.altic.magentojconnector.service.impl.SessionImpl#getService()}.
	 */
	@Test
	public void testGetService() {
		fail("Not yet implemented");
	}


	

}
