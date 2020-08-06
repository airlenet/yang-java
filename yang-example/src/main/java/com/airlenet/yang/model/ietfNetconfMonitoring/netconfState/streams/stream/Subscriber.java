/* 
 * @(#)Subscriber.java        1.0
 *
 * This file has been auto-generated by JNC, the
 * Java output format plug-in of pyang.
 * Origin: module "ietf-netconf-monitoring", revision: "2010-10-04".
 */

package com.airlenet.yang.model.ietfNetconfMonitoring.netconfState.streams.stream;

import com.airlenet.yang.model.ietfYangTypes.DateAndTime;
import com.airlenet.yang.model.tailfNetconfMonitoring.TncmPrefix;
import com.tailf.jnc.Element;
import com.tailf.jnc.JNCException;
import com.tailf.jnc.YangElement;
import com.tailf.jnc.YangUInt32;

/**
 * This class represents an element from 
 * the namespace urn:ietf:params:xml:ns:yang:ietf-netconf-monitoring
 * generated to "src/main/java/com.airlenet.yang.model/ietfNetconfMonitoring/netconfState/streams/stream/subscriber"
 * <p>
 * See line 259 in
 * src/main/yang/module/tailf/tailf-netconf-monitoring.yang
 *
 * @version 1.0
 * @author Auto Generated
 */
public class Subscriber extends YangElement {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor for an empty Subscriber object.
     */
    public Subscriber() {
        super(TncmPrefix.NAMESPACE, "subscriber");
    }

    /**
     * Clones this object, returning an exact copy.
     * @return A clone of the object.
     */
    public Subscriber clone() {
        return (Subscriber)cloneContent(new Subscriber());
    }

