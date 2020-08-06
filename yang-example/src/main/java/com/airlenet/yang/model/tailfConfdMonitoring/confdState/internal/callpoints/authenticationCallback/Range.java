/* 
 * @(#)Range.java        1.0
 *
 * This file has been auto-generated by JNC, the
 * Java output format plug-in of pyang.
 * Origin: module "tailf-confd-monitoring", revision: "2013-06-14".
 */

package com.airlenet.yang.model.tailfConfdMonitoring.confdState.internal.callpoints.authenticationCallback;

import com.airlenet.yang.model.tailfCommonMonitoring.TfcgPrefix;
import com.airlenet.yang.model.tailfConfdMonitoring.confdState.internal.callpoints.authenticationCallback.range.Daemon;
import com.tailf.jnc.Element;
import com.tailf.jnc.JNCException;
import com.tailf.jnc.NodeSet;
import com.tailf.jnc.YangElement;
import com.tailf.jnc.YangEmpty;
import com.tailf.jnc.YangString;

/**
 * This class represents an element from 
 * the namespace http://tail-f.com/yang/confd-monitoring
 * generated to "src/main/java/com.airlenet.yang.model/tailfConfdMonitoring/confdState/internal/callpoints/authenticationCallback/range"
 * <p>
 * See line 128 in
 * src/main/yang/module/tailf/tailf-common-monitoring.yang
 *
 * @version 1.0
 * @author Auto Generated
 */
public class Range extends YangElement {

    private static final long serialVersionUID = 1L;

    /**
     * Field for child container "daemon".
     */
    public Daemon daemon = null;
    public Daemon getDaemon() {
        return this.daemon;
    }

    /**
     * Constructor for an empty Range object.
     */
    public Range() {
        super(TfcgPrefix.NAMESPACE, "range");
    }

    /**
     * Clones this object, returning an exact copy.
     * @return A clone of the object.
     */
    public Range clone() {
        return (Range)cloneContent(new Range());
    }

