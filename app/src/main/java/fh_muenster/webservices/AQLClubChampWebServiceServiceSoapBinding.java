package fh_muenster.webservices;

//----------------------------------------------------
//
// Generated by www.easywsdl.com
// Version: 4.5.6.0
//
// Created by Quasar Development at 13/06/2016
//
//---------------------------------------------------




import org.ksoap2.HeaderProperty;
import org.ksoap2.serialization.*;
import org.ksoap2.transport.*;
import org.kxml2.kdom.Element;


import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AQLClubChampWebServiceServiceSoapBinding
{
    interface AQLIWcfMethod
    {
        AQLExtendedSoapSerializationEnvelope CreateSoapEnvelope() throws Exception;

        Object ProcessResult(AQLExtendedSoapSerializationEnvelope __envelope, Object result) throws Exception;
    }

    String url="http://10.60.64.40:8080/ClubChamp-System-ejb-0.0.1/ClubChampWebService";

    int timeOut=60000;
    public List< HeaderProperty> httpHeaders;
    public boolean enableLogging;

    AQLIServiceEvents callback;
    public AQLClubChampWebServiceServiceSoapBinding(){}

    public AQLClubChampWebServiceServiceSoapBinding (AQLIServiceEvents callback)
    {
        this.callback = callback;
    }
    public AQLClubChampWebServiceServiceSoapBinding(AQLIServiceEvents callback,String url)
    {
        this.callback = callback;
        this.url = url;
    }

    public AQLClubChampWebServiceServiceSoapBinding(AQLIServiceEvents callback,String url,int timeOut)
    {
        this.callback = callback;
        this.url = url;
        this.timeOut=timeOut;
    }

    protected org.ksoap2.transport.Transport createTransport()
    {
        try
        {
            java.net.URI uri = new java.net.URI(url);
            if(uri.getScheme().equalsIgnoreCase("https"))
            {
                int port=uri.getPort()>0?uri.getPort():443;
                return new HttpsTransportSE(uri.getHost(), port, uri.getPath(), timeOut);
            }
            else
            {
                return new HttpTransportSE(url,timeOut);
            }

        }
        catch (java.net.URISyntaxException e)
        {
        }
        return null;
    }
    
    protected AQLExtendedSoapSerializationEnvelope createEnvelope()
    {
        AQLExtendedSoapSerializationEnvelope envelope= new AQLExtendedSoapSerializationEnvelope(AQLExtendedSoapSerializationEnvelope.VER11);
        return envelope;
    }
    
    protected java.util.List sendRequest(String methodName,AQLExtendedSoapSerializationEnvelope envelope,org.ksoap2.transport.Transport transport  )throws Exception
    {
        return transport.call(methodName, envelope, httpHeaders);
    }

    Object getResult(Class destObj,Object source,String resultName,AQLExtendedSoapSerializationEnvelope __envelope) throws Exception
    {
        if(source==null)
        {
            return null;
        }
        if(source instanceof SoapPrimitive)
        {
            SoapPrimitive soap =(SoapPrimitive)source;
            if(soap.getName().equals(resultName))
            {
                Object instance=__envelope.get(source,destObj);
                return instance;
            }
        }
        else
        {
            SoapObject soap = (SoapObject)source;
            if (soap.hasProperty(resultName))
            {
                Object j=soap.getProperty(resultName);
                if(j==null)
                {
                    return null;
                }
                Object instance=__envelope.get(j,destObj);
                return instance;
            }
            else if( soap.getName().equals(resultName)) {
                Object instance=__envelope.get(source,destObj);
                return instance;
            }
       }

       return null;
    }

        
    public AQLmusikWuenscheAusgebenResponse musikWuenscheAusgeben( ) throws Exception
    {
        return (AQLmusikWuenscheAusgebenResponse)execute(new AQLIWcfMethod()
        {
            @Override
            public AQLExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              AQLExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("http://clubchamp.gruppe10/", "musikWuenscheAusgeben");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                return __envelope;
            }
            
            @Override
            public Object ProcessResult(AQLExtendedSoapSerializationEnvelope __envelope,Object __result)throws Exception {
                return (AQLmusikWuenscheAusgebenResponse)getResult(AQLmusikWuenscheAusgebenResponse.class,__result,"musikWuenscheAusgebenResponse",__envelope);
            }
        },"");
    }
    
    public android.os.AsyncTask< Void, Void, AQLOperationResult< AQLmusikWuenscheAusgebenResponse>> musikWuenscheAusgebenAsync()
    {
        return executeAsync(new AQLFunctions.IFunc< AQLmusikWuenscheAusgebenResponse>() {
            public AQLmusikWuenscheAusgebenResponse Func() throws Exception {
                return musikWuenscheAusgeben( );
            }
        });
    }
    
    public Boolean musikWurdeGespielt(final String arg0,final String arg1,final String arg2 ) throws Exception
    {
        return (Boolean)execute(new AQLIWcfMethod()
        {
            @Override
            public AQLExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              AQLExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("http://clubchamp.gruppe10/", "musikWurdeGespielt");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg0";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg0!=null?arg0:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg1";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg1!=null?arg1:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg2";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg2!=null?arg2:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public Object ProcessResult(AQLExtendedSoapSerializationEnvelope __envelope,Object __result)throws Exception {
                SoapObject __soap=(SoapObject)__result;
                Object obj = __soap.getProperty("return");
                if (obj != null && obj.getClass().equals(SoapPrimitive.class))
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    return new Boolean(j.toString());
                }
                else if (obj!= null && obj instanceof Boolean){
                    return (Boolean)obj;
                }
                return null;
            }
        },"");
    }
    
    public android.os.AsyncTask< Void, Void, AQLOperationResult< Boolean>> musikWurdeGespieltAsync(final String arg0,final String arg1,final String arg2)
    {
        return executeAsync(new AQLFunctions.IFunc< Boolean>() {
            public Boolean Func() throws Exception {
                return musikWurdeGespielt( arg0,arg1,arg2);
            }
        });
    }
    
    public Boolean signUp(final String arg0,final String arg1,final String arg2 ) throws Exception
    {
        return (Boolean)execute(new AQLIWcfMethod()
        {
            @Override
            public AQLExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              AQLExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("http://clubchamp.gruppe10/", "signUp");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg0";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg0!=null?arg0:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg1";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg1!=null?arg1:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg2";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg2!=null?arg2:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public Object ProcessResult(AQLExtendedSoapSerializationEnvelope __envelope,Object __result)throws Exception {
                SoapObject __soap=(SoapObject)__result;
                Object obj = __soap.getProperty("return");
                if (obj != null && obj.getClass().equals(SoapPrimitive.class))
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    return new Boolean(j.toString());
                }
                else if (obj!= null && obj instanceof Boolean){
                    return (Boolean)obj;
                }
                return null;
            }
        },"");
    }
    
    public android.os.AsyncTask< Void, Void, AQLOperationResult< Boolean>> signUpAsync(final String arg0,final String arg1,final String arg2)
    {
        return executeAsync(new AQLFunctions.IFunc< Boolean>() {
            public Boolean Func() throws Exception {
                return signUp( arg0,arg1,arg2);
            }
        });
    }
    
    public String login(final String arg0,final String arg1 ) throws Exception
    {
        return (String)execute(new AQLIWcfMethod()
        {
            @Override
            public AQLExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              AQLExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("http://clubchamp.gruppe10/", "login");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg0";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg0!=null?arg0:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg1";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg1!=null?arg1:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public Object ProcessResult(AQLExtendedSoapSerializationEnvelope __envelope,Object __result)throws Exception {
                SoapObject __soap=(SoapObject)__result;
                Object obj = __soap.getProperty("return");
                if (obj != null && obj.getClass().equals(SoapPrimitive.class))
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    return j.toString();
                }
                else if (obj!= null && obj instanceof String){
                    return (String)obj;
                }
                return null;
            }
        },"");
    }
    
    public android.os.AsyncTask< Void, Void, AQLOperationResult< String>> loginAsync(final String arg0,final String arg1)
    {
        return executeAsync(new AQLFunctions.IFunc< String>() {
            public String Func() throws Exception {
                return login( arg0,arg1);
            }
        });
    }
    
    public String musikWuenschen(final String arg0,final String arg1,final String arg2 ) throws Exception
    {
        return (String)execute(new AQLIWcfMethod()
        {
            @Override
            public AQLExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              AQLExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("http://clubchamp.gruppe10/", "musikWuenschen");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg0";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg0!=null?arg0:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg1";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg1!=null?arg1:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg2";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg2!=null?arg2:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                return __envelope;
            }
            
            @Override
            public Object ProcessResult(AQLExtendedSoapSerializationEnvelope __envelope,Object __result)throws Exception {
                SoapObject __soap=(SoapObject)__result;
                Object obj = __soap.getProperty("return");
                if (obj != null && obj.getClass().equals(SoapPrimitive.class))
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    return j.toString();
                }
                else if (obj!= null && obj instanceof String){
                    return (String)obj;
                }
                return null;
            }
        },"");
    }
    
    public android.os.AsyncTask< Void, Void, AQLOperationResult< String>> musikWuenschenAsync(final String arg0,final String arg1,final String arg2)
    {
        return executeAsync(new AQLFunctions.IFunc< String>() {
            public String Func() throws Exception {
                return musikWuenschen( arg0,arg1,arg2);
            }
        });
    }


    public String toStr( ) throws Exception
    {
        return (String)execute(new AQLIWcfMethod()
        {
            @Override
            public AQLExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
              AQLExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("http://clubchamp.gruppe10/", "toString");
                __envelope.setOutputSoapObject(__soapReq);
                
                PropertyInfo __info=null;
                return __envelope;
            }
            
            @Override
            public Object ProcessResult(AQLExtendedSoapSerializationEnvelope __envelope,Object __result)throws Exception {
                SoapObject __soap=(SoapObject)__result;
                Object obj = __soap.getProperty("return");
                if (obj != null && obj.getClass().equals(SoapPrimitive.class))
                {
                    SoapPrimitive j =(SoapPrimitive) obj;
                    return j.toString();
                }
                else if (obj!= null && obj instanceof String){
                    return (String)obj;
                }
                return null;
            }
        },"");
    }

    public android.os.AsyncTask< Void, Void, AQLOperationResult< String>> toStringAsync()
    {
        return executeAsync(new AQLFunctions.IFunc< String>() {
            public String Func() throws Exception {
                return toStr( );
            }
        });
    }
    
    public String feedbackGeben(final String arg0,final String arg1,final String arg2,final String arg3 ) throws Exception
    {
/*This feature is available in Premium account, Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account*/
        return null;    
    }
    
    public android.os.AsyncTask< Void, Void, AQLOperationResult< String>> feedbackGebenAsync(final String arg0,final String arg1,final String arg2,final String arg3)
    {
        return executeAsync(new AQLFunctions.IFunc< String>() {
            public String Func() throws Exception {
                return feedbackGeben( arg0,arg1,arg2,arg3);
            }
        });
    }

    public void clubBewerten(final String arg0,final Integer arg1 ) throws java.lang.Exception
    {
        execute(new AQLIWcfMethod()
        {
            @Override
            public AQLExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
                AQLExtendedSoapSerializationEnvelope __envelope = createEnvelope();
                SoapObject __soapReq = new SoapObject("http://clubchamp.gruppe10/", "clubBewerten");
                __envelope.setOutputSoapObject(__soapReq);

                PropertyInfo __info=null;
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg0";
                __info.type=PropertyInfo.STRING_CLASS;
                __info.setValue(arg0!=null?arg0:SoapPrimitive.NullSkip);
                __soapReq.addProperty(__info);
                __info = new PropertyInfo();
                __info.namespace="";
                __info.name="arg1";
                __info.type=PropertyInfo.INTEGER_CLASS;
                __info.setValue(arg1);
                __soapReq.addProperty(__info);
                return __envelope;
            }

            @Override
            public java.lang.Object ProcessResult(AQLExtendedSoapSerializationEnvelope __envelope,java.lang.Object __result)throws java.lang.Exception {
                return null;
            }
        },"");
    }

    public android.os.AsyncTask< Void, Void, AQLOperationResult< Void>> clubBewertenAsync(final String arg0,final Integer arg1)
    {
        return executeAsync(new AQLFunctions.IFunc< Void>()
        {
            @Override
            public Void Func() throws java.lang.Exception {
                clubBewerten( arg0,arg1);
                return null;
            }
        }) ;
    }
    
    public String logout(final String arg0 ) throws Exception
    {   return (String)execute(new AQLIWcfMethod()
    {
        @Override
        public AQLExtendedSoapSerializationEnvelope CreateSoapEnvelope(){
            AQLExtendedSoapSerializationEnvelope __envelope = createEnvelope();
            SoapObject __soapReq = new SoapObject("http://clubchamp.gruppe10/", "logout");
            __envelope.setOutputSoapObject(__soapReq);

            PropertyInfo __info=null;
            __info = new PropertyInfo();
            __info.namespace="";
            __info.name="arg0";
            __info.type=PropertyInfo.STRING_CLASS;
            __info.setValue(arg0!=null?arg0:SoapPrimitive.NullSkip);
            __soapReq.addProperty(__info);
            return __envelope;
        }

        @Override
        public Object ProcessResult(AQLExtendedSoapSerializationEnvelope __envelope,Object __result)throws Exception {
            SoapObject __soap=(SoapObject)__result;
            Object obj = __soap.getProperty("return");
            if (obj != null && obj.getClass().equals(SoapPrimitive.class))
            {
                SoapPrimitive j =(SoapPrimitive) obj;
                return j.toString();
            }
            else if (obj!= null && obj instanceof String){
                return (String)obj;
            }
            return null;
        }
    },"");
    }
    
    public android.os.AsyncTask< Void, Void, AQLOperationResult< String>> logoutAsync(final String arg0)
    {
        return executeAsync(new AQLFunctions.IFunc< String>() {
            public String Func() throws Exception {
                return logout( arg0);
            }
        });
    }
    
    public String musikLiken(final String arg0,final String arg1,final String arg2 ) throws Exception
    {
/*This feature is available in Premium account, Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account*/
        return null;    
    }
    
    public android.os.AsyncTask< Void, Void, AQLOperationResult< String>> musikLikenAsync(final String arg0,final String arg1,final String arg2)
    {
        return executeAsync(new AQLFunctions.IFunc< String>() {
            public String Func() throws Exception {
                return musikLiken( arg0,arg1,arg2);
            }
        });
    }
    
    public String clearMusicWunschliste(final String arg0 ) throws Exception
    {
/*This feature is available in Premium account, Check http://EasyWsdl.com/Payment/PremiumAccountDetails to see all benefits of Premium account*/
        return null;    
    }
    
    public android.os.AsyncTask< Void, Void, AQLOperationResult< String>> clearMusicWunschlisteAsync(final String arg0)
    {
        return executeAsync(new AQLFunctions.IFunc< String>() {
            public String Func() throws Exception {
                return clearMusicWunschliste( arg0);
            }
        });
    }

    
    protected Object execute(AQLIWcfMethod wcfMethod,String methodName) throws Exception
    {
        org.ksoap2.transport.Transport __httpTransport=createTransport();
        __httpTransport.debug=enableLogging;
        AQLExtendedSoapSerializationEnvelope __envelope=wcfMethod.CreateSoapEnvelope();
        try
        {
            sendRequest(methodName, __envelope, __httpTransport);
            
        }
        finally {
            if (__httpTransport.debug) {
                if (__httpTransport.requestDump != null) {
                    android.util.Log.i("requestDump",__httpTransport.requestDump);    
                    
                }
                if (__httpTransport.responseDump != null) {
                    android.util.Log.i("responseDump",__httpTransport.responseDump);
                }
            }
        }
        Object __retObj = __envelope.bodyIn;
        if (__retObj instanceof org.ksoap2.SoapFault){
            org.ksoap2.SoapFault __fault = (org.ksoap2.SoapFault)__retObj;
            throw convertToException(__fault,__envelope);
        }else{
            return wcfMethod.ProcessResult(__envelope,__retObj);
        }
    }
    
    protected < T> android.os.AsyncTask< Void, Void, AQLOperationResult< T>>  executeAsync(final AQLFunctions.IFunc< T> func)
    {
        return new android.os.AsyncTask< Void, Void, AQLOperationResult< T>>()
        {
            @Override
            protected void onPreExecute() {
                callback.Starting();
            };
            @Override
            protected AQLOperationResult< T> doInBackground(Void... params) {
                AQLOperationResult< T> result = new AQLOperationResult< T>();
                try
                {
                    result.Result= func.Func();
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                    result.Exception=ex;
                }
                return result;
            }
            
            @Override
            protected void onPostExecute(AQLOperationResult< T> result)
            {
                callback.Completed(result);
            }
        }.execute();
    }
        
    Exception convertToException(org.ksoap2.SoapFault fault,AQLExtendedSoapSerializationEnvelope envelope)
    {

        if(fault.detail!=null && fault.detail.getChildCount()>0)
        {
            Element detailsNode=(Element)fault.detail.getChild(0);
            try
            {
                SoapObject exceptionObject = null;
                exceptionObject=envelope.GetExceptionDetail(detailsNode,"http://clubchamp.gruppe10/","SignUpFailedException");
                if (exceptionObject != null)
                {
                    return new AQLSignUpFailedException(exceptionObject,envelope);
                }
                exceptionObject=envelope.GetExceptionDetail(detailsNode,"http://clubchamp.gruppe10/","LoginFailedException");
                if (exceptionObject != null)
                {
                    return new AQLLoginFailedException(exceptionObject,envelope);
                }
                exceptionObject=envelope.GetExceptionDetail(detailsNode,"http://clubchamp.gruppe10/","NoSessionException");
                if (exceptionObject != null)
                {
                    return new AQLNoSessionException(exceptionObject,envelope);
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return new Exception(fault.faultstring);
    }
}


