package org.gzhz.otherManage.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = 
			"2016091600521994";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCQxUckMJ7fWni63j8W4fZvQrs0gBEvV0hdgMrpJfLJ+f9PPBWMe28cD/JzqnVp9FebbfyYKrpSkkP/osLG/a9wJg4p53hQbfYZLyXXgq4IN/vnAKjg9G34wh81hhOVj8txe+Lu4U3srrJ9tMRVUipCSpl7axZO8+oy3zpw2OYu8NJscqWvWZ5gKCDwh5c1ma2SVLipHoMT4psq80+MB6te/qb/aj51/LtnvIL/crTP6Ahm6NA741KVahUZAZHGPQ6HCtMj8RavP0M94ETfg8iUfemtIlRRF/Sa+oE1LVNRwiPzXjIJncLSbj5w5H15GSwAHFkTk9P45vptVi9kaXQhAgMBAAECggEATTcbsb7JDiJIIItnpQHSmhdCmEbyY4ivTUfjciVOcNIJja5jY/F2Gsaar3yscV3k2D76qgKoLGBdKl0afF5Uk4GIrmsKLgPobhhKm77UqgeKMPSWHp3ghfyr/rVLfssaXKYSLQ04rdOj2g5vZX6UkZUOddhxJp1MPeP4XLYjV8dHZduVKXD/AJWFNY1Bkqd/uGvCdA17RZhdqN1T0JgiYisEMf4MR2DXv0PP8DEQy5xBjedBkt+WwhjAJ82P3jQXukd7JPJ/cNeSd7ZbTRc2HGPNdNC1NHOEPqC4XsftrbsAr3Px+bXiGiWQ5XdhkrU6QndF3h/3VpD9SEeSv7HgAQKBgQDCP/s9OBoZ1c1cK2Y2iDp8tZ5MHHx4pgu6cfRZ0VLgip3TmtHlw3GakU/QtEaqNrl/+WDz0ECfS7GqBLQGexBSZ5r+5sLujP4uNhvI3IWZodeTY4C/xCZiwApY3xPdsSRKBAo66LNaAayfRSmzsxlxkyiMyn5RQvXJKv2//HfNAQKBgQC+yq42EF0UjKo/OMhqbP0YLo8Lnxx0O+i1jDgLDJfIhTphiALAJEAYlT8zPBXOhj/nTiSIkghTpImy01f/WMSQIkjC5pDEf+q9onAlApnaweshNU6Dw3LbdvZnmiRLkeQXAt7OES2VdATLYF7RHHMKRzWbOJl+tUQXK4/+GV0HIQKBgFFlihu/FIDa7HDA5tXXA9saJ7jw/t93hNadxayVYEsjCruO1oGXAlWoqm9j+3B7+gM8Nno0O8AEcfAyhFVq4A4HyBUkEW7wudoXZlEmxvz3qmPigCLbSNJ8clmHMMXm4rP5OWgx9mWy6ejbjHv2gqTq60UD3SakDmY7k5UNcA4BAoGAcs2stFV2XOYjjzVQy1FXnhRt+LU+PubJqWx9UJC8SGl6brOTzCBD/UbZJ7AxAvufOkS4EQGmRwZL4THw0nKMnJo0pCpu0/6Qtpkm1+5Pu+VR4cKcwwZ5d3uG22JSErLvx7Tvcpm9jx+nvuT3SObQhk/A/uy42BikpziMRX7njmECgYAm4F5r6tTrJeegDrbvpj1rnXMDzG8AaD/sCBuEll1gbLtGAJLH4wXK5CDEO0F7G18J5kOqIzecWLoV/wOV1uamEbnJMIsiO+JqqcVh52+v32BMcbUWOCcQF5C6RBJOpvPfYkhdGYmJl3BXt4AY1BTxoZhFv++a7sDaFHzmyPSjXw==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAwbFbCKhsHX1hqZ5yzhz+7gjN72/oF3JYmfMYd6VjMe3dMlMYVIEsWvZQRjfMJcArDCUPcMC9uwUveYXYkwbOu0JqHzQsqnLtU/mkE1BE37EZ0ctWToVS24IjUZi7yJIrxx7NuNFf7FmZa7X0F8CritIfIH2yJhOlhI4U5qEAg64E6/Gq6EgGwicCuFBJpmFR8BaVoX8ho4omJ9jPAzKbs7015NwvV/FJrjz2G7YKKImnUdXgGyXSkHtrAPuKM7bcOio41IdfS7TCGq/qOf0Qisr+0amZEHEbBTLvX/cR5WVydd3TwooirwammrNpwWXjZZZWWNkI0Oq5TjJmjdhFrwIDAQAB";
    		// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:9090/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:9090/CarParkSystem/zlbjsp1/success.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
    	
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

