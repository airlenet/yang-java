/* 
 * @(#)Rest.java        1.0
 *
 * This file has been auto-generated by JNC, the
 * Java output format plug-in of pyang.
 * Origin: module "tailf-confd-monitoring", revision: "2013-06-14".
 */

package com.airlenet.yang.model.tailfConfdMonitoring.confdState;

import com.airlenet.yang.model.tailfCommonMonitoring.TfcgPrefix;
import com.airlenet.yang.model.tailfConfdMonitoring.confdState.rest.Listen;
import com.tailf.jnc.Element;
import com.tailf.jnc.JNCException;
import com.tailf.jnc.NodeSet;
import com.tailf.jnc.YangElement;

/**
 * This class represents an element from 
 * the namespace http://tail-f.com/yang/confd-monitoring
 * generated to "src/main/java/com.airlenet.yang.model/tailfConfdMonitoring/confdState/rest"
 * <p>
 * See line 443 in
 * src/main/yang/module/tailf/tailf-common-monitoring.yang
 *
 * @version 1.0
 * @author Auto Generated
 */
public class Rest extends YangElement {

    private static final long serialVersionUID = 1L;

    /**
     * Field for child container "listen".
     */
    public Listen listen = null;
    public Listen getListen() {
        return this.listen;
    }

    /**
     * Constructor for an empty Rest object.
     */
    public Rest() {
        super(TfcgPrefix.NAMESPACE, "rest");
        setDefaultPrefix();
        setPrefix(TfcgPrefix.PREFIX);
    }

    /**
     * Clones this object, returning an exact copy.
     * @return A clone of the object.
     */
    public Rest clone() {
        return (Rest)cloneContent(new Rest());
    }

    /**
     * Clones this object, returning a shallow copy.
     * @return A clone of the object. Children are not included.
     */
    public Rest cloneShallow() {
        return (Rest)cloneShallowContent(new Rest());
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
            "listen",
        };
    }

    /* Access methods for container child: "listen". */

    /**
     * Adds container entry "listen", using an existing object.
     * @param listen The object to add.
     * @return The added child.
     */
    public Listen addListen(Listen listen) throws JNCException {
        this.listen = listen;
        insertChild(listen, childrenNames());
        return listen;
    }

    /**
     * Adds container entry "listen".
     * This method is used for creating subtree filters.
     * @return The added child.
     */
    public Listen addListen() throws JNCException {
        Listen listen = new Listen();
        this.listen = listen;
        insertChild(listen, childrenNames());
        return listen;
    }

    /**
     * Deletes container entry "listen".
     * @return An array of the deleted element nodes.
     */
    public NodeSet deleteListen() throws JNCException {
        this.listen = null;
        String path = "listen";
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
        if (child instanceof Listen) listen = (Listen)child;
    }

}
