package sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository repository;

    @RequestMapping("/")
    public List<User> greeting(@RequestParam(value = "id", required = false) String id,
                               @RequestParam(value = "name", required = false) String name) {

        if (id != null && name != null) {
            repository.save(new User(id, name));
        }

        return repository.findAll();
    }
}
