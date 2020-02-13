package mehr.rest.controllers;

import mehr.rest.Database.UserDao;
import mehr.rest.Exceptions.UserNotFoundException;
import mehr.rest.beans.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import  static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;


    @GetMapping("/users")
    public List<UserBean> getAllUsers(){
        return userDao.getAllUsers();
    }


    @GetMapping("/users/{userId}")
    public Resource<UserBean>  getUserById( @PathVariable int userId){

        UserBean userBean = userDao.getUserById(userId);

        if (userBean == null){
            throw new UserNotFoundException("userId: " + userId + " not found!");
        }

        Resource<UserBean> userResource = new Resource(userBean);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllUsers());
        userResource.add(linkTo.withRel("Retrieve all Users"));

        return userResource;
    }


    @PostMapping("/users")
    public ResponseEntity addUser(@Valid @RequestBody UserBean user){
        UserBean savedUser = userDao.addUser(user);
         int userId= savedUser.getUserId();
         UriComponentsBuilder uriComponentsBuilder = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}");
         URI location = uriComponentsBuilder.buildAndExpand(userId).toUri();

        ResponseEntity responseEntity = ResponseEntity.created(location).build();

        return responseEntity;

    }

    @DeleteMapping("/users/{userId}")
    public void removeUser(@PathVariable int userId){
        UserBean userBean = userDao.deleteUserById(userId);

        if(userBean == null) {
            throw new UserNotFoundException("User with Id " + userId + " not found");
        }

    }

}
