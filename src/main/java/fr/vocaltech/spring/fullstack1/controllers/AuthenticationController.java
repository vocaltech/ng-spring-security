package fr.vocaltech.spring.fullstack1.controllers;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/dashboard")
public class AuthenticationController {
  @GetMapping()
  public Map<String, String> authentication(HttpServletRequest request) {
    Stream<String> stream = Stream.of(request.getHeader("Authorization").split("Basic")[1].trim());
    List list = stream
      .map(Base64.getDecoder()::decode)
        .collect(Collectors.toList());
    System.out.println(list);

    Map<String, String> map = new HashMap<>();
    map.put("id", UUID.randomUUID().toString());
    map.put("message", "Welcome in your dashboard !");


    return map;
  }
}
