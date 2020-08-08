/* 
 * @(#)Locks.java        1.0
 *
 * This file has been auto-generated by JNC, the
 * Java output format plug-in of pyang.
 * Origin: module "ietf-netconf-monitoring", revision: "2010-10-04".
 */

package com.airlenet.yang.model.ietfNetconfMonitoring.netconfState.datastores.datastore;

import com.airlenet.yang.model.ietfNetconfMonitoring.NcmPrefix;
import com.airlenet.yang.model.ietfNetconfMonitoring.netconfState.datastores.datastore.locks.GlobalLock;
import com.airlenet.yang.model.ietfNetconfMonitoring.netconfState.datastores.datastore.locks.PartialLock;
import com.tailf.jnc.Element;
import com.tailf.jnc.ElementChildrenIterator;
import com.tailf.jnc.JNCException;
import com.tailf.jnc.NodeSet;
import com.tailf.jnc.YangElement;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents an element from 
 * the namespace urn:ietf:params:xml:ns:yang:ietf-netconf-monitoring
 * generated to "src/main/java/com.airlenet.yang.model/ietfNetconfMonitoring/netconfState/datastores/datastore/locks"
 * <p>
 * See line 226 in
 * src/main/yang/module/ietf/ietf-netconf-monitoring.yang
 *
 * @version 1.0
 * @author Auto Generated
 */
public class Locks extends YangElement {

    private static final long serialVersionUID = 1L;

    /**
     * Field for child container "global-lock".
     */
    public com.airlenet.yang.model.ietfNetconfMonitoring.netconfState.datastores.datastore.locks.GlobalLock globalLock = null;
    public com.airlenet.yang.model.ietfNetconfMonitoring.netconfState.datastores.datastore.locks.GlobalLock getGlobalLock() {
        return this.globalLock;
    }

    /**
     * Constructor for an empty Locks object.
     */
    public Locks() {
        super(NcmPrefix.NAMESPACE, "locks");
    }

    /**
     * Clones this object, returning an exact copy.
     * @return A clone of the object.
     */
    public Locks clone() {
        return (Locks)cloneContent(new Locks());
    }

    /**
     * Clones this object, returning a shallow copy.
     * @return A clone of the object. Children are not included.
     */
    public Locks cloneShallow() {
        return (Locks)cloneShallowContent(new Locks());
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
            "global-lock",
            "partial-lock",
        };
    }

    /* Access methods for container child: "global-lock". */

    /**
     * Adds container entry "globalLock", using an existing object.
     * @param globalLock The object to add.
     * @return The added child.
     */
    public GlobalLock addGlobalLock(GlobalLock globalLock) throws JNCException {
        this.globalLock = globalLock;
        insertChild(globalLock, childrenNames());
        return globalLock;
    }

    /**
     * Adds container entry "globalLock".
     * This method is used for creating subtree filters.
     * @return The added child.
     */
    public GlobalLock addGlobalLock() throws JNCException {
        GlobalLock globalLock = new GlobalLock();
        this.globalLock = globalLock;
        insertChild(globalLock, childrenNames());
        return globalLock;
    }

    /**
     * Deletes container entry "globalLock".
     * @return An array of the deleted element nodes.
     */
    public NodeSet deleteGlobalLock() throws JNCException {
        this.globalLock = null;
        String path = "global-lock";
        return delete(path);
    }

    /* Access methods for list child: "partial-lock". */

    /**
     * Gets list entry "partialLock", with specified keys.
     */
    public PartialLock getPartialLock() throws JNCException {
        String path = "partial-lock";
        return (PartialLock)searchOne(path);
    }

    /**
     * Iterator method for the list "partial-lock".
     * @return An iterator for the list.
     */
    public ElementChildrenIterator partialLockIterator() {
        return new ElementChildrenIterator(children, "partial-lock");
    }

    /**
     * List method for the list "partial-lock".
     * @return An List for the list.
     */
    public List<PartialLock> getPartialLockList() {
        List<PartialLock> list = new ArrayList<>();
        ElementChildrenIterator iterator = partialLockIterator();
        if(iterator==null){
            return null;
        }
        while (iterator.hasNext()){
            PartialLock next =(PartialLock) iterator.next();
            list.add(next);
        }
        return list;
    }

    /**
     * Adds list entry "partialLock", using an existing object.
     * @param partialLock The object to add.
     * @return The added child.
     */
    public PartialLock addPartialLock(PartialLock partialLock)
            throws JNCException {
        insertChild(partialLock, childrenNames());
        return partialLock;
    }

    /**
     * Adds list entry "partialLock".
     * This method is used for creating subtree filters.
     * @return The added child.
     */
    public PartialLock addPartialLock() throws JNCException {
        PartialLock partialLock = new PartialLock();
        insertChild(partialLock, childrenNames());
        return partialLock;
    }

    /**
     * Deletes list entry "partialLock", with specified keys.
     */
    public void deletePartialLock() throws JNCException {
        String path = "partial-lock";
        delete(path);
    }

    /**
     * Support method for addChild.
     * Adds a child to this object.
     * 
     * @param child The child to add
     */
    public void addChild(Element child) {
        super.addChild(child);
        if (child instanceof GlobalLock) globalLock = (GlobalLock)child;
    }

}