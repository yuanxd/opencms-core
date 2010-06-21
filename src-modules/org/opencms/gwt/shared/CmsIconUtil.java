/*
 * File   : $Source: /alkacon/cvs/opencms/src-modules/org/opencms/gwt/shared/Attic/CmsIconUtil.java,v $
 * Date   : $Date: 2010/06/21 10:01:40 $
 * Version: $Revision: 1.2 $
 *
 * This library is part of OpenCms -
 * the Open Source Content Management System
 *
 * Copyright (C) 2002 - 2009 Alkacon Software (http://www.alkacon.com)
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

package org.opencms.gwt.shared;

/**
 * Utility class for the resource icon CSS.<p>
 * 
 * @author Tobias Herrmann
 * 
 * @version $Revision: 1.2 $
 * 
 * @since 8.0.0
 */
public class CmsIconUtil {

    /** The resource icon CSS class prefix. */
    protected static final String TYPE_ICON_CLASS = "cms_type_icon";

    /**
     * Constructor.<p>
     */
    protected CmsIconUtil() {

        // empty
    }

    /**
     * Returns the CSS classes of the resource icon for the given resource type name.<p>
     * 
     * Use this function, if the resource type is known, but not the filename. If the filename is available use {@link CmsIconUtil#getResourceIconClasses(String, String)}<p>
     * 
     * @param resourceTypeName the resource type name
     * 
     * @return the CSS classes
     */
    public static String getResourceIconClasses(String resourceTypeName) {

        StringBuffer sb = new StringBuffer(TYPE_ICON_CLASS);
        sb.append(" ").append(getResourceTypeIconClass(resourceTypeName));
        return sb.toString();
    }

    /**
     * Returns the CSS classes of the resource icon for the given resource type and filename.<p>
     * 
     * Use this the resource type and filename is known. Otherwise use {@link CmsIconUtil#getResourceIconClasses(String)}<p>
     * 
     * @param resourceTypeName the resource type name
     * @param fileName the filename
     * 
     * @return the CSS classes
     */
    public static String getResourceIconClasses(String resourceTypeName, String fileName) {

        StringBuffer sb = new StringBuffer(TYPE_ICON_CLASS);
        sb.append(" ").append(getResourceTypeIconClass(resourceTypeName)).append(" ").append(
            getFileTypeIconClass(resourceTypeName, fileName));
        return sb.toString();
    }

    /**
     * Returns the CSS class for the given filename.<p>
     * 
     * @param resourceTypeName the resource type name
     * @param fileName the filename
     * 
     * @return the CSS class
     */
    protected static String getFileTypeIconClass(String resourceTypeName, String fileName) {

        if ((fileName != null) && fileName.contains(".")) {
            int last = fileName.lastIndexOf(".");
            if (fileName.length() > last + 1) {
                String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
                return getResourceSubTypeIconClass(resourceTypeName, suffix);
            }
        }
        return "";

    }

    /**
     * Returns the CSS class for a given resource type name and file name extension.<p>
     * 
     * @param resourceTypeName the resource type name 
     * @param suffix the file name extension 
     * 
     * @return the CSS class for the type and extension 
     */
    protected static String getResourceSubTypeIconClass(String resourceTypeName, String suffix) {

        StringBuffer buffer = new StringBuffer(TYPE_ICON_CLASS).append("_").append(resourceTypeName.hashCode()).append(
            "_").append(suffix);
        return buffer.toString();
    }

    /**
     * Returns the CSS class for the given resource type.<p>
     * 
     * @param resourceTypeName the resource type name
     * 
     * @return the CSS class
     */
    protected static String getResourceTypeIconClass(String resourceTypeName) {

        StringBuffer sb = new StringBuffer(TYPE_ICON_CLASS);
        sb.append("_").append(resourceTypeName.hashCode());
        return sb.toString();
    }
}
