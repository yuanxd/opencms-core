/*
 * File   : $Source: /alkacon/cvs/opencms/src/com/opencms/file/Attic/A_CmsTask.java,v $
 * Date   : $Date: 2000/02/15 17:53:48 $
 * Version: $Revision: 1.9 $
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

package com.opencms.file;

import java.util.*;


/**
 * This abstract class describes a task in the Cms.
 * 
 * @author Ruediger Gutfleisch
 * @version $Revision: 1.9 $ $Date: 2000/02/15 17:53:48 $
 */
public abstract class A_CmsTask
{
	/**
	 * Returns the id of this task.
	 * 
	 * @return the id of this task.
	 */
	abstract public int getId();
	
	/**
	 * Returns the name of this task.
	 * 
	 * @return the name of this task.
	 */
	abstract public String getName();
	
	/**
	 * Returns a string-representation for this object.
	 * This can be used for debugging.
	 * 
	 * @return string-representation for this object.
	 */
	
	abstract public int getState();
	abstract public int getTaskType();
	abstract public int getRoot();
	abstract public int getParent();
	abstract public int getInitiatorUser();
	abstract public int getRole();
	abstract public int getAgentUser();
	abstract public int getOriginalUser();
	abstract public java.sql.Timestamp getStartTime();
	abstract public java.sql.Timestamp getWakeupTime();
	abstract public java.sql.Timestamp getTimeOut();
	abstract public java.sql.Timestamp getEndTime();
	abstract public int getPercentage();
	abstract public String getPermission();
	abstract public int getPriority();
	abstract public int getEscalationType();
	abstract public String getHtmlLink();
	abstract public int getMilestone();
	abstract public int getAutoFinish();

	abstract void setName(String taskname);
	abstract void setRoot(int root);
	abstract void setParent(int parent);
	abstract void setTaskType(int tasktype);
	abstract void setRole(int role);
	abstract void setAgentUser(int agentuser);
	abstract void setOriginalUser(int originaluser);
	abstract void setInitiatorUser(int initiatoruser);
	abstract void setWakeupTime(java.sql.Timestamp wakeuptime);
	abstract void setTimeOut(java.sql.Timestamp timeout);
	abstract void setPriority(int priority);
	abstract void setPercentage(int percentage);
	abstract void setState(int state);
	abstract void setStartTime(java.sql.Timestamp starttime);
	abstract void setMilestone(int milestone);

	
	/**
	 * Returns a string-representation for this object.
	 * This can be used for debugging.
	 * 
	 * @return string-representation for this object.
	 */
	abstract public String toString();
	
	/**
	 * Compares the overgiven object with this object.
	 * 
	 * @return true, if the object is identically else it returns false.
	 */
	abstract public boolean equals(Object obj);

}
