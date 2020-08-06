/* 
 * @(#)RestconfState.java        1.0
 *
 * This file has been auto-generated by JNC, the
 * Java output format plug-in of pyang.
 * Origin: module "ietf-restconf-monitoring", revision: "2016-08-15".
 */

package com.airlenet.yang.model.ietfRestconfMonitoring;

import com.airlenet.yang.model.ietfRestconfMonitoring.RcmonPrefix;
import com.airlenet.yang.model.ietfRestconfMonitoring.restconfState.Capabilities;
import com.airlenet.yang.model.ietfRestconfMonitoring.restconfState.Streams;
import com.tailf.jnc.Element;
import com.tailf.jnc.JNCException;
import com.tailf.jnc.NodeSet;
import com.tailf.jnc.YangElement;

/**
 * This class represents an element from 
 * the namespace urn:ietf:params:xml:ns:yang:ietf-restconf-monitoring
 * generated to "src/main/java/com.airlenet.yang.model/ietfRestconfMonitoring/restconf-state"
 * <p>
 * See line 56 in
 * src/main/yang/module/ietf/ietf-restconf-monitoring.yang
 *
 * @version 1.0
 * @author Auto Generated
 */
public class RestconfState extends YangElement {

    private static final long serialVersionUID = 1L;

    /**
     * Field for child container "capabilities".
     */
    public Capabilities capabilities = null;
    public Capabilities getCapabilities() {
        return this.capabilities;
    }

    /**
     * Field for child container "streams".
     */
    public Streams streams = null;
    public Streams getStreams() {
        return this.streams;
    }

    /**
     * Constructor for an empty RestconfState object.
     */
    public RestconfState() {
        super(RcmonPrefix.NAMESPACE, "restconf-state");
        setDefaultPrefix();
        setPrefix(RcmonPrefix.PREFIX);
    }

    /**
     * Clones this object, returning an exact copy.
     * @return A clone of the object.
     */
    public RestconfState clone() {
        return (RestconfState)cloneContent(new RestconfState());
    }

    /**
     * Clones this object, returning a shallow copy.
     * @return A clone of the object. Children are not included.
     */
    public RestconfState cloneShallow() {
        return (RestconfState)cloneShallowContent(new RestconfState());
    }

    /**
     * @return An array with the identifiers of any key children
     */
    public String[] keyNames() {
        return null;
    }

    /**
     * @return An array with the identifiers of any children, in order.
     */
    public String[] childrenNames() {
        return new String[] {
            "capabilities",
            "streams",
        };
    }

    /* Access methods for container child: "capabilities". */

    /**
     * Adds container entry "capabilities", using an existing object.
     * @param capabilities The object to add.
     * @return The added child.
     */
    public Capabilities addCapabilities(Capabilities capabilities)
            throws JNCException {
        this.capabilities = capabilities;
        insertChild(capabilities, childrenNames());
        return capabilities;
    }

    /**
     * Adds container entry "capabilities".
     * This method is used for creating subtree filters.
     * @return The added child.
     */
    public Capabilities addCapabilities() throws JNCException {
        Capabilities capabilities = new Capabilities();
        this.capabilities = capabilities;
        insertChild(capabilities, childrenNames());
        return capabilities;
    }

    /**
     * Deletes container entry "capabilities".
     * @return An array of the deleted element nodes.
     */
    public NodeSet deleteCapabilities() throws JNCException {
        this.capabilities = null;
        String path = "capabilities";
        return delete(path);
    }

    /* Access methods for container child: "streams". */

    /**
     * Adds container entry "streams", using an existing object.
     * @param streams The object to add.
     * @return The added child.
     */
    public Streams addStreams(Streams streams) throws JNCException {
        this.streams = streams;
        insertChild(streams, childrenNames());
        return streams;
    }

    /**
     * Adds container entry "streams".
     * This method is used for creating subtree filters.
     * @return The added child.
     */
    public Streams addStreams() throws JNCException {
        Streams streams = new Streams();
        this.streams = streams;
        insertChild(streams, childrenNames());
        return streams;
    }

    /**
     * Deletes container entry "streams".
     * @return An array of the deleted element nodes.
     */
    public NodeSet deleteStreams() throws JNCException {
        this.streams = null;
        String path = "streams";
        return delete(path);
    }

    /**
     * Support method for addChild.
     * Adds a child to this object.
     * 
     * @param child The child to add
     */
    public void addChild(Element child) {
        super.addChild(child);
        if (child instanceof Capabilities) capabilities = (Capabilities)child;
        else if (child instanceof Streams) streams = (Streams)child;
    }

}
