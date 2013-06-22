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

import javax.xml.rpc.ServiceException;

import org.altic.magentojconnector.magento.api.Mage_Api_Model_Server_V2_HandlerBindingStub;
import org.altic.magentojconnector.magento.api.Mage_Api_Model_Server_V2_HandlerPortType;
import org.altic.magentojconnector.magento.api.MagentoServiceLocator;
import org.altic.magentojconnector.service.exception.MJConnectorServiceException;
import org.altic.magentojconnector.service.Session;

public class SessionImpl implements Session {
	

	// Service Management
	public final static String MAGENTO_SERVICE_PATH = "/api/v2_soap/?wsdl"; 
	private Mage_Api_Model_Server_V2_HandlerPortType _service;
	
	private String 				_baseUrl;
	private String 				_servicePath;
	private String				_sessionKey;
	
	public SessionImpl(String baseUrl, String servicePath){
		this._baseUrl = baseUrl;
		this._servicePath = servicePath;
	}
	
	public SessionImpl(String baseUrl){
		this(baseUrl, MAGENTO_SERVICE_PATH);
	}
		
	public boolean close(String sessionId) throws MJConnectorServiceException {
		try{
			this.getService().endSession(sessionId);
			return true;
		}catch (RemoteException re) {
			throw new MJConnectorServiceException(re.getMessage());
		}
	}

	public Mage_Api_Model_Server_V2_HandlerPortType getService() throws MJConnectorServiceException {
		if(this._service == null)
			this.initStub();
		return this._service;
	}

	public String getSession() {
		return this._sessionKey;
	}

	public void setSession(String sessionId){
		this._sessionKey = sessionId;
	}
	
	public String open(String user, String password) throws MJConnectorServiceException {
		
		try {
			if(user == null || "".equals(user))
				throw new MJConnectorServiceException("User can not be null");
			if(password == null || "".equals(password))
				throw new MJConnectorServiceException("Password can not be null");
			
			this._sessionKey = this.getService().login(user, password);
			
			return this._sessionKey;
			
		}catch (RemoteException re) {
			throw new MJConnectorServiceException(re.getMessage());
		}
		
		
	}
	
	private void initStub() throws MJConnectorServiceException{
		
		MagentoServiceLocator serviceLocator = new MagentoServiceLocator();
		serviceLocator.setMage_Api_Model_Server_V2_HandlerPortEndpointAddress(this._baseUrl + "/" + this._servicePath);
		
		try {
			this._service = serviceLocator.getMage_Api_Model_Server_V2_HandlerPort();
			
		} catch (ServiceException e) {
			throw new MJConnectorServiceException(e.getMessage());
		}
		
		
	}
	

}
