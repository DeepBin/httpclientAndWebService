
    /**  
    * @Title: WenServiceTestInfo.java
    * @Package webservice.service
    * @Description: TODO(用一句话描述该文件做什么)
    * @author wjk
    * @date 2018年6月24日
    * @version V1.0  
    */
    
package webservice.service;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

/**
    * @ClassName: WenServiceTestInfo
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author wjk
    * @date 2018年6月24日
    *
    */

public class WenServiceTestInfo {

	/**
	 * @throws RemoteException 
	 * @throws ServiceException 
	    * @Title: main
	    * @Description: TODO(这里用一句话描述这个方法的作用)
	    * @param @param args    参数
	    * @return void    返回类型
	    * @throws
	    */

	public static void main(String[] args) throws ServiceException, RemoteException {
		WebServiceClientTest WebServiceClientTest = new WebServiceTestServiceLocator().getWebServiceTestPort();
		System.out.println(WebServiceClientTest.getInfo());
	}

}
