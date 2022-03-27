package fr.vocaltech.spring.fullstack1.controllers;

import fr.vocaltech.spring.fullstack1.models.ERole;
import fr.vocaltech.spring.fullstack1.models.Role;
import fr.vocaltech.spring.fullstack1.models.User;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.*;

@RestController
@RequestMapping("/dashboard")
public class AuthenticationController {
  @GetMapping()
  public Map<String, String> showDashboard(Principal principal) {

    System.out.println("principal: " + principal);

    Map<String, String> map = new HashMap<>();
    map.put("id", UUID.randomUUID().toString());
    map.put("message", "Welcome in your dashboard !");

    Set<Role> roles = new HashSet<>();
    roles.add(new Role(ERole.ROLE_ADMIN));
    roles.add(new Role(ERole.ROLE_USER));

    User user = new User(principal.getName(), "hidden", roles);
    map.put("profile", user.toString());

    return map;
  }
}
