package com.grupo5.Usuarios;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String username;
    private String password;

    public Usuario(String Username, String Password){
        setUsername(Username);
        setPassword(Password);
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
}
