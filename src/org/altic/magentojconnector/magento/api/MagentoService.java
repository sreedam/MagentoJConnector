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
 * MagentoService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.altic.magentojconnector.magento.api;

public interface MagentoService extends javax.xml.rpc.Service {
    public java.lang.String getMage_Api_Model_Server_V2_HandlerPortAddress();

    public org.altic.magentojconnector.magento.api.Mage_Api_Model_Server_V2_HandlerPortType getMage_Api_Model_Server_V2_HandlerPort() throws javax.xml.rpc.ServiceException;

    public org.altic.magentojconnector.magento.api.Mage_Api_Model_Server_V2_HandlerPortType getMage_Api_Model_Server_V2_HandlerPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
