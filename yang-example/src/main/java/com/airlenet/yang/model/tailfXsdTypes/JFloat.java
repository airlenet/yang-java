/* 
 * @(#)JFloat.java        1.0
 *
 * This file has been auto-generated by JNC, the
 * Java output format plug-in of pyang.
 * Origin: module "tailf-xsd-types", revision: "2009-03-17".
 */

package com.airlenet.yang.model.tailfXsdTypes;

import com.tailf.jnc.YangException;
import com.tailf.jnc.YangString;

/**
 * This class represents an element from 
 * the namespace 
 * generated to "src/main/java/com.airlenet.yang.model/tailfXsdTypes/float"
 * <p>
 * See line 56 in
 * src/main/yang/module/tailf/tailf-xsd-types.yang
 *
 * @version 1.0
 * @author Auto Generated
 */
public class JFloat extends YangString {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor for JFloat object from a string.
     * @param value Value to construct the JFloat from.
     */
    public JFloat(String value) throws YangException {
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
