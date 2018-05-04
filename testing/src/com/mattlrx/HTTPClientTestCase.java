package com.mattlrx;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HTTPClientTestCase {

	private CloseableHttpClient httpclient = HttpClients.createDefault();
	private HttpClientContext context = HttpClientContext.create();
	
	public String httpPostNoRedirect (String url, String usr, String pwd, String expected, Boolean storeCookies) throws ClientProtocolException, IOException, URISyntaxException {
		HttpPost httpPost = new HttpPost(url);
		List <NameValuePair> nvps = new ArrayList <NameValuePair>();
		nvps.add(new BasicNameValuePair("usr", usr));
		nvps.add(new BasicNameValuePair("pwd", pwd));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		CloseableHttpResponse response2 = httpclient.execute(httpPost, context);
		String redirectUri = "";
		String theString2 = "";
		try {
		    System.out.println(response2.getStatusLine());
		    HttpEntity entity2 = response2.getEntity();
		    // do something useful with the response body
		    // and ensure it is fully consumed
		    
		    StringWriter writer2 = new StringWriter();
		    IOUtils.copy(entity2.getContent(), writer2, StandardCharsets.UTF_8);
		    theString2 = writer2.toString();
		    
		    
		    
		    HttpHost target2 = context.getTargetHost();
		    List<URI> redirectLocations = context.getRedirectLocations();
		    URI location = URIUtils.resolve(httpPost.getURI(), target2, redirectLocations);
		    redirectUri = location.toASCIIString();
		    System.out.println("Final HTTP location: " + redirectUri);
		    redirectUri = location.toASCIIString();
		    
		    
		    
		    EntityUtils.consume(entity2);
		} finally {
		    response2.close();
		}
		System.out.println(theString2);
		if (theString2.contains(expected)) {
	    	return "success";
	    }
		else {
			return "failure";
		}
	}
	public static void main(String[] args) throws IOException, URISyntaxException {
		// TODO Auto-generated method stub
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		
		HttpClientContext context = HttpClientContext.create();
		
		HttpGet httpGet = new HttpGet("http://testing-ground.scraping.pro/login?mode=welcome");
		CloseableHttpResponse response1 = httpclient.execute(httpGet, context);
		// The underlying HTTP connection is still held by the response object
		// to allow the response content to be streamed directly from the network socket.
		// In order to ensure correct deallocation of system resources
		// the user MUST call CloseableHttpResponse#close() from a finally clause.
		// Please note that if response content is not fully consumed the underlying
		// connection cannot be safely re-used and will be shut down and discarded
		// by the connection manager. 
		try {
		    System.out.println(response1.getStatusLine());
		    HttpEntity entity1 = response1.getEntity();
		    // do something useful with the response body
		    // and ensure it is fully consumed
		    ;
		    
		    StringWriter writer1 = new StringWriter();
		    IOUtils.copy(entity1.getContent(), writer1, StandardCharsets.UTF_8);
		    String theString1 = writer1.toString();
		    System.out.println(theString1);
		    
		    HttpHost target = context.getTargetHost();
		    List<URI> redirectLocations = context.getRedirectLocations();
		    URI location = URIUtils.resolve(httpGet.getURI(), target, redirectLocations);
		    System.out.println("Final HTTP location: " + location.toASCIIString());
		    
		    EntityUtils.consume(entity1);
		} finally {
		    response1.close();
		}

		HttpPost httpPost = new HttpPost("http://testing-ground.scraping.pro/login?mode=login");
		List <NameValuePair> nvps = new ArrayList <NameValuePair>();
		nvps.add(new BasicNameValuePair("usr", "admin"));
		nvps.add(new BasicNameValuePair("pwd", "12345"));
		httpPost.setEntity(new UrlEncodedFormEntity(nvps));
		CloseableHttpResponse response2 = httpclient.execute(httpPost, context);
		String redirectUri = "";
		try {
		    System.out.println(response2.getStatusLine());
		    HttpEntity entity2 = response2.getEntity();
		    // do something useful with the response body
		    // and ensure it is fully consumed
		    
		    StringWriter writer2 = new StringWriter();
		    IOUtils.copy(entity2.getContent(), writer2, StandardCharsets.UTF_8);
		    String theString2 = writer2.toString();
		    System.out.println(theString2);
		    
		    HttpHost target2 = context.getTargetHost();
		    List<URI> redirectLocations = context.getRedirectLocations();
		    URI location = URIUtils.resolve(httpPost.getURI(), target2, redirectLocations);
		    redirectUri = location.toASCIIString();
		    System.out.println("Final HTTP location: " + redirectUri);
		    redirectUri = location.toASCIIString();
		    
		    
		    EntityUtils.consume(entity2);
		} finally {
		    response2.close();
		}
		httpGet = new HttpGet("http://testing-ground.scraping.pro/login?mode=welcome");
		response1 = httpclient.execute(httpGet);
		// The underlying HTTP connection is still held by the response object
		// to allow the response content to be streamed directly from the network socket.
		// In order to ensure correct deallocation of system resources
		// the user MUST call CloseableHttpResponse#close() from a finally clause.
		// Please note that if response content is not fully consumed the underlying
		// connection cannot be safely re-used and will be shut down and discarded
		// by the connection manager. 
		try {
		    System.out.println(response1.getStatusLine());
		    HttpEntity entity1 = response1.getEntity();
		    // do something useful with the response body
		    // and ensure it is fully consumed
		    ;
		    
		    StringWriter writer1 = new StringWriter();
		    IOUtils.copy(entity1.getContent(), writer1, StandardCharsets.UTF_8);
		    String theString1 = writer1.toString();
		    System.out.println(theString1);
		    
		    HttpHost target = context.getTargetHost();
		    List<URI> redirectLocations = context.getRedirectLocations();
		    URI location = URIUtils.resolve(httpGet.getURI(), target, redirectLocations);
		    System.out.println("Final HTTP location: " + location.toASCIIString());
		    
		    EntityUtils.consume(entity1);
		} finally {
		    response1.close();
		}
	}

}
