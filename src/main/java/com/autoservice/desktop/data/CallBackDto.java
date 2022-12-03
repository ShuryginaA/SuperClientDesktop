package com.autoservice.desktop.data;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class CallBackDto {
    private String name;
    private String phone;
    private String comment;
}
