package com.autoservice.desktop.data;

import lombok.Data;

@Data
public class OrderDto {
    private Long id;
    private String name;
    private String clientName;
    private String date;
    private String status;
}
