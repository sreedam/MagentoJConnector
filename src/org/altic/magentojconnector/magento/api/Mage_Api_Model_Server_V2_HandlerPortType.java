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
 * Mage_Api_Model_Server_V2_HandlerPortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.altic.magentojconnector.magento.api;

public interface Mage_Api_Model_Server_V2_HandlerPortType extends java.rmi.Remote {

    /**
     * End web service session
     */
    public boolean endSession(java.lang.String sessionId) throws java.rmi.RemoteException;

    /**
     * Login user and retrive session id
     */
    public java.lang.String login(java.lang.String username, java.lang.String apiKey) throws java.rmi.RemoteException;

    /**
     * Start web service session
     */
    public java.lang.String startSession() throws java.rmi.RemoteException;

    /**
     * List of available resources
     */
    public org.altic.magentojconnector.magento.api.ApiEntity[] resources(java.lang.String sessionId) throws java.rmi.RemoteException;

    /**
     * List of global faults
     */
    public org.altic.magentojconnector.magento.api.ExistsFaltureEntity[] globalFaults(java.lang.String sessionId) throws java.rmi.RemoteException;

    /**
     * List of resource faults
     */
    public org.altic.magentojconnector.magento.api.ExistsFaltureEntity[] resourceFaults(java.lang.String resourceName, java.lang.String sessionId) throws java.rmi.RemoteException;

    /**
     * List of countries
     */
    public org.altic.magentojconnector.magento.api.DirectoryCountryEntity[] directoryCountryList(java.lang.String sessionId) throws java.rmi.RemoteException;

    /**
     * List of regions in specified country
     */
    public org.altic.magentojconnector.magento.api.DirectoryRegionEntity[] directoryRegionList(java.lang.String sessionId, java.lang.String country) throws java.rmi.RemoteException;

    /**
     * Retrieve customers
     */
    public org.altic.magentojconnector.magento.api.CustomerCustomerEntity[] customerCustomerList(java.lang.String sessionId, org.altic.magentojconnector.magento.api.Filters filters) throws java.rmi.RemoteException;

    /**
     * Create customer
     */
    public int customerCustomerCreate(java.lang.String sessionId, org.altic.magentojconnector.magento.api.CustomerCustomerEntityToCreate customerData) throws java.rmi.RemoteException;

    /**
     * Retrieve customer data
     */
    public org.altic.magentojconnector.magento.api.CustomerCustomerEntity customerCustomerInfo(java.lang.String sessionId, int customerId, java.lang.String[] attributes) throws java.rmi.RemoteException;

    /**
     * Update customer data
     */
    public boolean customerCustomerUpdate(java.lang.String sessionId, int customerId, org.altic.magentojconnector.magento.api.CustomerCustomerEntityToCreate customerData) throws java.rmi.RemoteException;

    /**
     * Delete customer
     */
    public boolean customerCustomerDelete(java.lang.String sessionId, int customerId) throws java.rmi.RemoteException;

    /**
     * Retrieve customer groups
     */
    public org.altic.magentojconnector.magento.api.CustomerGroupEntity[] customerGroupList(java.lang.String sessionId) throws java.rmi.RemoteException;

    /**
     * Retrieve customer addresses
     */
    public org.altic.magentojconnector.magento.api.CustomerAddressEntityItem[] customerAddressList(java.lang.String sessionId, int customerId) throws java.rmi.RemoteException;

    /**
     * Create customer address
     */
    public int customerAddressCreate(java.lang.String sessionId, int customerId, org.altic.magentojconnector.magento.api.CustomerAddressEntityCreate addressData) throws java.rmi.RemoteException;

    /**
     * Retrieve customer address data
     */
    public org.altic.magentojconnector.magento.api.CustomerAddressEntityItem customerAddressInfo(java.lang.String sessionId, int addressId) throws java.rmi.RemoteException;

    /**
     * Update customer address data
     */
    public boolean customerAddressUpdate(java.lang.String sessionId, int addressId, org.altic.magentojconnector.magento.api.CustomerAddressEntityCreate addressData) throws java.rmi.RemoteException;

    /**
     * Delete customer address
     */
    public boolean customerAddressDelete(java.lang.String sessionId, int addressId) throws java.rmi.RemoteException;

