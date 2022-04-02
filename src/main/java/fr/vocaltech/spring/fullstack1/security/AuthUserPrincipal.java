package fr.vocaltech.spring.fullstack1.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import fr.vocaltech.spring.fullstack1.models.Role;
import fr.vocaltech.spring.fullstack1.models.User;

public class AuthUserPrincipal implements UserDetails {
  private final User user;

  public AuthUserPrincipal(User user) {
    this.user = user;
  }

  public User getUser() {
    return user;
  }

  @Override
  public String getUsername() {
    return user.getUsername();
  }

  @Override
  public String getPassword() {
    return user.getPassword();
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<GrantedAuthority> authorities = new ArrayList<>();

    Set<Role> roles = user.getRoles();
    for (Role role: roles) {
      authorities.add(new SimpleGrantedAuthority(role.getName().toString()));
    }

    return authorities;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
