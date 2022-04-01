package fr.vocaltech.spring.fullstack1.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthUserDetailsService implements UserDetailsService {
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    /*
    User user = userRepository.findByUsername(username);

    if (user == null)
      throw new UsernameNotFoundException(username);

    System.out.println("---> [CustomUserDetailsService.loadUserByUsername()] logged as: " + user.getUsername());
    System.out.println("---> [CustomUserDetailsService.loadUserByUsername()] roles: " + user.getRoles());

    return new CustomUserPrincipal(user);
    */

    return null;
  }
}
