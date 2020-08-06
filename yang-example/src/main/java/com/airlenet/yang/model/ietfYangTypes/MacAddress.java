/* 
 * @(#)MacAddress.java        1.0
 *
 * This file has been auto-generated by JNC, the
 * Java output format plug-in of pyang.
 * Origin: module "ietf-yang-types", revision: "2013-07-15".
 */

package com.airlenet.yang.model.ietfYangTypes;

import com.tailf.jnc.YangException;
import com.tailf.jnc.YangString;

/**
 * This class represents an element from 
 * the namespace 
 * generated to "src/main/java/com.airlenet.yang.model/ietfYangTypes/mac-address"
 * <p>
 * See line 403 in
 * src/main/yang/module/ietf/ietf-yang-types.yang
 *
 * @version 1.0
 * @author Auto Generated
 */
public class MacAddress extends YangString {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor for MacAddress object from a string.
     * @param value Value to construct the MacAddress from.
     */
    public MacAddress(String value) throws YangException {
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
