/* 
 * @(#)TransactionLock.java        1.0
 *
 * This file has been auto-generated by JNC, the
 * Java output format plug-in of pyang.
 * Origin: module "ietf-netconf-monitoring", revision: "2010-10-04".
 */

package com.airlenet.yang.model.ietfNetconfMonitoring.netconfState.datastores.datastore.locks;

import com.airlenet.yang.model.tailfNetconfMonitoring.TncmPrefix;
import com.tailf.jnc.Element;
import com.tailf.jnc.JNCException;
import com.tailf.jnc.YangElement;
import com.tailf.jnc.YangUInt32;

/**
 * This class represents an element from 
 * the namespace urn:ietf:params:xml:ns:yang:ietf-netconf-monitoring
 * generated to "src/main/java/com.airlenet.yang.model/ietfNetconfMonitoring/netconfState/datastores/datastore/locks/transaction-lock"
 * <p>
 * See line 204 in
 * src/main/yang/module/tailf/tailf-netconf-monitoring.yang
 *
 * @version 1.0
 * @author Auto Generated
 */
public class TransactionLock extends YangElement {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor for an empty TransactionLock object.
     */
    public TransactionLock() {
        super(TncmPrefix.NAMESPACE, "transaction-lock");
        setDefaultPrefix();
        setPrefix(TncmPrefix.PREFIX);
    }

    /**
     * Clones this object, returning an exact copy.
     * @return A clone of the object.
     */
    public TransactionLock clone() {
        return (TransactionLock)cloneContent(new TransactionLock());
    }

    /**
     * Clones this object, returning a shallow copy.
     * @return A clone of the object. Children are not included.
     */
    public TransactionLock cloneShallow() {
        return (TransactionLock)cloneShallowContent(new TransactionLock());
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
            "locked-by-session",
        };
    }

    /* Access methods for optional leaf child: "locked-by-session". */

    /**
     * Gets the value for child leaf "locked-by-session".
     * @return The value of the leaf.
     */
    public com.tailf.jnc.YangUInt32 getLockedBySessionValue()
            throws JNCException {
        return (com.tailf.jnc.YangUInt32)getValue("locked-by-session");
    }

    /**
     * Sets the value for child leaf "locked-by-session",
     * using instance of generated typedef class.
     * @param lockedBySessionValue The value to set.
     * @param lockedBySessionValue used during instantiation.
     */
    public void setLockedBySessionValue(com.tailf.jnc.YangUInt32 lockedBySessionValue)
            throws JNCException {
        setLeafValue(TncmPrefix.NAMESPACE,
            "locked-by-session",
            lockedBySessionValue,
            childrenNames());
    }

    /**
     * Sets the value for child leaf "locked-by-session",
     * using Java primitive values.
     * @param lockedBySessionValue used during instantiation.
     */
    public void setLockedBySessionValue(long lockedBySessionValue)
            throws JNCException {
        setLockedBySessionValue(new com.tailf.jnc.YangUInt32(lockedBySessionValue));
    }

    /**
     * Sets the value for child leaf "locked-by-session",
     * using a String value.
     * @param lockedBySessionValue used during instantiation.
     */
    public void setLockedBySessionValue(String lockedBySessionValue)
            throws JNCException {
        setLockedBySessionValue(new com.tailf.jnc.YangUInt32(lockedBySessionValue));
    }

    /**
     * Unsets the value for child leaf "locked-by-session".
     */
    public void unsetLockedBySessionValue() throws JNCException {
        delete("locked-by-session");
    }

    /**
     * This method is used for creating a subtree filter.
     * The added "locked-by-session" leaf will not have a value.
     */
    public void addLockedBySession() throws JNCException {
        setLeafValue(TncmPrefix.NAMESPACE,
            "locked-by-session",
            null,
            childrenNames());
    }

    /**
     * Marks the leaf "locked-by-session" with operation "replace".
     */
    public void markLockedBySessionReplace() throws JNCException {
        markLeafReplace("locked-by-session");
    }

    /**
     * Marks the leaf "locked-by-session" with operation "merge".
     */
    public void markLockedBySessionMerge() throws JNCException {
        markLeafMerge("locked-by-session");
    }

    /**
     * Marks the leaf "locked-by-session" with operation "create".
     */
    public void markLockedBySessionCreate() throws JNCException {
        markLeafCreate("locked-by-session");
    }

    /**
     * Marks the leaf "locked-by-session" with operation "delete".
     */
    public void markLockedBySessionDelete() throws JNCException {
        markLeafDelete("locked-by-session");
    }

    /**
     * Marks the leaf "locked-by-session" with operation "remove".
     */
    public void markLockedBySessionRemove() throws JNCException {
        markLeafRemove("locked-by-session");
    }

    /**
     * Support method for addChild.
     * Adds a child to this object.
     * 
     * @param child The child to add
     */
    public void addChild(Element child) {
        super.addChild(child);
    }

}