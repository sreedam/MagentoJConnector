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

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

import org.altic.magentojconnector.magento.api.*;
import org.altic.magentojconnector.service.*;
import org.altic.magentojconnector.service.exception.MJConnectorServiceException;
import org.altic.magentojconnector.service.util.ConvertImage;

public class OutputOperationImpl implements OutputOperation {
	
	private Session						_outSession;
	private String						_id;
	private String 						_storeView;
	private Map<String, String>			_object;
	
	
	// setters
	
	public void setId(String id) {
		this._id = id;
	}
	public void setOutSession(Session session) {
		this._outSession = session;
	}

	public void setStoreView(String storeView) {
		this._storeView = storeView;
	}
	
	public void setObject(Map<String, String> o) {
		this._object = o;
	}

	// getters
	public Session getOutSession() {
		return this._outSession;
	}
	
	
	// Constructors
	public OutputOperationImpl(){
		super();
	}
	
	public OutputOperationImpl(Session session){
		this();
		this.setOutSession(session);
	}
	
	// operations
	
	public int createOrderComment() {
		
		
		//salesOrderAddComment(java.lang.String sessionId, java.lang.String orderIncrementId, java.lang.String status, java.lang.String comment, java.lang.String notify) throws java.rmi.RemoteException {
		try {
			
			this._outSession.getService().salesOrderAddComment(
					 this._outSession.getSession(),
					 this._id,
					 (String)this._object.get("status"),
					 (String)this._object.get("comment"),
					 (String)this._object.get("notify")
			);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
		return 1;
	}

	
	@Override
	public int cancelOrder() {
		try {
			
			return this._outSession.getService().salesOrderCancel(
					 this._outSession.getSession(),
					 this._id
			);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public int holdOrder() {
		try {
			
			return this._outSession.getService().salesOrderHold(
					 this._outSession.getSession(),
					 this._id
			);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public int unholdOrder() {
		try {
			
			return this._outSession.getService().salesOrderUnhold(
					 this._outSession.getSession(),
					 this._id
			);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

/*	
	
	@Override
	public int createOrderInvoice() {
		try {
			
			return this._outSession.getService().salesOrderInvoiceCreate(
					sessionId, invoiceIncrementId, itemsQty, comment, email, includeComment)(
					 this._outSession.getSession(),
					 this._id
			);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	@Override
	public int createOrderInvoiceComment() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int createOrderShipment() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int createOrderShipmentComment() {
		// TODO Auto-generated method stub
		return 0;
	}
	
*/
	public int createProduct() {
		try {
			
			
			ArrayList<String> aCategories = new ArrayList<String>();
			String[] categories = null;
			
			ArrayList<String> aWebsites	  = new ArrayList<String>();
			String[] websites = null;
			
			ArrayList<String> aWebsiteIds	  = new ArrayList<String>();
			String[] websiteIds = null;
			
			ArrayList<String> aCategoryIds = new ArrayList<String>();
			String[] categoryIds = null;
			
			ArrayList<String> atierPrices  = new ArrayList<String>();
			String[] tierPrices = null;
			
			ArrayList<AssociativeEntity> aAttributes = 
				new ArrayList<AssociativeEntity>() ;
			AssociativeEntity[] attributes = null;
			
			CatalogInventoryStockItemUpdateEntity oStock = null;
			
			// here we need some special features like manage differents categories, websites, attributes
			Iterator<String> objIterator = this._object.keySet().iterator();
			String key;
			AssociativeEntity val;
			while (objIterator.hasNext()){
				key = objIterator.next();
				
				if(this._object.get(key) != null){
				
					if(key.startsWith("category_")){
						aCategories.add((String)this._object.get(key));
					}
					if(key.startsWith("website_")){
						aWebsites.add((String)this._object.get(key));
					}
					if(key.startsWith("categoryId_")){
						aCategoryIds.add((String)this._object.get(key));
					}
					if(key.startsWith("websiteId_")){
						aWebsiteIds.add((String)this._object.get(key));
					}
					if(key.startsWith("tier_price_")){
						atierPrices.add((String)this._object.get(key));
					}
					if(key.startsWith("att_")){
						val = new AssociativeEntity();
						val.setKey(key.substring(4, key.length()));
						val.setValue((String)this._object.get(key));
						aAttributes.add(val);
					}
				}
				
			}
			
			if(aCategories.size() > 0){
				categories = new String[aCategories.size()];
				categories = aCategories.toArray(categories);
			}
			if(aWebsites.size() > 0){
				websites = new String[aWebsites.size()];
				websites = aWebsites.toArray(websites);
			}
			if(aCategoryIds.size() > 0){
				categoryIds = new String[aCategoryIds.size()];
				categoryIds = aCategoryIds.toArray(categoryIds);
			}
			if(aWebsiteIds.size() > 0){
				websiteIds = new String[aWebsiteIds.size()];
				websiteIds = aWebsiteIds.toArray(websiteIds);
			}
			if(atierPrices.size() > 0){
				tierPrices = new String[atierPrices.size()];
				tierPrices = atierPrices.toArray(tierPrices);
			}
			if(aAttributes.size() > 0){
				attributes = new AssociativeEntity[aAttributes.size()];
				attributes = aAttributes.toArray(attributes);
			}
			
			
			if(	this._object.get("stock_qty") 						!= null ||
				this._object.get("stock_is_in_stock") 				!= null ||
				this._object.get("stock_manage_stock") 				!= null ||
				this._object.get("stock_use_config_manage_stock") 	!= null ||
				this._object.get("stock_min_qty") 					!= null ||
				this._object.get("stock_use_config_min_qty") 		!= null ||
				this._object.get("stock_min_sale_qty") 				!= null ||
				this._object.get("stock_use_config_min_sale_qty") 	!= null ||
				this._object.get("stock_max_sale_qty") 				!= null ||
				this._object.get("stock_use_config_max_sale_qty") 	!= null ||
				this._object.get("stock_is_qty_decimal") 			!= null ||
				this._object.get("stock_backorders") 				!= null ||
				this._object.get("stock_use_config_backorders") 	!= null ||
				this._object.get("stock_notify_stock_qty") 			!= null ||
				this._object.get("stock_use_config_notify_stock_qty") != null ){
				
			}
				
				
			oStock = new CatalogInventoryStockItemUpdateEntity(
		
					(this._object.get("stock_qty") != null) ? (String)this._object.get("stock_qty") : null,
					(this._object.get("stock_is_in_stock")  != null ) ? Integer.valueOf(this._object.get("stock_is_in_stock")) : null,
					(this._object.get("stock_manage_stock") != null ) ? Integer.valueOf(this._object.get("stock_manage_stock")) : null,
					(this._object.get("stock_use_config_manage_stock") != null ) ? Integer.valueOf(this._object.get("stock_use_config_manage_stock")) : null,
					(this._object.get("stock_min_qty") != null ) ? Integer.valueOf(this._object.get("stock_min_qty"))  : null,
					(this._object.get("stock_use_config_min_qty") != null ) ? Integer.valueOf(this._object.get("stock_use_config_min_qty"))  : null,
					(this._object.get("stock_min_sale_qty") != null ) ? Integer.valueOf(this._object.get("stock_min_sale_qty"))  : null,
					(this._object.get("stock_use_config_min_sale_qty") != null ) ? Integer.valueOf(this._object.get("stock_use_config_min_sale_qty")) : null,
					(this._object.get("stock_max_sale_qty") != null ) ? Integer.valueOf(this._object.get("stock_max_sale_qty")) : null,
					(this._object.get("stock_use_config_max_sale_qty") != null ) ? Integer.valueOf(this._object.get("stock_use_config_max_sale_qty"))  : null,
					(this._object.get("stock_is_qty_decimal") != null ) ? Integer.valueOf(this._object.get("stock_is_qty_decimal")) : null,
					(this._object.get("stock_backorders") != null ) ? Integer.valueOf(this._object.get("stock_backorders")) : null,
					(this._object.get("stock_use_config_backorders") != null ) ? Integer.valueOf(this._object.get("stock_use_config_backorders"))  : null,
					(this._object.get("stock_notify_stock_qty") != null ) ? Integer.valueOf(this._object.get("stock_notify_stock_qty")) : null,
					(this._object.get("stock_use_config_notify_stock_qty") != null ) ? Integer.valueOf(this._object.get("stock_use_config_notify_stock_qty")) : null
			);
			
						
			CatalogProductCreateEntity productData = 
				new CatalogProductCreateEntity( 
						categories,
						websites,
						(String)this._object.get("name"),
						(String)this._object.get("description"),
						(String)this._object.get("short_description"),
						(String)this._object.get("weight"),
						(String)this._object.get("status"),
						(String)this._object.get("url_key"),
						(String)this._object.get("url_path"),
						(String)this._object.get("visibility"),
						categoryIds,
						websiteIds,
						(String)this._object.get("has_options"),
						(String)this._object.get("gift_message_available"),
						(String)this._object.get("price"),
						(String)this._object.get("special_price"),
						(String)this._object.get("special_from_date"),
						(String)this._object.get("special_to_date"),
						(String)this._object.get("tax_class_id"),
						tierPrices,
						(String)this._object.get("meta_title"),
						(String)this._object.get("meta_keyword"),
						(String)this._object.get("meta_description"),
						(String)this._object.get("custom_design"),
						(String)this._object.get("custom_layout_update"),
						(String)this._object.get("options_container"),
						attributes,
						oStock
	         );
			
			this._outSession.getService().catalogProductCreate(
					 this._outSession.getSession(),
					 (String)this._object.get("type"),
					 (String)this._object.get("set"),
					 (String)this._object.get("sku"),
					 productData);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}  catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
		return 1;
	}

	public int deleteProduct() {
		try {			
		
			this._outSession.getService().catalogProductDelete(
					 this._outSession.getSession(),
					 this._id,
					 //TODO comprendre ce qu'est "product identifier type"
					 null
			);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}  catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
		return 1;
	}

	
	public int updateProduct() {
		try {
		
			ArrayList<String> aCategories = new ArrayList<String>();
			String[] categories = null;
			
			ArrayList<String> aWebsites	  = new ArrayList<String>();
			String[] websites = null;
			
			ArrayList<String> aCategoryIds = new ArrayList<String>();
			String[] categoryIds = null;
			
			ArrayList<String> aWebsiteIds	  = new ArrayList<String>();
			String[] websiteIds = null;
			
			ArrayList<String> atierPrices  = new ArrayList<String>();
			String[] tierPrices = null;
			
			ArrayList<AssociativeEntity> aAttributes = new ArrayList<AssociativeEntity>() ;
			AssociativeEntity[] attributes = null;
			
			CatalogInventoryStockItemUpdateEntity oStock = null;
			
			// here we need some special features like manage differents categories, websites, attributes
			Iterator<String> objIterator = this._object.keySet().iterator();
			String key;
			AssociativeEntity val;
			while (objIterator.hasNext()){
				key = objIterator.next();
				
				if(this._object.get(key) != null){
					if(key.startsWith("category_")){
						aCategories.add((String)this._object.get(key));
					}
					if(key.startsWith("website_")){
						aWebsites.add((String)this._object.get(key));
					}
					if(key.startsWith("categoryId_")){
						aCategoryIds.add((String)this._object.get(key));
					}
					if(key.startsWith("websiteId_")){
						aWebsiteIds.add((String)this._object.get(key));
					}
					if(key.startsWith("tier_price_")){
						atierPrices.add((String)this._object.get(key));
					}
					if(key.startsWith("att_")){
						val = new AssociativeEntity();
						val.setKey(key.substring(4, key.length()));
						val.setValue((String)this._object.get(key));
						aAttributes.add(val);
					}
				}
				
			}
			
			if(aCategories.size() > 0){
				categories = new String[aCategories.size()];
				categories = aCategories.toArray(categories);
			}
			if(aWebsites.size() > 0){
				websites = new String[aWebsites.size()];
				websites = aWebsites.toArray(websites);
			}
			if(aCategoryIds.size() > 0){
				categoryIds = new String[aCategoryIds.size()];
				categoryIds = aCategoryIds.toArray(categoryIds);
			}
			if(aWebsiteIds.size() > 0){
				websiteIds = new String[aWebsiteIds.size()];
				websiteIds = aWebsiteIds.toArray(websiteIds);
			}
			if(atierPrices.size() > 0){
				tierPrices = new String[atierPrices.size()];
				tierPrices = atierPrices.toArray(tierPrices);
			}
			if(aAttributes.size() > 0){
				attributes = new AssociativeEntity[aAttributes.size()];
				attributes = aAttributes.toArray(attributes);
			}
			
			
			if(	this._object.get("stock_qty") 						!= null ||
				this._object.get("stock_is_in_stock") 				!= null ||
				this._object.get("stock_manage_stock") 				!= null ||
				this._object.get("stock_use_config_manage_stock") 	!= null ||
				this._object.get("stock_min_qty") 					!= null ||
				this._object.get("stock_use_config_min_qty") 		!= null ||
				this._object.get("stock_min_sale_qty") 				!= null ||
				this._object.get("stock_use_config_min_sale_qty") 	!= null ||
				this._object.get("stock_max_sale_qty") 				!= null ||
				this._object.get("stock_use_config_max_sale_qty") 	!= null ||
				this._object.get("stock_is_qty_decimal") 			!= null ||
				this._object.get("stock_backorders") 				!= null ||
				this._object.get("stock_use_config_backorders") 	!= null ||
				this._object.get("stock_notify_stock_qty") 			!= null ||
				this._object.get("stock_use_config_notify_stock_qty") != null ){
				
			}
				
				
			oStock = new CatalogInventoryStockItemUpdateEntity(
		
					(this._object.get("stock_qty") != null) ? (String)this._object.get("stock_qty") : null,
					(this._object.get("stock_is_in_stock")  != null ) ? Integer.valueOf(this._object.get("stock_is_in_stock")) : null,
					(this._object.get("stock_manage_stock") != null ) ? Integer.valueOf(this._object.get("stock_manage_stock")) : null,
					(this._object.get("stock_use_config_manage_stock") != null ) ? Integer.valueOf(this._object.get("stock_use_config_manage_stock")) : null,
					(this._object.get("stock_min_qty") != null ) ? Integer.valueOf(this._object.get("stock_min_qty"))  : null,
					(this._object.get("stock_use_config_min_qty") != null ) ? Integer.valueOf(this._object.get("stock_use_config_min_qty"))  : null,
					(this._object.get("stock_min_sale_qty") != null ) ? Integer.valueOf(this._object.get("stock_min_sale_qty"))  : null,
					(this._object.get("stock_use_config_min_sale_qty") != null ) ? Integer.valueOf(this._object.get("stock_use_config_min_sale_qty")) : null,
					(this._object.get("stock_max_sale_qty") != null ) ? Integer.valueOf(this._object.get("stock_max_sale_qty")) : null,
					(this._object.get("stock_use_config_max_sale_qty") != null ) ? Integer.valueOf(this._object.get("stock_use_config_max_sale_qty"))  : null,
					(this._object.get("stock_is_qty_decimal") != null ) ? Integer.valueOf(this._object.get("stock_is_qty_decimal")) : null,
					(this._object.get("stock_backorders") != null ) ? Integer.valueOf(this._object.get("stock_backorders")) : null,
					(this._object.get("stock_use_config_backorders") != null ) ? Integer.valueOf(this._object.get("stock_use_config_backorders"))  : null,
					(this._object.get("stock_notify_stock_qty") != null ) ? Integer.valueOf(this._object.get("stock_notify_stock_qty")) : null,
					(this._object.get("stock_use_config_notify_stock_qty") != null ) ? Integer.valueOf(this._object.get("stock_use_config_notify_stock_qty")) : null
			);
			
						
			CatalogProductCreateEntity productData = 
				new CatalogProductCreateEntity( 
						categories,
						websites,
						(String)this._object.get("name"),
						(String)this._object.get("description"),
						(String)this._object.get("short_description"),
						(String)this._object.get("weight"),
						(String)this._object.get("status"),
						(String)this._object.get("url_key"),
						(String)this._object.get("url_path"),
						(String)this._object.get("visibility"),
						categoryIds,
						websiteIds,
						(String)this._object.get("has_options"),
						(String)this._object.get("gift_message_available"),
						(String)this._object.get("price"),
						(String)this._object.get("special_price"),
						(String)this._object.get("special_from_date"),
						(String)this._object.get("special_to_date"),
						(String)this._object.get("tax_class_id"),
						tierPrices,
						(String)this._object.get("meta_title"),
						(String)this._object.get("meta_keyword"),
						(String)this._object.get("meta_description"),
						(String)this._object.get("custom_design"),
						(String)this._object.get("custom_layout_update"),
						(String)this._object.get("options_container"),
						attributes,
						oStock
	         );
			
			this._outSession.getService().catalogProductUpdate(
					 this._outSession.getSession(),
					 this._id,
					 productData,
					 this._storeView,
					 //TODO manage productIdentifierType
					 null
			);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}  catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return 0;
		}
	
		return 1;
	}
	
	public int updateProductStock() {
		try {

			CatalogInventoryStockItemUpdateEntity stock = 
				new CatalogInventoryStockItemUpdateEntity();

			if(this._object.get("qty") != null)
					stock.setQty((String)this._object.get("qty"));
			
			if(this._object.get("is_in_stock")  != null ) 
				stock.setIs_in_stock(Integer.valueOf(this._object.get("is_in_stock")));
			
			if(this._object.get("manage_stock") != null );
					stock.setManage_stock(Integer.valueOf(this._object.get("manage_stock")));
			
			if(this._object.get("use_config_manage_stock") != null )
				stock.setUse_config_manage_stock(Integer.valueOf(this._object.get("use_config_manage_stock")));
			
			if (this._object.get("min_qty") != null )
			  stock.setMin_qty(Integer.valueOf(this._object.get("min_qty")));
			
			if(this._object.get("use_config_min_qty") != null )
					stock.setUse_config_min_qty( Integer.valueOf(this._object.get("use_config_min_qty")));
			
			if(this._object.get("min_sale_qty") != null )
					stock.setMin_sale_qty( Integer.valueOf(this._object.get("min_sale_qty")));
			
			if(this._object.get("use_config_min_sale_qty") != null )
					stock.setUse_config_min_sale_qty(Integer.valueOf(this._object.get("use_config_min_sale_qty")));
			
			if(this._object.get("max_sale_qty") != null )
					stock.setMax_sale_qty( Integer.valueOf(this._object.get("max_sale_qty")));
			
			if(this._object.get("use_config_max_sale_qty") != null )
					stock.setUse_config_max_sale_qty( Integer.valueOf(this._object.get("use_config_max_sale_qty")));
			
			if(this._object.get("is_qty_decimal") != null )
					stock.setIs_qty_decimal( Integer.valueOf(this._object.get("is_qty_decimal")));
			
			if(this._object.get("backorders") != null )
					stock.setBackorders(Integer.valueOf(this._object.get("stock_backorders")));
			
			if(this._object.get("use_config_backorders") != null )
					stock.setUse_config_backorders(Integer.valueOf(this._object.get("use_config_backorders")));
			
			if(this._object.get("notify_stock_qty") != null )
					stock.setNotify_stock_qty( Integer.valueOf(this._object.get("notify_stock_qty")));
			
			if(this._object.get("use_config_notify_stock") != null )
					stock.setUse_config_notify_stock_qty( Integer.valueOf(this._object.get("use_config_notify_stock_qty")));
						
			this._outSession.getService().catalogInventoryStockItemUpdate(
					 this._outSession.getSession(),
					 this._id,
					 stock
			);
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}  catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	
		return 1;
	}
	
	
	public int updateProductTierPrice(){
		
		try {

			ArrayList<CatalogProductTierPriceEntity> tier_prices = new ArrayList<CatalogProductTierPriceEntity>();
			CatalogProductTierPriceEntity[] aTierPrices;
			CatalogProductTierPriceEntity tier_price = null;
			
			
			StringTokenizer stTierPrices = new StringTokenizer(this._object.get("tiersprice"), "|");
		     while (stTierPrices.hasMoreTokens()) {
		    	 
		    	String tknTierPrice =  stTierPrices.nextToken();
		    	if(tknTierPrice != null && tknTierPrice.length() > 0){
		    		
		    		
		    		String[] strTierPrice = tknTierPrice.split(";");
		    		tier_price = new CatalogProductTierPriceEntity();
				    	 
			    	 tier_price.setCustomer_group_id(strTierPrice[0]);
			    	 tier_price.setWebsite(strTierPrice[1]);
					 tier_price.setQty(Integer.valueOf(strTierPrice[2]));
					 tier_price.setPrice(Double.valueOf(strTierPrice[3]));
				     
					tier_prices.add(tier_price);
		    	}
		    	 
		    	 
		    	 
		     }

			aTierPrices = new CatalogProductTierPriceEntity[tier_prices.size()];
			aTierPrices = tier_prices.toArray(aTierPrices);
    
			this._outSession.getService().catalogProductAttributeTierPriceUpdate(
					
					 this._outSession.getSession(),
					 this._id,
					 aTierPrices,
					 //TODO manage productIdentifierType
					 null
			);
		}catch (NumberFormatException e) {
			// TODO: handle exception
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}  catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	
		
		return 1;
		
	}
	
	
	
	// manage customer //
	
	@Override
	public int createCustomer() {
		
		try {
			CustomerCustomerEntityToCreate customer = new CustomerCustomerEntityToCreate();
			
			customer.setEmail(this._object.get("email"));
			customer.setFirstname(this._object.get("firstname"));
			customer.setLastname(this._object.get("lastname"));
			customer.setPassword(this._object.get("password"));
			customer.setStore_id((Integer.valueOf(this._object.get("store_id"))).intValue());
			customer.setWebsite_id((Integer.valueOf(this._object.get("website_id"))).intValue());
			customer.setGroup_id((Integer.valueOf(this._object.get("group_id"))).intValue());
		    
		    return this._outSession.getService().customerCustomerCreate(
					 this._outSession.getSession(),
					 customer
			);
		    
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}  catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public int updateCustomer() {
		
		try {
			CustomerCustomerEntityToCreate customer = new CustomerCustomerEntityToCreate();
			
			if(this._object.get("email") != null)
				customer.setEmail(this._object.get("email"));
			
			if(this._object.get("firstname") != null)
				customer.setFirstname(this._object.get("firstname"));
			
			if(this._object.get("lastname") != null)
				customer.setLastname(this._object.get("lastname"));
			
			if(this._object.get("password") != null)
				customer.setPassword(this._object.get("password"));
			
			if(this._object.get("store_id") != null)
				customer.setStore_id((Integer.valueOf(this._object.get("store_id"))).intValue());
			
			if(this._object.get("website_id") != null)
				customer.setWebsite_id((Integer.valueOf(this._object.get("website_id"))).intValue());
			
			if(this._object.get("group_id") != null)
				customer.setGroup_id((Integer.valueOf(this._object.get("group_id"))).intValue());
		    
		    return this._outSession.getService().customerCustomerUpdate(
					 this._outSession.getSession(),
					 Integer.valueOf(this._id).intValue(),
					 customer
			) ? 1 : 0;
		    
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}  catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	
	@Override
	public int deleteCustomer() {
		try {
			return this._outSession.getService().customerCustomerDelete(
					 this._outSession.getSession(),
					 Integer.valueOf(this._id).intValue()
			) ? 1 : 0;
		    
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}  catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public int createCustomerAddress() {
		try {
			
			if(this._object.get("customer_id") == null){
				throw new MJConnectorServiceException("the customer_id field can not be empty");
			}
			
			CustomerAddressEntityCreate customerAddress = new CustomerAddressEntityCreate();
			
			customerAddress.setCity(this._object.get("city"));
			customerAddress.setCompany(this._object.get("company"));
			customerAddress.setCountry_id(this._object.get("country_id"));
			customerAddress.setFax(this._object.get("fax"));
			customerAddress.setFirstname(this._object.get("firstname"));
			customerAddress.setLastname(this._object.get("lastname"));
			customerAddress.setMiddlename(this._object.get("middlename"));
			customerAddress.setPostcode(this._object.get("postcode"));
			customerAddress.setPrefix(this._object.get("prefix"));
			
			if(this._object.get("region_id") != null)
				customerAddress.setRegion_id(Integer.valueOf(this._object.get("region_id")));
			
			customerAddress.setRegion(this._object.get("region"));
			
			String[] streets = this._object.get("street").split("\n");
			customerAddress.setStreet(streets);
			
			customerAddress.setSuffix(this._object.get("suffix"));
			customerAddress.setTelephone(this._object.get("telephone"));
			
			if(this._object.get("is_default_billing") != null)
				customerAddress.setIs_default_billing(Boolean.valueOf(this._object.get("is_default_billing")));
			
			if(this._object.get("is_default_shipping") != null)
				customerAddress.setIs_default_shipping(Boolean.valueOf(this._object.get("is_default_shipping")));
			
			
			/* 
		    <COLUMN KEY="false" LENGTH="50" NAME="city" NULLABLE="true" TYPE="id_String"/>
		    <COLUMN KEY="false" LENGTH="50" NAME="company" NULLABLE="true" TYPE="id_String"/>
		    <COLUMN KEY="false" LENGTH="50" NAME="country_id" NULLABLE="true" TYPE="id_String"/>
		    <COLUMN KEY="false" LENGTH="50" NAME="fax" NULLABLE="true" TYPE="id_String"/>
		    <COLUMN KEY="false" LENGTH="50" NAME="firstname" NULLABLE="true" TYPE="id_String"/>
		    <COLUMN KEY="false" LENGTH="50" NAME="lastname" NULLABLE="true" TYPE="id_String"/>
		    <COLUMN KEY="false" LENGTH="50" NAME="middlename" NULLABLE="true" TYPE="id_String"/>
		    <COLUMN KEY="false" LENGTH="50" NAME="postcode" NULLABLE="true" TYPE="id_String"/>
		    <COLUMN KEY="false" LENGTH="50" NAME="prefix" NULLABLE="true" TYPE="id_String"/>
		    <COLUMN KEY="false" LENGTH="50" NAME="region_id" NULLABLE="true" TYPE="id_String"/>
		    <COLUMN KEY="false" LENGTH="50" NAME="region" NULLABLE="true" TYPE="id_String"/>
		    <COLUMN KEY="false" LENGTH="50" NAME="street" NULLABLE="true" TYPE="id_String"/>
		    <COLUMN KEY="false" LENGTH="50" NAME="suffix" NULLABLE="true" TYPE="id_String"/>
		    <COLUMN KEY="false" LENGTH="50" NAME="telephone" NULLABLE="true" TYPE="id_String"/>
		    <COLUMN KEY="false" LENGTH="50" NAME="is_default_billing" NULLABLE="false" TYPE="id_String" />
		    <COLUMN KEY="false" LENGTH="50" NAME="is_default_shipping" NULLABLE="false" TYPE="id_String"/>

		*/
		    
		    return this._outSession.getService().customerAddressCreate(
					 this._outSession.getSession(),
					 Integer.valueOf(this._object.get("customer_id")),
					 customerAddress
			);
		    
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}  catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public int updateCustomerAddress() {
		try {
			
			CustomerAddressEntityCreate customerAddress = new CustomerAddressEntityCreate();
			
			if(this._object.get("city") != null)
				customerAddress.setCity(this._object.get("city"));
			
			if(this._object.get("company") != null)
				customerAddress.setCompany(this._object.get("company"));
			
			if(this._object.get("country_id") != null)
				customerAddress.setCountry_id(this._object.get("country_id"));

			if(this._object.get("fax") != null)
				customerAddress.setFax(this._object.get("fax"));

			if(this._object.get("firstname") != null)
				customerAddress.setFirstname(this._object.get("firstname"));

			if(this._object.get("lastname") != null)
				customerAddress.setLastname(this._object.get("lastname"));
			
			if(this._object.get("middlename") != null)				
				customerAddress.setMiddlename(this._object.get("middlename"));
			
			if(this._object.get("postcode") != null)	
				customerAddress.setPostcode(this._object.get("postcode"));
			
			if(this._object.get("prefix") != null)
				customerAddress.setPrefix(this._object.get("prefix"));
				
				
			if(this._object.get("region_id") != null)
				customerAddress.setRegion_id(Integer.valueOf(this._object.get("region_id")));
			
			if(this._object.get("region") != null)
				customerAddress.setRegion(this._object.get("region"));

			if(this._object.get("street") != null){
				String[] streets = this._object.get("street").split("\n");
				customerAddress.setStreet(streets);
			}

			if(this._object.get("suffix") != null)				
				customerAddress.setSuffix(this._object.get("suffix"));
			
			if(this._object.get("telephone") != null)
				customerAddress.setTelephone(this._object.get("telephone"));
			
			if(this._object.get("is_default_billing") != null)
				customerAddress.setIs_default_billing(Boolean.valueOf(this._object.get("is_default_billing")));
			
			if(this._object.get("is_default_shipping") != null)
				customerAddress.setIs_default_shipping(Boolean.valueOf(this._object.get("is_default_shipping")));

		    return this._outSession.getService().customerAddressUpdate(
					 this._outSession.getSession(),
					 Integer.valueOf(this._id),
					 customerAddress
			) ? 1 : 0;
		    
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}  catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public int deleteCustomerAddress() {
		try {
			
			return this._outSession.getService().customerAddressDelete(
					 this._outSession.getSession(),
					 Integer.valueOf(this._id)
			) ? 1 : 0;
		    
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}  catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	
	@Override
	public int createProductImage() {
		try {
			
			CatalogProductAttributeMediaCreateEntity imageContent = new CatalogProductAttributeMediaCreateEntity();
			
			CatalogProductImageFileEntity file = new CatalogProductImageFileEntity();
			
			file.setContent(ConvertImage.toBase64(this._object.get("uri")));
			file.setMime(this._object.get("mime"));
			file.setName(this._object.get("name"));
			
			imageContent.setFile(file);
			imageContent.setLabel(this._object.get("label"));
			imageContent.setPosition(this._object.get("position"));
			
			String[] types = null;
			if(this._object.get("types") != null)
				types =  ((String)this._object.get("types")).split(",");
			imageContent.setTypes(types);
			imageContent.setExclude(this._object.get("exclude"));
			imageContent.setRemove(null);
			
	
			/*
			<COLUMN KEY="false" LENGTH="255" NAME="uri" NULLABLE="true" TYPE="id_String"/>
			<COLUMN KEY="false" LENGTH="50" NAME="mime" NULLABLE="true" TYPE="id_String"/>
    		<COLUMN KEY="false" LENGTH="50" NAME="name" NULLABLE="true" TYPE="id_String"/>
		    <COLUMN KEY="false" LENGTH="50" NAME="label" NULLABLE="true" TYPE="id_String"/>
		    <COLUMN KEY="false" LENGTH="50" NAME="position" NULLABLE="true" TYPE="id_String"/>
		    <COLUMN KEY="false" LENGTH="50" NAME="types" NULLABLE="true" TYPE="id_String"/>
		    <COLUMN KEY="false" LENGTH="50" NAME="exclude" NULLABLE="true" TYPE="id_String"/>
		*/
			
			this._outSession.getService().catalogProductAttributeMediaCreate(
					 this._outSession.getSession(),
					 this._id,
					 imageContent,
					 this._storeView,
					 null
			);
			
			return 1;
		    
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}  catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public int updateProductImage() {
		try {
			
			if(this._object.get("product_image_name") == null){
				throw new MJConnectorServiceException("the product_image_name field can not be empty");
			}
			
			CatalogProductAttributeMediaCreateEntity imageContent = new CatalogProductAttributeMediaCreateEntity();
			
			CatalogProductImageFileEntity file = new CatalogProductImageFileEntity();
			
			file.setContent(this._object.get("uri"));
			file.setMime(this._object.get("mime"));
			file.setName(this._object.get("name"));
			
			imageContent.setFile(file);
			
			if(this._object.get("label") != null)
				imageContent.setLabel(this._object.get("label"));
			
			if(this._object.get("position") != null)
				imageContent.setPosition(this._object.get("position"));
			
			String[] types = null;
			if(this._object.get("types") != null)
				types =  ((String)this._object.get("types")).split(",");
			imageContent.setTypes(types);
			
			if(this._object.get("exclude") != null)
				imageContent.setExclude(this._object.get("exclude"));
			
			imageContent.setRemove(null);
			
	
			/*
			<COLUMN KEY="false" LENGTH="50" NAME="exclude" NULLABLE="false" TYPE="product_image_name"/>
			<COLUMN KEY="false" LENGTH="255" NAME="uri" NULLABLE="true" TYPE="id_String"/>
			<COLUMN KEY="false" LENGTH="50" NAME="mime" NULLABLE="true" TYPE="id_String"/>
    		<COLUMN KEY="false" LENGTH="50" NAME="name" NULLABLE="true" TYPE="id_String"/>
		    <COLUMN KEY="false" LENGTH="50" NAME="label" NULLABLE="true" TYPE="id_String"/>
		    <COLUMN KEY="false" LENGTH="50" NAME="position" NULLABLE="true" TYPE="id_String"/>
		    <COLUMN KEY="false" LENGTH="50" NAME="types" NULLABLE="true" TYPE="id_String"/>
		    <COLUMN KEY="false" LENGTH="50" NAME="exclude" NULLABLE="true" TYPE="id_String"/>
		*/
			
			this._outSession.getService().catalogProductAttributeMediaUpdate(				
					 this._outSession.getSession(),
					 this._id,
					 this._object.get("product_image_name"),
					 imageContent,
					 this._storeView,
					 null
			);
			
			return 1;
		    
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}  catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public int deleteProductImage() {

		try {	
			if(this._object.get("product_image_name") == null){
				throw new MJConnectorServiceException("the product_image_name field can not be empty");
			}
			
	
	
			/*
			<COLUMN KEY="false" LENGTH="50" NAME="exclude" NULLABLE="false" TYPE="product_image_name"/>
			<COLUMN KEY="false" LENGTH="255" NAME="uri" NULLABLE="true" TYPE="id_String"/>
			<COLUMN KEY="false" LENGTH="50" NAME="mime" NULLABLE="true" TYPE="id_String"/>
    		<COLUMN KEY="false" LENGTH="50" NAME="name" NULLABLE="true" TYPE="id_String"/>
		    <COLUMN KEY="false" LENGTH="50" NAME="label" NULLABLE="true" TYPE="id_String"/>
		    <COLUMN KEY="false" LENGTH="50" NAME="position" NULLABLE="true" TYPE="id_String"/>
		    <COLUMN KEY="false" LENGTH="50" NAME="types" NULLABLE="true" TYPE="id_String"/>
		    <COLUMN KEY="false" LENGTH="50" NAME="exclude" NULLABLE="true" TYPE="id_String"/>
		*/
			
			this._outSession.getService().catalogProductAttributeMediaRemove(				
					 this._outSession.getSession(),
					 this._id,
					 this._object.get("product_image_name"),
					 null
			);
			
			return 1;
		    
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}  catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	
	@Override
	public int createProductLinked() {
		
		/* 
		 * 
	    <COLUMN KEY="true" LENGTH="50" NAME="product_id" NULLABLE="true" TYPE="id_String"/>
	    <COLUMN KEY="false" LENGTH="50" NAME="type" NULLABLE="true" TYPE="id_Integer"/>
	    <COLUMN KEY="false" LENGTH="50" NAME="linked_product" NULLABLE="true" TYPE="id_String"/>
	    
	    <COLUMN KEY="false" LENGTH="50" NAME="lkp_product_id" NULLABLE="true" TYPE="id_String"/>
    	<COLUMN KEY="false" LENGTH="50" NAME="lkp_type" NULLABLE="true" TYPE="id_String"/>
    	<COLUMN KEY="false" LENGTH="50" NAME="lkp_set" NULLABLE="true" TYPE="id_String"/>
    	<COLUMN KEY="false" LENGTH="50" NAME="lkp_sku" NULLABLE="true" TYPE="id_String"/>
    	<COLUMN KEY="false" LENGTH="50" NAME="lkp_position" NULLABLE="true" TYPE="id_String"/>
    	<COLUMN KEY="false" LENGTH="50" NAME="lkp_qty" NULLABLE="true" TYPE="id_String"/>
    	
    	<COLUMN KEY="false" LENGTH="50" NAME="product_identifier_type" NULLABLE="true" TYPE="id_String"/>
		 */
		
		try {
			
			
			
			if(this._id == null){
				throw new MJConnectorServiceException("the id field can not be empty");
			}
			if(this._object.get("linked_product") == null){
				throw new MJConnectorServiceException("the linked_product field can not be empty");
			}
			
			
			CatalogProductLinkEntity data = new CatalogProductLinkEntity();
			
			if(this._object.get("lkp_product_id") != null)
				data.setProduct_id(this._object.get("lkp_product_id"));
			
			if(this._object.get("lkp_type") != null)	
				data.setType(this._object.get("lkp_type"));
			
			if(this._object.get("lkp_set") != null)
				data.setSet(this._object.get("lkp_set") );
			
			if(this._object.get("lkp_sku") != null)
				data.setSku(this._object.get("lkp_sku"));
			
			if(this._object.get("lkp_position") != null)
				data.setPosition(this._object.get("lkp_position"));
			
			if(this._object.get("lkp_qty") != null)
				data.setQty(this._object.get("lkp_qty"));
			
			
			this._outSession.getService().catalogProductLinkAssign(				
					 this._outSession.getSession(),
					 this._object.get("type"),
					 this._id,
					 this._object.get("linked_product"),
					 data,
					 this._object.get("product_identifier_type")
			);
			
			return 1;
		    
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}  catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	@Override
	public int updateProductLinked() {		
		
		/* 
		 * 
	    <COLUMN KEY="true" LENGTH="50" NAME="product_id" NULLABLE="true" TYPE="id_String"/>
	    <COLUMN KEY="false" LENGTH="50" NAME="type" NULLABLE="true" TYPE="id_Integer"/>
	    <COLUMN KEY="false" LENGTH="50" NAME="linked_product" NULLABLE="true" TYPE="id_String"/>
	    
	    <COLUMN KEY="false" LENGTH="50" NAME="lkp_product_id" NULLABLE="true" TYPE="id_String"/>
    	<COLUMN KEY="false" LENGTH="50" NAME="lkp_type" NULLABLE="true" TYPE="id_String"/>
    	<COLUMN KEY="false" LENGTH="50" NAME="lkp_set" NULLABLE="true" TYPE="id_String"/>
    	<COLUMN KEY="false" LENGTH="50" NAME="lkp_sku" NULLABLE="true" TYPE="id_String"/>
    	<COLUMN KEY="false" LENGTH="50" NAME="lkp_position" NULLABLE="true" TYPE="id_String"/>
    	<COLUMN KEY="false" LENGTH="50" NAME="lkp_qty" NULLABLE="true" TYPE="id_String"/>
    	
    	<COLUMN KEY="false" LENGTH="50" NAME="product_identifier_type" NULLABLE="true" TYPE="id_String"/>
		 */
		
		try {
			
			
			
			if(this._id == null){
				throw new MJConnectorServiceException("the id field can not be empty");
			}
			if(this._object.get("linked_product") == null){
				throw new MJConnectorServiceException("the linked_product field can not be empty");
			}
			
			
			CatalogProductLinkEntity data = new CatalogProductLinkEntity();
			
			if(this._object.get("lkp_product_id") != null)
				data.setProduct_id(this._object.get("lkp_product_id"));
			
			if(this._object.get("lkp_type") != null)	
				data.setType(this._object.get("lkp_type"));
			
			if(this._object.get("lkp_set") != null)
				data.setSet(this._object.get("lkp_set") );
			
			if(this._object.get("lkp_sku") != null)
				data.setSku(this._object.get("lkp_sku"));
			
			if(this._object.get("lkp_position") != null)
				data.setPosition(this._object.get("lkp_position"));
			
			if(this._object.get("lkp_qty") != null)
				data.setQty(this._object.get("lkp_qty"));
			
			
			this._outSession.getService().catalogProductLinkUpdate(				
					 this._outSession.getSession(),
					 this._object.get("type"),
					 this._id,
					 this._object.get("linked_product"),
					 data,
					 this._object.get("product_identifier_type")
			);
			
			return 1;
		    
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}  catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	@Override
	public int deleteProdutLinked() {
		/* 
		 * 
	    <COLUMN KEY="true" LENGTH="50" NAME="product_id" NULLABLE="true" TYPE="id_String"/>
	    <COLUMN KEY="false" LENGTH="50" NAME="type" NULLABLE="true" TYPE="id_Integer"/>
	    <COLUMN KEY="false" LENGTH="50" NAME="linked_product" NULLABLE="true" TYPE="id_String"/>    	
    	<COLUMN KEY="false" LENGTH="50" NAME="product_identifier_type" NULLABLE="true" TYPE="id_String"/>
		 */
		
		try {
			
			if(this._id == null){
				throw new MJConnectorServiceException("the id field can not be empty");
			}
			if(this._object.get("linked_product") == null){
				throw new MJConnectorServiceException("the linked_product field can not be empty");
			}
			
			this._outSession.getService().catalogProductLinkRemove(				
					 this._outSession.getSession(),
					 this._object.get("type"),
					 this._id,
					 this._object.get("linked_product"),
					 this._object.get("product_identifier_type")
			);
			
			return 1;
		    
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}  catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	
	
	
	/*public int updateProductPrice() {
		// TODO Auto-generated method stub
		return 0;
	}
*/
	public int updateProductSpecialPrice() {
		
		try{
			
			if(this._object.get("store_view") != null){
				this._storeView = (String) this._object.get("store_view");
			}
					
			
			if(
				this._object.get("special_price") != null
				&&
				this._object.get("special_from_date") != null
					
			){
				this._outSession.getService().catalogProductSetSpecialPrice(
						this._outSession.getSession(),//sessionId
						 this._id,//product
						 this._object.get("special_price"),//specialPrice
						 this._object.get("special_from_date"),//specialPrice
						 this._object.get("special_to_date"),//toDate
						 this._storeView,//storeView
						 this._object.get("product_identifier_type") //productIdentifierType
				);
				
				return 1;
			}
			return 0;
		    
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}  catch (MJConnectorServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	

}
