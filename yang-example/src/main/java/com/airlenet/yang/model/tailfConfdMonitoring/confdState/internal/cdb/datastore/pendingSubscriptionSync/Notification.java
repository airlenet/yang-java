/* 
 * @(#)Notification.java        1.0
 *
 * This file has been auto-generated by JNC, the
 * Java output format plug-in of pyang.
 * Origin: module "tailf-confd-monitoring", revision: "2013-06-14".
 */

package com.airlenet.yang.model.tailfConfdMonitoring.confdState.internal.cdb.datastore.pendingSubscriptionSync;

import com.airlenet.yang.model.tailfCommonMonitoring.TfcgPrefix;
import com.tailf.jnc.Element;
import com.tailf.jnc.ElementLeafListValueIterator;
import com.tailf.jnc.JNCException;
import com.tailf.jnc.YangElement;
import com.tailf.jnc.YangString;
import com.tailf.jnc.YangUInt32;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents an element from 
 * the namespace http://tail-f.com/yang/confd-monitoring
 * generated to "src/main/java/com.airlenet.yang.model/tailfConfdMonitoring/confdState/internal/cdb/datastore/pendingSubscriptionSync/notification"
 * <p>
 * See line 696 in
 * src/main/yang/module/tailf/tailf-common-monitoring.yang
 *
 * @version 1.0
 * @author Auto Generated
 */
public class Notification extends YangElement {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor for an empty Notification object.
     */
    public Notification() {
        super(TfcgPrefix.NAMESPACE, "notification");
    }

    /**
     * Clones this object, returning an exact copy.
     * @return A clone of the object.
     */
    public Notification clone() {
        return (Notification)cloneContent(new Notification());
    }