    /**
     * Set_Get current store view
     */
    public int catalogCategoryCurrentStore(java.lang.String sessionId, java.lang.String storeView) throws java.rmi.RemoteException;

    /**
     * Retrieve hierarchical tree of categories.
     */
    public org.altic.magentojconnector.magento.api.CatalogCategoryTree catalogCategoryTree(java.lang.String sessionId, java.lang.String parentId, java.lang.String storeView) throws java.rmi.RemoteException;

    /**
     * Retrieve hierarchical tree of categories.
     */
    public org.altic.magentojconnector.magento.api.CatalogCategoryEntityNoChildren[] catalogCategoryLevel(java.lang.String sessionId, java.lang.String website, java.lang.String storeView, java.lang.String parentCategory) throws java.rmi.RemoteException;

    /**
     * Retrieve hierarchical tree of categories.
     */
    public org.altic.magentojconnector.magento.api.CatalogCategoryInfo catalogCategoryInfo(java.lang.String sessionId, int categoryId, java.lang.String storeView, java.lang.String[] attributes) throws java.rmi.RemoteException;

    /**
     * Create new category and return its id.
     */
    public int catalogCategoryCreate(java.lang.String sessionId, int parentId, org.altic.magentojconnector.magento.api.CatalogCategoryEntityCreate categoryData, java.lang.String storeView) throws java.rmi.RemoteException;

    /**
     * Update category
     */
    public boolean catalogCategoryUpdate(java.lang.String sessionId, int categoryId, org.altic.magentojconnector.magento.api.CatalogCategoryEntityCreate categoryData, java.lang.String storeView) throws java.rmi.RemoteException;

    /**
     * Move category in tree
     */
    public boolean catalogCategoryMove(java.lang.String sessionId, int categoryId, int parentId, java.lang.String afterId) throws java.rmi.RemoteException;

    /**
     * Delete category
     */
    public boolean catalogCategoryDelete(java.lang.String sessionId, int categoryId) throws java.rmi.RemoteException;

    /**
     * Retrieve list of assigned products
     */
    public org.altic.magentojconnector.magento.api.CatalogAssignedProduct[] catalogCategoryAssignedProducts(java.lang.String sessionId, int categoryId) throws java.rmi.RemoteException;

    /**
     * Assign product to category
     */
    public boolean catalogCategoryAssignProduct(java.lang.String sessionId, int categoryId, java.lang.String product, java.lang.String position, java.lang.String productIdentifierType) throws java.rmi.RemoteException;

    /**
     * Update assigned product
     */
    public boolean catalogCategoryUpdateProduct(java.lang.String sessionId, int categoryId, java.lang.String product, java.lang.String position, java.lang.String productIdentifierType) throws java.rmi.RemoteException;

    /**
     * Remove product assignment from category
     */
    public boolean catalogCategoryRemoveProduct(java.lang.String sessionId, int categoryId, java.lang.String product, java.lang.String productIdentifierType) throws java.rmi.RemoteException;

    /**
     * Set/Get current store view
     */
    public int catalogCategoryAttributeCurrentStore(java.lang.String sessionId, java.lang.String storeView) throws java.rmi.RemoteException;

    /**
     * Retrieve category attributes
     */
    public org.altic.magentojconnector.magento.api.CatalogAttributeEntity[] catalogCategoryAttributeList(java.lang.String sessionId) throws java.rmi.RemoteException;

    /**
     * Retrieve attribute options
     */
    public org.altic.magentojconnector.magento.api.CatalogAttributeOptionEntity[] catalogCategoryAttributeOptions(java.lang.String sessionId, java.lang.String attributeId, java.lang.String storeView) throws java.rmi.RemoteException;

    /**
     * Set/Get current store view
     */
    public int catalogProductCurrentStore(java.lang.String sessionId, java.lang.String storeView) throws java.rmi.RemoteException;

    /**
     * Retrieve products list by filters
     */
    public org.altic.magentojconnector.magento.api.CatalogProductEntity[] catalogProductList(java.lang.String sessionId, org.altic.magentojconnector.magento.api.Filters filters, java.lang.String storeView) throws java.rmi.RemoteException;

