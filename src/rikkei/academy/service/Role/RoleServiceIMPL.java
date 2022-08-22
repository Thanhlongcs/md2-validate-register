package rikkei.academy.service.Role;

import rikkei.academy.model.Role;
import rikkei.academy.model.RoleName;
import rikkei.academy.service.Role.IRoleService;

import java.util.ArrayList;
import java.util.List;

public class RoleServiceIMPL implements IRoleService {
    public  static List<Role> roleList = new ArrayList<>();
    static {
        roleList.add(new Role(1,RoleName.PM));
        roleList.add(new Role(2,RoleName.USER));
        roleList.add(new Role(3,RoleName.ADMIN));
    }
    @Override
    public List<Role> findAll() {
        return roleList;
    }

    @Override
    public Role findByName(RoleName name) {
        for (int i = 0; i < roleList.size(); i++) {
            if(name==roleList.get(i).getName()){
                return roleList.get(i);
            }
        }
        return null;
    }
}
