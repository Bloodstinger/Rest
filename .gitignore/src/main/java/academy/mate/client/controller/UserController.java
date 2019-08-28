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

    private final String SERVER_URL = "http://localhost:8080/encodeUser";

    @GetMapping("/getUser")
    public User getUser(@RequestParam(name = "name", required = false,
            defaultValue = "testUser") String username,
                        @RequestParam(name = "password", required = false,
                                defaultValue = "testPassword") String password) {
        RestTemplate template = new RestTemplate();
        HttpEntity<User> request = new HttpEntity<>(new User(username, password));
        ResponseEntity<User> user = template.postForEntity(SERVER_URL, request, User.class);
        return user.getBody();
    }
}
