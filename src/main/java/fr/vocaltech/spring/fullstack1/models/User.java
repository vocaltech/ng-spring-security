package fr.vocaltech.spring.fullstack1.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Document(collection = "users")
@Data
@NoArgsConstructor
public class User {
  @Id
  private String id;
  private String username;
  private String password;
  private Set<Role> roles = new HashSet<>();

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public User(String username, String password, Set<Role> roles) {
    this.username = username;
    this.password = password;
    this.roles = roles;
  }

  @Override
  public String toString() {
    return "{\"username\": \"" + username + "\", \"password\": \"" + password + "\", \"roles\": " + roles + "}";
  }
}
