
    /**  
    * @Title: WebServiceTest.java
    * @Package webservice.service
    * @Description: TODO(��һ�仰�������ļ���ʲô)
    * @author wjk
    * @date 2018��6��24��
    * @version V1.0  
    */
    
package webservice.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
    * @ClassName: WebServiceTest
    * @Description: TODO(������һ�仰��������������)
    * @author wjk
    * @date 2018��6��24��
    *
    */
@WebService
public class WebServiceTest {
	@WebMethod
	public String getInfo() {
		return  "hello webservice!";
	}

	/**
	    * @Title: main
	    * @Description: TODO(������һ�仰�����������������)
	    * @param @param args    ����
	    * @return void    ��������
	    * @throws
	    */

	public static void main(String[] args) {
		Endpoint.publish("http://192.168.199.178:8081/httpclient/service/WebService", new WebServiceTest());
		System.out.println("webservice �����ɹ�");
	}

}
