package fr.vocaltech.spring.fullstack1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
  @Id
  private String id;
  private ERole name;

  public Role(ERole name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "{ name: '" + name + "' }";
  }

}
