package application.controller;

import application.domain.ApplicationUser;
import application.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/amount/{id}")
public class AmountController {

  private UserRepository userRepository;

  public AmountController(UserRepository userRepository)
  {
    this.userRepository = userRepository;
  }

  @GetMapping
  public String getUserAmount(@PathVariable long id) {
    if (userRepository.existsById(id)) {
      ApplicationUser user = userRepository.getOne(id);
      return "Currently amount " + user.getAmount() + " for user " + user.getName();
    }

    return "Haven't user with id " + id + " in system!";
  }

  @PostMapping
  public String setNewAmount(@PathVariable long id, @RequestBody Integer newAmount)
  {
    if (userRepository.existsById(id)) {
      ApplicationUser user = userRepository.getOne(id);
      user.setAmount(newAmount);
      userRepository.save(user);

      return "New amount " + user.getAmount() + " for user " + user.getName();

    }
    return "Haven't user with id " + id + " in system!";
  }

}
