package dev.diegofernando.optimizingrequests;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author Diego Fernando
 * @since 02/09/2020
 */

@SpringBootApplication
@EnableAsync
@EnableFeignClients(basePackages = { "dev.diegofernando.optimizingrequests.api.feign" })
public class OptimizingrequestsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OptimizingrequestsApplication.class, args);
	}

}