    /**
     * Clones this object, returning a shallow copy.
     * @return A clone of the object. Children are not included.
     */
    public Notification cloneShallow() {
        return (Notification)cloneShallowContent(new Notification());
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
            "client-name",
            "subscription-ids",
        };
    }

    /* Access methods for optional leaf child: "client-name". */

    /**
     * Gets the value for child leaf "client-name".
     * @return The value of the leaf.
     */
    public com.tailf.jnc.YangString getClientNameValue() throws JNCException {
        return (com.tailf.jnc.YangString)getValue("client-name");
    }

    /**
     * Sets the value for child leaf "client-name",
     * using instance of generated typedef class.
     * @param clientNameValue The value to set.
     * @param clientNameValue used during instantiation.
     */
    public void setClientNameValue(com.tailf.jnc.YangString clientNameValue)
            throws JNCException {
        setLeafValue(TfcgPrefix.NAMESPACE,
            "client-name",
            clientNameValue,
            childrenNames());
    }

    /**
     * Sets the value for child leaf "client-name",
     * using a String value.
     * @param clientNameValue used during instantiation.
     */
    public void setClientNameValue(String clientNameValue) throws JNCException {
        setClientNameValue(new com.tailf.jnc.YangString(clientNameValue));
    }

    /**
     * Unsets the value for child leaf "client-name".
     */
    public void unsetClientNameValue() throws JNCException {
        delete("client-name");
    }

    /**
     * This method is used for creating a subtree filter.
     * The added "client-name" leaf will not have a value.
     */
    public void addClientName() throws JNCException {
        setLeafValue(TfcgPrefix.NAMESPACE,
            "client-name",
            null,
            childrenNames());
    }

    /**
     * Marks the leaf "client-name" with operation "replace".
     */
    public void markClientNameReplace() throws JNCException {
        markLeafReplace("client-name");
    }

    /**
     * Marks the leaf "client-name" with operation "merge".
     */
    public void markClientNameMerge() throws JNCException {
        markLeafMerge("client-name");
    }

    /**
     * Marks the leaf "client-name" with operation "create".
     */
    public void markClientNameCreate() throws JNCException {
        markLeafCreate("client-name");
    }

    /**
     * Marks the leaf "client-name" with operation "delete".
     */
    public void markClientNameDelete() throws JNCException {
        markLeafDelete("client-name");
    }

    /**
     * Marks the leaf "client-name" with operation "remove".
     */
    public void markClientNameRemove() throws JNCException {
        markLeafRemove("client-name");
    }

    /* Access methods for optional leaf-list child: "subscription-ids". */

    /**
     * Iterator method for the leaf-list "subscription-ids".
     * @return An iterator for the leaf-list.
     */
    public ElementLeafListValueIterator subscriptionIdsIterator() {
        return new ElementLeafListValueIterator(children, "subscription-ids");
    }

    /**
     * List method for the leaf-list "subscription-ids".
     * @return An List for the leaf-list.
     */
    public List<com.tailf.jnc.YangUInt32> getSubscriptionIdsList() {
        List<com.tailf.jnc.YangUInt32> list = new ArrayList<>();
        ElementLeafListValueIterator iterator = subscriptionIdsIterator();
        if(iterator==null){
            return null;
        }
        while (iterator.hasNext()){
            com.tailf.jnc.YangUInt32 next =(com.tailf.jnc.YangUInt32) iterator.next();
            list.add(next);
        }
        return list;
    }

    /**
     * Sets the value for child leaf-list "subscription-ids",
     * using a JNC type value.
     * @param subscriptionIdsValue The value to set.
     * @param subscriptionIdsValue used during instantiation.
     */
    public void setSubscriptionIdsValue(com.tailf.jnc.YangUInt32 subscriptionIdsValue)
            throws JNCException {
        setLeafListValue(TfcgPrefix.NAMESPACE,
            "subscription-ids",
            subscriptionIdsValue,
            childrenNames());
    }

    /**
     * Sets the value for child leaf-list "subscription-ids",
     * using Java primitive values.
     * @param subscriptionIdsValue used during instantiation.
     */
    public void setSubscriptionIdsValue(long subscriptionIdsValue)
            throws JNCException {
        setSubscriptionIdsValue(new com.tailf.jnc.YangUInt32(subscriptionIdsValue));
    }

    /**
     * Sets the value for child leaf-list "subscription-ids",
     * using a String value.
     * @param subscriptionIdsValue used during instantiation.
     */
    public void setSubscriptionIdsValue(String subscriptionIdsValue)
            throws JNCException {
        setSubscriptionIdsValue(new com.tailf.jnc.YangUInt32(subscriptionIdsValue));
    }

    /**
     * Deletes leaf-list entry "subscriptionIds".
     * @param subscriptionIdsValue Value to delete.
     */
    public void deleteSubscriptionIds(YangUInt32 subscriptionIdsValue)
            throws JNCException {
        String path = "subscription-ids[subscriptionIdsValue]";
        delete(path);
    }

    /**
     * Deletes leaf-list entry "subscriptionIds".
     * The value is specified as a string.
     * @param subscriptionIdsValue Value to delete.
     */
    public void deleteSubscriptionIds(String subscriptionIdsValue)
            throws JNCException {
        String path = "subscription-ids[subscriptionIdsValue]";
        delete(path);
    }

    /**
     * This method is used for creating a subtree filter.
     * The added "subscription-ids" leaf-list will not have a value.
     */
    public void addSubscriptionIds() throws JNCException {
        setLeafListValue(TfcgPrefix.NAMESPACE,
            "subscription-ids",
            null,
            childrenNames());
    }

    /**
     * Marks the leaf-list "subscription-ids" with operation "replace".
     * @param subscriptionIdsValue The value to mark
     */
    public void markSubscriptionIdsReplace(YangUInt32 subscriptionIdsValue)
            throws JNCException {
        markLeafReplace("subscription-ids[name='" + subscriptionIdsValue + "']");
    }

    /**
     * Marks the leaf-list "subscription-ids" with operation "replace".
     * @param subscriptionIdsValue The value to mark, given as a String
     */
    public void markSubscriptionIdsReplace(String subscriptionIdsValue)
            throws JNCException {
        markLeafReplace("subscription-ids[name='" + subscriptionIdsValue + "']");
    }

    /**
     * Marks the leaf-list "subscription-ids" with operation "merge".
     * @param subscriptionIdsValue The value to mark
     */
    public void markSubscriptionIdsMerge(YangUInt32 subscriptionIdsValue)
            throws JNCException {
        markLeafMerge("subscription-ids[name='" + subscriptionIdsValue + "']");
    }

    /**
     * Marks the leaf-list "subscription-ids" with operation "merge".
     * @param subscriptionIdsValue The value to mark, given as a String
     */
    public void markSubscriptionIdsMerge(String subscriptionIdsValue)
            throws JNCException {
        markLeafMerge("subscription-ids[name='" + subscriptionIdsValue + "']");
    }

    /**
     * Marks the leaf-list "subscription-ids" with operation "create".
     * @param subscriptionIdsValue The value to mark
     */
    public void markSubscriptionIdsCreate(YangUInt32 subscriptionIdsValue)
            throws JNCException {
        markLeafCreate("subscription-ids[name='" + subscriptionIdsValue + "']");
    }

    /**
     * Marks the leaf-list "subscription-ids" with operation "create".
     * @param subscriptionIdsValue The value to mark, given as a String
     */
    public void markSubscriptionIdsCreate(String subscriptionIdsValue)
            throws JNCException {
        markLeafCreate("subscription-ids[name='" + subscriptionIdsValue + "']");
    }

    /**
     * Marks the leaf-list "subscription-ids" with operation "delete".
     * @param subscriptionIdsValue The value to mark
     */
    public void markSubscriptionIdsDelete(YangUInt32 subscriptionIdsValue)
            throws JNCException {
        markLeafDelete("subscription-ids[name='" + subscriptionIdsValue + "']");
    }

    /**
     * Marks the leaf-list "subscription-ids" with operation "delete".
     * @param subscriptionIdsValue The value to mark, given as a String
     */
    public void markSubscriptionIdsDelete(String subscriptionIdsValue)
            throws JNCException {
        markLeafDelete("subscription-ids[name='" + subscriptionIdsValue + "']");
    }

    /**
     * Marks the leaf-list "subscription-ids" with operation "remove".
     * @param subscriptionIdsValue The value to mark
     */
    public void markSubscriptionIdsRemove(YangUInt32 subscriptionIdsValue)
            throws JNCException {
        markLeafRemove("subscription-ids[name='" + subscriptionIdsValue + "']");
    }

    /**
     * Marks the leaf-list "subscription-ids" with operation "remove".
     * @param subscriptionIdsValue The value to mark, given as a String
     */
    public void markSubscriptionIdsRemove(String subscriptionIdsValue)
            throws JNCException {
        markLeafRemove("subscription-ids[name='" + subscriptionIdsValue + "']");
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
