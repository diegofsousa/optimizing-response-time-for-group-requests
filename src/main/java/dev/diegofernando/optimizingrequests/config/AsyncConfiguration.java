//package dev.diegofernando.optimizingrequests.config;
//
//import java.util.concurrent.Executor;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//
///**
// * @author Diego Fernando
// * @since 03/09/2020
// */
//
//@Configuration
//@EnableAsync
//public class AsyncConfiguration {
//	@Bean
//	public Executor asyncExecutor() {
//		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//		return executor;
//	}
//}