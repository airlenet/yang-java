/* 
 * @(#)Subscription.java        1.0
 *
 * This file has been auto-generated by JNC, the
 * Java output format plug-in of pyang.
 * Origin: module "tailf-confd-monitoring", revision: "2013-06-14".
 */

package com.airlenet.yang.model.tailfConfdMonitoring.confdState.internal.cdb.client;

import com.airlenet.yang.model.tailfCommonMonitoring.TfcgPrefix;
import com.tailf.jnc.Element;
import com.tailf.jnc.JNCException;
import com.tailf.jnc.YangElement;
import com.tailf.jnc.YangEmpty;
import com.tailf.jnc.YangEnumeration;
import com.tailf.jnc.YangInt32;
import com.tailf.jnc.YangString;
import com.tailf.jnc.YangUInt32;

/**
 * This class represents an element from 
 * the namespace http://tail-f.com/yang/confd-monitoring
 * generated to "src/main/java/com.airlenet.yang.model/tailfConfdMonitoring/confdState/internal/cdb/client/subscription"
 * <p>
 * See line 815 in
 * src/main/yang/module/tailf/tailf-common-monitoring.yang
 *
 * @version 1.0
 * @author Auto Generated
 */
public class Subscription extends YangElement {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor for an empty Subscription object.
     */
    public Subscription() {
        super(TfcgPrefix.NAMESPACE, "subscription");
    }

    /**
     * Clones this object, returning an exact copy.
     * @return A clone of the object.
     */
    public Subscription clone() {
        return (Subscription)cloneContent(new Subscription());
    }

