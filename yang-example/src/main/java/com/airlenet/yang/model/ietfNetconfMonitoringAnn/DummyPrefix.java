/* 
 * @(#)DummyPrefix.java        1.0
 *
 * This file has been auto-generated by JNC, the
 * Java output format plug-in of pyang.
 * Origin: module "ietf-netconf-monitoring-ann", revision: "unknown".
 */

package com.airlenet.yang.model.ietfNetconfMonitoringAnn;

import com.tailf.jnc.JNCException;
import com.tailf.jnc.SchemaNode;
import com.tailf.jnc.SchemaParser;
import com.tailf.jnc.SchemaTree;
import com.tailf.jnc.Tagpath;
import com.tailf.jnc.YangElement;

import java.util.HashMap;

/**
 * The root class for namespace urn:dummy (accessible from 
 * IetfNetconfMonitoringAnn.NAMESPACE) with prefix "dummyPrefix" (IetfNetconfMonitoringAnn.PREFIX).
 *
 * @version 1.0
 * @author Auto Generated
 */
public class DummyPrefix {

    public static final String NAMESPACE = "urn:dummy";

    public static final String PREFIX = "dummy";

    /**
     * Enable the elements in this namespace to be aware
     * of the data model and use the generated classes.
     */
    public static void enable() throws JNCException {
        YangElement.setPackage(NAMESPACE, "com.airlenet.yang.model.ietfNetconfMonitoringAnn");
        DummyPrefix.registerSchema();
    }

    /**
     * Register the schema for this namespace in the global
     * schema table (CsTree) making it possible to lookup
     * CsNode entries for all tagpaths
     */
    public static void registerSchema() throws JNCException {
        SchemaParser parser = new SchemaParser();
        HashMap<Tagpath, SchemaNode> h = SchemaTree.create(NAMESPACE);
        parser.findAndReadFile("DummyPrefix.schema", h, DummyPrefix.class);
    }

}
