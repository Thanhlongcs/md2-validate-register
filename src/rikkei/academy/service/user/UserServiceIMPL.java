package rikkei.academy.service.user;

import rikkei.academy.config.Config;
import rikkei.academy.model.User;

import java.util.List;

public class UserServiceIMPL implements IUserService{
    public static String PATH_USER = "C:\\Users\\THINKPAD\\IdeaProjects\\md2-demo-validate\\src\\rikkei\\academy\\database\\user.txt";
    public static List<User> userList = new Config<User>().readFile(PATH_USER);
    @Override
    public List<User> findAll() {
        new Config<User>().writeFile(PATH_USER, userList);
        return userList;
    }

    @Override
    public void save(User user) {
        userList.add(user);

    }

    @Override
    public boolean existedByUsername(String username) {
        for (int i = 0; i < userList.size(); i++) {
            if (username.equals(userList.get(i).getUsername())) {
                return true;
            }
        }
           return false;
        }

    @Override
    public boolean existedByEmail(String email) {
        for (int i = 0; i < userList.size(); i++){
            if (email.equals(userList.get(i).getEmail())) {
                return true;
            }
        }
        return false;
    }
}
