package com.dust.ms.user.interfaces.dto;

public class UserRegisterParam {
    private String username;
    private String email;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*
     * @Author MaKunPeng
     * @Description //TODO
     * @Date 21:23 2020/5/11
     * @Param []
     * @return java.lang.String
     * @throws
     **/
    @Override
    public String toString() {
        return "UserRegisterParam{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
