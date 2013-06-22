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
package org.altic.magentojconnector.service.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.altic.magentojconnector.magento.api.CatalogAttributeEntity;
import org.altic.magentojconnector.magento.api.CatalogAttributeOptionEntity;
import org.altic.magentojconnector.magento.api.CatalogCategoryInfo;
import org.altic.magentojconnector.magento.api.CatalogCategoryTree;
import org.altic.magentojconnector.magento.api.CatalogProductAttributeSetEntity;
import org.altic.magentojconnector.magento.api.CatalogProductEntity;
import org.altic.magentojconnector.magento.api.CatalogProductImageEntity;
import org.altic.magentojconnector.magento.api.CatalogProductLinkEntity;
import org.altic.magentojconnector.magento.api.CatalogProductRequestAttributes;
import org.altic.magentojconnector.magento.api.CatalogProductReturnEntity;
import org.altic.magentojconnector.magento.api.CatalogProductTierPriceEntity;
import org.altic.magentojconnector.magento.api.CatalogProductTypeEntity;
import org.altic.magentojconnector.magento.api.CustomerAddressEntityItem;
import org.altic.magentojconnector.magento.api.CustomerCustomerEntity;
import org.altic.magentojconnector.magento.api.CustomerGroupEntity;
import org.altic.magentojconnector.magento.api.DirectoryCountryEntity;
import org.altic.magentojconnector.magento.api.DirectoryRegionEntity;
import org.altic.magentojconnector.magento.api.Filters;
import org.altic.magentojconnector.magento.api.SalesOrderAddressEntity;
import org.altic.magentojconnector.magento.api.SalesOrderEntity;
import org.altic.magentojconnector.magento.api.SalesOrderInvoiceEntity;
import org.altic.magentojconnector.magento.api.SalesOrderItemEntity;
import org.altic.magentojconnector.magento.api.SalesOrderPaymentEntity;
import org.altic.magentojconnector.magento.api.SalesOrderShipmentEntity;
import org.altic.magentojconnector.magento.api.SalesOrderStatusHistoryEntity;
import org.altic.magentojconnector.magento.pojo.ConfigurableProduct;
import org.altic.magentojconnector.magento.pojo.ProductCategories;
import org.altic.magentojconnector.magento.pojo.ProductTiersPrices;
import org.altic.magentojconnector.magento.pojo.ProductWebsites;
import org.altic.magentojconnector.service.InputOperation;
import org.altic.magentojconnector.service.Session;
import org.altic.magentojconnector.service.exception.MJConnectorServiceException;
import org.altic.magentojconnector.service.util.JsonToConfigurableProduct;

public class InputOperationImpl implements InputOperation {
	
	
	public final static String			PRODUCT_TYPE_CONFIGURABLE = "configurable";
	public final static String			PRODUCT_TYPE_BUNDLE = "bundle";
	public final static String			PRODUCT_TYPE_SIMPLE = "simple";
	
	private Filters						_filters;
	private String[]					_attributes;
	private String						_id;
	private String 						_storeView;
	
	private HashMap<String, String>		_params; // Other named parameters
	
	
	// Sales Entities
	private SalesOrderEntity[]			_orders;
	private SalesOrderEntity			_order;
	private SalesOrderItemEntity[]		_orderItems;
	private SalesOrderAddressEntity[]	_orderAddress;
	private SalesOrderPaymentEntity		_orderPayment;
	private SalesOrderStatusHistoryEntity[] _orderHistories;
	
	private SalesOrderShipmentEntity	_shipment;
	private SalesOrderShipmentEntity[]	_shipmentItems;
	private SalesOrderInvoiceEntity		_invoice;
	private SalesOrderInvoiceEntity[]	_invoiceItems;
	
	// Customer Entities
	private CustomerCustomerEntity[]	_customers;
	private CustomerCustomerEntity		_customer;
	private CustomerAddressEntityItem[]	_customerAddresses;
	private CustomerAddressEntityItem	_customerAddress;
	private CustomerGroupEntity[]		_customerGroups;
	
	// Country
	private DirectoryCountryEntity[]	_countries;
	
	// Region
	private DirectoryRegionEntity[]		_regions;
	
	// Product category
	private CatalogCategoryTree			_categories;
	private CatalogCategoryInfo			_category;
	
