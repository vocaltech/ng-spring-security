package fr.vocaltech.spring.fullstack1.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
  private ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
    response.setStatus(HttpStatus.UNAUTHORIZED.value());

    Map<String, String> map = new HashMap<>();
    map.put("message", exception.getMessage());
    map.put("status", String.valueOf(response.getStatus()));

    System.out.println("[onAuthenticationFailure()] map: " + map);

    response.getOutputStream().println(objectMapper.writeValueAsString(map));
  }
}
