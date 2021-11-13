package com.frodolele.openFeignHttpClient;

import com.frodolele.openFeignHttpClient.bean.GalaxyBean;
import com.frodolele.openFeignHttpClient.feign.Galaxy;
import com.frodolele.openFeignHttpClient.restTemplate.ConsumeRestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class OpenFeignHttpClientApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(OpenFeignHttpClientApplication.class);

	@Autowired
	private ConsumeRestTemplate consumeRestTemplate;
	@Autowired
	private Galaxy galaxyFeign;

	public static void main(String[] args) {
		SpringApplication.run(OpenFeignHttpClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String url = "https://2a6e0231-05f5-4028-8571-cbce1dcfb5b5.mock.pstmn.io/cosmos";

		ResponseEntity<String> response = consumeRestTemplate.response(url);

		logger.info(response.getBody());

		logger.info("********** OPEN FEIGN *********");

		List<GalaxyBean> galaxyBeans = galaxyFeign.getAllGalaxies();
		galaxyBeans.forEach(galaxy -> {
			System.out.println(galaxy.getId());
			System.out.println(galaxy.getName());
			System.out.println(galaxy.getTag());
		});
	}
}
