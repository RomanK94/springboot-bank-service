package application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AmountRestfulController {

  private RestTemplate restTemplate;
  private static final String AMOUNT_RESOURCE_URL = "http://localhost:8080/amount/";

  public AmountRestfulController(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @RequestMapping("/rest/amount/{id}")
  public String getRestAmount(@PathVariable long id) {

    ResponseEntity<String> response = restTemplate.getForEntity(AMOUNT_RESOURCE_URL + id, String.class);

    return response.getBody();
  }

}
