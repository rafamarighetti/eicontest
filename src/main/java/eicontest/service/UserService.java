package eicontest.service;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import eicontest.exception.CustomException;
import eicontest.model.User;
import eicontest.model.UserLogin;
import eicontest.repository.UserRepository;
import eicontest.security.JwtTokenProvider;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtTokenProvider jwtTokenProvider;
  private final AuthenticationManager authenticationManager;
  

  public List<User>  users() {
    return userRepository.findAll();
  }
  
  public UserLogin signin(String username, String password) {
    User user = userRepository.findByUsername(username);
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

     return new UserLogin() {
        {
          id = user.getId();
          username = user.getUsername();
          email = user.getEmail();
          token = jwtTokenProvider.createToken(username, userRepository.findByUsername(username).getAppUserRoles());
          roles = user.getAppUserRoles();
        }
      };
    } catch (AuthenticationException e) {
      throw new CustomException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
    }
  }

  public UserLogin signup(User user) {
    if (!userRepository.existsByUsername(user.getUsername())) {
      user.setPassword(passwordEncoder.encode(user.getPassword()));
      userRepository.save(user);
      return new UserLogin() {
        {
          id = user.getId();
          username = user.getUsername();
          email = user.getEmail();
          token = jwtTokenProvider.createToken(username, userRepository.findByUsername(username).getAppUserRoles());
          roles = user.getAppUserRoles();
        }
      };
    } else {
      throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
    }
  }

  public void delete(String username) {
    userRepository.deleteByUsername(username);
  }

  public User search(String username) {
    User appUser = userRepository.findByUsername(username);
    if (appUser == null) {
      throw new CustomException("The user doesn't exist", HttpStatus.NOT_FOUND);
    }
    return appUser;
  }

  public User whoami(HttpServletRequest req) {
    return userRepository.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
  }

  public String refresh(String username) {
    return jwtTokenProvider.createToken(username, userRepository.findByUsername(username).getAppUserRoles());
  }

}
