package com.autoservice.desktop.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginForm {

    private String username;

    private String password;
}
