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

import java.util.Map;

import org.altic.magentojconnector.magento.api.*;

public interface OutputOperation {
	
	//id, storeView
	public void setId(String id);
	public void setStoreView(String storeView);
	// always the same object that ew have to explode in the good variable
	public void setObject(Map<String, String> o);
	
	// Session management
	public void setOutSession(Session session);
	public Session getOutSession();
	
	// product
	public int createProduct();
	public int updateProduct();
	public int deleteProduct();
	//public int updateProductPrice();
	public int updateProductSpecialPrice();	
	public int updateProductStock();

	//product tiers price
	public int updateProductTierPrice();
	
	
	// product & images
	public int createProductImage();
	public int updateProductImage();
	public int deleteProductImage();
	
	// product & linked
	public int createProductLinked();
	public int updateProductLinked();
	public int deleteProdutLinked();

		
	// customer
	public int createCustomer();
	public int updateCustomer();
	public int deleteCustomer();
	
	// customer Address
	public int createCustomerAddress();
	public int updateCustomerAddress();
	public int deleteCustomerAddress();
	
	
	// order
	public int createOrderComment();
	public int holdOrder();
	public int unholdOrder();
	public int cancelOrder();
	/*public int createOrderShipment();
	public int createOrderShipmentComment();
	public int createOrderInvoice();
	public int createOrderInvoiceComment();*/
	
	

	
	
	
}
