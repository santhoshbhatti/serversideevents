package com.piedpiper.serversideevents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piedpiper.serversideevents.service.StreamingService;

import reactor.core.publisher.Mono;

@RestController
public class VideoStreamingController {
	
	@Autowired
	private StreamingService service;

	@GetMapping(value = "video/{title}", produces = "video/mp4")
	public Mono<Resource> getVideo(@PathVariable("title") String title
			,@RequestHeader("range") String range){ 
		return service.getVideo(title);
		
	}
}
