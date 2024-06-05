package sungs.msa.apps.msapp2.controller;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;

//import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import lombok.extern.slf4j.Slf4j;



@Slf4j
@RestController
public class WebserverController {
    //private final Logger log = LoggerFactory.getLogger(getClass());
	@Value("${server.port}")
	int port;

    @GetMapping("/webclient/{param}")
	public String testWebClient(
		@PathVariable("param") String param, 
		@RequestHeader HttpHeaders headers,
		@CookieValue(name = "httpclient-type", required=false, defaultValue="undefined") String httpClientType) {
		
    	log.info("====== /webclient/{param} in ==========");
		log.info(">>>> Cookie 'httpclient-type={}'", httpClientType);

		headers.forEach((key, value) -> {
			log.info(String.format(">>>>> Header '%s' => %s", key, value));
		});
		
		log.info("### Received: /webclient/" + param);
		
		String msg = "("+headers.get("host")+":"+port+")"+param + " => Working successfully !!!";
		log.info("### Sent: " + msg);
		log.info("====== /webclient/{param} out ==========");
		return msg;
	} 
    
    @GetMapping("/hehe")
	public String testWebClient() {
    	return "call";
    }
}
