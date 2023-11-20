package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

public class Main {
    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Heute ist: " + localDateTime);
        //Add a timespan of 2 weeks to the current date and output the new date.
        long weeks = 2;
        System.out.println(localDateTime.plusWeeks(weeks));

        //Compare the current date with a specified future date and output whether the current date is before or after the specified date.
        //methode zum Datum eingeben:
        LocalDate futureDate=datumEingabe();
        LocalDate currentDate=LocalDate.now();
        //compare the dates
        compareTheDates(currentDate,futureDate);
        //Calculate the difference in days between two arbitrary dates and output the result
        LocalDate date1=LocalDate.of(1975,11,20);
        LocalDate date2=LocalDate.of(2023,11,20);
        System.out.println("Es sind : " +calculateDays(date1, date2)+" Tage vergangen");
        //Create an instance of the Animal class
        Animal dogJosie = Animal.builder().
                name("Josie").
                birthDate(LocalDate.of(2022,10,25)).build();
        System.out.println(dogJosie);
        LocalDate nextBirthdate=dogJosie.getBirthDate().plusYears(1);
        long daysUntilBirthday=ChronoUnit.DAYS.between(LocalDate.now(),nextBirthdate);
        if(daysUntilBirthday<0){
            System.out.println(365+daysUntilBirthday);
        }
        else if(daysUntilBirthday==0){
            System.out.println(daysUntilBirthday);
        }




    }
    private static LocalDate datumEingabe () {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Geben Sie ein Datum im Format dd.MM.yyyy ein: ");
        String dateString = scanner.nextLine();
        LocalDate lDate=LocalDate.now();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

        try {
            Date date = dateFormat.parse(dateString);
            System.out.println("Eingegebenes Datum: " + dateFormat.format(date));
            lDate = date.toInstant().atZone(TimeZone.getDefault().toZoneId()).toLocalDate();

        } catch (ParseException e) {
            System.out.println("Fehler beim Parsen des Datums: " + e.getMessage());
        } finally {
            scanner.close();
            return lDate;
        }

    }
    private static void compareTheDates(LocalDate current,LocalDate future){
        int result=current.compareTo(future);
        if (result<0){
            System.out.println(current+" ist vor " + future);
        }
        else if(result==0){
            System.out.println(current + " ist gleich mit " + future);
        } else {
            System.out.println(current + " ist nach " + future);
        }
    }
    //Calculate the difference in days between two arbitrary dates and output the result
    private static long calculateDays(LocalDate date1,LocalDate date2){
        return ChronoUnit.DAYS.between(date1,date2);
    }
}