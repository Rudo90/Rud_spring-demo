package am.itspace.springdemo.controller;


import am.itspace.springdemo.model.User;
import am.itspace.springdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String homePage (ModelMap modelMap){
        List<User> list = userRepository.findAll();
        modelMap.addAttribute("users", list);
        modelMap.addAttribute("message", "Welcome");
        return "home";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User user){
        userRepository.save(user);
        return "redirect:/";
    }

    @GetMapping("/about")
    public String aboutUsPage (){
        return "aboutUs";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") int id){
        userRepository.deleteById(id);
        return "redirect:/";
    }
}
