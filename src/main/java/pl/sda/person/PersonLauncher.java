package pl.sda.person;

import java.util.Arrays;
import java.util.Random;

public class PersonLauncher {

    public static void main(String[] args) {

        Person first = new Person("Jan", getRandomAge(), "Mechanik");
        Person second = new Person("Jacek", getRandomAge(), "Lekarz");
        Person third = new Person("Maria", getRandomAge(), "Nauczyciel");
        Person fourth = new Person("Joanna", getRandomAge(), "Analityk");
        Person fifth = new Person("Pawel", getRandomAge(), "Barman");

        Person[] people = {first, second, third, fourth, fifth};
        display(people);

        Person youngest = findYoungestPerson(people);
        System.out.println("\n*********\nNajmlodsza osoba jest: " + youngest);

        Person oldest = findOldestPerson(people);
        System.out.println("\n*********\nNajstarsza osoba jest: " + oldest);

        int totalAge = calculateTotalAge(people);
        System.out.println("\n*********\nOsoby maja w sumie: " + totalAge + " lat");

        double averageAge = calculateAverageAge(people);
        System.out.printf("\n*********\nOsoby maja średnio %.2f lat", averageAge);
    }

    private static void display(Person[] people) {
        System.out.println(Arrays.toString(people));
    }

    private static Person findYoungestPerson(Person[] people) {
        Person youngest = people[0];

        for (int i = 1; i < people.length; ++i) {
            Person current = people[i];
            if (current.getAge() < youngest.getAge()) {
                youngest = current;
            }
        }
        return youngest;
    }

    private static Person findOldestPerson(Person[] people) {
        Person oldest = people[0];

        for (int i = 1; i < people.length; ++i) {
            Person current = people[i];
            if (current.getAge() > oldest.getAge()) {
                oldest = current;
            }
        }
        return oldest;
    }

    private static int calculateTotalAge(Person[] people) {
        int result = 0;
        for (Person person : people) {
            result += person.getAge();
        }
        return result;
    }

    private static double calculateAverageAge(Person[] people) {
        double sum = calculateTotalAge(people);
        return sum / people.length;
    }

    private static int getRandomAge() {
        Random random = new Random();
        return random.nextInt(100);
    }

}
