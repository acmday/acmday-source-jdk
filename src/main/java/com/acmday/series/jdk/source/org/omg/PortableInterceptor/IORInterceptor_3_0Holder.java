package org.omg.PortableInterceptor;

/**
* org/omg/PortableInterceptor/IORInterceptor_3_0Holder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /HUDSON/workspace/8-2-build-linux-amd64/jdk8u211/12973/corba/src/share/classes/org/omg/PortableInterceptor/Interceptors.idl
* Monday, April 1, 2019 8:39:46 PM PDT
*/

public final class IORInterceptor_3_0Holder implements org.omg.CORBA.portable.Streamable
{
  public org.omg.PortableInterceptor.IORInterceptor_3_0 value = null;

  public IORInterceptor_3_0Holder ()
  {
  }

  public IORInterceptor_3_0Holder (org.omg.PortableInterceptor.IORInterceptor_3_0 initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = org.omg.PortableInterceptor.IORInterceptor_3_0Helper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    org.omg.PortableInterceptor.IORInterceptor_3_0Helper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return org.omg.PortableInterceptor.IORInterceptor_3_0Helper.type ();
  }

}