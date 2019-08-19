package academy.mate.client.controller;

import academy.mate.client.model.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserController {

    @GetMapping("/getUser")
    public User getUser(@RequestParam(name = "name", required = false, defaultValue = "testUser") String username,
                        @RequestParam(name = "password", required = false,
                                defaultValue = "testPassword") String password) {
        RestTemplate template = new RestTemplate();
        String url = "http://localhost:8080/encodeUser";
        HttpEntity<User> request = new HttpEntity<>(new User(username, password));
        ResponseEntity<User> user = template.postForEntity(url, request, User.class);
        System.out.println(user.getBody());
        return user.getBody();
    }
}
