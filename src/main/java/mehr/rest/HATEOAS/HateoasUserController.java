package mehr.rest.HATEOAS;

import mehr.rest.Database.UserDao;
import mehr.rest.Exceptions.UserNotFoundException;
import mehr.rest.beans.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class HateoasUserController {
/*
    @Autowired
    private UserDao userDao;


    @GetMapping("/users")
    public List<UserBean> getAllHateoasUsers(){
        return userDao.getAllUsers();
    }


    @GetMapping("/users/{userId}")
    public Resource<UserBean> getUserHateoasById(@PathVariable int userId){

        UserBean userBean = userDao.getUserById(userId);

        if (userBean == null){
            throw new UserNotFoundException("userId: " + userId + " not found!");
        }

        Resource<UserBean> userResource = new Resource(userBean);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllHateoasUsers());
        userResource.add(linkTo.withRel("Retrieve all Users"));

        return userResource;
    }

    */
}
