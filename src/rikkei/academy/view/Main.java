package rikkei.academy.view;

import rikkei.academy.config.Config;
import rikkei.academy.service.Role.RoleServiceIMPL;

public class Main {
    public  Main(){
        new RoleServiceIMPL().findAll();
        System.out.println( new RoleServiceIMPL().findAll());
        System.out.println("1.register");
        int chooseMenu = Config.scanner().nextInt();
        switch (chooseMenu) {
            case 1:
                new ViewUser().formRegister();
                break;

        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
