package com.example.alejandromorato.soaptest.DecorAR;

/**
 * Created by alejandro.morato on 26/01/2017.
 */

public class SoapConfig {

    public final static String SOAP_ACTION = "http://tempuri.org/";
    public final static String NAME_SPACE = "http://tempuri.org/";
    public final static String URL = "http://192.168.2.138/ServiceApp/WebServiceTest.asmx";

    public final static String METHOD_ADD = "Add";
    public final static String METHOD_ADD_PARAM_A = "a";
    public final static String METHOD_ADD_PARAM_B = "b";

    public final static String METHOD_HELLO = "HelloWorld";

    public final static String SOAP_ACTION_ADD = SOAP_ACTION + METHOD_ADD;
    public final static String SOAP_ACTION_HELLO = SOAP_ACTION + METHOD_HELLO;
}