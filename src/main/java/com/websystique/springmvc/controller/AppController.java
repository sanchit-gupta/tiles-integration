package com.websystique.springmvc.controller;

import com.websystique.springmvc.model.User;
import com.websystique.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;


@Controller
@RequestMapping("/")
public class AppController {

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        return "home";
    }

    @Autowired
    UserService userService;

    @RequestMapping(value = {"/products"}, method = RequestMethod.GET)
    public String productsPage(ModelMap model) {
        return "products";
    }

    @RequestMapping(value = {"/contactus"}, method = RequestMethod.GET)
    public String contactUsPage(ModelMap model) {
        return "contactus";
    }

    @RequestMapping(value = {"/test"}, method = RequestMethod.GET)
    public String testPage(ModelMap model) {

        System.out.println("from test action");
        System.out.println("userService : " + userService);

        User user = new User();
        user.setEmail("hibernateTestEmail@gmail.com");
        user.setFirstName("firstname");
//		user.setId(2);
        user.setLastName("lastname");
        user.setPassword("123456");
        user.setSsoId("" + new Date());

        System.out.println(user);
        System.out.println("before calling service ");
        userService.saveUser(user);


        return "test";
    }

    @RequestMapping(value = {"/findById/{id}"}, method = RequestMethod.GET)
    public String findById(@PathVariable int id, ModelMap model) {
        System.out.println("before find user from db");
        User user = userService.findById(id);

        System.out.println("User find from db of id : " + id);
        System.out.println(user);
        return "test";
    }


    @RequestMapping(value = {"/findByAll"}, method = RequestMethod.GET)
    public String findByAll(ModelMap model) {
        System.out.println("*************************************************************************");
        System.out.println("");
        System.out.println("");
        System.out.println("before find all user from db");
        for (User user : userService.findAllUsers()) {
            System.out.println(user);
        }
        System.out.println("");
        System.out.println("***************************************************************************");
        return "test";
    }

    @RequestMapping(value = {"/deleteById/{id}"}, method = RequestMethod.GET)
    public String deleteById(ModelMap model, @PathVariable int id) {

        System.out.println("***************************************");
        System.out.println("");
        System.out.println("");
        System.out.println("goig to delete by id : "+id);
        userService.deleteUserBySSO(id);

        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("deleted");
        System.out.println("****************************************");
        return "test";
    }
}