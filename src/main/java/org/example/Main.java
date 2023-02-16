package org.example;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Person p = new Person("Ivan", "Ivanov", LocalDate.of(2000, 12, 12));
        JSONObject json = new JsonSerializer<>(Person.class).serialize(p);
        System.out.println(json);
    }
}