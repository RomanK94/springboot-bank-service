package application.controller;

import application.domain.ApplicationUser;
import application.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
public class RegisterUserController {

  private UserRepository userRepository;

  public RegisterUserController(UserRepository userRepository)
  {
    this.userRepository = userRepository;
  }

  @PostMapping
  public String registrUser(@RequestBody String name) {
    ApplicationUser registrApplicationUser = userRepository.save(new ApplicationUser(name));
    return "Congrat! New user " + registrApplicationUser.getName();
  }

}
