
    /**  
    * @Title: WebServiceTest.java
    * @Package webservice.service
    * @Description: TODO(用一句话描述该文件做什么)
    * @author wjk
    * @date 2018年6月24日
    * @version V1.0  
    */
    
package webservice.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
    * @ClassName: WebServiceTest
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author wjk
    * @date 2018年6月24日
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
	    * @Description: TODO(这里用一句话描述这个方法的作用)
	    * @param @param args    参数
	    * @return void    返回类型
	    * @throws
	    */

	public static void main(String[] args) {
		Endpoint.publish("http://192.168.199.178:8081/httpclient/service/WebService", new WebServiceTest());
		System.out.println("webservice 发布成功");
	}

}
