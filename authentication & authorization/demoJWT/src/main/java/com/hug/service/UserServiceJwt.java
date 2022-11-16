package com.hug.service;

import com.hug.model.AppUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceJwt {
    public static List<AppUser> listUser = new ArrayList<AppUser>();
    static {
        AppUser userKai = new AppUser(1, "kai", "123456");
        userKai.setRoles(new String[] { "ROLE_ADMIN" });
        AppUser userSena = new AppUser(2, "sena", "123456");
        userSena.setRoles(new String[] { "ROLE_USER" });
        listUser.add(userKai);
        listUser.add(userSena);
    }
    public List<AppUser> findAll() {
        return listUser;
    }
    public AppUser findById(int id) {
        for (AppUser user : listUser) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }
    public boolean add(AppUser user) {
        for (AppUser userExist : listUser) {
            if (user.getId() == userExist.getId() || StringUtils.equals(user.getUsername(), userExist.getUsername())) {
                return false;
            }
        }
        listUser.add(user);
        return true;
    }
    public void delete(int id) {
        listUser.removeIf(user -> user.getId() == id);
    }
    public AppUser loadUserByUsername(String username) {
        for (AppUser user : listUser) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
    public boolean checkLogin(AppUser user) {
        for (AppUser userExist : listUser) {
            if (StringUtils.equals(user.getUsername(), userExist.getUsername())
                    && StringUtils.equals(user.getPassword(), userExist.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
