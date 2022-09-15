package com.company;

import com.company.services.impl.FindAbleImpl;
import com.company.services.impl.SortAbleImpl;

import java.util.Scanner;
public class Main {

     static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

logika();

    }


    static void commands() {
        System.out.println("\n--------------Commands-----------------------");
        System.out.println("Press 1 to print catalog");
        System.out.println("Press 2 to Find a Movie by full or part name");
        System.out.println("Press 3 to sort by year");
        System.out.println("Press 4 to sort by name");
        System.out.println("Press 5 to sort by director");
        System.out.println("Press 6 to find movies by actor's name");
        System.out.println("Press 7 to find movies by director's name");
        System.out.println("Press 8 to find movies by year");
        System.out.println("Press 9 to List all movies and roles by actor's name");
        System.out.println("Press 10 to sorted List of all actors with his roles");
        System.out.println("---------------------------------------------");
    }
    static String button(){
        System.out.print("Choose a command: ");
        return scanner.nextLine();
    }
    static  void logika() {
        Scanner scanner = new Scanner(System.in);
        SortAbleImpl sortAble = new SortAbleImpl();
        FindAbleImpl findAble = new FindAbleImpl();
        String number = "l";

        while (!number.equals("x")) {
            commands();
            System.err.print("\nВыберите цифру от 1 до 10 (если хотите остонавить нажмите 'х') :");
            number = scanner.nextLine();
            try {


                if (Character.isDigit(number.charAt(0))) {
                    switch (number) {
                        case "1" -> sortAble.printAllMovies();
                        case "2" -> sortAble.findMovie();
                        case "3" -> sortByYear();
                        case "4" -> sortAble.sortByName();
                        case "5" -> sortAble.sortByDirector();
                        case "6" -> findAble.findMoviesByActor();
                        case "7" -> findAble.findMoviesByDirector();
                        case "8" -> findAble.findMoviesByYear();
                        case "9" -> findAble.findMoviesAndRoleByActor();
                        case "10" -> findAble.showActorRoles();
                    }
                } else{
                    throw new RuntimeException();
                }
            }catch (RuntimeException e){

            }
        }
    }
    static void sortByYear(){
        SortAbleImpl sortAble = new SortAbleImpl();
        System.out.println("from lower to higher '1' : ");
        System.out.println("high to low '2' :");
        sortAble.sortByYear(scanner.nextInt());
    }
}
