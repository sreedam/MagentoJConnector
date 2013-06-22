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

import java.io.IOException;

import org.apache.axis.encoding.Base64;



public class ConvertImage {
	
	public static String toBase64(String filename) throws IOException{
		return coderImage(filename);
	}
	
	private static byte[] readFileToByte(String filename) throws IOException {
	    
		java.io.File file = new java.io.File(filename);
	    java.io.BufferedInputStream bis = new java.io.BufferedInputStream(new
	        java.io.FileInputStream(file));
	    
	    int bytes = (int) file.length();
	    
	    byte[] buffer = new byte[bytes];
	    int readBytes = bis.read(buffer);
	    bis.close();
	    
	    return buffer;
	    
	  }
	  
	  // Méthode de création de la chaîne de caractères reprenant l'image
	  // NB : le nom du fichier doit être complet (ie chemin relatif ou absolu et extension)
	  
	  private static String coderImage(String fichier) throws IOException {
	    byte[] buffer = readFileToByte(fichier);
	    String encode = Base64.encode(buffer);
	    return encode;
	  }


}
