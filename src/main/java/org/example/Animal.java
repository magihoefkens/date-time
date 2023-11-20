package org.example;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
@Data
@Builder
public class Animal {
    String name;
    LocalDate birthDate;

}
