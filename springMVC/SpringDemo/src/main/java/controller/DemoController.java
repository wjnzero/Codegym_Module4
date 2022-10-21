package controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
public class DemoController {
    @GetMapping("/detail/{id}")
    public String demo1(@PathVariable Long id, Model model, @RequestParam String name){
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        return "demo";
    }
}
