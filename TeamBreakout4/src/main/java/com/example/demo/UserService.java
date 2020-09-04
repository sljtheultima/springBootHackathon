package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class UserService {

    @Autowired
    private UserRepository repository;

    @Value("#{userlist}")
    private Map<Integer, User> userlist;

    public void addUser(String username, String password, String fullname) {
        if (!userlist.containsKey(id)) {
            repository.add(id, username, password, fullname);
        }
    }

    public void removeUser(int id) {
        if (userlist.containsKey(id)) {
            repository.remove(id);
        }
    }

    public Map<Integer, User> getAllUsers() {
        return repository.getAll();
    }


}
