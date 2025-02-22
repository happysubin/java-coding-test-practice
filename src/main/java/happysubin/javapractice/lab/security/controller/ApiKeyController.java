package happysubin.javapractice.lab.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/key")
public class ApiKeyController {

    @GetMapping("/test")
    public Dto test() {
        return new Dto("hihihihihi");
    }


    static class Dto {
        private final String message;

        public Dto(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

}
