package eicontest;

import java.util.ArrayList;
import java.util.Arrays;

import lombok.RequiredArgsConstructor;
import eicontest.model.User;
import eicontest.model.Role;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import eicontest.service.UserService;

@SpringBootApplication
@RequiredArgsConstructor
public class JwtAuthServiceApp implements CommandLineRunner {

  final UserService userService;

  public static void main(String[] args) {
    SpringApplication.run(JwtAuthServiceApp.class, args);
  }

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

  @Override
  public void run(String... params) throws Exception {
    User client1 = new User();
    client1.setUsername("client1");
    client1.setPassword("client1");
    client1.setEmail("client1@eicontest.com");
    client1.setAppUserRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_ADMIN)));

    userService.signup(client1);

    User client2 = new User();
    client2.setUsername("client2");
    client2.setPassword("client2");
    client2.setEmail("client2@eicontest.com");
    client2.setAppUserRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_ADMIN)));

    userService.signup(client2);

    User client3 = new User();
    client3.setUsername("client3");
    client3.setPassword("client3");
    client3.setEmail("client3@eicontest.com");
    client3.setAppUserRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_ADMIN)));

    userService.signup(client3);

    User client4 = new User();
    client4.setUsername("client4");
    client4.setPassword("client4");
    client4.setEmail("client4@eicontest.com");
    client4.setAppUserRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_ADMIN)));

    userService.signup(client4);

    User client5 = new User();
    client5.setUsername("client5");
    client5.setPassword("client5");
    client5.setEmail("client5@eicontest.com");
    client5.setAppUserRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_ADMIN)));

    userService.signup(client5);

    User client6 = new User();
    client6.setUsername("client6");
    client6.setPassword("client6");
    client6.setEmail("client6@eicontest.com");
    client6.setAppUserRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_ADMIN)));

    userService.signup(client6);

    User client7 = new User();
    client7.setUsername("client7");
    client7.setPassword("client7");
    client7.setEmail("client7@eicontest.com");
    client7.setAppUserRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_ADMIN)));

    userService.signup(client7);

    User client8 = new User();
    client8.setUsername("client8");
    client8.setPassword("client8");
    client8.setEmail("client8@eicontest.com");
    client8.setAppUserRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_ADMIN)));

    userService.signup(client8);

    User client9 = new User();
    client9.setUsername("client9");
    client9.setPassword("client9");
    client9.setEmail("client9@eicontest.com");
    client9.setAppUserRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_ADMIN)));

    userService.signup(client9);

    User client10 = new User();
    client10.setUsername("client10");
    client10.setPassword("client10");
    client10.setEmail("client10@eicontest.com");
    client10.setAppUserRoles(new ArrayList<Role>(Arrays.asList(Role.ROLE_ADMIN)));

    userService.signup(client10);
  }

}
