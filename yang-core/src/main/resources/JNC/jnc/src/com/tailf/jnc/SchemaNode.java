package com.tailf.jnc;

/**
 * The SchemaNode class is used to represent individual nodes in the schema
 * tree. Each set of classes generated by the JNC pyang plugin gets its schema,
 * as a set of SchemaNode objects generated in its top class. The SchemaNodes
 * are put into a hashtable in the SchemaTree class.
 */
public class SchemaNode {

    public Tagpath tagpath;
    public String namespace;

    public int primitive_type; // C_*
    public int min_occurs;
    public int max_occurs;
    public String[] children;

    public long flags; // CS_NODE_*
    public String desc;
    public RevisionInfo[] revInfo;

//    public static final int CS_NODE_IS_DYN = (1 << 0);
//    public static final int CS_NODE_IS_WRITE = (1 << 1);
//    public static final int CS_NODE_IS_CDB = (1 << 2);
//    public static final int CS_NODE_IS_ACTION = (1 << 3);
//    public static final int CS_NODE_IS_PARAM = (1 << 4);
//    public static final int CS_NODE_IS_RESULT = (1 << 5);
//    public static final int CS_NODE_IS_NOTIF = (1 << 6);
//    public static final int CS_NODE_IS_CASE = (1 << 7);
//    
//    public static final int C_BUF = 5; // (xs:string ...)
//    public static final int C_INT8 = 6; // (xs:byte)
//    public static final int C_INT16 = 7; // (xs:short)
//    public static final int C_INT32 = 8; // (xs:int)
//    public static final int C_INT64 = 9; // (xs:integer)
//    public static final int C_UINT8 = 10; // (xs:unsignedByte)
//    public static final int C_UINT16 = 11; // (xs:unsignedShort)
//    public static final int C_UINT32 = 12; // (xs:unsignedInt)
//    public static final int C_UINT64 = 13; // (xs:unsignedLong)
//    public static final int C_DOUBLE = 14; // (xs:float,xs:double)
//    public static final int C_IPV4 = 15; // (confd:inetAddressIPv4)
//    public static final int C_IPV6 = 16; // (confd:inetAddressIPv6)
//    public static final int C_BOOL = 17; // (xs:boolean)
//    public static final int C_QNAME = 18; // (xs:QName)
//    public static final int C_DATETIME = 19; // (xs:dateTime)
//    public static final int C_DATE = 20; // (xs:date)
//    public static final int C_GYEARMONTH = 21; // (xs:gYearMonth)
//    public static final int C_GYEAR = 22; // (xs:gYear)
//    public static final int C_TIME = 23; // (xs:time)
//    public static final int C_GDAY = 24; // (xs:gDay)
//    public static final int C_GMONTHDAY = 25; // (xs:gMonthDay)
//    public static final int C_GMONTH = 26; // (xs:gMonth)
//    public static final int C_DURATION = 27; // (xs:duration)
//    public static final int C_ENUM_HASH = 28; // (string enumerations)
//    public static final int C_BIT32 = 29; // (bitsType size 32)
//    public static final int C_BIT64 = 30; // (bitsType size 64)
//    public static final int C_LIST = 31; // (xs:list)
//
//    public static final int C_OBJECTREF = 34; // (confd:objectRef)
//    public static final int C_UNION = 35; // (xs:union)
//    public static final int C_OID = 38; // (confd:oid)
//    public static final int C_BINARY = 39; // (xs:hexBinary ...)
//    public static final int C_IPV4PREFIX = 40; // (confd:ipv4Prefix)
//    public static final int C_IPV6PREFIX = 41; // (confd:ipv6Prefix)

    /**
     * @return "SchemaNode{" + tagpath + "}", with tagpath in /foo/bar style.
     */
    @Override
    public String toString() {
        return "SchemaNode{" + tagpath + "}";
    }

    /**
     * Finds the schema class for a data element
     * 
     * @param e The data element
     * @return the schema node with same namespace and tagpath as e
     */
    public static SchemaNode get(Element e) {
        return SchemaTree.lookup(e.namespace, e.tagpath());
    }

}
