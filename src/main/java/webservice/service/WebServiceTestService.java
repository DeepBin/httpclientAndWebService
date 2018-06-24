/**
 * WebServiceTestService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package webservice.service;

public interface WebServiceTestService extends javax.xml.rpc.Service {
    public java.lang.String getWebServiceTestPortAddress();

    public webservice.service.WebServiceClientTest getWebServiceTestPort() throws javax.xml.rpc.ServiceException;

    public webservice.service.WebServiceClientTest getWebServiceTestPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
