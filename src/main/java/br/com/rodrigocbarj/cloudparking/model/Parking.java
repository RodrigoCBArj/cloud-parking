package br.com.rodrigocbarj.cloudparking.model;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class Parking {

    private Long id;
    private String licence;
    private String state;
    private String model;
    private String color;
    private LocalDateTime entryDate;
    private LocalDateTime exitDate;
    private Double bill;
}
