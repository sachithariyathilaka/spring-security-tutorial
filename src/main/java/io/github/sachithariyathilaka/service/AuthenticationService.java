package io.github.sachithariyathilaka.service;

import io.github.sachithariyathilaka.entity.User;
import io.github.sachithariyathilaka.resource.request.UserRequest;

/**
 *Authentication service interface layer.
 *
 * @author  Sachith Ariyathilaka
 * @version 1.0.0
 * @since   2024/04/07
 */
public interface AuthenticationService {
    User registerUser(UserRequest userRequest);
}
