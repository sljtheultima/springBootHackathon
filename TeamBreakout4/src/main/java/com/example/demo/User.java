package demo;

public class User{

    private String username;
    private String password;
    private String fullname;

    public User(String username, String password, String fullname){
        this.username = username;
        this.password = password;
        this. fullname = fullname;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullname(){
        return fullname;
    }
}