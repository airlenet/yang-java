/* 
 * @(#)Deviation.java        1.0
 *
 * This file has been auto-generated by JNC, the
 * Java output format plug-in of pyang.
 * Origin: module "ietf-yang-library", revision: "2016-06-21".
 */

package com.airlenet.yang.model.ietfYangLibrary.modulesState.module;

import com.airlenet.yang.model.ietfYangLibrary.YanglibPrefix;
import com.airlenet.yang.model.ietfYangTypes.YangIdentifier;
import com.tailf.jnc.Element;
import com.tailf.jnc.JNCException;
import com.tailf.jnc.YangElement;
import com.tailf.jnc.YangUnion;

/**
 * This class represents an element from 
 * the namespace urn:ietf:params:xml:ns:yang:ietf-yang-library
 * generated to "src/main/java/com.airlenet.yang.model/ietfYangLibrary/modulesState/module/deviation"
 * <p>
 * See line 139 in
 * src/main/yang/module/ietf/ietf-yang-library.yang
 *
 * @version 1.0
 * @author Auto Generated
 */
public class Deviation extends YangElement {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor for an empty Deviation object.
     */
    public Deviation() {
        super(YanglibPrefix.NAMESPACE, "deviation");
    }

    /**
     * Clones this object, returning an exact copy.
     * @return A clone of the object.
     */
    public Deviation clone() {
        return (Deviation)cloneContent(new Deviation());
    }

    /**
     * Clones this object, returning a shallow copy.
     * @return A clone of the object. Children are not included.
     */
    public Deviation cloneShallow() {
        return (Deviation)cloneShallowContent(new Deviation());
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
            "name",
            "revision",
        };
    }

    /* Access methods for leaf child: "name". */

    /**
     * Gets the value for child leaf "name".
     * @return The value of the leaf.
     */
    public com.airlenet.yang.model.ietfYangTypes.YangIdentifier getNameValue()
            throws JNCException {
        return (com.airlenet.yang.model.ietfYangTypes.YangIdentifier)getValue("name");
    }

    /**
     * Sets the value for child leaf "name",
     * using a JNC type value.
     * @param nameValue The value to set.
     * @param nameValue used during instantiation.
     */
    public void setNameValue(com.airlenet.yang.model.ietfYangTypes.YangIdentifier nameValue)
            throws JNCException {
        setLeafValue(YanglibPrefix.NAMESPACE,
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
        setNameValue(new com.airlenet.yang.model.ietfYangTypes.YangIdentifier(nameValue));
    }

    /**
     * This method is used for creating a subtree filter.
     * The added "name" leaf will not have a value.
     */
    public void addName() throws JNCException {
        setLeafValue(YanglibPrefix.NAMESPACE,
            "name",
            null,
            childrenNames());
    }

    /* Access methods for leaf child: "revision". */

    /**
     * Gets the value for child leaf "revision".
     * @return The value of the leaf.
     */
    public com.tailf.jnc.YangUnion getRevisionValue() throws JNCException {
        return (com.tailf.jnc.YangUnion)getValue("revision");
    }

    /**
     * Sets the value for child leaf "revision",
     * using instance of generated typedef class.
     * @param revisionValue The value to set.
     * @param revisionValue used during instantiation.
     */
    public void setRevisionValue(com.tailf.jnc.YangUnion revisionValue)
            throws JNCException {
        setLeafValue(YanglibPrefix.NAMESPACE,
            "revision",
            revisionValue,
            childrenNames());
    }

    /**
     * Sets the value for child leaf "revision",
     * using a String value.
     * @param revisionValue used during instantiation.
     */
    public void setRevisionValue(String revisionValue) throws JNCException {
        setRevisionValue(new com.tailf.jnc.YangUnion(revisionValue, new String[] {
             "com.airlenet.yang.model.ietfYangLibrary.RevisionIdentifier",
             "com.tailf.jnc.YangString",
        }));
    }

    /**
     * This method is used for creating a subtree filter.
     * The added "revision" leaf will not have a value.
     */
    public void addRevision() throws JNCException {
        setLeafValue(YanglibPrefix.NAMESPACE,
            "revision",
            null,
            childrenNames());
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