/*
 * File   : $Source: /alkacon/cvs/opencms/src/com/opencms/core/Attic/CmsMultipartInputStreamHandler.java,v $
 * Date   : $Date: 2000/02/15 17:53:48 $
 * Version: $Revision: 1.3 $
 *
 * Copyright (C) 2000  The OpenCms Group 
 * 
 * This File is part of OpenCms -
 * the Open Source Content Mananagement System
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * For further information about OpenCms, please see the
 * OpenCms Website: http://www.opencms.com
 * 
 * You should have received a copy of the GNU General Public License
 * long with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package com.opencms.core;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;

/**A class to aid in reading multipart/form-data from a ServletInputStream.
* <p>
* It keeps track of how many bytes have been read and detects when the
* Content-Length limit has been reached.  This is necessary since some 
* servlet engines are slow to notice the end of stream.
*/
class CmsMultipartInputStreamHandler
{

  ServletInputStream m_in;
  String m_boundary;
  int m_totalExpected;
  int totalRead = 0;
  byte[] buf = new byte[8 * 1024];

  /**
   * Constructor, creates a new CmsMultipartInputStreamHandler
   * 
   * @param in An input stream
   * @param boundary Boundary defintition
   * @param totalExpected Number of bytes expected to be read 
   */
  public CmsMultipartInputStreamHandler(ServletInputStream in,
                                     String boundary,
                                     int totalExpected) {
    m_in = in;
    m_boundary = boundary;
    m_totalExpected = totalExpected;
  }

  /** Reads the next line of input.  Returns null to indicate the end
  * of stream.
  * 
  * @return Line of input.
  * @exception IOException Throws IOException if any error with the input stream occurs.
  */
  
  public String readLine() throws IOException {
    StringBuffer sbuf = new StringBuffer();
    int result;
    String line;
    
   
    // loop only if the buffer was filled
    do {
      // this.readLine() does +=
      result = this.readLine(buf, 0, buf.length); 
      if (result != -1) {
        sbuf.append(new String(buf, 0, result, "ISO-8859-1"));
      }
    } while (result == buf.length); 

    if (sbuf.length() == 0) {
      // nothing read, must be at the end of stream
      return null; 
    }
    
    // cut off the trailing \r\n
    sbuf.setLength(sbuf.length() - 2); 
    return sbuf.toString();
  }

  /** A pass-through to ServletInputStream.readLine() that keeps track
  * how many bytes have been read and stops reading when the 
  * Content-Length limit has been reached.
  * 
  * @param b[] Array of bytes.
  * @param off Read offset.
  * @param len Length of byte buffer.
  * @return Number of bytes read.
  * @exception IOException Throws IOException if any error with the input stream occurs.
  */
  public int readLine(byte b[], int off, int len) throws IOException {
    if (totalRead >= m_totalExpected) {
      return -1;
    }
    else {
      int result = m_in.readLine(b, off, len);
      if (result > 0) {
        totalRead += result;
      }
      return result;
    }
  }
}
