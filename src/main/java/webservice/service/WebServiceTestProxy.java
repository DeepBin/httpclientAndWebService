package webservice.service;

public class WebServiceTestProxy implements webservice.service.WebServiceClientTest {
  private String _endpoint = null;
  private webservice.service.WebServiceClientTest webServiceTest = null;
  
  public WebServiceTestProxy() {
    _initWebServiceTestProxy();
  }
  
  public WebServiceTestProxy(String endpoint) {
    _endpoint = endpoint;
    _initWebServiceTestProxy();
  }
  
  private void _initWebServiceTestProxy() {
    try {
      webServiceTest = (new webservice.service.WebServiceTestServiceLocator()).getWebServiceTestPort();
      if (webServiceTest != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)webServiceTest)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)webServiceTest)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (webServiceTest != null)
      ((javax.xml.rpc.Stub)webServiceTest)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public webservice.service.WebServiceClientTest getWebServiceTest() {
    if (webServiceTest == null)
      _initWebServiceTestProxy();
    return webServiceTest;
  }
  
  public java.lang.String getInfo() throws java.rmi.RemoteException{
    if (webServiceTest == null)
      _initWebServiceTestProxy();
    return webServiceTest.getInfo();
  }
  
  public void main(java.lang.String[] arg0) throws java.rmi.RemoteException{
    if (webServiceTest == null)
      _initWebServiceTestProxy();
    webServiceTest.main(arg0);
  }
  
  
}