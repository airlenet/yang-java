/* 
 * @(#)Employees.java        1.0
 *
 * This file has been auto-generated by JNC, the
 * Java output format plug-in of pyang.
 * Origin: module "demo", revision: "unknown".
 */

package com.airlenet.yang.model.demo;

import com.airlenet.yang.model.demo.DemoPrefix;
import com.airlenet.yang.model.demo.employees.Employee;
import com.tailf.jnc.Element;
import com.tailf.jnc.ElementChildrenIterator;
import com.tailf.jnc.JNCException;
import com.tailf.jnc.YangElement;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents an element from 
 * the namespace http://tail-f.com/ns/example/demo
 * generated to "src/main/java/com.airlenet.yang.model/demo/employees"
 * <p>
 * See line 5 in
 * src/main/yang/demo.yang
 *
 * @version 1.0
 * @author Auto Generated
 */
public class Employees extends YangElement {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor for an empty Employees object.
     */
    public Employees() {
        super(DemoPrefix.NAMESPACE, "employees");
        setDefaultPrefix();
        setPrefix(DemoPrefix.PREFIX);
    }

    /**
     * Clones this object, returning an exact copy.
     * @return A clone of the object.
     */
    public Employees clone() {
        return (Employees)cloneContent(new Employees());
    }

    /**
     * Clones this object, returning a shallow copy.
     * @return A clone of the object. Children are not included.
     */
    public Employees cloneShallow() {
        return (Employees)cloneShallowContent(new Employees());
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
            "employee",
        };
    }

    /* Access methods for list child: "employee". */

    /**
     * Gets list entry "employee", with specified keys.
     * @param idValue Key argument of child.
     */
    public Employee getEmployee(com.tailf.jnc.YangUInt32 idValue)
            throws JNCException {
        String path = "employee[id='" + idValue + "']";
        return (Employee)searchOne(path);
    }

    /**
     * Gets list entry "employee", with specified keys.
     * The keys are specified as strings.
     * @param idValue Key argument of child.
     */
    public Employee getEmployee(String idValue) throws JNCException {
        String path = "employee[id='" + idValue + "']";
        return (Employee)searchOne(path);
    }

    /**
     * Iterator method for the list "employee".
     * @return An iterator for the list.
     */
    public ElementChildrenIterator employeeIterator() {
        return new ElementChildrenIterator(children, "employee");
    }

    /**
     * List method for the list "employee".
     * @return An List for the list.
     */
    public List<Employee> getEmployeeList() {
        List<Employee> list = new ArrayList<>();
        ElementChildrenIterator iterator = employeeIterator();
        if(iterator==null){
            return null;
        }
        while (iterator.hasNext()){
            Employee next =(Employee) iterator.next();
            list.add(next);
        }
        return list;
    }

    /**
     * Adds list entry "employee", using an existing object.
     * @param employee The object to add.
     * @return The added child.
     */
    public Employee addEmployee(Employee employee) throws JNCException {
        insertChild(employee, childrenNames());
        return employee;
    }

    /**
     * Adds list entry "employee", with specified keys.
     * @param idValue Key argument of child.
     * @return The added child.
     */
    public Employee addEmployee(com.tailf.jnc.YangUInt32 idValue)
            throws JNCException {
        Employee employee = new Employee(idValue);
        return addEmployee(employee);
    }

    /**
     * Adds list entry "employee", with specified keys.
     * The keys are specified as strings.
     * @param idValue Key argument of child.
     * @return The added child.
     */
    public Employee addEmployee(String idValue) throws JNCException {
        Employee employee = new Employee(idValue);
        return addEmployee(employee);
    }

    /**
     * Adds list entry "employee".
     * This method is used for creating subtree filters.
     * @return The added child.
     */
    public Employee addEmployee() throws JNCException {
        Employee employee = new Employee();
        insertChild(employee, childrenNames());
        return employee;
    }

    /**
     * Deletes list entry "employee", with specified keys.
     * @param idValue Key argument of child.
     */
    public void deleteEmployee(com.tailf.jnc.YangUInt32 idValue)
            throws JNCException {
        String path = "employee[id='" + idValue + "']";
        delete(path);
    }

    /**
     * Deletes list entry "employee", with specified keys.
     * The keys are specified as strings.
     * @param idValue Key argument of child.
     */
    public void deleteEmployee(String idValue) throws JNCException {
        String path = "employee[id='" + idValue + "']";
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
    }

}
