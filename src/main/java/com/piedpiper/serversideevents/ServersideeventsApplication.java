package com.piedpiper.serversideevents;

import java.time.Duration;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@SpringBootApplication
@RestController
public class ServersideeventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServersideeventsApplication.class, args);
	}
	
	@GetMapping(value="/sse/servertime",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<String> getServerTime(){
		return Flux.interval(Duration.ofSeconds(1))
				.map(curTime -> curTime+" : "+new Date().toString());
	}

}
