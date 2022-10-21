package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value={"", "/page", "page*","view/*,**/msg"})
//@RequestMapping("/hug")
public class HomeController {
    @GetMapping("/")
    public String hello() {
        return "home";
    }
    @RequestMapping("/test1/{id}")
    public String test1(@PathVariable("id") int id, Model model) {
        model.addAttribute("id", id);
        return "test1";
    }

    @RequestMapping("/test2/{id}/{name}")
    public String test2(@PathVariable("id") int id, @PathVariable("name") String name, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        return "test2";
    }

    @RequestMapping("/test3")
    public String test3(String name, @RequestParam(value = "id") int id, Model model) {
//    public String test3(String name, int id, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("name", name);
        return "test3";
    }

}
