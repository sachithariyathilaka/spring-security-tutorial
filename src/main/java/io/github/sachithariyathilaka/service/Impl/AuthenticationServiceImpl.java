package io.github.sachithariyathilaka.service.Impl;

import io.github.sachithariyathilaka.entity.User;
import io.github.sachithariyathilaka.repository.UserRepository;
import io.github.sachithariyathilaka.resource.request.UserRequest;
import io.github.sachithariyathilaka.service.AuthenticationService;
import io.github.sachithariyathilaka.util.JwtTokenUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

/**
 * Service implementation for the authentication service.
 *
 * @author  Sachith Ariyathilaka
 * @version 1.0.0
 * @since   2024/04/07
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;

    public AuthenticationServiceImpl(UserRepository userRepository,
                                     PasswordEncoder passwordEncoder,
                                     JwtTokenUtil jwtTokenUtil,
                                     AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenUtil = jwtTokenUtil;
        this.authenticationManager = authenticationManager;
    }

    /**
     * User registration service method.
     *
     * @param   userRequest the user request
     *
     * @return  the user
     */
    @Override
    public User registerUser(UserRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        return userRepository.saveAndFlush(user);
    }

    /**
     * User login service method.
     *
     * @param   userRequest the user request
     *
     * @return  the token
     */
    @Override
    public String userLogin(UserRequest userRequest) {
        Optional<User> optionalUser = userRepository.findByUsername(userRequest.getUsername());

        if (optionalUser.isPresent())
        {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userRequest.getUsername(), userRequest.getPassword()));

            HashMap<String, Object> claims = new HashMap<>();
            claims.put("user", optionalUser.get());

            return jwtTokenUtil.generateToken(claims, optionalUser.get().getUsername());
        } else
            return null;
    }
}
