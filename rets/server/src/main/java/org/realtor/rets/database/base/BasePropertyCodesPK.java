package org.realtor.rets.database.base;

import java.io.Serializable;


/**
 * This class has been automatically generated by Hibernate Synchronizer.
 * For more information or documentation, visit The Hibernate Synchronizer page
 * at http://www.binamics.com/hibernatesync or contact Joe Hudson at joe@binamics.com.
 */
public class BasePropertyCodesPK implements Serializable {

	private int hashCode = Integer.MIN_VALUE;

	private java.lang.String _attributeName;
	private java.lang.String _value;

	public BasePropertyCodesPK () {}
	
	public BasePropertyCodesPK (
		java.lang.String _attributeName,
		java.lang.String _value) {

		this.setAttributeName(_attributeName);
		this.setValue(_value);
	}


	public java.lang.String getAttributeName () {
		return _attributeName;
	}

	public void setAttributeName (java.lang.String _attributeName) {
		hashCode = Integer.MIN_VALUE;
		this._attributeName = _attributeName;
	}

	public java.lang.String getValue () {
		return _value;
	}

	public void setValue (java.lang.String _value) {
		hashCode = Integer.MIN_VALUE;
		this._value = _value;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof org.realtor.rets.database.PropertyCodesPK)) return false;
		else {
			org.realtor.rets.database.PropertyCodesPK mObj = (org.realtor.rets.database.PropertyCodesPK) obj;
			if (null != this.getAttributeName() && null != mObj.getAttributeName()) {
				if (!this.getAttributeName().equals(mObj.getAttributeName())) {
					return false;
				}
			}
			else {
				return false;
			}
			if (null != this.getValue() && null != mObj.getValue()) {
				if (!this.getValue().equals(mObj.getValue())) {
					return false;
				}
			}
			else {
				return false;
			}
			return true;
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			StringBuffer sb = new StringBuffer();
			if (null != this.getAttributeName()) {
				sb.append(this.getAttributeName().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			if (null != this.getValue()) {
				sb.append(this.getValue().hashCode());
				sb.append(":");
			}
			else {
				return super.hashCode();
			}
			this.hashCode = sb.toString().hashCode();
		}
		return this.hashCode;
	}

}