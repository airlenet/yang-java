/* 
 * @(#)Xpath10.java        1.0
 *
 * This file has been auto-generated by JNC, the
 * Java output format plug-in of pyang.
 * Origin: module "ietf-netconf-acm", revision: "2012-02-22".
 */

package com.airlenet.yang.model.ietfNetconfAcm;

import com.tailf.jnc.YangException;
import com.tailf.jnc.YangString;

/**
 * This class represents an element from 
 * the namespace 
 * generated to "src/main/java/com.airlenet.yang.model/ietfNetconfAcm/xpath1.0"
 * <p>
 * See line 421 in
 * src/main/yang/module/ietf/ietf-yang-types.yang
 *
 * @version 1.0
 * @author Auto Generated
 */
public class Xpath10 extends YangString {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor for Xpath10 object from a string.
     * @param value Value to construct the Xpath10 from.
     */
    public Xpath10(String value) throws YangException {
        super(value);
        check();
    }

    /**
     * Sets the value using a string value.
     * @param value The value to set.
     */
    public void setValue(String value) throws YangException {
        super.setValue(value);
        check();
    }

    /**
     * Checks all restrictions (if any).
     */
    public void check() throws YangException {
    }

}