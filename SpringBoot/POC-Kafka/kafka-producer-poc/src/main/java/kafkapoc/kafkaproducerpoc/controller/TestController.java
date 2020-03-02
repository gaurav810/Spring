package kafkapoc.kafkaproducerpoc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/producer")
public class TestController {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@RequestMapping(value = "{name}", method = RequestMethod.GET)
	public String produceAsName(@PathVariable("name") String name) {
		
		kafkaTemplate.send("name-topic", name);
		
		System.out.println("Produced message: " + name);
		return "Produced message: " + name;
	}
}
