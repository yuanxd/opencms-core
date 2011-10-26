/*
 * File   : $Source$
 * Date   : $Date$
 * Version: $Revision$
 *
 * This library is part of OpenCms -
 * the Open Source Content Management System
 *
 * Copyright (C) 2002 - 2011 Alkacon Software (http://www.alkacon.com)
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * For further information about Alkacon Software, please see the
 * company website: http://www.alkacon.com
 *
 * For further information about OpenCms, please see the
 * project website: http://www.opencms.org
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package org.opencms.ade.containerpage.inherited;

import org.opencms.xml.containerpage.CmsContainerElementBean;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CmsContainerConfiguration {

	public static final String N_CONFIGURATION = "Configuration";
	public static final String N_VISIBLE = "Visible";
	public static final String N_HIDDEN = "Hidden";
	public static final String N_ORDERKEY = "OrderKey";
	public static final String N_NAME = "Name";
	public static final String N_NEWELEMENT = "NewElement";
	public static final String N_KEY = "Key";
	public static final String N_ELEMENT = "Element";
	

    private Map<String, CmsContainerElementBean> m_newElements;

    private List<String> m_ordering;

    private String m_path;

    private Map<String, Boolean> m_visibility;

    public CmsContainerConfiguration(
        List<String> ordering,
        Map<String, Boolean> visibility,
        Map<String, CmsContainerElementBean> newElements) {

        m_ordering = ordering != null ? Collections.unmodifiableList(ordering) : null;
        m_visibility = Collections.unmodifiableMap(visibility);
        m_newElements = Collections.unmodifiableMap(newElements);
    }

    /** Empty configuration constant. */
    public static CmsContainerConfiguration emptyConfiguration() {

        return new CmsContainerConfiguration(
            null,
            new HashMap<String, Boolean>(),
            new HashMap<String, CmsContainerElementBean>());
    }

    public Map<String, CmsContainerElementBean> getNewElements() {

        return m_newElements;
    }

    public List<String> getOrdering() {

        return m_ordering;
    }

    public String getPath() {

        return m_path;
    }

    public Map<String, Boolean> getVisibility() {

        return m_visibility;
    }

    public void setPath(String path) {

        m_path = path;
    }

}
