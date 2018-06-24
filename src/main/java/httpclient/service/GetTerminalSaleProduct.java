package httpclient.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import httpclient.model.ProductMessage;
import httpclient.model.StoreMessage;

public class GetTerminalSaleProduct {
	
private static final String url ="http://test.diageo.com.cn:8888/diageo-app/getTerminalSaleProduct";
	
	private static final String validCode ="c2ZhMTIz00";
	
	//0001�� ����ʱ�����Ϊ��  0003����֤�����Ϊ��  0004����֤����� 0005�����ڸ�ʽ����
	
	
	/**
	 * ��ʱ������� ������ 
	 * �õ����� ���д��� ���浽 ���ݿ� ������־
	 * �������ظ��������� 
	 * @author wangjiankai
	 * @return result
	 */
	public  void  getTerminalSaleProductDataAndInsertDB(){
		String result = restfulPostJava(getUrl(url,validCode));
		if(result != null ) {
			Map<String, String> resultMap = getModelFromJson(result);
			this.saveLog(resultMap);
		}
	}
	
	/** ������־
	 * @author wangjiankai
	 *  saveLog 
	 * @param result
	 */
	private void saveLog(Map<String, String> resultMap) {
		 String  code = resultMap.get("code").toString();
		 String  msg = resultMap.get("msg").toString();
		 String  timeBegin = resultMap.get("dateTime").toString();
		 String  timeEnd = resultMap.get("endTime").toString();
		 String  inertLogSql  = "INSERT  INTO  SPE_COSTUMER_STORE_PRODUCT_LOG VALUES(lower(REPLACE(NEWID(),'-','')),'"+new SimpleDateFormat("yyyy-MM-dd").format(new Date())+"','"+timeBegin+"','"+timeEnd+"','"+code+"','"+msg+"')";
	}

	/**
	 * post��ʽ��������
	 * @param url �����������ַ
	 * @return JSONObject ���
	 * @author wangjiankai
	 */
	public String  restfulPostJava(String  url){
		HttpClient client = new  HttpClient();
		PostMethod postMethod = new PostMethod(url);
		String obj = null;
		try {
			int response = client.executeMethod(postMethod);
			System.out.println("code:"+response);
			if(200 == response){ //�ɹ�
				String  res = postMethod.getResponseBodyAsString();
				obj = res;
			}
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			postMethod.releaseConnection();
			client.getHttpConnectionManager().closeIdleConnections(0);
		}
		return obj;
	}
	
	/**
	 * �õ������������ַ
	 * @param url ����ĵ�ַ
	 * @param validCode ��֤��
	 * @return �����������ַ
	 * @author wangjiankai
	 */
	public String getUrl(String url,String validCode){
		StringBuffer sb = new StringBuffer(url);
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		format.format(new Date());
		return  sb.append("/").append(format.format(new Date())).append("/").append(validCode).toString();
	}
	
	/**
	 * �����ص����� ���б��浽���ݿ�
	 * @param json 
	 * @return List
	 * @author wangjiankai
	 */
	public  Map<String, String>  getModelFromJson(String result){
		JSONObject jsStr = JSONObject.parseObject(result);
		String code = jsStr.get("code").toString(); // 0 �ɹ�  0001�� ����ʱ�����Ϊ��  0003����֤�����Ϊ��  0004����֤����� 0005�����ڸ�ʽ����
		String msg  = jsStr.getString("msg");
		String  data = jsStr.getString("data").toString();
		Map<String, String>  resultMap  = new  HashMap<String, String>();
		resultMap.put("code", code);
		resultMap.put("msg", msg);
	    resultMap.put("dateTime", new  SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
		if(code.equals("0") && data!= null && data.length()>0){//�������� ���н���
			JSONArray jsonArray =jsStr.getJSONArray("data");//�õ�����
			for(int i=0;i<jsonArray.size();i++){
				JSONObject job = jsonArray.getJSONObject(i); // ���� jsonarray ����
				StoreMessage storeMessage = JSONObject.parseObject(JSONObject.toJSONString(job), new TypeReference<StoreMessage>() {});
				String uuid = UUID.randomUUID().toString().replace("-", "");
				StringBuffer inertStoreSql =  new  StringBuffer("INSERT INTO SPE_COSTUMER_STORE_MESSAGE values(");
				inertStoreSql.append("'"+uuid+"',");
				inertStoreSql.append("'"+storeMessage.getCode()+"',");
				inertStoreSql.append("'"+storeMessage.getSign()+"',");
				inertStoreSql.append("'"+storeMessage.getName()+"',");
				inertStoreSql.append(storeMessage.getType());
				inertStoreSql.append(",'"+new SimpleDateFormat("yyyy-MM-dd").format(new Date())+"',");
				inertStoreSql.append("'"+new SimpleDateFormat("yyyy-MM-dd").format(new Date())+"'");
				inertStoreSql.append(")");
				for(ProductMessage productMessage:storeMessage.getProductList()){
						 StringBuffer insertProductSql = new StringBuffer("INSERT INTO SPE_COSTUMER_PRODUCT_MESSAGE values(");
						 insertProductSql.append("'"+UUID.randomUUID().toString().replace("-","")+"',");
						 insertProductSql.append("'"+uuid+"',");
						 insertProductSql.append("'"+productMessage.getProductId()+"',");
						 insertProductSql.append("'"+productMessage.getProductName()+"',");
						 insertProductSql.append("'"+productMessage.getSourceNumber()+"',");
						 insertProductSql.append(productMessage.getNumber());
						 insertProductSql.append(")");
				}
				
			}
		}
		resultMap.put("endTime", new  SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
		return  resultMap;
	}
}
