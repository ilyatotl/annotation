package org.example;

import lombok.Data;
import org.annotation.Published;

import java.time.LocalDate;
import java.time.Period;

@Data
public class Person {
    @Published
    public final String firstName;
    @Published
    private final String lastName;
    @Published
    private final LocalDate birthDate;

    int getAge(){
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}
