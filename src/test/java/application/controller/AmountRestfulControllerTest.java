package application.controller;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@Ignore
public class AmountRestfulControllerTest {

  private RestTemplate restTemplate;

  @LocalServerPort
  int randomServerPort;

  @Before
  public void beforeTest() {
    restTemplate = new RestTemplate();
  }

  @Test
  public void givenResourceUrl_whenSendGetForRequestEntity_thenStatusOk() {
    String AMOUNT_RESOURCE_URL = "http://localhost:" + randomServerPort + "/amount/";

    ResponseEntity<String> response = restTemplate.getForEntity(AMOUNT_RESOURCE_URL, String.class);

    Assert.assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
  }
}
