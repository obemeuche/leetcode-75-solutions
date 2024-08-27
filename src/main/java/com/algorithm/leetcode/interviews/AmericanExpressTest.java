package com.algorithm.leetcode.interviews;

import java.util.HashMap;
import java.util.Map;

public class AmericanExpressTest {
    public static void main(String[] args) {
        Map<String, Integer> userIds = Map.of("adam", 12345, "nick", 67890, "bob", 666);

        String[][] datesOfBirth = {{"67890", "01/06"}, {"12345", "09/10"}};
        /* * Given the above data structures, merge them on ID and log out
         * * the merged data in the following structure:
         * * [{ "name": "adam", "id": "12345", dateOfBirth: "09/10" }, ...] */

        //create a person object with attributes, id, name, dateOfBirth
        //initialize a map object to take in String id and person

        Map<String, Person> map = new HashMap<>();

        for (String name : userIds.keySet()) {
            Person person = new Person();
            person.name = name;
            person.id = String.valueOf(userIds.get(name));
            map.put(person.id, person);
        }

        System.out.println("Before: " + map);
        for (String[] date : datesOfBirth) {
            Person person = map.get(date[0]);
            if (person != null) {
                person.dateOfBirth = date[1];
            }
    }

        System.out.println("After: "+map);
}


static class Person {
    String id;
    String name;
    String dateOfBirth;

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
}
