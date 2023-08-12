package com.nseed.catalog.clients;

import java.net.URI;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nseed.catalog.utils.UriUtil;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class NseedApiClient {
	
	//@Autowired
	private UriUtil uriUtil;
	
	public static MediaType DEFAULT_CONTENT_TYPE = MediaType.APPLICATION_JSON;
	public static MediaType DEFAULT_ACCEPT = MediaType.APPLICATION_JSON;
	
	//@Autowired
	//private OAuth2RestTemplate restTemplate;
	
	@SuppressWarnings("unchecked")
	public void sendData()  throws Exception{
		
		ResponseEntity<Object> resp=null;
		try {
			resp=(ResponseEntity<Object>) exchange(uriUtil.getNseedURI(), HttpMethod.POST, getNseedResponseEntity(new Object()), String.class);
		}catch (Exception e) {
			throw new Exception ("Save results failed",e);
		}
		
	}
	private HttpEntity<Object> getNseedResponseEntity(Object s){
		
		return new HttpEntity<>(s,getDefauttHeaders());
	}
	
	public ResponseEntity<?> exchange(URI endpoint,HttpMethod method,HttpEntity<?> entity,Class<?> returntype) throws Exception{
		ResponseEntity<?> resp=null;
		
		String msgFailed ="DataService Exchange failed,";
		if(endpoint==null) {
			throw new Exception (msgFailed +"missing endpoint");
		}
		//if(restTemplate == null) {
		//	throw new Exception (msgFailed +"restTemplate is null");
		//}
		if(method == null) {
			throw new Exception (msgFailed +"method is null");
		}
		String msg="exchange calling "+method.name() + "on" +endpoint.toString();
		log.debug(msg);
		try {
		//resp=restTemplate.exchange(endpoint,method,entity,returntype);
		}catch (Exception e) {
			throw new Exception(msgFailed+msg,e);
		}
		if(resp==null) {
			throw new Exception(msgFailed+msg+":: no response received");
		}
	return resp;
	}
	public void validateResponse(ResponseEntity<?> resp,String msg) throws Exception {
		HttpStatus status= resp.getStatusCode();
		msg = msg == null ? "::" : msg+":: failed";
		if(status!= HttpStatus.OK && status !=HttpStatus.ACCEPTED) {
			Object b;
			try {
				b=resp.getBody();
				if(b == null) {
					throw new Exception(msg+status.toString()+" :: response body is null"); 
				}
			}
			
		catch (Exception e) {
			throw new Exception(msg+status.toString());
		  }
			log.error("{}{}::{}",msg,status.toString(),b);
			throw new Exception(msg+status.toString());
		}
	}
	
	private HttpHeaders  getDefauttHeaders() {
		return getHeaders(null,null);
	}
	private HttpHeaders getHeaders(MediaType type, MediaType accept) {
		HttpHeaders httpHeaders=new HttpHeaders();
		httpHeaders.setContentType(type==null ? DEFAULT_CONTENT_TYPE : type);
		httpHeaders.setAccept(Collections.singletonList(accept==null ? DEFAULT_ACCEPT : accept));
		httpHeaders.add("Referer",uriUtil.getOfsaaURI());
		return httpHeaders;
	}
}
