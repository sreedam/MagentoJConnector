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
 * CatalogProductEntity.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.altic.magentojconnector.magento.api;

public class CatalogProductEntity  implements java.io.Serializable {
/* *************************************************** */
/*                  Talend Field                       */
/* *************************************************** */
/* 
    <COLUMN KEY="false" LENGTH="50" NAME="product_id" NULLABLE="true" TYPE="id_String"/>
    <COLUMN KEY="false" LENGTH="50" NAME="sku" NULLABLE="true" TYPE="id_String"/>
    <COLUMN KEY="false" LENGTH="50" NAME="name" NULLABLE="true" TYPE="id_String"/>
    <COLUMN KEY="false" LENGTH="50" NAME="set" NULLABLE="true" TYPE="id_String"/>
    <COLUMN KEY="false" LENGTH="50" NAME="type" NULLABLE="true" TYPE="id_String"/>
    <COLUMN KEY="false" LENGTH="50" NAME="category_ids" NULLABLE="true" TYPE="id_String"/>
    <COLUMN KEY="false" LENGTH="50" NAME="website_ids" NULLABLE="true" TYPE="id_String"/>

*/
    private java.lang.String product_id;

    private java.lang.String sku;

    private java.lang.String name;

    private java.lang.String set;

    private java.lang.String type;

    private java.lang.String[] category_ids;

    private java.lang.String[] website_ids;

    public CatalogProductEntity() {
    }

    public CatalogProductEntity(
           java.lang.String product_id,
           java.lang.String sku,
           java.lang.String name,
           java.lang.String set,
           java.lang.String type,
           java.lang.String[] category_ids,
           java.lang.String[] website_ids) {
           this.product_id = product_id;
           this.sku = sku;
           this.name = name;
           this.set = set;
           this.type = type;
           this.category_ids = category_ids;
           this.website_ids = website_ids;
    }


    /**
     * Gets the product_id value for this CatalogProductEntity.
     * 
     * @return product_id
     */
    public java.lang.String getProduct_id() {
        return product_id;
    }


    /**
     * Sets the product_id value for this CatalogProductEntity.
     * 
     * @param product_id
     */
    public void setProduct_id(java.lang.String product_id) {
        this.product_id = product_id;
    }


    /**
     * Gets the sku value for this CatalogProductEntity.
     * 
     * @return sku
     */
    public java.lang.String getSku() {
        return sku;
    }


    /**
     * Sets the sku value for this CatalogProductEntity.
     * 
     * @param sku
     */
    public void setSku(java.lang.String sku) {
        this.sku = sku;
    }


    /**
     * Gets the name value for this CatalogProductEntity.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this CatalogProductEntity.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the set value for this CatalogProductEntity.
     * 
     * @return set
     */
    public java.lang.String getSet() {
        return set;
    }


    /**
     * Sets the set value for this CatalogProductEntity.
     * 
     * @param set
     */
    public void setSet(java.lang.String set) {
        this.set = set;
    }


    /**
     * Gets the type value for this CatalogProductEntity.
     * 
     * @return type
     */
    public java.lang.String getType() {
        return type;
    }


    /**
     * Sets the type value for this CatalogProductEntity.
     * 
     * @param type
     */
    public void setType(java.lang.String type) {
        this.type = type;
    }


    /**
     * Gets the category_ids value for this CatalogProductEntity.
     * 
     * @return category_ids
     */
    public java.lang.String[] getCategory_ids() {
        return category_ids;
    }


    /**
     * Sets the category_ids value for this CatalogProductEntity.
     * 
     * @param category_ids
     */
    public void setCategory_ids(java.lang.String[] category_ids) {
        this.category_ids = category_ids;
    }


    /**
     * Gets the website_ids value for this CatalogProductEntity.
     * 
     * @return website_ids
     */
    public java.lang.String[] getWebsite_ids() {
        return website_ids;
    }


    /**
     * Sets the website_ids value for this CatalogProductEntity.
     * 
     * @param website_ids
     */
    public void setWebsite_ids(java.lang.String[] website_ids) {
        this.website_ids = website_ids;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CatalogProductEntity)) return false;
        CatalogProductEntity other = (CatalogProductEntity) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.product_id==null && other.getProduct_id()==null) || 
             (this.product_id!=null &&
              this.product_id.equals(other.getProduct_id()))) &&
            ((this.sku==null && other.getSku()==null) || 
             (this.sku!=null &&
              this.sku.equals(other.getSku()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.set==null && other.getSet()==null) || 
             (this.set!=null &&
              this.set.equals(other.getSet()))) &&
            ((this.type==null && other.getType()==null) || 
             (this.type!=null &&
              this.type.equals(other.getType()))) &&
            ((this.category_ids==null && other.getCategory_ids()==null) || 
             (this.category_ids!=null &&
              java.util.Arrays.equals(this.category_ids, other.getCategory_ids()))) &&
            ((this.website_ids==null && other.getWebsite_ids()==null) || 
             (this.website_ids!=null &&
              java.util.Arrays.equals(this.website_ids, other.getWebsite_ids())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getProduct_id() != null) {
            _hashCode += getProduct_id().hashCode();
        }
        if (getSku() != null) {
            _hashCode += getSku().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getSet() != null) {
            _hashCode += getSet().hashCode();
        }
        if (getType() != null) {
            _hashCode += getType().hashCode();
        }
        if (getCategory_ids() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCategory_ids());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCategory_ids(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getWebsite_ids() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getWebsite_ids());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getWebsite_ids(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CatalogProductEntity.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:Magento", "catalogProductEntity"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("product_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "product_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sku");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sku"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("set");
        elemField.setXmlName(new javax.xml.namespace.QName("", "set"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("type");
        elemField.setXmlName(new javax.xml.namespace.QName("", "type"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("category_ids");
        elemField.setXmlName(new javax.xml.namespace.QName("", "category_ids"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("website_ids");
        elemField.setXmlName(new javax.xml.namespace.QName("", "website_ids"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
