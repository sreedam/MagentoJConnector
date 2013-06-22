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

import java.util.HashMap;

import org.altic.magentojconnector.magento.api.*;
import org.altic.magentojconnector.magento.pojo.ProductCategories;
import org.altic.magentojconnector.magento.pojo.ProductTiersPrices;
import org.altic.magentojconnector.magento.pojo.ProductWebsites;


public interface InputOperation {
	
	//Attributes, filters, id, storeView
	public void setFilters(Filters filters);
	public void setId(String id);
	public void setAttributes(String[] attributes);
	public void setStoreView(String storeView);
	public void setParams(HashMap<String, String> params);
	public void setParamValue(String key, String value);
	
	// Session management
	public void setInSession(Session session);
	public Session getInSession();
	
	// Customer Operations
	public void							readCustomers();
	public CustomerCustomerEntity[] 	getCustomers();
	public void							readCustomer();
	public CustomerCustomerEntity		getCustomer();
	
	// Customer Group Operations
	public void							readCustomerGroups();
	public CustomerGroupEntity[]		getCustomersGroups();
	
	// Customer Address Operations
	public void							readAddressByCustomer();
	public CustomerAddressEntityItem[]	getAddresses();
	public void							readAddress();
	public CustomerAddressEntityItem	getAddress();
	
	// Order
	public void							readOrders();
	public SalesOrderEntity[]			getOrders();
	public void							readOrder();
	public SalesOrderEntity				getOrder();
	public SalesOrderItemEntity[]		getOrderItems();
	public SalesOrderAddressEntity[]	getOrderAddress();
	// Order - Shipment
	public void							readShipments();
	public SalesOrderShipmentEntity[]	getShipments();
	public void							readShipment();
	public SalesOrderShipmentEntity		getShipment();
	// Order - Invoice
	public void							readInvoices();
	public SalesOrderInvoiceEntity[]	getInvoices();
	public void							readInvoice();
	public SalesOrderInvoiceEntity		getInvoice();
	
	// Payments
	public void							readOrderPayment(); // TODO not necessary
	public SalesOrderPaymentEntity		getOrderPayment();
	
	// Order History
	public void							readOrderHistories(); // TODO not necessary
	public SalesOrderStatusHistoryEntity[] getOrderHistories();
	
	// Country
	public void 						readCountries();
	public DirectoryCountryEntity[]		getCountries();
	
	// Region
	public void							readRegions();
	public DirectoryRegionEntity[]		getRegions();
	
	// Product Category
	public void							readCategories();
	public CatalogCategoryTree			getCategories();
	public void							readCategory();
	public CatalogCategoryInfo			getCategory();
	
	// Product
	public void							readProducts();
	public CatalogProductEntity[]		getProducts();
	public void							readProduct();
	public CatalogProductReturnEntity	getProduct();	
	public ProductCategories[]			getProductCategories();
	public ProductWebsites[]			getProductWebsites();
	public ProductTiersPrices[]			getProductTierPrices();
	
	public void							readProductTierPriceItems();
	public CatalogProductTierPriceEntity[]	getProductTierPriceItems();
	
	// Product Attribut Set
	public CatalogProductAttributeSetEntity[]	getAttributeSets();
	public void							readAttributeSets();
	// Product Attribute by Set
	public CatalogAttributeEntity[]		getAttributes();
	public void							readAttributes();
	// Product Attribute Options
	public CatalogAttributeOptionEntity[]	getAttributeOptions();
	public void 						readAttributeOptions();
	
	// Product type
	public CatalogProductTypeEntity[]	getProductTypes();
	public void							readProductTypes();
	// Product link
	public CatalogProductLinkEntity[]	getProductLinks();
	public void							readProductLinks();
	// Product link Type
	public String[]						getProductLinkTypes();
	public void							readProductLinkTypes();
	
	// Product media
	public CatalogProductImageEntity[]	getProductMedias();
	public void							readProductMedias();
	
	

	
	
	

}
