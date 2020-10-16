package com.tecnara_enterprise.modelos;

public class Login {
    private String name;
    private boolean loggedIn;

    public Login(String name, boolean logged){
        this.name = name;
        this.loggedIn = logged;
    }

    public String getName() {
            return name;
    }

    public void setName(String name) {
            this.name = name;
    }

    public boolean isLoggedIn() {
            return loggedIn;
    }
    public void setLoggedIn(boolean loggedIn) {
            this.loggedIn = loggedIn;
    }
}

