package StudentApplication.SpringJPAHibernate.Controllers;

import StudentApplication.SpringJPAHibernate.Model.User;
import StudentApplication.SpringJPAHibernate.Repository.UserRepository;
import jakarta.persistence.Id;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepoObj;
    @PostMapping("/signup")
    public User save(@RequestBody User userObj){
        System.out.println(userObj);
        User userResponse = userRepoObj.save(userObj);


        return userResponse;
    };

    @DeleteMapping("/deleteOne")
    public void delete(@RequestBody User userObj){
        userRepoObj.delete(userObj);
    }

    @GetMapping("/findAll")
    public void findAll(){
        for(User u : userRepoObj.findAll()){
            System.out.println(u);
        }
    }

    @GetMapping("/")
    public String index() {
        return "Hello!!!";
    }

}

