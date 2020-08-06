/* 
 * @(#)Daemon.java        1.0
 *
 * This file has been auto-generated by JNC, the
 * Java output format plug-in of pyang.
 * Origin: module "tailf-confd-monitoring", revision: "2013-06-14".
 */

package com.airlenet.yang.model.tailfConfdMonitoring.confdState.internal.callpoints.typepoint.range;

import com.airlenet.yang.model.tailfCommonMonitoring.TfcgPrefix;
import com.tailf.jnc.Element;
import com.tailf.jnc.JNCException;
import com.tailf.jnc.YangElement;
import com.tailf.jnc.YangEnumeration;
import com.tailf.jnc.YangString;
import com.tailf.jnc.YangUInt32;

/**
 * This class represents an element from 
 * the namespace http://tail-f.com/yang/confd-monitoring
 * generated to "src/main/java/com.airlenet.yang.model/tailfConfdMonitoring/confdState/internal/callpoints/typepoint/range/daemon"
 * <p>
 * See line 147 in
 * src/main/yang/module/tailf/tailf-common-monitoring.yang
 *
 * @version 1.0
 * @author Auto Generated
 */
public class Daemon extends YangElement {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor for an empty Daemon object.
     */
    public Daemon() {
        super(TfcgPrefix.NAMESPACE, "daemon");
    }

    /**
     * Clones this object, returning an exact copy.
     * @return A clone of the object.
     */
    public Daemon clone() {
        return (Daemon)cloneContent(new Daemon());
    }

    /**
     * Clones this object, returning a shallow copy.
     * @return A clone of the object. Children are not included.
     */
    public Daemon cloneShallow() {
        return (Daemon)cloneShallowContent(new Daemon());
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
            "id",
            "name",
            "error",
        };
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
     * using instance of generated typedef class.
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

    /* Access methods for optional leaf child: "name". */

    /**
     * Gets the value for child leaf "name".
     * @return The value of the leaf.
     */
    public com.tailf.jnc.YangString getNameValue() throws JNCException {
        return (com.tailf.jnc.YangString)getValue("name");
    }

    /**
     * Sets the value for child leaf "name",
     * using instance of generated typedef class.
     * @param nameValue The value to set.
     * @param nameValue used during instantiation.
     */
    public void setNameValue(com.tailf.jnc.YangString nameValue)
            throws JNCException {
        setLeafValue(TfcgPrefix.NAMESPACE,
            "name",
            nameValue,
            childrenNames());
    }

    /**
     * Sets the value for child leaf "name",
     * using a String value.
     * @param nameValue used during instantiation.
     */
    public void setNameValue(String nameValue) throws JNCException {
        setNameValue(new com.tailf.jnc.YangString(nameValue));
    }

    /**
     * Unsets the value for child leaf "name".
     */
    public void unsetNameValue() throws JNCException {
        delete("name");
    }

    /**
     * This method is used for creating a subtree filter.
     * The added "name" leaf will not have a value.
     */
    public void addName() throws JNCException {
        setLeafValue(TfcgPrefix.NAMESPACE,
            "name",
            null,
            childrenNames());
    }

    /**
     * Marks the leaf "name" with operation "replace".
     */
    public void markNameReplace() throws JNCException {
        markLeafReplace("name");
    }

    /**
     * Marks the leaf "name" with operation "merge".
     */
    public void markNameMerge() throws JNCException {
        markLeafMerge("name");
    }

    /**
     * Marks the leaf "name" with operation "create".
     */
    public void markNameCreate() throws JNCException {
        markLeafCreate("name");
    }

    /**
     * Marks the leaf "name" with operation "delete".
     */
    public void markNameDelete() throws JNCException {
        markLeafDelete("name");
    }

    /**
     * Marks the leaf "name" with operation "remove".
     */
    public void markNameRemove() throws JNCException {
        markLeafRemove("name");
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
