package com.tayfun.springhibernateenversexample.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    private Long id;
    private String name;
    private String username;
}
