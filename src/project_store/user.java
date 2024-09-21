package project_store;

public class user {

 
    private Integer id;
    private String username;
    private String password;
    private String role;   static DataBase db = new DataBase();

    public user(Integer id, String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.role = role;
    }

    public user() {
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Integer getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "user{" + "id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + '}';
    }

}
