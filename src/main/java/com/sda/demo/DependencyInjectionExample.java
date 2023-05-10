package com.sda.demo;

import java.util.ArrayList;
import java.util.List;

public class DependencyInjectionExample {

    public static void main(String[] args) {
        //code to interface principle was used to create in memory repository of type UserRepository
        //this is a base for Dependency Injection that allows us to insert different implementations
        UserRepository repository = new InMemoryUserRepository();
        //Dependency injection using constructor
        UserService userService = new UserService(repository);

        //alternatively we could use setter for DI
//        userService.setUserRepository(repository);
        User user = new User("Jar-Jar","Bings");
        userService.save(user);
    }
}

class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    public void setUserRepository(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    public void save(User user) {
        userRepository.addUser(user);
    }
}

interface UserRepository {
    void addUser(User user);
}

record User(String firstName, String lastName) {}

class InMemoryUserRepository implements UserRepository {
    List<User> users = new ArrayList<>();

    @Override
    public void addUser(User user) {
        System.out.println("Adding User to Repository " + user);
        users.add(user);
    }
}