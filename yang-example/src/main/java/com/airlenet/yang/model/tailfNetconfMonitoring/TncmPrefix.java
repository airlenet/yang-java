/* 
 * @(#)TncmPrefix.java        1.0
 *
 * This file has been auto-generated by JNC, the
 * Java output format plug-in of pyang.
 * Origin: module "tailf-netconf-monitoring", revision: "2016-11-24".
 */

package com.airlenet.yang.model.tailfNetconfMonitoring;

import com.tailf.jnc.JNCException;
import com.tailf.jnc.SchemaNode;
import com.tailf.jnc.SchemaParser;
import com.tailf.jnc.SchemaTree;
import com.tailf.jnc.Tagpath;
import com.tailf.jnc.YangElement;

import java.util.HashMap;

/**
 * The root class for namespace http://tail-f.com/yang/netconf-monitoring (accessible from 
 * TailfNetconfMonitoring.NAMESPACE) with prefix "tncmPrefix" (TailfNetconfMonitoring.PREFIX).
 *
 * @version 1.0
 * @author Auto Generated
 */
public class TncmPrefix {

    public static final String NAMESPACE = "http://tail-f.com/yang/netconf-monitoring";

    public static final String PREFIX = "tncm";

    /**
     * Enable the elements in this namespace to be aware
     * of the data model and use the generated classes.
     */
    public static void enable() throws JNCException {
        YangElement.setPackage(NAMESPACE, "com.airlenet.yang.model.tailfNetconfMonitoring");
        TncmPrefix.registerSchema();
    }

    /**
     * Register the schema for this namespace in the global
     * schema table (CsTree) making it possible to lookup
     * CsNode entries for all tagpaths
     */
    public static void registerSchema() throws JNCException {
        SchemaParser parser = new SchemaParser();
        HashMap<Tagpath, SchemaNode> h = SchemaTree.create(NAMESPACE);
        parser.findAndReadFile("TncmPrefix.schema", h, TncmPrefix.class);
    }

}
