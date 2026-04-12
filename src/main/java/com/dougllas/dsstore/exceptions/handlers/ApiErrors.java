package com.dougllas.dsstore.exceptions.handlers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiErrors {

    private Instant timestamp;
    private Integer status;
    private String message;
    private String path;

}
