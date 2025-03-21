package edu.du.sb_portal.controller;

import edu.du.sb_portal.entity.User;
import edu.du.sb_portal.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/join")
    public String showCreateUserForm() {
        return "module0/join";
    }

    @PostMapping("/users")
    public String createUser(User user, Model model) {
        User savedUser = userService.createUser(user);

        if (savedUser == null) {
            model.addAttribute("error", "ID가 중복되었습니다.");
            return "module0/join";
        }
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "module0/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String id, @RequestParam String password, HttpSession session, Model model) {
        User user = userService.getUserById(id);

        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("userName", user.getName());
            return "redirect:http://localhost:8087";
        } else {
            model.addAttribute("error", "다시 확인해 주세요");
            return "module0/login";
        }
    }
}