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
package org.altic.magentojconnector.magento.pojo;

import java.util.HashMap;

public class ConfigurableProduct {
	
	
	private String ibUenc;
	private String ibProductId;
	private String ibRelatedProduct;
	private String ibSuperAttribute;
	private String ibQuantity;
	private HashMap<String, String> attributes;
	private String pdtName;
	private String pdtSku;
	private Integer pdtCalculation;
	private Integer pdtShipmentType;
	
	
	public String getIbUenc() {
		return ibUenc;
	}
	public void setIbUenc(String ibUenc) {
		this.ibUenc = ibUenc;
	}
	public String getIbProductId() {
		return ibProductId;
	}
	public void setIbProductId(String ibProductId) {
		this.ibProductId = ibProductId;
	}
	public String getIbRelatedProduct() {
		return ibRelatedProduct;
	}
	public void setIbRelatedProduct(String ibRelatedProduct) {
		this.ibRelatedProduct = ibRelatedProduct;
	}
	public String getIbSuperAttribute() {
		return ibSuperAttribute;
	}
	public void setIbSuperAttribute(String ibSuperAttribute) {
		this.ibSuperAttribute = ibSuperAttribute;
	}
	public String getIbQuantity() {
		return ibQuantity;
	}
	public void setIbQuantity(String ibQuantity) {
		this.ibQuantity = ibQuantity;
	}
	public HashMap<String, String> getAttributes() {
		return attributes;
	}
	public void setAttributes(HashMap<String, String> attributes) {
		this.attributes = attributes;
	}
	public String getPdtName() {
		return pdtName;
	}
	public void setPdtName(String pdtName) {
		this.pdtName = pdtName;
	}
	public String getPdtSku() {
		return pdtSku;
	}
	public void setPdtSku(String pdtSku) {
		this.pdtSku = pdtSku;
	}
	public Integer getPdtCalculation() {
		return pdtCalculation;
	}
	public void setPdtCalculation(Integer pdtCalculation) {
		this.pdtCalculation = pdtCalculation;
	}
	public Integer getPdtShipmentType() {
		return pdtShipmentType;
	}
	public void setPdtShipmentType(Integer pdtShipmentType) {
		this.pdtShipmentType = pdtShipmentType;
	}
	
	

}
