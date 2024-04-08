package io.github.sachithariyathilaka.controller;

import io.github.sachithariyathilaka.entity.User;
import io.github.sachithariyathilaka.resource.response.APIResponse;
import io.github.sachithariyathilaka.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller layer for the user module.
 *
 * @author  Sachith Ariyathilaka
 * @version 1.0.0
 * @since   2024/04/07
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * User load get rest api.
     *
     * @return  the api response
     */
    @GetMapping("/")
    public ResponseEntity<APIResponse<List<User>>> loadUsers() {
        APIResponse<List<User>> apiResponse = new APIResponse<>(
                200,
                "Users loaded successfully!",
                userService.loadUsers());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
