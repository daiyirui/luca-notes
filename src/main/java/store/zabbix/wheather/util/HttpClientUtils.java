package store.zabbix.wheather.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * HttpClient4.3工具类
 */
@Slf4j
public class HttpClientUtils {

    private static final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36";
    private static final int DEFAULT_TIMEOUT = 3000;
    private static final String ENCODE_CHARSET = "UTF-8";
    private static RequestConfig requestConfig;

    public static void main(String[] args) throws IOException {
        System.out.println("result:" + doGet("https://www.apiopen.top/weatherApi?city=静安区"));
    }


    static {
        // 设置请求和传输超时时间
        requestConfig = RequestConfig.custom().setSocketTimeout(DEFAULT_TIMEOUT).setConnectTimeout(DEFAULT_TIMEOUT).build();
    }


    /**
     * @param url
     * @param obj 1. json字符串   2. map  3.JSONObject
     * @return JSONObject
     */
    public static JSONObject httpPost(String url, Object obj) {
        // post请求返回结果
        CloseableHttpClient httpClient = HttpClients.createDefault();
        JSONObject jsonResult = null;
        HttpPost httpPost = new HttpPost(url);
        // 设置请求和传输超时时间
        httpPost.setConfig(requestConfig);
        try {
            if (null != obj) {
                StringEntity entity = null;
                if (obj instanceof String) {
                    entity = new StringEntity(obj.toString(), ENCODE_CHARSET);
                } else {
                    entity = new StringEntity(JSON.toJSONString(obj), ENCODE_CHARSET);
                }
                entity.setContentEncoding(ENCODE_CHARSET);
                entity.setContentType("application/json");
                httpPost.setEntity(entity);
            }
            log.debug(" {} - {} ", url, obj);
            CloseableHttpResponse response = httpClient.execute(httpPost);

            return convertResponse(response);
        } catch (Exception e) {
            log.error("error HttpClientUtils {} - {} - {}" + url, obj, e);
        } finally {
            httpPost.releaseConnection();
        }
        return jsonResult;
    }


    /**
     * post请求传输String参数 例如：name=Jack&sex=1&type=2
     * Content-type:application/x-www-form-urlencoded
     *
     * @param url url地址
     * @param
     * @return
     */
    public static JSONObject httpPostForm(String url, Map<String, String> params) {
        // post请求返回结果
        CloseableHttpClient httpClient = HttpClients.createDefault();
        JSONObject jsonResult = null;
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        try {
            if (null != params) {
                //组织请求参数
                List<NameValuePair> paramList = new ArrayList<>();
                if (params.size() > 0) {
                    Set<String> keySet = params.keySet();
                    for (String key : keySet) {
                        paramList.add(new BasicNameValuePair(key, params.get(key)));
                    }
                }

                httpPost.setEntity(new UrlEncodedFormEntity(paramList, ENCODE_CHARSET));
            }
            CloseableHttpResponse response = httpClient.execute(httpPost);
            return convertResponse(response);
        } catch (IOException e) {
            log.error("post请求提交失败:" + url, e);
        } finally {
            httpPost.releaseConnection();
        }
        return jsonResult;
    }

    /**
     * Get 请求
     *
     * @param uri URI
     * @return response
     * @throws IOException
     */
    public static String doGet(String uri) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(uri);
        httpGet.setHeader(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
        httpGet.setHeader(HttpHeaders.USER_AGENT, USER_AGENT);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        HttpEntity httpEntity = response.getEntity();
        // if (null != httpEntity) {
        //     InputStream inputStream = httpEntity.getContent();
        //     inputStream.close();
        // }
        // ResponseHandler<String> responseHandler = response -> {
        //     int status = response.getStatusLine().getStatusCode();
        //     if (status >= 200 && status < 300) {
        //         HttpEntity entity = response.getEntity();
        //         return entity != null ? EntityUtils.toString(entity, "UTF-8") : null;
        //     } else {
        //         log.error("Unexpected response status: " + status);
        //         throw new ClientProtocolException("Unexpected response status: " + status);
        //     }
        // };
        return httpEntity != null ? EntityUtils.toString(httpEntity, "UTF-8") : "{\"data\",\"未获取\"}";
    }

    public static HttpUriRequest getRequestMethod(Map<String, String> map, String url, String method) {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        for (Map.Entry<String, String> e : entrySet) {
            String name = e.getKey();
            String value = e.getValue();
            NameValuePair pair = new BasicNameValuePair(name, value);
            params.add(pair);
        }
        HttpUriRequest reqMethod = null;
        if ("post".equals(method)) {
            reqMethod = RequestBuilder.post().setUri(url)
                    .addParameters(params.toArray(new BasicNameValuePair[params.size()]))
                    .setConfig(requestConfig).build();
        } else if ("get".equals(method)) {
            reqMethod = RequestBuilder.get().setUri(url)
                    .addParameters(params.toArray(new BasicNameValuePair[params.size()]))
                    .setConfig(requestConfig).build();
        }
        return reqMethod;
    }
    private static JSONObject convertResponse(CloseableHttpResponse response) throws IOException, ParseException {
        // 请求发送成功，并得到响应
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            // 读取服务器返回过来的json字符串数据
            HttpEntity entity = response.getEntity();
            String strResult = EntityUtils.toString(entity, "utf-8");
            // 把json字符串转换成json对象
            return JSONObject.parseObject(strResult);
        } else {
            log.error(" {} ", response);
        }

        return null;
    }


}