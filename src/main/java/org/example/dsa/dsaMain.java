package org.example.dsa;


import com.google.common.net.MediaType;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.RequestLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.apache.http.nio.client.HttpAsyncClient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class dsaMain {

    public static void main(String[] args) throws IOException, URISyntaxException {

        int x = 15;
        System.out.println(x>15);
    }



    //addRequestInterceptor();
    public static void addRequestInterceptor() throws IOException {

        HttpRequestInterceptor httpRequestInterceptor = new HttpRequestInterceptor() {
            @Override
            public void process(HttpRequest request, HttpContext context) throws HttpException, IOException {
                System.out.println("Inside Interceptor");
                RequestLine requestLine = request.getRequestLine();
                System.out.println(requestLine); /*   /api/v1/employee/1    */
                System.out.println(requestLine.getUri()); /* /api/v1/employee/1 */
                if(request.getRequestLine() != null && request.getRequestLine().getUri() != null){
                    String str = request.getRequestLine().getUri(); // query if URL; path if URI

                    String[] pairs = str.split("/");
                    for(int i=0;i< pairs.length;i++){
                        if(pairs[i].equals("employee")){ //sid
                            if(pairs[i+1]!=null && !pairs[i+1].isEmpty()){
                                System.out.println(pairs[i+1]);
                                request.setHeader("Content-Type", "application/json"); // any header
                                return;
                            }
                            break;
                        }
                    }
                }
            };
        };

    }

    private static void checkSidInUri(){
        try{
            URI uri = new URI("/cmdg/v1/sid/123/mbox/message/ymumid/456/mime/structure/inline");
            String str = uri.getPath(); // query if URL; path if URI

            String[] pairs = str.split("/");
            for(int i=0;i< pairs.length;i++){
                if(pairs[i].equals("sid")){
                    if(pairs[i+1]!=null && !pairs[i+1].isEmpty()){
                        System.out.println(pairs[i+1]);
                    }
                    break;
                }
            }
        }catch (URISyntaxException u){
            System.out.println("URISyntaxException"+u.getMessage());
        }
    }

    private static void callRestEndpointUsingHttpClient() throws IOException {
        HttpGet httpGet = new HttpGet("https://dummy.restapiexample.com/api/v1/employee/1");
        httpGet.setHeader("Content-Type", "application/json");

        HttpPost httpPost = new HttpPost("https://dummy.restapiexample.com/api/v1/create");
        httpPost.setHeader("Content-Type", "application/json");
        StringEntity stringEntity = new StringEntity("{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}");
        httpPost.setEntity(stringEntity);

        CloseableHttpAsyncClient closeableHttpAsyncClient = HttpAsyncClientBuilder.create().build();
        closeableHttpAsyncClient.start();

        HttpResponse httpResponse = null;
        try {
            final Future<HttpResponse> httpResponseFuture = closeableHttpAsyncClient.execute(httpGet, null);
            httpResponse = httpResponseFuture.get(30, TimeUnit.SECONDS);
            String str = EntityUtils.toString(httpResponse.getEntity(), StandardCharsets.UTF_8);
            System.out.println(str);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("finally");
            closeableHttpAsyncClient.close();
        }
    }

    /*
    System.out.println(uri.getAuthority()); //null
            System.out.println(uri.getHost()); //null
            System.out.println(uri.getFragment()); //null
            System.out.println(uri.getPath()); // /api/v1/employee/1
            System.out.println(uri.getPort()); // -1
            System.out.println(uri.getQuery());//null
            System.out.println(uri.getRawAuthority());//null
            System.out.println(uri.getRawFragment());//null
            System.out.println(uri.getRawPath());// /api/v1/employee/1
            System.out.println(uri.getRawQuery());//null
            System.out.println(uri.getRawUserInfo());//null
            System.out.println(uri.getRawSchemeSpecificPart());// /api/v1/employee/1
            System.out.println(uri.getScheme());//null
            System.out.println(uri.getUserInfo());//null
            System.out.println(uri.getSchemeSpecificPart());// /api/v1/employee/1
     */

    private static void tryURI(){
        try{
            URI uri = new URI("http://google.com");
            URI invalidUri = new URI("http://");
        }catch (URISyntaxException u){
            System.out.println("URISyntaxException"+u.getMessage());
            // URISyntaxExceptionExpected authority at index 7: http://
        }
    }

    /*
    SubArray -> Continuous
    1. Initialize prevMax = first element.
    2. Initialize maxSum = first element.
    3. Iterate from second element.
    4. Compute the prevMax. Can either be current element (or) sum of currElement+prevMax.
    5. Computer maxSum.
    printMaximumSubArray(new int[]{1,2,3}, 3);
     */
    private static void printMaximumSubArray(int[] arr, int n){
        double maxSum = arr[0];
        double prevElementsMaxSum = arr[0];
        for(int i=1; i<n; i++){
            prevElementsMaxSum = Math.max(prevElementsMaxSum+arr[i], arr[i]);
            maxSum = Math.max(maxSum, prevElementsMaxSum);
        }
        System.out.println(maxSum);
    }


    //  printMaxConsecutiveOnes(new int[]{0,1,0,1}, 4);
    private static void printMaxConsecutiveOnes(int[] arr, int n){
        int res = 0;
        int cur = 0;
        for(int i=0; i<n; i++){
            if(arr[i]==0){
                cur = 0;
            }else{
                cur++;
                res = Math.max(res, cur);
            }
        }
        System.out.println(res);
    }

    //  printMaxProfitInStock(new int[]{100,180,260,310,40,535,695}, 7);
    private static void printMaxProfitInStock(int[] priceArrInDay, int n){
        int profit = 0;
        for(int i=1; i<n; i++){
            if(priceArrInDay[i] > priceArrInDay[i-1]){
                profit = profit + (priceArrInDay[i]-priceArrInDay[i-1]);
            }
        }
        System.out.println(profit);
    }

    // findRainWaterStorage(new int[]{5,0,6,2,3}, 5);
    private static void findRainWaterStorage(int[] arr, int n){
        int totalStorage = 0;

        int[] lMax = new int[n];
        int[] rMax = new int[n];
        lMax[0] = arr[0];
        rMax[n-1] = arr[n-1];

        for(int i=1; i<n; i++){
            lMax[i] = Math.max(arr[i],arr[i-1]);
        }
        for(int i=n-2; i>=0; i--){
            rMax[i] = Math.max(arr[i], arr[i+1]);
        }
        for(int i=1; i<n; i++){
            totalStorage = totalStorage + (Math.min(lMax[i], rMax[i])-arr[i]);
        }
        System.out.println(totalStorage);
    }




}
