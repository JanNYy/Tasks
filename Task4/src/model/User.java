package model;

/**
 * Created by Anna Oliinyk
 *
 * Model for table user in DB
 *
 * @author Anna Oliinyk
 */
public class User {

    private int userID;
    private String login;
    private String password;
    private Role role;

    public enum Role {
        ADMIN(0),
        CLIENT(1);

        private int roleValue;

        Role(int val) {
            roleValue = val;
        }

        public int getRoleValue() {
            return roleValue;
        }
    }

    public User() {

    }

    public User(int userID, String login, String password, int role) {
        this.userID = userID;
        this.login = login;
        this.password = password;
        this.role = Role.values()[role];
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = Role.values()[role];
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
