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

import org.altic.magentojconnector.magento.api.*;
import org.altic.magentojconnector.service.InputOperation;
import org.altic.magentojconnector.service.OutputOperation;
import org.altic.magentojconnector.service.Session;

public class Operation {
	
	private OutputOperation 	_outOperation;
	private InputOperation		_inOperation;
	
	// Session Management
	private String 				_user;
	private String 				_passwd;
	private String 				_sessionKey;
	private Session				_session;
	
	// Operation Management
	private String 				_objectName;
	private String 				_operationName;
	private String 				_resourcePath;
	
	
	
}