    /**
     * Retrieve product
     */
    public org.altic.magentojconnector.magento.api.CatalogProductReturnEntity catalogProductInfo(java.lang.String sessionId, java.lang.String product, java.lang.String storeView, org.altic.magentojconnector.magento.api.CatalogProductRequestAttributes attributes, java.lang.String productIdentifierType) throws java.rmi.RemoteException;

    /**
     * Create new product and return product id
     */
    public int catalogProductCreate(java.lang.String sessionId, java.lang.String type, java.lang.String set, java.lang.String sku, org.altic.magentojconnector.magento.api.CatalogProductCreateEntity productData) throws java.rmi.RemoteException;

    /**
     * Update product
     */
    public boolean catalogProductUpdate(java.lang.String sessionId, java.lang.String product, org.altic.magentojconnector.magento.api.CatalogProductCreateEntity productData, java.lang.String storeView, java.lang.String productIdentifierType) throws java.rmi.RemoteException;

    /**
     * Update product special price
     */
    public int catalogProductSetSpecialPrice(java.lang.String sessionId, java.lang.String product, java.lang.String specialPrice, java.lang.String fromDate, java.lang.String toDate, java.lang.String storeView, java.lang.String productIdentifierType) throws java.rmi.RemoteException;

    /**
     * Get product special price data
     */
    public org.altic.magentojconnector.magento.api.CatalogProductReturnEntity catalogProductGetSpecialPrice(java.lang.String sessionId, java.lang.String product, java.lang.String storeView, java.lang.String productIdentifierType) throws java.rmi.RemoteException;

    /**
     * Delete product
     */
    public int catalogProductDelete(java.lang.String sessionId, java.lang.String product, java.lang.String productIdentifierType) throws java.rmi.RemoteException;

    /**
     * Set/Get current store view
     */
    public int catalogProductAttributeCurrentStore(java.lang.String sessionId, java.lang.String storeView) throws java.rmi.RemoteException;

    /**
     * Retrieve attribute list
     */
    public org.altic.magentojconnector.magento.api.CatalogAttributeEntity[] catalogProductAttributeList(java.lang.String sessionId, int setId) throws java.rmi.RemoteException;

    /**
     * Retrieve attribute options
     */
    public org.altic.magentojconnector.magento.api.CatalogAttributeOptionEntity[] catalogProductAttributeOptions(java.lang.String sessionId, java.lang.String attributeId, java.lang.String storeView) throws java.rmi.RemoteException;

    /**
     * Retrieve product attribute sets
     */
    public org.altic.magentojconnector.magento.api.CatalogProductAttributeSetEntity[] catalogProductAttributeSetList(java.lang.String sessionId) throws java.rmi.RemoteException;

    /**
     * Retrieve product types
     */
    public org.altic.magentojconnector.magento.api.CatalogProductTypeEntity[] catalogProductTypeList(java.lang.String sessionId) throws java.rmi.RemoteException;

    /**
     * Retrieve product tier prices
     */
    public org.altic.magentojconnector.magento.api.CatalogProductTierPriceEntity[] catalogProductAttributeTierPriceInfo(java.lang.String sessionId, java.lang.String product, java.lang.String productIdentifierType) throws java.rmi.RemoteException;

    /**
     * Update product tier prices
     */
    public int catalogProductAttributeTierPriceUpdate(java.lang.String sessionId, java.lang.String product, org.altic.magentojconnector.magento.api.CatalogProductTierPriceEntity[] tier_price, java.lang.String productIdentifierType) throws java.rmi.RemoteException;

    /**
     * Set/Get current store view
     */
    public int catalogProductAttributeMediaCurrentStore(java.lang.String sessionId, java.lang.String storeView) throws java.rmi.RemoteException;

    /**
     * Retrieve product image list
     */
    public org.altic.magentojconnector.magento.api.CatalogProductImageEntity[] catalogProductAttributeMediaList(java.lang.String sessionId, java.lang.String product, java.lang.String storeView, java.lang.String productIdentifierType) throws java.rmi.RemoteException;

    /**
     * Retrieve product image data
     */
    public org.altic.magentojconnector.magento.api.CatalogProductImageEntity catalogProductAttributeMediaInfo(java.lang.String sessionId, java.lang.String product, java.lang.String file, java.lang.String storeView, java.lang.String productIdentifierType) throws java.rmi.RemoteException;