    /**
     * Clones this object, returning a shallow copy.
     * @return A clone of the object. Children are not included.
     */
    public Subscriber cloneShallow() {
        return (Subscriber)cloneShallowContent(new Subscriber());
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
            "session-id",
            "start-time",
            "stop-time",
        };
    }

    /* Access methods for leaf child: "session-id". */

    /**
     * Gets the value for child leaf "session-id".
     * @return The value of the leaf.
     */
    public com.tailf.jnc.YangUInt32 getSessionIdValue() throws JNCException {
        return (com.tailf.jnc.YangUInt32)getValue("session-id");
    }

    /**
     * Sets the value for child leaf "session-id",
     * using instance of generated typedef class.
     * @param sessionIdValue The value to set.
     * @param sessionIdValue used during instantiation.
     */
    public void setSessionIdValue(com.tailf.jnc.YangUInt32 sessionIdValue)
            throws JNCException {
        setLeafValue(TncmPrefix.NAMESPACE,
            "session-id",
            sessionIdValue,
            childrenNames());
    }

    /**
     * Sets the value for child leaf "session-id",
     * using Java primitive values.
     * @param sessionIdValue used during instantiation.
     */
    public void setSessionIdValue(long sessionIdValue) throws JNCException {
        setSessionIdValue(new com.tailf.jnc.YangUInt32(sessionIdValue));
    }

    /**
     * Sets the value for child leaf "session-id",
     * using a String value.
     * @param sessionIdValue used during instantiation.
     */
    public void setSessionIdValue(String sessionIdValue) throws JNCException {
        setSessionIdValue(new com.tailf.jnc.YangUInt32(sessionIdValue));
    }

    /**
     * This method is used for creating a subtree filter.
     * The added "session-id" leaf will not have a value.
     */
    public void addSessionId() throws JNCException {
        setLeafValue(TncmPrefix.NAMESPACE,
            "session-id",
            null,
            childrenNames());
    }

    /* Access methods for optional leaf child: "start-time". */

    /**
     * Gets the value for child leaf "start-time".
     * @return The value of the leaf.
     */
    public com.airlenet.yang.model.ietfYangTypes.DateAndTime getStartTimeValue()
            throws JNCException {
        return (com.airlenet.yang.model.ietfYangTypes.DateAndTime)getValue("start-time");
    }

    /**
     * Sets the value for child leaf "start-time",
     * using a JNC type value.
     * @param startTimeValue The value to set.
     * @param startTimeValue used during instantiation.
     */
    public void setStartTimeValue(com.airlenet.yang.model.ietfYangTypes.DateAndTime startTimeValue)
            throws JNCException {
        setLeafValue(TncmPrefix.NAMESPACE,
            "start-time",
            startTimeValue,
            childrenNames());
    }

    /**
     * Sets the value for child leaf "start-time",
     * using a String value.
     * @param startTimeValue used during instantiation.
     */
    public void setStartTimeValue(String startTimeValue) throws JNCException {
        setStartTimeValue(new com.airlenet.yang.model.ietfYangTypes.DateAndTime(startTimeValue));
    }

    /**
     * Unsets the value for child leaf "start-time".
     */
    public void unsetStartTimeValue() throws JNCException {
        delete("start-time");
    }

    /**
     * This method is used for creating a subtree filter.
     * The added "start-time" leaf will not have a value.
     */
    public void addStartTime() throws JNCException {
        setLeafValue(TncmPrefix.NAMESPACE,
            "start-time",
            null,
            childrenNames());
    }

    /**
     * Marks the leaf "start-time" with operation "replace".
     */
    public void markStartTimeReplace() throws JNCException {
        markLeafReplace("start-time");
    }

    /**
     * Marks the leaf "start-time" with operation "merge".
     */
    public void markStartTimeMerge() throws JNCException {
        markLeafMerge("start-time");
    }

    /**
     * Marks the leaf "start-time" with operation "create".
     */
    public void markStartTimeCreate() throws JNCException {
        markLeafCreate("start-time");
    }

    /**
     * Marks the leaf "start-time" with operation "delete".
     */
    public void markStartTimeDelete() throws JNCException {
        markLeafDelete("start-time");
    }

    /**
     * Marks the leaf "start-time" with operation "remove".
     */
    public void markStartTimeRemove() throws JNCException {
        markLeafRemove("start-time");
    }

    /* Access methods for optional leaf child: "stop-time". */

    /**
     * Gets the value for child leaf "stop-time".
     * @return The value of the leaf.
     */
    public com.airlenet.yang.model.ietfYangTypes.DateAndTime getStopTimeValue()
            throws JNCException {
        return (com.airlenet.yang.model.ietfYangTypes.DateAndTime)getValue("stop-time");
    }

    /**
     * Sets the value for child leaf "stop-time",
     * using a JNC type value.
     * @param stopTimeValue The value to set.
     * @param stopTimeValue used during instantiation.
     */
    public void setStopTimeValue(com.airlenet.yang.model.ietfYangTypes.DateAndTime stopTimeValue)
            throws JNCException {
        setLeafValue(TncmPrefix.NAMESPACE,
            "stop-time",
            stopTimeValue,
            childrenNames());
    }

    /**
     * Sets the value for child leaf "stop-time",
     * using a String value.
     * @param stopTimeValue used during instantiation.
     */
    public void setStopTimeValue(String stopTimeValue) throws JNCException {
        setStopTimeValue(new com.airlenet.yang.model.ietfYangTypes.DateAndTime(stopTimeValue));
    }

    /**
     * Unsets the value for child leaf "stop-time".
     */
    public void unsetStopTimeValue() throws JNCException {
        delete("stop-time");
    }

    /**
     * This method is used for creating a subtree filter.
     * The added "stop-time" leaf will not have a value.
     */
    public void addStopTime() throws JNCException {
        setLeafValue(TncmPrefix.NAMESPACE,
            "stop-time",
            null,
            childrenNames());
    }

    /**
     * Marks the leaf "stop-time" with operation "replace".
     */
    public void markStopTimeReplace() throws JNCException {
        markLeafReplace("stop-time");
    }

    /**
     * Marks the leaf "stop-time" with operation "merge".
     */
    public void markStopTimeMerge() throws JNCException {
        markLeafMerge("stop-time");
    }

    /**
     * Marks the leaf "stop-time" with operation "create".
     */
    public void markStopTimeCreate() throws JNCException {
        markLeafCreate("stop-time");
    }

    /**
     * Marks the leaf "stop-time" with operation "delete".
     */
    public void markStopTimeDelete() throws JNCException {
        markLeafDelete("stop-time");
    }

    /**
     * Marks the leaf "stop-time" with operation "remove".
     */
    public void markStopTimeRemove() throws JNCException {
        markLeafRemove("stop-time");
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