	// Product
	private CatalogProductEntity[]		_products;
	private	CatalogProductReturnEntity	_product;
	private ProductCategories[]			_productCategories;
	private ProductWebsites[]			_productWebsites;
	private ProductTiersPrices[]		_productTiersPrices;
	private CatalogProductTierPriceEntity[]		_productTiersPriceItems;
	// Product Attribute Sets
	private CatalogProductAttributeSetEntity[] _productAttributeSets;
	// Product Attributes
	private CatalogAttributeEntity[]	_productAttributes;
	// Product Attributes Options
	private CatalogAttributeOptionEntity[] _productAttributeOptions;
	// Product Type
	private CatalogProductTypeEntity[]	_productTypes;
	// Product Link
	private CatalogProductLinkEntity[]	_productLinks;
	// Product Link Type
	private String[]					_productLinkTypes;
	// Product Medias
	private CatalogProductImageEntity[]	_productMedias;
	
	
	
	private Session						_inSession;
	
	
	// Constructors
	public InputOperationImpl(){
		super();
	}
	
	public InputOperationImpl(Session session){
		this();
		this.setInSession(session);
	}
	
	public void setInSession(Session session){
		this._inSession = session;
	}
	
	public Session getInSession(){
		return this._inSession;
	}
	
	/* Read 
	 * (non-Javadoc)
	 * @see org.altic.magentojconnector.service.InputOpera// TODO Auto-generated method stub
		return null;tion#readOrders(org.altic.magentojconnector.magento.api.Filters)
	 */
	public void readOrders() {
		
		try {
			this._orders = this._inSession.getService().salesOrderList(
					 this._inSession.getSession(),
					 this._filters);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	public CustomerAddressEntityItem getAddress() {
		return this._customerAddress;
	}

	public CustomerAddressEntityItem[] getAddresses() {
		return this._customerAddresses;
	}

	public CustomerCustomerEntity getCustomer() {
		return this._customer;
	}

	public CustomerCustomerEntity[] getCustomers() {
		return this._customers;
	}

	public SalesOrderEntity getOrder() {
		return this._order;
	}

	public SalesOrderEntity[] getOrders() {
		return this._orders;
	}
	
	public SalesOrderPaymentEntity	getOrderPayment(){
		return this._orderPayment;		
	}
	
	public SalesOrderStatusHistoryEntity[] getOrderHistories(){
		return this._orderHistories;
	}

	public void readAddress() {
		try {
			this._customerAddress = this._inSession.getService().customerAddressInfo(
					 this._inSession.getSession(), Integer.valueOf(this._id).intValue()
				);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void readAddressByCustomer() {
		try {
			this._customerAddresses = this._inSession.getService().customerAddressList(
					 this._inSession.getSession(), Integer.valueOf(this._id).intValue()
				);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void readCustomer() {
		try {
			this._customer = this._inSession.getService().customerCustomerInfo(
					 this._inSession.getSession(), Integer.valueOf(this._id).intValue(), this._attributes
				);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void readCustomers() {
		
		try {
			this._customers = this._inSession.getService().customerCustomerList(
					 this._inSession.getSession(), this._filters
				);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void readOrder() {
		try {
			this._order = this._inSession.getService().salesOrderInfo(
					 this._inSession.getSession(), this._id);
			
			this._explodeOrderObjects();
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public SalesOrderAddressEntity[] getOrderAddress() {
		return this._orderAddress;
	}

	public SalesOrderItemEntity[] getOrderItems() {
		return this._orderItems;
	}	
	
	public void readCustomerGroups() {
		try {
			this._customerGroups = this._inSession.getService().customerGroupList(
					 this._inSession.getSession()
			);
			
			//this.explodeOrderObjects();
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public CustomerGroupEntity[] getCustomersGroups() {
		return this._customerGroups;
	}

	public DirectoryCountryEntity[] getCountries() {
		return this._countries;
	}

	public void readCountries() {
		try {
			this._countries = this._inSession.getService().directoryCountryList(
					 this._inSession.getSession()
			);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public DirectoryRegionEntity[] getRegions() {
		return this._regions;
	}

	public void readRegions() {
		
		try {
			this._regions = this._inSession.getService().directoryRegionList(
					 this._inSession.getSession(),
					 this._id				 
					 
			);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public CatalogProductReturnEntity getProduct() {
		return this._product;
	}

	public CatalogCategoryTree getCategories() {
		return this._categories;
	}

	public CatalogCategoryInfo getCategory() {
		return this._category;
	}

	public CatalogProductEntity[] getProducts() {
		return this._products;
	}

	public void readProduct() {
		
		try {
			
			CatalogProductRequestAttributes pAttributes = null;
			
			String[] atts, add_atts;
			ArrayList<String> array_atts = new ArrayList<String>();
			ArrayList<String> array_add_atts = new ArrayList<String>();
			
			for(int i=0; i < this._attributes.length; i++){
				if(this._attributes[i].startsWith("att_"))
					array_add_atts.add(this._attributes[i].substring(4, this._attributes[i].length()));
				else
					array_atts.add(this._attributes[i]);				
			}
			
			if(array_atts.size() > 0){
				atts = new String[array_atts.size()];
				atts = array_atts.toArray(atts);
				
				if(pAttributes == null)
					pAttributes = new CatalogProductRequestAttributes();
				
				pAttributes.setAttributes(atts);
			}
				
			if(array_add_atts.size() > 0){
				add_atts = new String[array_add_atts.size()];
				add_atts = array_add_atts.toArray(add_atts);
				
				if(pAttributes == null)
					pAttributes = new CatalogProductRequestAttributes();
				
				pAttributes.setAdditional_attributes(add_atts);
			}		
			
			
			this._product = this._inSession.getService().catalogProductInfo(
					 this._inSession.getSession(),
					 this._id, this._storeView, 
					 pAttributes,
					 null
			);
			
			this._explodeProductObject();
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	public void readCategories() {
		try {
			this._categories = this._inSession.getService().catalogCategoryTree(
					 this._inSession.getSession(),
					 this._id, this._storeView
			);			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void readCategory() {
		try {
			this._category = this._inSession.getService().catalogCategoryInfo(
					 this._inSession.getSession(),
					 	Integer.valueOf(this._id).intValue(), this._storeView, this._attributes
			);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void readProducts() {
		try {
			this._products = this._inSession.getService().catalogProductList(
					 this._inSession.getSession(),
					 this._filters, this._storeView
			);			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public CatalogProductTierPriceEntity[] getProductTierPriceItems() {
		return this._productTiersPriceItems;
	}
	
	@Override
	public void readProductTierPriceItems() {
		try {
			this._productTiersPriceItems = this._inSession.getService().catalogProductAttributeTierPriceInfo(
					 this._inSession.getSession(),
					 this._id,
					 null
			);			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ProductCategories[] getProductCategories() {
		return this._productCategories;
	}

	public ProductTiersPrices[] getProductTierPrices() {
		return this._productTiersPrices;
	}

	public ProductWebsites[] getProductWebsites() {
		return this._productWebsites;
	}
	
	
	@Override
	public SalesOrderInvoiceEntity[] getInvoices() {
		return this._invoiceItems;
	}

	@Override
	public SalesOrderInvoiceEntity getInvoice() {
		return this._invoice;
	}

	@Override
	public SalesOrderShipmentEntity getShipment() {
		return this._shipment;
	}

	@Override
	public SalesOrderShipmentEntity[] getShipments() {
		return this._shipmentItems;
	}

	@Override
	public void readInvoice() {
		try {
			this._invoice = this._inSession.getService().salesOrderInvoiceInfo(
					 this._inSession.getSession(),
					 this._id);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void readInvoices() {
		try {
			this._invoiceItems = this._inSession.getService().salesOrderInvoiceList(
					 this._inSession.getSession(),
					 this._filters);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void readShipment() {
		try {
			this._shipment = this._inSession.getService().salesOrderShipmentInfo(
					 this._inSession.getSession(),
					 this._id);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public void readShipments() {
		try {
			this._shipmentItems = this._inSession.getService().salesOrderShipmentList(
					 this._inSession.getSession(),
					 this._filters);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	
	@Override
	public CatalogProductAttributeSetEntity[] getAttributeSets() {
		return this._productAttributeSets;
	}

	@Override
	public void readAttributeSets() {
		try {
			this._productAttributeSets = this._inSession.getService().catalogProductAttributeSetList(
					 this._inSession.getSession()
			);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	@Override
	public CatalogProductTypeEntity[] getProductTypes() {
		return this._productTypes;
	}

	@Override
	public void readProductTypes() {
		try {
			this._productTypes = this._inSession.getService().catalogProductTypeList(
					 this._inSession.getSession()
			);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public String[] getProductLinkTypes() {
		return this._productLinkTypes;
	}

	@Override
	public CatalogProductLinkEntity[] getProductLinks() {
		return this._productLinks;
	}

	@Override
	public void readProductLinkTypes() {
		try {
			this._productLinkTypes = this._inSession.getService().catalogProductLinkTypes(
					 this._inSession.getSession()
			);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	// TODO add a flexible global parameter
	@Override
	public void readProductLinks() {
		try {
			
			
			if(this._params.get("product_type") == null){
				throw new MJConnectorServiceException("the id product_type can not be empty");
			}
			
			this._productLinks = this._inSession.getService().catalogProductLinkList(
					 this._inSession.getSession(),
					 (String)this._params.get("product_type"),
					 this._id,
					 null
					 
			);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public CatalogAttributeOptionEntity[] getAttributeOptions() {
		return this._productAttributeOptions;
	}

	@Override
	public CatalogAttributeEntity[] getAttributes() {
		return this._productAttributes;
	}

	@Override
	public void readAttributeOptions() {
		try {
			this._productAttributeOptions = this._inSession.getService().catalogProductAttributeOptions(
					 this._inSession.getSession(),
					 this._id,
					 this._storeView
					 
			);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void readAttributes() {
		try {
			this._productAttributes = this._inSession.getService().catalogProductAttributeList(
					 this._inSession.getSession(),
					 (Integer.valueOf(this._id)).intValue()
			);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public CatalogProductImageEntity[] getProductMedias() {
		return this._productMedias;
	}

	@Override
	public void readProductMedias() {
		try {
			this._productMedias = this._inSession.getService().catalogProductAttributeMediaList(
					 this._inSession.getSession(),
					 this._id,
					 this._storeView,
					 null
			);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
		
///////////////////////////////////////////////////////////////////////////////
// setters
//////////////////////////////////////////////////////////////////////////////
	
	
	public void setFilters(Filters filters){
		this._filters = filters;
	}
	
	public void setId(String id){
		this._id = id;
	}
	
	public void setAttributes(String[] attributes){
		this._attributes = attributes;
	}
	
	public void setStoreView(String storeView){
		this._storeView = storeView;
	}
	
	public void setParams(HashMap<String, String> params){
		this._params = params;
	}
	
	public void setParamValue(String key, String value){
		if(this._params == null)
			this._params = new HashMap<String,String>();
		
		this._params.put(key, value);
	}
	
///////////////////////////////////////////////////////////////////////////////
// explode objects
//////////////////////////////////////////////////////////////////////////////

	private void _explodeOrderObjects(){
		
		// save the previous product item to compare with the next and
		// 
		boolean isPrecItemConfigurable = false; 
		
		
		
		// order address
		List<SalesOrderAddressEntity> addressList = new ArrayList<SalesOrderAddressEntity>();
		this._order.getBilling_address().setIncrement_id(this._order.getIncrement_id());
		addressList.add(this._order.getBilling_address());
		this._order.getShipping_address().setIncrement_id(this._order.getIncrement_id());
		addressList.add(this._order.getShipping_address());
		this._orderAddress = new SalesOrderAddressEntity[2];
		this._orderAddress = addressList.toArray(this._orderAddress);
		
		// order Items		
		if(this._order.getItems() != null && this._order.getItems().length > 0 ){
			
			this._orderItems = this._order.getItems();
			
			for(int i = 0; i < this._orderItems.length; i++){
				
				this._orderItems[i].setOrder_id(this._order.getIncrement_id());
				
				// Check if this item is a configurable product
				if(PRODUCT_TYPE_CONFIGURABLE.equals(this._orderItems[i].getProduct_type())){
					
					isPrecItemConfigurable = true;
					
					if(this._orderItems[i].getProduct_options() != null){
						ConfigurableProduct cfgPdt = JsonToConfigurableProduct.toCfgPdt(this._orderItems[i].getProduct_options() );
						
						if(cfgPdt != null){
							this._orderItems[i].setName(this._orderItems[i].getName() + "(" + this._orderItems[i].getSku()+ ")");
							this._orderItems[i].setSku(cfgPdt.getPdtSku());
						}
					}
					
				}else{
					
					if(	isPrecItemConfigurable 
							&& PRODUCT_TYPE_SIMPLE.equals(this._orderItems[i].getProduct_type()) 
							&& this._orderItems[i].getSku().equals(this._orderItems[i-1].getSku())
					){
						//modify the itemId, save the parent item ID
						this._orderItems[i].setItem_id(this._orderItems[i].getItem_id() + ";"+ this._orderItems[i-1].getItem_id());
						
					}
					
					isPrecItemConfigurable = false;
				}
			}
		}
		
		// Payments
		this._orderPayment = this._order.getPayment();
		this._orderPayment.setIncrement_id(this._order.getIncrement_id());
		
		// Histories		
		if(this._order.getStatus_history() != null && this._order.getStatus_history().length > 0){
			this._orderHistories = this._order.getStatus_history();
			
			for(int u = 0; u < this._orderHistories.length; u++){
				this._orderHistories[u].setIncrement_id(this._order.getIncrement_id());
			}
		}

	}

	private void _explodeProductObject(){
		
		// product categories
		if(this._product.getCategories() != null && 
				this._product.getCategories().length > 0){
			
			List<ProductCategories> productCategories = new ArrayList<ProductCategories>();
			ProductCategories pCategory;
			for(int pcIdx = 0; pcIdx < this._product.getCategories().length; pcIdx++){
				
				pCategory = new ProductCategories();
				
				pCategory.setProductId(this._product.getProduct_id());
				pCategory.setCategory(this._product.getCategories()[pcIdx]);
				if(this._product.getCategory_ids() != null)
					pCategory.setCategoryId(this._product.getCategory_ids()[pcIdx]);
				
				productCategories.add(pCategory);
				
			}
			this._productCategories = new ProductCategories[productCategories.size()];
			this._productCategories = productCategories.toArray(this._productCategories);
			
			productCategories = null;
			pCategory = null;
		}
		
		// website
		if(this._product.getWebsites() != null && 
				this._product.getWebsites().length > 0
		){
			List<ProductWebsites> productWebSites = new ArrayList<ProductWebsites>();
			ProductWebsites pWebSite;
			
			for(int pwIdx = 0; pwIdx < this._product.getWebsites().length; pwIdx++){
				
				pWebSite = new ProductWebsites();
				
				pWebSite.setProductId(this._product.getProduct_id());
				pWebSite.setWebsite(this._product.getWebsites()[pwIdx]);
				pWebSite.setWebsiteId(this._product.getWebsites()[pwIdx]);
				
				productWebSites.add(pWebSite);
			}
			
			this._productWebsites = new ProductWebsites[productWebSites.size()];
			this._productWebsites = productWebSites.toArray(this._productWebsites);
			
			productWebSites = null;
			pWebSite = null;	
			
		}
		
		// Tiers Prices
		if(this._product.getTier_price() != null && 
				this._product.getTier_price().length > 0
		){

			List<ProductTiersPrices> productTiersPrices = new ArrayList<ProductTiersPrices>();
			ProductTiersPrices pTiersPrice;
			
			for(int ppIdx = 0; ppIdx < this._product.getTier_price().length; ppIdx++){
				
				pTiersPrice = new ProductTiersPrices();
				
				pTiersPrice.setProductId(this._product.getProduct_id());
				pTiersPrice.setTiersPrice(this._product.getTier_price()[ppIdx]);
				
				productTiersPrices.add(pTiersPrice);
			}
			
			this._productTiersPrices = new ProductTiersPrices[productTiersPrices.size()];
			this._productTiersPrices = productTiersPrices.toArray(this._productTiersPrices);
			
			productTiersPrices = null;
			pTiersPrice = null;	
		}
	}
	
///////////////////////////////////////////////////////////////////////////////
// TODO	Implement It
//////////////////////////////////////////////////////////////////////////////
	public void		readOrderPayment(){
		//TODO Not implemented
		return;
	}
	
	public void		readOrderHistories(){
		//TODO Not implemented
		return;
	}

}
