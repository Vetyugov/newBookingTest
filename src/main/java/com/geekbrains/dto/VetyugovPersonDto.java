package com.geekbrains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VetyugovPersonDto {
    private Long id;
    private String username;
    private Boolean isAdmin;
}
