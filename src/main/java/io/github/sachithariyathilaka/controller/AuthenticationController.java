package io.github.sachithariyathilaka.controller;

import io.github.sachithariyathilaka.entity.User;
import io.github.sachithariyathilaka.resource.request.UserRequest;
import io.github.sachithariyathilaka.resource.response.APIResponse;
import io.github.sachithariyathilaka.service.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller layer for the authentication module.
 *
 * @author  Sachith Ariyathilaka
 * @version 1.0.0
 * @since   2024/04/07
 */
@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    /**
     * User registration post rest api.
     *
     * @param   userRequest the user request
     *
     * @return  the api response
     */
    @PostMapping("/register")
    public ResponseEntity<APIResponse<Long>> registerUser(@RequestBody UserRequest userRequest) {
        User user = authenticationService.registerUser(userRequest);
        APIResponse<Long> apiResponse = new APIResponse<>(200, "User successfully registered! You can now log in to the system.", user.getId());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
