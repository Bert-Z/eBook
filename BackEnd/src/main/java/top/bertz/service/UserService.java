package top.bertz.service;

public interface UserService {

    public void signup(String username,String password,String email);
    public int signin(String username,String password);
}