    /**
     * Clones this object, returning a shallow copy.
     * @return A clone of the object. Children are not included.
     */
    public Range cloneShallow() {
        return (Range)cloneShallowContent(new Range());
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
            "lower",
            "upper",
            "default",
            "daemon",
        };
    }

    /* Access methods for optional leaf child: "lower". */

    /**
     * Gets the value for child leaf "lower".
     * @return The value of the leaf.
     */
    public com.tailf.jnc.YangString getLowerValue() throws JNCException {
        return (com.tailf.jnc.YangString)getValue("lower");
    }

    /**
     * Sets the value for child leaf "lower",
     * using instance of generated typedef class.
     * @param lowerValue The value to set.
     * @param lowerValue used during instantiation.
     */
    public void setLowerValue(com.tailf.jnc.YangString lowerValue)
            throws JNCException {
        setLeafValue(TfcgPrefix.NAMESPACE,
            "lower",
            lowerValue,
            childrenNames());
    }

    /**
     * Sets the value for child leaf "lower",
     * using a String value.
     * @param lowerValue used during instantiation.
     */
    public void setLowerValue(String lowerValue) throws JNCException {
        setLowerValue(new com.tailf.jnc.YangString(lowerValue));
    }

    /**
     * Unsets the value for child leaf "lower".
     */
    public void unsetLowerValue() throws JNCException {
        delete("lower");
    }

    /**
     * This method is used for creating a subtree filter.
     * The added "lower" leaf will not have a value.
     */
    public void addLower() throws JNCException {
        setLeafValue(TfcgPrefix.NAMESPACE,
            "lower",
            null,
            childrenNames());
    }

    /**
     * Marks the leaf "lower" with operation "replace".
     */
    public void markLowerReplace() throws JNCException {
        markLeafReplace("lower");
    }

    /**
     * Marks the leaf "lower" with operation "merge".
     */
    public void markLowerMerge() throws JNCException {
        markLeafMerge("lower");
    }

    /**
     * Marks the leaf "lower" with operation "create".
     */
    public void markLowerCreate() throws JNCException {
        markLeafCreate("lower");
    }

    /**
     * Marks the leaf "lower" with operation "delete".
     */
    public void markLowerDelete() throws JNCException {
        markLeafDelete("lower");
    }

    /**
     * Marks the leaf "lower" with operation "remove".
     */
    public void markLowerRemove() throws JNCException {
        markLeafRemove("lower");
    }

    /* Access methods for optional leaf child: "upper". */

    /**
     * Gets the value for child leaf "upper".
     * @return The value of the leaf.
     */
    public com.tailf.jnc.YangString getUpperValue() throws JNCException {
        return (com.tailf.jnc.YangString)getValue("upper");
    }

    /**
     * Sets the value for child leaf "upper",
     * using instance of generated typedef class.
     * @param upperValue The value to set.
     * @param upperValue used during instantiation.
     */
    public void setUpperValue(com.tailf.jnc.YangString upperValue)
            throws JNCException {
        setLeafValue(TfcgPrefix.NAMESPACE,
            "upper",
            upperValue,
            childrenNames());
    }

    /**
     * Sets the value for child leaf "upper",
     * using a String value.
     * @param upperValue used during instantiation.
     */
    public void setUpperValue(String upperValue) throws JNCException {
        setUpperValue(new com.tailf.jnc.YangString(upperValue));
    }

    /**
     * Unsets the value for child leaf "upper".
     */
    public void unsetUpperValue() throws JNCException {
        delete("upper");
    }

    /**
     * This method is used for creating a subtree filter.
     * The added "upper" leaf will not have a value.
     */
    public void addUpper() throws JNCException {
        setLeafValue(TfcgPrefix.NAMESPACE,
            "upper",
            null,
            childrenNames());
    }

    /**
     * Marks the leaf "upper" with operation "replace".
     */
    public void markUpperReplace() throws JNCException {
        markLeafReplace("upper");
    }

    /**
     * Marks the leaf "upper" with operation "merge".
     */
    public void markUpperMerge() throws JNCException {
        markLeafMerge("upper");
    }

    /**
     * Marks the leaf "upper" with operation "create".
     */
    public void markUpperCreate() throws JNCException {
        markLeafCreate("upper");
    }

    /**
     * Marks the leaf "upper" with operation "delete".
     */
    public void markUpperDelete() throws JNCException {
        markLeafDelete("upper");
    }

    /**
     * Marks the leaf "upper" with operation "remove".
     */
    public void markUpperRemove() throws JNCException {
        markLeafRemove("upper");
    }

    /* Access methods for optional leaf child: "default". */

    /**
     * Searches for leaf "default".
     * @return A YangEmpty object if leaf exists; <code>null</code> otherwise.
     */
    public com.tailf.jnc.YangEmpty getJDefaultValue() throws JNCException {
        return (com.tailf.jnc.YangEmpty)getValue("default");
    }

    /**
     * Sets the value for child leaf "default",
     * using instance of generated typedef class.
     * @param default_Value The value to set.
     * @param default_Value used during instantiation.
     */
    public void setJDefaultValue(com.tailf.jnc.YangEmpty default_Value)
            throws JNCException {
        setLeafValue(TfcgPrefix.NAMESPACE,
            "default",
            default_Value,
            childrenNames());
    }

    /**
     * Sets the value for child leaf "default",
     * by instantiating it (value n/a).
     * @param default_Value ignored.
     */
    public void setJDefaultValue(String default_Value) throws JNCException {
        setJDefaultValue(new YangEmpty());
    }

    /**
     * Unsets the value for child leaf "default".
     */
    public void unsetJDefaultValue() throws JNCException {
        delete("default");
    }

    /**
     * This method is used for creating a subtree filter.
     * The added "default" leaf will not have a value.
     */
    public void addJDefault() throws JNCException {
        setLeafValue(TfcgPrefix.NAMESPACE,
            "default",
            null,
            childrenNames());
    }

    /**
     * Marks the leaf "default" with operation "replace".
     */
    public void markJDefaultReplace() throws JNCException {
        markLeafReplace("default");
    }

    /**
     * Marks the leaf "default" with operation "merge".
     */
    public void markJDefaultMerge() throws JNCException {
        markLeafMerge("default");
    }

    /**
     * Marks the leaf "default" with operation "create".
     */
    public void markJDefaultCreate() throws JNCException {
        markLeafCreate("default");
    }

    /**
     * Marks the leaf "default" with operation "delete".
     */
    public void markJDefaultDelete() throws JNCException {
        markLeafDelete("default");
    }

    /**
     * Marks the leaf "default" with operation "remove".
     */
    public void markJDefaultRemove() throws JNCException {
        markLeafRemove("default");
    }

    /* Access methods for container child: "daemon". */

    /**
     * Adds container entry "daemon", using an existing object.
     * @param daemon The object to add.
     * @return The added child.
     */
    public Daemon addDaemon(Daemon daemon) throws JNCException {
        this.daemon = daemon;
        insertChild(daemon, childrenNames());
        return daemon;
    }

    /**
     * Adds container entry "daemon".
     * This method is used for creating subtree filters.
     * @return The added child.
     */
    public Daemon addDaemon() throws JNCException {
        Daemon daemon = new Daemon();
        this.daemon = daemon;
        insertChild(daemon, childrenNames());
        return daemon;
    }

    /**
     * Deletes container entry "daemon".
     * @return An array of the deleted element nodes.
     */
    public NodeSet deleteDaemon() throws JNCException {
        this.daemon = null;
        String path = "daemon";
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
        if (child instanceof Daemon) daemon = (Daemon)child;
    }

}
