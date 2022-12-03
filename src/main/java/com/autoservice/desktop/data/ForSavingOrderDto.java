package com.autoservice.desktop.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ForSavingOrderDto {
    private String name;
    private Long clientId;
    private String date;
}