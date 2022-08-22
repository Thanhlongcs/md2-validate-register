package rikkei.academy.view;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import rikkei.academy.config.Config;
import rikkei.academy.controller.UserController;
import rikkei.academy.dto.request.SignUpDTO;
import rikkei.academy.dto.response.ResponseMessenger;
import rikkei.academy.model.User;
import rikkei.academy.service.Role.RoleServiceIMPL;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class ViewUser {
    UserController userController = new UserController();
    List<User> userList = userController.showListUser();

    public ViewUser() {

    }

    public void formRegister() {
        System.out.println("------------REGISTER---------------");
        int id;
        if (userList.size() == 0) {
            id = 1;
        } else {
            id = userList.get(userList.size() - 1).getId() + 1;
        }
        String name;
        boolean validateName;
        while (true) {
            System.out.println("enter the name: ");
            name = Config.scanner().nextLine();
            validateName = Pattern.matches("[A-Z][a-zA-Z[\\s]]{1,100}", name);
            if (validateName) {
                break;
            } else {
                System.err.println("please try again");
            }
        }
        String username;
        boolean validateUserName;
        while(true){

            System.out.println("enter the username: ");
            username = Config.scanner().nextLine();
            validateUserName = Pattern.matches("[a-zA-Z0-9]{1,40}", username);
            if (validateUserName) {
                break;
            } else {
                System.err.println("please try again");
            }
        }
        String email;
        boolean validateEmail;
        while(true){
            System.out.println("enter the email: ");
            email = Config.scanner().nextLine();
            validateEmail = Pattern.matches("^(.+)@(.+)$", email);
            if (validateEmail) {
                break;
            } else {
                System.err.println("please try again");
            }
        }
        String password;
        boolean validatePassword;
        while(true){
            System.out.println("enter the password: ");
            password = Config.scanner().nextLine();
            validatePassword = Pattern.matches("[a-zA-Z0-9]{1,40}", password);
            if (validatePassword) {
                break;
            } else {
                System.err.println("please try again");
            }
        }
        System.out.println("nhap vao role: ");
        String role = Config.scanner().nextLine();
        Set<String> strRoles = new HashSet<>();
        strRoles.add(role);
        SignUpDTO signUpDTO = new SignUpDTO(id,name,username,email,password,strRoles);
        ResponseMessenger check_existed = userController.register(signUpDTO);
        final String ANSI_RESET  =  "\u001B[0m";
        final String ANSI_YELLOW = "\u001B[33m";
        if(check_existed.getMessenger().equals("username existed")){
            System.err.println("username already exists. Please try again");
            formRegister();
        } else if (check_existed.getMessenger().equals("email existed")) {
            System.err.println("email already exists. Please try again");
            formRegister();
        }else if (check_existed.getMessenger().equals("success")){
            System.out.println(ANSI_YELLOW+ "create user success" + ANSI_RESET);
            System.out.println("check list => " + userController.showListUser());
            new Main();
        }
    }
    public void showListUser(){
        System.out.println(userController.showListUser());
    }
}

