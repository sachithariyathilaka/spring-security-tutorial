package io.github.sachithariyathilaka.resource.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Response class for the api response.
 *
 * @author  Sachith Ariyathilaka
 * @version 1.0.0
 * @since   2024/04/07
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class APIResponse<Object> {

    private int code;
    private String message;
    private Object data;
}
