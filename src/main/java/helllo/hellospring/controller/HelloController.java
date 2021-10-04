package helllo.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "spring!!");
                return "hello";
        }

    @GetMapping("hello-mvc")
    public String hellowMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
         return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody   // ResponseBody 응답 Body 부분이 이걸 추가하겠다. 만약에 Spring 을 추가하면
    public String helloString(@RequestParam("name") String name){
        return "hello"+ name;   // hello + Spring 이 된다
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
