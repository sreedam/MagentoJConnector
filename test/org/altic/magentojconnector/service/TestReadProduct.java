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

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashMap;
import java.util.Map;

import org.altic.magentojconnector.magento.api.AssociativeEntity;
import org.altic.magentojconnector.magento.api.CatalogProductEntity;
import org.altic.magentojconnector.magento.api.CatalogProductRequestAttributes;
import org.altic.magentojconnector.magento.api.CatalogProductReturnEntity;
import org.altic.magentojconnector.magento.api.ComplexFilter;
import org.altic.magentojconnector.magento.api.Filters;
import org.altic.magentojconnector.service.impl.OutputOperationImpl;
import org.altic.magentojconnector.service.impl.SessionImpl;
import org.junit.Test;

public class TestReadProduct {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 testReadProducts();

	}
	
	public static void testReadProducts() {
		
		try{
			
			//String baseUrl ="http://bmage.dev";
			String baseUrl ="http://recette.boutique-artisans-du-monde.com";
			String servicePath = "/api/v2_soap/?wsdl/1";
			Session s = new SessionImpl(baseUrl, servicePath);
			
			System.out.println("Service is created : " + s.toString());
			
			
			String sKey = s.open("admin", "admin123");
			System.out.println("Session is opened session key is : " +  sKey);			

			//Output Service 
			InputOperation mageServ = new org.altic.magentojconnector.service.impl.InputOperationImpl();
			mageServ.setInSession(s);
			
			
			
			Filters filter = new Filters();
			ComplexFilter[] cfilter = new ComplexFilter[1];
			cfilter[0] = new ComplexFilter();
			AssociativeEntity filterWid = new AssociativeEntity();
			
			filterWid.setKey("like");
			String[] websites = {"1"};
			//filterWid.setValue(websites);
			
			cfilter[0].setKey("websites");
			cfilter[0].setValue(filterWid);
			
			filter.setComplex_filter(cfilter);
			
			mageServ.setFilters(filter);			
			mageServ.setStoreView("1");
			
			
			mageServ.readProducts();
			CatalogProductEntity[] pdts =  mageServ.getProducts();
			/*for(int i=0; i < pdts.length; i++){
				System.out.println(pdts[i].getName() + ";" + pdts[i].getSku() + ";");
			}*/
			s.close(sKey);
			
		}catch(Exception e){
			//fail("test :: testReadProducts failed" + e.getMessage());
			e.printStackTrace();
		}
	}

/*	
	public static void testReadProduct() {
			
		try{
			//String baseUrl = "http://mage1.1.e-gwada.gotdns.org";
			//String baseUrl ="http://bmusic.altic.pro";
			String baseUrl ="http://recette.boutique-artisans-du-monde.com/";
			String servicePath = "api/v2_soap/?wsdl";
			Session s = new SessionImpl(baseUrl, servicePath);
			
			System.out.println("Service is created : " + s.toString());
			
			
			String sKey = s.open("admin", "admin");
			System.out.println("Session is opened session key is : " +  sKey);			

			//Output Service 
			InputOperation mageServ = new org.altic.magentojconnector.service.impl.InputOperationImpl();
			mageServ.setInSession(s);
			
			
			String[] atts = {"name", "description", "meta_title", "att_marge", "att_marge_mini"}; 
			System.out.println("********** NDE083-084-085");
			
			mageServ.setId("NDE083-084-085");
			mageServ.setAttributes(atts);
			mageServ.setStoreView("1");
			
			mageServ.readProduct();
			CatalogProductReturnEntity pdt =  mageServ.getProduct();
			System.out.println("********** Product Name : " + pdt.getName());
			System.out.println("********** Product SKU : " + pdt.getSku());
			System.out.println("********** Product Meta Title : " + pdt.getMeta_title());
			System.out.println("********** Product Description : " + pdt.getDescription());
			System.out.println("********** Product Marge : " + pdt.getAdditional_attributes()[0].getValue());
			System.out.println("********** Product Marge : " + pdt.getAdditional_attributes()[1].getValue());
			s.close(sKey);
			
		}catch(Exception e){
			fail("test :: testUpdateProductStock failed" + e.getMessage());
			e.printStackTrace();
		}
	}*/
	
}
