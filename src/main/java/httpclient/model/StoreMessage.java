
    /**  
    * @Title: StoreMessage.java
    * @Package httpclient.model
    * @Description: TODO(用一句话描述该文件做什么)
    * @author wjk
    * @date 2018年6月24日
    * @version V1.0  
    */
    
package httpclient.model;

import java.util.ArrayList;
import java.util.List;

/**
    * @ClassName: StoreMessage
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author wjk
    * @date 2018年6月24日
    *
    */

public class StoreMessage {
	private String code;
	
	private Integer type;
	
	private String name;
	
	
	private List<ProductMessage> productList = new ArrayList<ProductMessage>();
	/**
	* @return code
	*/
	
	public String getCode() {
		return code;
	}

	
	
	/**
	* @return productList
	*/
	
	public List<ProductMessage> getProductList() {
		return productList;
	}


	
	/**
	 * @param paramtheparamthe{bare_field_name} to set
	 */
	
	public void setProductList(List<ProductMessage> productList) {
		this.productList = productList;
	}


	/**
	 * @param paramtheparamthe{bare_field_name} to set
	 */
	
	public void setCode(String code) {
		this.code = code;
	}

	
	/**
	* @return type
	*/
	
	public Integer getType() {
		return type;
	}

	
	/**
	 * @param paramtheparamthe{bare_field_name} to set
	 */
	
	public void setType(Integer type) {
		this.type = type;
	}

	
	/**
	* @return name
	*/
	
	public String getName() {
		return name;
	}

	
	/**
	 * @param paramtheparamthe{bare_field_name} to set
	 */
	
	public void setName(String name) {
		this.name = name;
	}

	
	/**
	* @return sign
	*/
	
	public String getSign() {
		return sign;
	}

	
	/**
	 * @param paramtheparamthe{bare_field_name} to set
	 */
	
	public void setSign(String sign) {
		this.sign = sign;
	}

	private String sign;
		
		 

}
