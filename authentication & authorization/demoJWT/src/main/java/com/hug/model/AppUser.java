package com.hug.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = {"roles", "authorities"})
public class AppUser {

    private int id;
    private String username;
    private String password;
    private String[] roles;

    public AppUser() {
    }

    public AppUser(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public List<GrantedAuthority> getAuthorities(){
        List<GrantedAuthority> authorities =new ArrayList<GrantedAuthority>();
        for (String role : roles
             ) {
            authorities.add(new SimpleGrantedAuthority(role));

        }
        return authorities;
    }
}
