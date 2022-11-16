package com.hug.jwt.service;

import com.hug.jwt.entities.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    public static List<User> userList = new ArrayList<User>();
    static {
        User userHug = new User(1,"Hug","1");
        userHug.setRoles(new String[]{"ROLE_ADMIN"});
        User userPutin = new User(2,"Putin","1");
        userHug.setRoles(new String[]{"ROLE_USER"});
        userList.add(userHug);
        userList.add(userPutin);
    }
    public List<User> fillAll(){
        return userList;
    }
    public User findById(int id){
        for (User user:userList) {
            if (user.getId()==id){
                return user;
            }
        }
        return null;
    }
    public boolean add(User user){
        for (User userEx:userList) {
            if (user.getId()==userEx.getId()|| StringUtils.equals(user.getUsername(),userEx.getUsername())){
                return false;
            }
        }
        userList.add(user);
        return true;
    }
    public void delete(int id){
        userList.removeIf(user -> user.getId()==id);
    }
    public User loadUserByUsername(String username){
        for (User user : userList) {
            if (user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }
    public boolean checkLogin(User user){
        for (User userEx:userList
             ) {
            if (StringUtils.equals(user.getUsername(),userEx.getUsername())&&
                    StringUtils.equals(user.getPassword(),userEx.getPassword())){
                return true;
            }
        }
        return false;
    }
}
