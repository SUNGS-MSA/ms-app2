package sungs.msa.apps.msapp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient  //유레카 클라이언트 적용
public class MsApp2Application {

	public static void main(String[] args) {
		SpringApplication.run(MsApp2Application.class, args);
	}

}
