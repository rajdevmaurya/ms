package com.nseed.catalog.utils;

import java.net.URI;
import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UriUtil {
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@Value("${ofsaa.api.endpoint.mcp}")
	private String nseedEndPoint;
	
	@Value("${ofsaaEndpoint.host}")
	private String ofsaaEndpoint;
	
	public URI getNseedURI() throws Exception{
		return getURI(nseedEndPoint);
	}
	
	public String getOfsaaURI() {
		return ofsaaEndpoint;
	}
	
	private URI getURI(String endpoint) throws Exception {
		if(endpoint==null || endpoint.isEmpty() ) {
			throw new Exception("Invailed endpoint");
		}
		String uri="";
		String path="/";
		int i=endpoint.indexOf("/");
		if(i>1) {
			uri=endpoint.substring(0,i);
			path=endpoint.substring(i);
		}
		URI u=null;
		ServiceInstance si=loadBalancerClient.choose(uri);
		if(si==null) {
			log.error("Endpoint not found for "+uri);
			u=craeteURI("."+path);

		}else {
			u=craeteURI(si.getUri()+path);
			log.debug("URI for {} ::{}",endpoint,u.toString());

		}
		return u;
	}
	private URI craeteURI(String uri) throws Exception {
		URI u=null;
             try {
            	 u=new URI(clearURL(uri));
             }catch (URISyntaxException e) {
            	 throw new Exception ("fail to create URI for URL :: "+uri, e);
			}
		return u;
	}
public static String clearURL(String url) {
	
	if(url==null || url.isEmpty()) {
		url="/";
	}else {
		url=url.replaceAll("(?<!http[s]?:)//", "/");
	}
	return url;
}
}
