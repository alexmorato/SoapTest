package com.example.alejandromorato.soaptest.DecorAR;

public class SoapConfig {

    public final static String SOAP_ACTION = "http://tempuri2.org/";
    public final static String NAME_SPACE = "http://tempuri2.org/";
    public final static String URL = "http://192.168.2.138/DecorAR/DecorARWebService.asmx";

    public final static String METHOD_ADD = "Add";
    public final static String METHOD_ADD_PARAM_A = "a";
    public final static String METHOD_ADD_PARAM_B = "b";

    public final static String METHOD_GET_USER_SIMPLE = "GetUserSimple";

    public final static String METHOD_GET_IMAGE = "GetImageData";

    public final static String SOAP_ACTION_ADD = SOAP_ACTION + METHOD_ADD;
    public final static String SOAP_ACTION_GET_USER_SIMPLE = SOAP_ACTION + METHOD_GET_USER_SIMPLE;
    public final static String SOAP_ACTION_GET_IMAGE = SOAP_ACTION + METHOD_GET_IMAGE;
}