
    /**  
    * @Title: WenServiceTestInfo.java
    * @Package webservice.service
    * @Description: TODO(��һ�仰�������ļ���ʲô)
    * @author wjk
    * @date 2018��6��24��
    * @version V1.0  
    */
    
package webservice.service;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

/**
    * @ClassName: WenServiceTestInfo
    * @Description: TODO(������һ�仰��������������)
    * @author wjk
    * @date 2018��6��24��
    *
    */

public class WenServiceTestInfo {

	/**
	 * @throws RemoteException 
	 * @throws ServiceException 
	    * @Title: main
	    * @Description: TODO(������һ�仰�����������������)
	    * @param @param args    ����
	    * @return void    ��������
	    * @throws
	    */

	public static void main(String[] args) throws ServiceException, RemoteException {
		WebServiceClientTest WebServiceClientTest = new WebServiceTestServiceLocator().getWebServiceTestPort();
		System.out.println(WebServiceClientTest.getInfo());
	}

}
