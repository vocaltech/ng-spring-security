package fr.vocaltech.spring.fullstack1.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


// TODO: Remove @CrossOrigin

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/authentication")
public class AuthenticationController {
  @GetMapping
  public Map<String, String> authentication() {
    Map<String, String> map = new HashMap<>();
    map.put("message", "Greeting from AuthenticationController !");

    return map;
  }
}
