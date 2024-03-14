package net.javaguides.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/form")
	public String getFormPage(User user) {
		return "form";
	}
	
	@PostMapping("/form")
	public String saveUser(User user, Model model) {
		userRepository.save(user);
		model.addAttribute("message", "Submitted Sucessfully");
		return "form";
	}
}
