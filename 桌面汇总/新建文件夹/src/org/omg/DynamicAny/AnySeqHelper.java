package org.omg.DynamicAny;


/**
* org/omg/DynamicAny/AnySeqHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from c:/re/workspace/8-2-build-windows-i586-cygwin/jdk8u161/10277/corba/src/share/classes/org/omg/DynamicAny/DynamicAny.idl
* Tuesday, December 19, 2017 5:10:17 PM PST
*/

abstract public class AnySeqHelper
{
  private static String  _id = "IDL:omg.org/DynamicAny/AnySeq:1.0";

  public static void insert (org.omg.CORBA.Any a, org.omg.CORBA.Any[] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static org.omg.CORBA.Any[] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_any);
      __typeCode = org.omg.CORBA.ORB.init ().create_sequence_tc (0, __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (org.omg.DynamicAny.AnySeqHelper.id (), "AnySeq", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static org.omg.CORBA.Any[] read (org.omg.CORBA.portable.InputStream istream)
  {
    org.omg.CORBA.Any value[] = null;
    int _len0 = istream.read_long ();
    value = new org.omg.CORBA.Any[_len0];
    for (int _o1 = 0;_o1 < value.length; ++_o1)
      value[_o1] = istream.read_any ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, org.omg.CORBA.Any[] value)
  {
    ostream.write_long (value.length);
    for (int _i0 = 0;_i0 < value.length; ++_i0)
      ostream.write_any (value[_i0]);
  }

}
