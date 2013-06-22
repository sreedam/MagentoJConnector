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
 * CatalogProductAttributeMediaCreateEntity.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.altic.magentojconnector.magento.api;

public class CatalogProductAttributeMediaCreateEntity  implements java.io.Serializable {
/* *************************************************** */
/*                  Talend Field                       */
/* *************************************************** */
/* 
    <COLUMN KEY="false" LENGTH="50" NAME="file" NULLABLE="true" TYPE="id_String"/>
    <COLUMN KEY="false" LENGTH="50" NAME="label" NULLABLE="true" TYPE="id_String"/>
    <COLUMN KEY="false" LENGTH="50" NAME="position" NULLABLE="true" TYPE="id_String"/>
    <COLUMN KEY="false" LENGTH="50" NAME="types" NULLABLE="true" TYPE="id_String"/>
    <COLUMN KEY="false" LENGTH="50" NAME="exclude" NULLABLE="true" TYPE="id_String"/>
    <COLUMN KEY="false" LENGTH="50" NAME="remove" NULLABLE="true" TYPE="id_String"/>

*/
    private org.altic.magentojconnector.magento.api.CatalogProductImageFileEntity file;

    private java.lang.String label;

    private java.lang.String position;

    private java.lang.String[] types;

    private java.lang.String exclude;

    private java.lang.String remove;

    public CatalogProductAttributeMediaCreateEntity() {
    }

    public CatalogProductAttributeMediaCreateEntity(
           org.altic.magentojconnector.magento.api.CatalogProductImageFileEntity file,
           java.lang.String label,
           java.lang.String position,
           java.lang.String[] types,
           java.lang.String exclude,
           java.lang.String remove) {
           this.file = file;
           this.label = label;
           this.position = position;
           this.types = types;
           this.exclude = exclude;
           this.remove = remove;
    }


    /**
     * Gets the file value for this CatalogProductAttributeMediaCreateEntity.
     * 
     * @return file
     */
    public org.altic.magentojconnector.magento.api.CatalogProductImageFileEntity getFile() {
        return file;
    }


    /**
     * Sets the file value for this CatalogProductAttributeMediaCreateEntity.
     * 
     * @param file
     */
    public void setFile(org.altic.magentojconnector.magento.api.CatalogProductImageFileEntity file) {
        this.file = file;
    }


    /**
     * Gets the label value for this CatalogProductAttributeMediaCreateEntity.
     * 
     * @return label
     */
    public java.lang.String getLabel() {
        return label;
    }


    /**
     * Sets the label value for this CatalogProductAttributeMediaCreateEntity.
     * 
     * @param label
     */
    public void setLabel(java.lang.String label) {
        this.label = label;
    }


    /**
     * Gets the position value for this CatalogProductAttributeMediaCreateEntity.
     * 
     * @return position
     */
    public java.lang.String getPosition() {
        return position;
    }


    /**
     * Sets the position value for this CatalogProductAttributeMediaCreateEntity.
     * 
     * @param position
     */
    public void setPosition(java.lang.String position) {
        this.position = position;
    }


    /**
     * Gets the types value for this CatalogProductAttributeMediaCreateEntity.
     * 
     * @return types
     */
    public java.lang.String[] getTypes() {
        return types;
    }


    /**
     * Sets the types value for this CatalogProductAttributeMediaCreateEntity.
     * 
     * @param types
     */
    public void setTypes(java.lang.String[] types) {
        this.types = types;
    }


    /**
     * Gets the exclude value for this CatalogProductAttributeMediaCreateEntity.
     * 
     * @return exclude
     */
    public java.lang.String getExclude() {
        return exclude;
    }


    /**
     * Sets the exclude value for this CatalogProductAttributeMediaCreateEntity.
     * 
     * @param exclude
     */
    public void setExclude(java.lang.String exclude) {
        this.exclude = exclude;
    }


    /**
     * Gets the remove value for this CatalogProductAttributeMediaCreateEntity.
     * 
     * @return remove
     */
    public java.lang.String getRemove() {
        return remove;
    }


    /**
     * Sets the remove value for this CatalogProductAttributeMediaCreateEntity.
     * 
     * @param remove
     */
    public void setRemove(java.lang.String remove) {
        this.remove = remove;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CatalogProductAttributeMediaCreateEntity)) return false;
        CatalogProductAttributeMediaCreateEntity other = (CatalogProductAttributeMediaCreateEntity) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.file==null && other.getFile()==null) || 
             (this.file!=null &&
              this.file.equals(other.getFile()))) &&
            ((this.label==null && other.getLabel()==null) || 
             (this.label!=null &&
              this.label.equals(other.getLabel()))) &&
            ((this.position==null && other.getPosition()==null) || 
             (this.position!=null &&
              this.position.equals(other.getPosition()))) &&
            ((this.types==null && other.getTypes()==null) || 
             (this.types!=null &&
              java.util.Arrays.equals(this.types, other.getTypes()))) &&
            ((this.exclude==null && other.getExclude()==null) || 
             (this.exclude!=null &&
              this.exclude.equals(other.getExclude()))) &&
            ((this.remove==null && other.getRemove()==null) || 
             (this.remove!=null &&
              this.remove.equals(other.getRemove())));
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
        if (getFile() != null) {
            _hashCode += getFile().hashCode();
        }
        if (getLabel() != null) {
            _hashCode += getLabel().hashCode();
        }
        if (getPosition() != null) {
            _hashCode += getPosition().hashCode();
        }
        if (getTypes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getTypes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getTypes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getExclude() != null) {
            _hashCode += getExclude().hashCode();
        }
        if (getRemove() != null) {
            _hashCode += getRemove().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CatalogProductAttributeMediaCreateEntity.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:Magento", "catalogProductAttributeMediaCreateEntity"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("file");
        elemField.setXmlName(new javax.xml.namespace.QName("", "file"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:Magento", "catalogProductImageFileEntity"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("label");
        elemField.setXmlName(new javax.xml.namespace.QName("", "label"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("position");
        elemField.setXmlName(new javax.xml.namespace.QName("", "position"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("types");
        elemField.setXmlName(new javax.xml.namespace.QName("", "types"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exclude");
        elemField.setXmlName(new javax.xml.namespace.QName("", "exclude"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("remove");
        elemField.setXmlName(new javax.xml.namespace.QName("", "remove"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
