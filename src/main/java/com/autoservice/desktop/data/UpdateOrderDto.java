package com.autoservice.desktop.data;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class UpdateOrderDto {
    private Long id;
    private String newDateAndTime;
}