    /**
     * Retrieve product image types
     */
    public org.altic.magentojconnector.magento.api.CatalogProductAttributeMediaTypeEntity[] catalogProductAttributeMediaTypes(java.lang.String sessionId, java.lang.String setId) throws java.rmi.RemoteException;

    /**
     * Upload new product image
     */
    public java.lang.String catalogProductAttributeMediaCreate(java.lang.String sessionId, java.lang.String product, org.altic.magentojconnector.magento.api.CatalogProductAttributeMediaCreateEntity data, java.lang.String storeView, java.lang.String productIdentifierType) throws java.rmi.RemoteException;

    /**
     * Update product image
     */
    public int catalogProductAttributeMediaUpdate(java.lang.String sessionId, java.lang.String product, java.lang.String file, org.altic.magentojconnector.magento.api.CatalogProductAttributeMediaCreateEntity data, java.lang.String storeView, java.lang.String productIdentifierType) throws java.rmi.RemoteException;

    /**
     * Remove product image
     */
    public int catalogProductAttributeMediaRemove(java.lang.String sessionId, java.lang.String product, java.lang.String file, java.lang.String productIdentifierType) throws java.rmi.RemoteException;

    /**
     * Retrieve linked products
     */
    public org.altic.magentojconnector.magento.api.CatalogProductLinkEntity[] catalogProductLinkList(java.lang.String sessionId, java.lang.String type, java.lang.String product, java.lang.String productIdentifierType) throws java.rmi.RemoteException;

    /**
     * Assign product link
     */
    public java.lang.String catalogProductLinkAssign(java.lang.String sessionId, java.lang.String type, java.lang.String product, java.lang.String linkedProduct, org.altic.magentojconnector.magento.api.CatalogProductLinkEntity data, java.lang.String productIdentifierType) throws java.rmi.RemoteException;

    /**
     * Update product link
     */
    public java.lang.String catalogProductLinkUpdate(java.lang.String sessionId, java.lang.String type, java.lang.String product, java.lang.String linkedProduct, org.altic.magentojconnector.magento.api.CatalogProductLinkEntity data, java.lang.String productIdentifierType) throws java.rmi.RemoteException;

    /**
     * Remove product link
     */
    public java.lang.String catalogProductLinkRemove(java.lang.String sessionId, java.lang.String type, java.lang.String product, java.lang.String linkedProduct, java.lang.String productIdentifierType) throws java.rmi.RemoteException;

    /**
     * Retrieve product link types
     */
    public java.lang.String[] catalogProductLinkTypes(java.lang.String sessionId) throws java.rmi.RemoteException;

    /**
     * Retrieve product link type attributes
     */
    public org.altic.magentojconnector.magento.api.CatalogProductLinkAttributeEntity[] catalogProductLinkAttributes(java.lang.String sessionId, java.lang.String type) throws java.rmi.RemoteException;

    /**
     * Retrieve list of orders by filters
     */
    public org.altic.magentojconnector.magento.api.SalesOrderEntity[] salesOrderList(java.lang.String sessionId, org.altic.magentojconnector.magento.api.Filters filters) throws java.rmi.RemoteException;

    /**
     * Retrieve order information
     */
    public org.altic.magentojconnector.magento.api.SalesOrderEntity salesOrderInfo(java.lang.String sessionId, java.lang.String orderIncrementId) throws java.rmi.RemoteException;

    /**
     * Add comment to order
     */
    public int salesOrderAddComment(java.lang.String sessionId, java.lang.String orderIncrementId, java.lang.String status, java.lang.String comment, java.lang.String notify) throws java.rmi.RemoteException;

    /**
     * Hold order
     */
    public int salesOrderHold(java.lang.String sessionId, java.lang.String orderIncrementId) throws java.rmi.RemoteException;

    /**
     * Unhold order
     */
    public int salesOrderUnhold(java.lang.String sessionId, java.lang.String orderIncrementId) throws java.rmi.RemoteException;

    /**
     * Cancel order
     */
    public int salesOrderCancel(java.lang.String sessionId, java.lang.String orderIncrementId) throws java.rmi.RemoteException;

