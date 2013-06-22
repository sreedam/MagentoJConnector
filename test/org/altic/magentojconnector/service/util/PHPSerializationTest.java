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
package org.altic.magentojconnector.service.util;

import static org.junit.Assert.*;

import org.json.simple.JSONArray;
import org.junit.Test;
import org.lorecraft.phparser.JSONTransformer;
import org.lorecraft.phparser.SerializedPhpParser;

public class PHPSerializationTest {

	/* @Test
	public void testSerialize() {
		
		PHPSerialization.serialize(obj)
		fail("Not yet implemented");
	}*/

	@Test
	public void testUnserialize() {
		
	//Object obj = PHPSerializedTest.unserialize("a:6:{s:15:\"info_buyRequest\";a:5:{s:4:\"uenc\";s:76:\"aHR0cDovL2FkbS5hbHRpYy5wcm8vdmVzdGUtYm9nb2xhbi1tYXJyb24uaHRtbD9fX19TSUQ9VQ,,\";s:7:\"product\";s:4:\"2824\";s:15:\"related_product\";s:0:\"\";s:15:\"super_attribute\";a:1:{i:552;s:2:\"10\";}s:3:\"qty\";s:1:\"1\";}s:15:\"attributes_info\";a:1:{i:0;a:2:{s:5:\"label\";s:6:\"Taille\";s:5:\"value\";s:1:\"S\";}}s:11:\"simple_name\";s:22:\"Veste bogolan marron S\";s:10:\"simple_sku\";s:6:\"NDE083\";s:20:\"product_calculations\";i:1;s:13:\"shipment_type\";i:0;}");
		
		//Object obj = PHPSerializedTest.unserialize("a:6:{s:15:\"info_buyRequest\";a:5:{s:4:\"uenc\";s:76:\"aHR0cDovL2FkbS5hbHRpYy5wcm8vdmVzdGUtYm9nb2xhbi1tYXJyb24uaHRtbD9fX19TSUQ9VQ,,\";s:7:\"product\";s:4:\"2824\";s:15:\"related_product\";s:0:\"\";s:15:\"super_attribute\";a:1:{i:552;s:2:\"10\";}s:3:\"qty\";s:1:\"1\";}s:15:\"attributes_info\";a:1:{i:0;a:2:{s:5:\"label\";s:6:\"Taille\";s:5:\"value\";s:1:\"S\";}}}");
		
		//Object obj = PHPSerializedTest.unserialize("a:6:{s:5:\"value\";d:0.004999999888241291;s:7:\"foo_bar\";b:1;s:0:\"\";N;i:1;s:5:* \"world\";s:2:\"me\";N;i:0;s:5:\"hello\";}");
		
		String input = "a:6:{s:15:\"info_buyRequest\";a:5:{s:4:\"uenc\";s:76:\"aHR0cDovL2FkbS5hbHRpYy5wcm8vdmVzdGUtYm9nb2xhbi1tYXJyb24uaHRtbD9fX19TSUQ9VQ,,\";s:7:\"product\";s:4:\"2824\";s:15:\"related_product\";s:0:\"\";s:15:\"super_attribute\";a:1:{i:552;s:2:\"10\";}s:3:\"qty\";s:1:\"1\";}s:15:\"attributes_info\";a:1:{i:0;a:2:{s:5:\"label\";s:6:\"Taille\";s:5:\"value\";s:1:\"S\";}}s:11:\"simple_name\";s:22:\"Veste bogolan marron S\";s:10:\"simple_sku\";s:6:\"NDE083\";s:20:\"product_calculations\";i:1;s:13:\"shipment_type\";i:0;}";
		SerializedPhpParser phps = new SerializedPhpParser(input);
		
		Object res = phps.parse();
		
		System.out.println(res);
		
		JSONArray o = (JSONArray) JSONTransformer.toJSON(res);
		
		String str = ((String)((JSONArray)o.get(0)).get(0));
		
		System.out.println(o);
	}
	
	
	
}
