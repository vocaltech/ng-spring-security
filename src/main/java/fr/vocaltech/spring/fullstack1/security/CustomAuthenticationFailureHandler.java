package fr.vocaltech.spring.fullstack1.security;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {
  @Override
  public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
    response.setStatus(HttpStatus.UNAUTHORIZED.value());

    String jsonPayload = "{\"message\" : \"%s\", \"code\" : \"%d\" }";
    response.getOutputStream().println(String.format(jsonPayload, exception.getMessage(), response.getStatus()));
  }
}
