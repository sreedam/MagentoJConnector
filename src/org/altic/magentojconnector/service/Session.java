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

import org.altic.magentojconnector.magento.api.Mage_Api_Model_Server_V2_HandlerBindingStub;
import org.altic.magentojconnector.magento.api.Mage_Api_Model_Server_V2_HandlerPortType;
import org.altic.magentojconnector.service.exception.MJConnectorServiceException;

public interface Session {
	
	public String open(String user, String password)throws MJConnectorServiceException;
	public boolean close(String sessionId)  throws MJConnectorServiceException;
	public String getSession();
	public void setSession(String sessionId);	
	public Mage_Api_Model_Server_V2_HandlerPortType getService() throws MJConnectorServiceException;

}
