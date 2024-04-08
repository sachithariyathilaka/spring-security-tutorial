package io.github.sachithariyathilaka.service.Impl;

import io.github.sachithariyathilaka.entity.User;
import io.github.sachithariyathilaka.repository.UserRepository;
import io.github.sachithariyathilaka.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for the user service.
 *
 * @author  Sachith Ariyathilaka
 * @version 1.0.0
 * @since   2024/04/07
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Load all users from the database.
     *
     * @return  the users list
     */
    @Override
    public List<User> loadUsers() {
        return userRepository.findAll();
    }
}
