package fh_muenster.webservices;

//----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 4.5.6.0
//
// Created by Quasar Development at 13/06/2016
//
//---------------------------------------------------



import org.ksoap2.serialization.*;
import java.util.Vector;
import java.util.Hashtable;

/**
 * @author easywsdl.com
 */
public class AQLmusikWuenscheAusgebenResponse extends Vector< String> implements KvmSerializable
{
    
    public AQLmusikWuenscheAusgebenResponse(){}

    /**
     *
     * @param inObj
     * @param __envelope
     */
    public AQLmusikWuenscheAusgebenResponse(Object inObj,AQLExtendedSoapSerializationEnvelope __envelope)
    {
        if (inObj == null)
            return;
        SoapObject soapObject=(SoapObject)inObj;
        int size = soapObject.getPropertyCount();
        for (int i0=0;i0< size;i0++)
        {
            Object obj = soapObject.getProperty(i0);
            if (obj!=null && obj instanceof AttributeContainer)
            {
                AttributeContainer j =(AttributeContainer) soapObject.getProperty(i0);
                String j1= j.toString();
                add(j1);
            }
        }
}

    /**
     *
     * @param arg0
     * @return
     */
    @Override
    public Object getProperty(int arg0) {
        return this.get(arg0)!=null?this.get(arg0):SoapPrimitive.NullNilElement;
    }

    /**
     *
     * @return
     */
    @Override
    public int getPropertyCount() {
        return this.size();
    }

    /**
     *
     * @param index
     * @param arg1
     * @param info
     */
    @Override
    public void getPropertyInfo(int index, @SuppressWarnings("rawtypes") Hashtable arg1, PropertyInfo info) {
        info.name = "return";
        info.type = PropertyInfo.STRING_CLASS;
    	info.namespace= "";
    }

    /**
     *
     * @param arg0
     * @param arg1
     */
    @Override
    public void setProperty(int arg0, Object arg1) {
    }

}