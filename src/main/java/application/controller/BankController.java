package application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BankController {

  @GetMapping
  public String welcomeBankPage() {
    return "Hello, this is your bank app!";
  }

}
