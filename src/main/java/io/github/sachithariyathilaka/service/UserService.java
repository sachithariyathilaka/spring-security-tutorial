package io.github.sachithariyathilaka.service;

import io.github.sachithariyathilaka.entity.User;
import io.github.sachithariyathilaka.resource.request.UserRequest;

import java.util.List;

/**
 * User service interface layer.
 *
 * @author  Sachith Ariyathilaka
 * @version 1.0.0
 * @since   2024/04/07
 */
public interface UserService {
    List<User> loadUsers();
}
