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
 * Filters.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.altic.magentojconnector.magento.api;

public class Filters  implements java.io.Serializable {
/* *************************************************** */
/*                  Talend Field                       */
/* *************************************************** */
/* 
    <COLUMN KEY="false" LENGTH="50" NAME="filter" NULLABLE="true" TYPE="id_String"/>
    <COLUMN KEY="false" LENGTH="50" NAME="complex_filter" NULLABLE="true" TYPE="id_String"/>

*/
    private org.altic.magentojconnector.magento.api.AssociativeEntity[] filter;

    private org.altic.magentojconnector.magento.api.ComplexFilter[] complex_filter;

    public Filters() {
    }

    public Filters(
           org.altic.magentojconnector.magento.api.AssociativeEntity[] filter,
           org.altic.magentojconnector.magento.api.ComplexFilter[] complex_filter) {
           this.filter = filter;
           this.complex_filter = complex_filter;
    }


    /**
     * Gets the filter value for this Filters.
     * 
     * @return filter
     */
    public org.altic.magentojconnector.magento.api.AssociativeEntity[] getFilter() {
        return filter;
    }


    /**
     * Sets the filter value for this Filters.
     * 
     * @param filter
     */
    public void setFilter(org.altic.magentojconnector.magento.api.AssociativeEntity[] filter) {
        this.filter = filter;
    }


    /**
     * Gets the complex_filter value for this Filters.
     * 
     * @return complex_filter
     */
    public org.altic.magentojconnector.magento.api.ComplexFilter[] getComplex_filter() {
        return complex_filter;
    }


    /**
     * Sets the complex_filter value for this Filters.
     * 
     * @param complex_filter
     */
    public void setComplex_filter(org.altic.magentojconnector.magento.api.ComplexFilter[] complex_filter) {
        this.complex_filter = complex_filter;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Filters)) return false;
        Filters other = (Filters) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.filter==null && other.getFilter()==null) || 
             (this.filter!=null &&
              java.util.Arrays.equals(this.filter, other.getFilter()))) &&
            ((this.complex_filter==null && other.getComplex_filter()==null) || 
             (this.complex_filter!=null &&
              java.util.Arrays.equals(this.complex_filter, other.getComplex_filter())));
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
        if (getFilter() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFilter());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFilter(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getComplex_filter() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getComplex_filter());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getComplex_filter(), i);
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
        new org.apache.axis.description.TypeDesc(Filters.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:Magento", "filters"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filter");
        elemField.setXmlName(new javax.xml.namespace.QName("", "filter"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:Magento", "associativeEntity"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("complex_filter");
        elemField.setXmlName(new javax.xml.namespace.QName("", "complex_filter"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:Magento", "complexFilter"));
        elemField.setMinOccurs(0);
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
