package co.mr.thymeleafEx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class MainController {
    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/var")
    public String var(Model model) {
        Person person1 = new Person("김길동", 11, "서울");
        Person person2 = new Person("이길동", 22, "대전");

        ArrayList<Person> list = new ArrayList<>();
        list.add(person1);
        list.add(person2);

        model.addAttribute("person", person1);
        model.addAttribute("list", list);

        return "var";
    }

    @GetMapping("/link")
    public String link(Model model) {
        model.addAttribute("param1", "value1");
        model.addAttribute("param2", "value2");

        return "link";
    }

    @GetMapping("/inline")
    public String inline(Model model) {
        model.addAttribute("name", "홍길동");
        model.addAttribute("name2", "<strong>홍길동</strong>");
        return "inline";
    }

    @GetMapping("/js")
    public String js(Model model) {
        model.addAttribute("person", new Person("kim", 10, "서울"));

        person(model);
        return "js_inline";
    }

    @GetMapping("/each")
    public String each(Model model) {
        person(model);
        return "each";
    }

    @GetMapping("/if")
    public String ifstate(Model model) {
        person(model);
        return "if";
    }

    public void person(Model model) {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("kim", 10, "서울"));
        list.add(new Person("lee", 20, "대전"));
        list.add(new Person("Park", 10, "부산"));
        model.addAttribute("people", list);
    }
}
