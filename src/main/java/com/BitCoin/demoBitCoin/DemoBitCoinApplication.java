package com.BitCoin.demoBitCoin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableScheduling
public class DemoBitCoinApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoBitCoinApplication.class, args);
	}

	private static final Logger log = LoggerFactory.getLogger(DemoBitCoinApplication.class);

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
		return restTemplateBuilder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception{
		return args -> {
			OnlyFans();
		};
	}

	@Scheduled(fixedRate = 10000)
	public void OnlyFans(){
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CurrentPrice[]> responseEntity = restTemplate.getForEntity("https://api.n.exchange/en/api/v1/price/BTCLTC/latest/?format=json&market_code=nex", CurrentPrice[].class);
		log.info(Arrays.toString(responseEntity.getBody()));
	}



}	
