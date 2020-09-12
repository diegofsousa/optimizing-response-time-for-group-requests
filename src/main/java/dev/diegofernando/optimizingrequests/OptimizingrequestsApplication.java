package dev.diegofernando.optimizingrequests;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

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

	@Bean
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(2);
		executor.setQueueCapacity(500);
		executor.setThreadNamePrefix("DeckAsync-");
		executor.initialize();
		return executor;
	}

}
