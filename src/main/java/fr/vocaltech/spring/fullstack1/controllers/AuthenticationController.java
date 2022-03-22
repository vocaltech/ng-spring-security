package fr.vocaltech.spring.fullstack1.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

//
// TODO: Remove @CrossOrigin
//

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/dashboard")
public class AuthenticationController {
  @GetMapping
  public Map<String, String> authentication() {
    Map<String, String> map = new HashMap<>();
    map.put("id", UUID.randomUUID().toString());
    map.put("message", "Welcome in your dashboard !");

    return map;
  }
}