    /**
     * Retrieve list of shipments by filters
     */
    public org.altic.magentojconnector.magento.api.SalesOrderShipmentEntity[] salesOrderShipmentList(java.lang.String sessionId, org.altic.magentojconnector.magento.api.Filters filters) throws java.rmi.RemoteException;

    /**
     * Retrieve shipment information
     */
    public org.altic.magentojconnector.magento.api.SalesOrderShipmentEntity salesOrderShipmentInfo(java.lang.String sessionId, java.lang.String shipmentIncrementId) throws java.rmi.RemoteException;

    /**
     * Create new shipment for order
     */
    public java.lang.String salesOrderShipmentCreate(java.lang.String sessionId, java.lang.String orderIncrementId, org.altic.magentojconnector.magento.api.OrderItemIdQty[] itemsQty, java.lang.String comment, int email, int includeComment) throws java.rmi.RemoteException;

    /**
     * Add new comment to shipment
     */
    public int salesOrderShipmentAddComment(java.lang.String sessionId, java.lang.String shipmentIncrementId, java.lang.String comment, java.lang.String email, java.lang.String includeInEmail) throws java.rmi.RemoteException;

    /**
     * Add new tracking number
     */
    public int salesOrderShipmentAddTrack(java.lang.String sessionId, java.lang.String shipmentIncrementId, java.lang.String carrier, java.lang.String title, java.lang.String trackNumber) throws java.rmi.RemoteException;

    /**
     * Remove tracking number
     */
    public int salesOrderShipmentRemoveTrack(java.lang.String sessionId, java.lang.String shipmentIncrementId, java.lang.String trackId) throws java.rmi.RemoteException;

    /**
     * Retrieve list of allowed carriers for order
     */
    public org.altic.magentojconnector.magento.api.AssociativeEntity[] salesOrderShipmentGetCarriers(java.lang.String sessionId, java.lang.String orderIncrementId) throws java.rmi.RemoteException;

    /**
     * Retrieve list of invoices by filters
     */
    public org.altic.magentojconnector.magento.api.SalesOrderInvoiceEntity[] salesOrderInvoiceList(java.lang.String sessionId, org.altic.magentojconnector.magento.api.Filters filters) throws java.rmi.RemoteException;

    /**
     * Retrieve invoice information
     */
    public org.altic.magentojconnector.magento.api.SalesOrderInvoiceEntity salesOrderInvoiceInfo(java.lang.String sessionId, java.lang.String invoiceIncrementId) throws java.rmi.RemoteException;

    /**
     * Create new invoice for order
     */
    public java.lang.String salesOrderInvoiceCreate(java.lang.String sessionId, java.lang.String invoiceIncrementId, org.altic.magentojconnector.magento.api.OrderItemIdQty[] itemsQty, java.lang.String comment, java.lang.String email, java.lang.String includeComment) throws java.rmi.RemoteException;

    /**
     * Add new comment to shipment
     */
    public java.lang.String salesOrderInvoiceAddComment(java.lang.String sessionId, java.lang.String invoiceIncrementId, java.lang.String comment, java.lang.String email, java.lang.String includeComment) throws java.rmi.RemoteException;

    /**
     * Capture invoice
     */
    public java.lang.String salesOrderInvoiceCapture(java.lang.String sessionId, java.lang.String invoiceIncrementId) throws java.rmi.RemoteException;

    /**
     * Void invoice
     */
    public java.lang.String salesOrderInvoiceVoid(java.lang.String sessionId, java.lang.String invoiceIncrementId) throws java.rmi.RemoteException;

    /**
     * Cancel invoice
     */
    public java.lang.String salesOrderInvoiceCancel(java.lang.String sessionId, java.lang.String invoiceIncrementId) throws java.rmi.RemoteException;

    /**
     * Retrieve stock data by product ids
     */
    public org.altic.magentojconnector.magento.api.CatalogInventoryStockItemEntity[] catalogInventoryStockItemList(java.lang.String sessionId, java.lang.String[] products) throws java.rmi.RemoteException;

    /**
     * Update product stock data
     */
    public int catalogInventoryStockItemUpdate(java.lang.String sessionId, java.lang.String product, org.altic.magentojconnector.magento.api.CatalogInventoryStockItemUpdateEntity data) throws java.rmi.RemoteException;
}
