package fr.vocaltech.spring.fullstack1;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = AuthenticationApplication.class)
public class AuthenticationApplicationTest {
  private static final String URL_BASE = "http://localhost:8080/dashboard";
  private TestRestTemplate restTemplate;

  @Test
  public void givenCorrectCredentials_whenLogin_thenSuccess() {
    restTemplate = new TestRestTemplate("user", "pass");
    ResponseEntity<String> res = restTemplate.getForEntity(URL_BASE, String.class);

    assertEquals(200, res.getStatusCodeValue());
    assertTrue(res.getBody().contains("username: 'user'"));
  }

  //TODO: doesn't work
  @Test
  public void givenWrongCredentials_whenLogin_thenFailure() {
    restTemplate = new TestRestTemplate("user", "wrong_pass");
    ResponseEntity<String> res = restTemplate.getForEntity(URL_BASE, String.class);

    System.out.println("status code val: " + res.getStatusCodeValue()); // TODO: must return 401 !!!
    System.out.println(res.getBody());

  }
}
