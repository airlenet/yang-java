/* 
 * @(#)Udp.java        1.0
 *
 * This file has been auto-generated by JNC, the
 * Java output format plug-in of pyang.
 * Origin: module "tailf-confd-monitoring", revision: "2013-06-14".
 */

package com.airlenet.yang.model.tailfConfdMonitoring.confdState.snmp.listen;

import com.airlenet.yang.model.ietfInetTypes.IpAddress;
import com.airlenet.yang.model.ietfInetTypes.PortNumber;
import com.airlenet.yang.model.tailfCommonMonitoring.TfcgPrefix;
import com.tailf.jnc.Element;
import com.tailf.jnc.JNCException;
import com.tailf.jnc.YangElement;

/**
 * This class represents an element from 
 * the namespace http://tail-f.com/yang/confd-monitoring
 * generated to "src/main/java/com.airlenet.yang.model/tailfConfdMonitoring/confdState/snmp/listen/udp"
 * <p>
 * See line 468 in
 * src/main/yang/module/tailf/tailf-common-monitoring.yang
 *
 * @version 1.0
 * @author Auto Generated
 */
public class Udp extends YangElement {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor for an empty Udp object.
     */
    public Udp() {
        super(TfcgPrefix.NAMESPACE, "udp");
    }

    /**
     * Clones this object, returning an exact copy.
     * @return A clone of the object.
     */
    public Udp clone() {
        return (Udp)cloneContent(new Udp());
    }

    /**
     * Clones this object, returning a shallow copy.
     * @return A clone of the object. Children are not included.
     */
    public Udp cloneShallow() {
        return (Udp)cloneShallowContent(new Udp());
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
            "ip",
            "port",
        };
    }

    /* Access methods for optional leaf child: "ip". */

    /**
     * Gets the value for child leaf "ip".
     * @return The value of the leaf.
     */
    public com.airlenet.yang.model.ietfInetTypes.IpAddress getIpValue()
            throws JNCException {
        return (com.airlenet.yang.model.ietfInetTypes.IpAddress)getValue("ip");
    }

    /**
     * Sets the value for child leaf "ip",
     * using a JNC type value.
     * @param ipValue The value to set.
     * @param ipValue used during instantiation.
     */
    public void setIpValue(com.airlenet.yang.model.ietfInetTypes.IpAddress ipValue)
            throws JNCException {
        setLeafValue(TfcgPrefix.NAMESPACE,
            "ip",
            ipValue,
            childrenNames());
    }

    /**
     * Sets the value for child leaf "ip",
     * using a String value.
     * @param ipValue used during instantiation.
     */
    public void setIpValue(String ipValue) throws JNCException {
        setIpValue(new com.airlenet.yang.model.ietfInetTypes.IpAddress(ipValue));
    }

    /**
     * Unsets the value for child leaf "ip".
     */
    public void unsetIpValue() throws JNCException {
        delete("ip");
    }

    /**
     * This method is used for creating a subtree filter.
     * The added "ip" leaf will not have a value.
     */
    public void addIp() throws JNCException {
        setLeafValue(TfcgPrefix.NAMESPACE,
            "ip",
            null,
            childrenNames());
    }

    /**
     * Marks the leaf "ip" with operation "replace".
     */
    public void markIpReplace() throws JNCException {
        markLeafReplace("ip");
    }

    /**
     * Marks the leaf "ip" with operation "merge".
     */
    public void markIpMerge() throws JNCException {
        markLeafMerge("ip");
    }

    /**
     * Marks the leaf "ip" with operation "create".
     */
    public void markIpCreate() throws JNCException {
        markLeafCreate("ip");
    }

    /**
     * Marks the leaf "ip" with operation "delete".
     */
    public void markIpDelete() throws JNCException {
        markLeafDelete("ip");
    }

    /**
     * Marks the leaf "ip" with operation "remove".
     */
    public void markIpRemove() throws JNCException {
        markLeafRemove("ip");
    }

    /* Access methods for optional leaf child: "port". */

    /**
     * Gets the value for child leaf "port".
     * @return The value of the leaf.
     */
    public com.airlenet.yang.model.ietfInetTypes.PortNumber getPortValue()
            throws JNCException {
        return (com.airlenet.yang.model.ietfInetTypes.PortNumber)getValue("port");
    }

    /**
     * Sets the value for child leaf "port",
     * using a JNC type value.
     * @param portValue The value to set.
     * @param portValue used during instantiation.
     */
    public void setPortValue(com.airlenet.yang.model.ietfInetTypes.PortNumber portValue)
            throws JNCException {
        setLeafValue(TfcgPrefix.NAMESPACE,
            "port",
            portValue,
            childrenNames());
    }

    /**
     * Sets the value for child leaf "port",
     * using Java primitive values.
     * @param portValue used during instantiation.
     */
    public void setPortValue(int portValue) throws JNCException {
        setPortValue(new com.airlenet.yang.model.ietfInetTypes.PortNumber(portValue));
    }

    /**
     * Sets the value for child leaf "port",
     * using a String value.
     * @param portValue used during instantiation.
     */
    public void setPortValue(String portValue) throws JNCException {
        setPortValue(new com.airlenet.yang.model.ietfInetTypes.PortNumber(portValue));
    }

    /**
     * Unsets the value for child leaf "port".
     */
    public void unsetPortValue() throws JNCException {
        delete("port");
    }

    /**
     * This method is used for creating a subtree filter.
     * The added "port" leaf will not have a value.
     */
    public void addPort() throws JNCException {
        setLeafValue(TfcgPrefix.NAMESPACE,
            "port",
            null,
            childrenNames());
    }

    /**
     * Marks the leaf "port" with operation "replace".
     */
    public void markPortReplace() throws JNCException {
        markLeafReplace("port");
    }

    /**
     * Marks the leaf "port" with operation "merge".
     */
    public void markPortMerge() throws JNCException {
        markLeafMerge("port");
    }

    /**
     * Marks the leaf "port" with operation "create".
     */
    public void markPortCreate() throws JNCException {
        markLeafCreate("port");
    }

    /**
     * Marks the leaf "port" with operation "delete".
     */
    public void markPortDelete() throws JNCException {
        markLeafDelete("port");
    }

    /**
     * Marks the leaf "port" with operation "remove".
     */
    public void markPortRemove() throws JNCException {
        markLeafRemove("port");
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
