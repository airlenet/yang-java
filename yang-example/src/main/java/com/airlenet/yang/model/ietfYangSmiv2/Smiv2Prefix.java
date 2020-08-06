/* 
 * @(#)Smiv2Prefix.java        1.0
 *
 * This file has been auto-generated by JNC, the
 * Java output format plug-in of pyang.
 * Origin: module "ietf-yang-smiv2", revision: "2011-11-25".
 */

package com.airlenet.yang.model.ietfYangSmiv2;

import com.tailf.jnc.JNCException;
import com.tailf.jnc.SchemaNode;
import com.tailf.jnc.SchemaParser;
import com.tailf.jnc.SchemaTree;
import com.tailf.jnc.Tagpath;
import com.tailf.jnc.YangElement;

import java.util.HashMap;

/**
 * The root class for namespace urn:ietf:params:xml:ns:yang:ietf-yang-smiv2 (accessible from 
 * IetfYangSmiv2.NAMESPACE) with prefix "smiv2Prefix" (IetfYangSmiv2.PREFIX).
 *
 * @version 1.0
 * @author Auto Generated
 */
public class Smiv2Prefix {

    public static final String NAMESPACE = "urn:ietf:params:xml:ns:yang:ietf-yang-smiv2";

    public static final String PREFIX = "smiv2";

    /**
     * Enable the elements in this namespace to be aware
     * of the data model and use the generated classes.
     */
    public static void enable() throws JNCException {
        YangElement.setPackage(NAMESPACE, "com.airlenet.yang.model.ietfYangSmiv2");
        Smiv2Prefix.registerSchema();
    }

    /**
     * Register the schema for this namespace in the global
     * schema table (CsTree) making it possible to lookup
     * CsNode entries for all tagpaths
     */
    public static void registerSchema() throws JNCException {
        SchemaParser parser = new SchemaParser();
        HashMap<Tagpath, SchemaNode> h = SchemaTree.create(NAMESPACE);
        parser.findAndReadFile("Smiv2Prefix.schema", h, Smiv2Prefix.class);
    }

}