    /**
     * Clones this object, returning a shallow copy.
     * @return A clone of the object. Children are not included.
     */
    public Subscription cloneShallow() {
        return (Subscription)cloneShallowContent(new Subscription());
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
            "datastore",
            "twophase",
            "priority",
            "id",
            "path",
            "error",
        };
    }

    /* Access methods for optional leaf child: "datastore". */

    /**
     * Gets the value for child leaf "datastore".
     * @return The value of the leaf.
     */
    public com.tailf.jnc.YangEnumeration getDatastoreValue()
            throws JNCException {
        return (com.tailf.jnc.YangEnumeration)getValue("datastore");
    }

    /**
     * Sets the value for child leaf "datastore",
     * using a JNC type value.
     * @param datastoreValue The value to set.
     * @param datastoreValue used during instantiation.
     */
    public void setDatastoreValue(com.tailf.jnc.YangEnumeration datastoreValue)
            throws JNCException {
        setLeafValue(TfcgPrefix.NAMESPACE,
            "datastore",
            datastoreValue,
            childrenNames());
    }

    /**
     * Sets the value for child leaf "datastore",
     * using a String value.
     * @param datastoreValue used during instantiation.
     */
    public void setDatastoreValue(String datastoreValue) throws JNCException {
        setDatastoreValue(new com.tailf.jnc.YangEnumeration(datastoreValue, new String[] {
        }));
    }

    /**
     * Unsets the value for child leaf "datastore".
     */
    public void unsetDatastoreValue() throws JNCException {
        delete("datastore");
    }

    /**
     * This method is used for creating a subtree filter.
     * The added "datastore" leaf will not have a value.
     */
    public void addDatastore() throws JNCException {
        setLeafValue(TfcgPrefix.NAMESPACE,
            "datastore",
            null,
            childrenNames());
    }

    /**
     * Marks the leaf "datastore" with operation "replace".
     */
    public void markDatastoreReplace() throws JNCException {
        markLeafReplace("datastore");
    }

    /**
     * Marks the leaf "datastore" with operation "merge".
     */
    public void markDatastoreMerge() throws JNCException {
        markLeafMerge("datastore");
    }

    /**
     * Marks the leaf "datastore" with operation "create".
     */
    public void markDatastoreCreate() throws JNCException {
        markLeafCreate("datastore");
    }

    /**
     * Marks the leaf "datastore" with operation "delete".
     */
    public void markDatastoreDelete() throws JNCException {
        markLeafDelete("datastore");
    }

    /**
     * Marks the leaf "datastore" with operation "remove".
     */
    public void markDatastoreRemove() throws JNCException {
        markLeafRemove("datastore");
    }

    /* Access methods for optional leaf child: "twophase". */

    /**
     * Searches for leaf "twophase".
     * @return A YangEmpty object if leaf exists; <code>null</code> otherwise.
     */
    public com.tailf.jnc.YangEmpty getTwophaseValue() throws JNCException {
        return (com.tailf.jnc.YangEmpty)getValue("twophase");
    }

    /**
     * Sets the value for child leaf "twophase",
     * using instance of generated typedef class.
     * @param twophaseValue The value to set.
     * @param twophaseValue used during instantiation.
     */
    public void setTwophaseValue(com.tailf.jnc.YangEmpty twophaseValue)
            throws JNCException {
        setLeafValue(TfcgPrefix.NAMESPACE,
            "twophase",
            twophaseValue,
            childrenNames());
    }

    /**
     * Sets the value for child leaf "twophase",
     * by instantiating it (value n/a).
     * @param twophaseValue ignored.
     */
    public void setTwophaseValue(String twophaseValue) throws JNCException {
        setTwophaseValue(new YangEmpty());
    }

    /**
     * Unsets the value for child leaf "twophase".
     */
    public void unsetTwophaseValue() throws JNCException {
        delete("twophase");
    }

    /**
     * This method is used for creating a subtree filter.
     * The added "twophase" leaf will not have a value.
     */
    public void addTwophase() throws JNCException {
        setLeafValue(TfcgPrefix.NAMESPACE,
            "twophase",
            null,
            childrenNames());
    }

    /**
     * Marks the leaf "twophase" with operation "replace".
     */
    public void markTwophaseReplace() throws JNCException {
        markLeafReplace("twophase");
    }

    /**
     * Marks the leaf "twophase" with operation "merge".
     */
    public void markTwophaseMerge() throws JNCException {
        markLeafMerge("twophase");
    }

    /**
     * Marks the leaf "twophase" with operation "create".
     */
    public void markTwophaseCreate() throws JNCException {
        markLeafCreate("twophase");
    }

    /**
     * Marks the leaf "twophase" with operation "delete".
     */
    public void markTwophaseDelete() throws JNCException {
        markLeafDelete("twophase");
    }

    /**
     * Marks the leaf "twophase" with operation "remove".
     */
    public void markTwophaseRemove() throws JNCException {
        markLeafRemove("twophase");
    }

    /* Access methods for optional leaf child: "priority". */

    /**
     * Gets the value for child leaf "priority".
     * @return The value of the leaf.
     */
    public com.tailf.jnc.YangInt32 getPriorityValue() throws JNCException {
        return (com.tailf.jnc.YangInt32)getValue("priority");
    }

    /**
     * Sets the value for child leaf "priority",
     * using a JNC type value.
     * @param priorityValue The value to set.
     * @param priorityValue used during instantiation.
     */
    public void setPriorityValue(com.tailf.jnc.YangInt32 priorityValue)
            throws JNCException {
        setLeafValue(TfcgPrefix.NAMESPACE,
            "priority",
            priorityValue,
            childrenNames());
    }

    /**
     * Sets the value for child leaf "priority",
     * using Java primitive values.
     * @param priorityValue used during instantiation.
     */
    public void setPriorityValue(int priorityValue) throws JNCException {
        setPriorityValue(new com.tailf.jnc.YangInt32(priorityValue));
    }

    /**
     * Sets the value for child leaf "priority",
     * using a String value.
     * @param priorityValue used during instantiation.
     */
    public void setPriorityValue(String priorityValue) throws JNCException {
        setPriorityValue(new com.tailf.jnc.YangInt32(priorityValue));
    }

    /**
     * Unsets the value for child leaf "priority".
     */
    public void unsetPriorityValue() throws JNCException {
        delete("priority");
    }

    /**
     * This method is used for creating a subtree filter.
     * The added "priority" leaf will not have a value.
     */
    public void addPriority() throws JNCException {
        setLeafValue(TfcgPrefix.NAMESPACE,
            "priority",
            null,
            childrenNames());
    }

    /**
     * Marks the leaf "priority" with operation "replace".
     */
    public void markPriorityReplace() throws JNCException {
        markLeafReplace("priority");
    }

    /**
     * Marks the leaf "priority" with operation "merge".
     */
    public void markPriorityMerge() throws JNCException {
        markLeafMerge("priority");
    }

    /**
     * Marks the leaf "priority" with operation "create".
     */
    public void markPriorityCreate() throws JNCException {
        markLeafCreate("priority");
    }

    /**
     * Marks the leaf "priority" with operation "delete".
     */
    public void markPriorityDelete() throws JNCException {
        markLeafDelete("priority");
    }

    /**
     * Marks the leaf "priority" with operation "remove".
     */
    public void markPriorityRemove() throws JNCException {
        markLeafRemove("priority");
    }

    /* Access methods for optional leaf child: "id". */

    /**
     * Gets the value for child leaf "id".
     * @return The value of the leaf.
     */
    public com.tailf.jnc.YangUInt32 getIdValue() throws JNCException {
        return (com.tailf.jnc.YangUInt32)getValue("id");
    }

    /**
     * Sets the value for child leaf "id",
     * using a JNC type value.
     * @param idValue The value to set.
     * @param idValue used during instantiation.
     */
    public void setIdValue(com.tailf.jnc.YangUInt32 idValue)
            throws JNCException {
        setLeafValue(TfcgPrefix.NAMESPACE,
            "id",
            idValue,
            childrenNames());
    }

    /**
     * Sets the value for child leaf "id",
     * using Java primitive values.
     * @param idValue used during instantiation.
     */
    public void setIdValue(long idValue) throws JNCException {
        setIdValue(new com.tailf.jnc.YangUInt32(idValue));
    }

    /**
     * Sets the value for child leaf "id",
     * using a String value.
     * @param idValue used during instantiation.
     */
    public void setIdValue(String idValue) throws JNCException {
        setIdValue(new com.tailf.jnc.YangUInt32(idValue));
    }

    /**
     * Unsets the value for child leaf "id".
     */
    public void unsetIdValue() throws JNCException {
        delete("id");
    }

    /**
     * This method is used for creating a subtree filter.
     * The added "id" leaf will not have a value.
     */
    public void addId() throws JNCException {
        setLeafValue(TfcgPrefix.NAMESPACE,
            "id",
            null,
            childrenNames());
    }

    /**
     * Marks the leaf "id" with operation "replace".
     */
    public void markIdReplace() throws JNCException {
        markLeafReplace("id");
    }

    /**
     * Marks the leaf "id" with operation "merge".
     */
    public void markIdMerge() throws JNCException {
        markLeafMerge("id");
    }

    /**
     * Marks the leaf "id" with operation "create".
     */
    public void markIdCreate() throws JNCException {
        markLeafCreate("id");
    }

    /**
     * Marks the leaf "id" with operation "delete".
     */
    public void markIdDelete() throws JNCException {
        markLeafDelete("id");
    }

    /**
     * Marks the leaf "id" with operation "remove".
     */
    public void markIdRemove() throws JNCException {
        markLeafRemove("id");
    }

    /* Access methods for optional leaf child: "path". */

    /**
     * Gets the value for child leaf "path".
     * @return The value of the leaf.
     */
    public com.tailf.jnc.YangString getPathValue() throws JNCException {
        return (com.tailf.jnc.YangString)getValue("path");
    }

    /**
     * Sets the value for child leaf "path",
     * using instance of generated typedef class.
     * @param pathValue The value to set.
     * @param pathValue used during instantiation.
     */
    public void setPathValue(com.tailf.jnc.YangString pathValue)
            throws JNCException {
        setLeafValue(TfcgPrefix.NAMESPACE,
            "path",
            pathValue,
            childrenNames());
    }

    /**
     * Sets the value for child leaf "path",
     * using a String value.
     * @param pathValue used during instantiation.
     */
    public void setPathValue(String pathValue) throws JNCException {
        setPathValue(new com.tailf.jnc.YangString(pathValue));
    }

    /**
     * Unsets the value for child leaf "path".
     */
    public void unsetPathValue() throws JNCException {
        delete("path");
    }

    /**
     * This method is used for creating a subtree filter.
     * The added "path" leaf will not have a value.
     */
    public void addPath() throws JNCException {
        setLeafValue(TfcgPrefix.NAMESPACE,
            "path",
            null,
            childrenNames());
    }

    /**
     * Marks the leaf "path" with operation "replace".
     */
    public void markPathReplace() throws JNCException {
        markLeafReplace("path");
    }

    /**
     * Marks the leaf "path" with operation "merge".
     */
    public void markPathMerge() throws JNCException {
        markLeafMerge("path");
    }

    /**
     * Marks the leaf "path" with operation "create".
     */
    public void markPathCreate() throws JNCException {
        markLeafCreate("path");
    }

    /**
     * Marks the leaf "path" with operation "delete".
     */
    public void markPathDelete() throws JNCException {
        markLeafDelete("path");
    }

    /**
     * Marks the leaf "path" with operation "remove".
     */
    public void markPathRemove() throws JNCException {
        markLeafRemove("path");
    }

    /* Access methods for optional leaf child: "error". */

    /**
     * Gets the value for child leaf "error".
     * @return The value of the leaf.
     */
    public com.tailf.jnc.YangEnumeration getErrorValue() throws JNCException {
        return (com.tailf.jnc.YangEnumeration)getValue("error");
    }

    /**
     * Sets the value for child leaf "error",
     * using instance of generated typedef class.
     * @param errorValue The value to set.
     * @param errorValue used during instantiation.
     */
    public void setErrorValue(com.tailf.jnc.YangEnumeration errorValue)
            throws JNCException {
        setLeafValue(TfcgPrefix.NAMESPACE,
            "error",
            errorValue,
            childrenNames());
    }

    /**
     * Sets the value for child leaf "error",
     * using a String value.
     * @param errorValue used during instantiation.
     */
    public void setErrorValue(String errorValue) throws JNCException {
        setErrorValue(new com.tailf.jnc.YangEnumeration(errorValue, new String[] {
             "PENDING",
        }));
    }

    /**
     * Unsets the value for child leaf "error".
     */
    public void unsetErrorValue() throws JNCException {
        delete("error");
    }

    /**
     * This method is used for creating a subtree filter.
     * The added "error" leaf will not have a value.
     */
    public void addError() throws JNCException {
        setLeafValue(TfcgPrefix.NAMESPACE,
            "error",
            null,
            childrenNames());
    }

    /**
     * Marks the leaf "error" with operation "replace".
     */
    public void markErrorReplace() throws JNCException {
        markLeafReplace("error");
    }

    /**
     * Marks the leaf "error" with operation "merge".
     */
    public void markErrorMerge() throws JNCException {
        markLeafMerge("error");
    }

    /**
     * Marks the leaf "error" with operation "create".
     */
    public void markErrorCreate() throws JNCException {
        markLeafCreate("error");
    }

    /**
     * Marks the leaf "error" with operation "delete".
     */
    public void markErrorDelete() throws JNCException {
        markLeafDelete("error");
    }

    /**
     * Marks the leaf "error" with operation "remove".
     */
    public void markErrorRemove() throws JNCException {
        markLeafRemove("error");
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
