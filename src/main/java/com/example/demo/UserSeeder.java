package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.models.User;
import com.example.repository.UserRepository;

@Component
public class UserSeeder implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            userRepository.save(new User(null, "Alice", "alice@example.com", "alice", true, 25));
            userRepository.save(new User(null, "Bob", "bob@example.com", "bob", true, 30));
            userRepository.save(new User(null, "Charlie", "charlie@example.com", "charlie", false, 22));
        }
    }
}
