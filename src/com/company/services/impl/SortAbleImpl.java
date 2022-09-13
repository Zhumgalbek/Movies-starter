package com.company.services.impl;

import com.company.JsonIO;
import com.company.models.Movie;
import com.company.services.SortAble;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SortAbleImpl implements SortAble {
    private static Scanner in = new Scanner(System.in);

    @Override
    public void printAllMovies() {
        List<Movie> movies = JsonIO.getMovies();

        for (Movie i: movies) {
            System.out.println(i);
        }
    }

    @Override
    public void findMovie() {
        System.out.println("write movie name : ");
        String moveName = in.nextLine().trim();
        List<Movie> movies = JsonIO.getMovies();
        if (moveName.length()>0){
            for (Movie i :movies) {
                if (i.getName().toLowerCase().contains(moveName.toLowerCase())){
                    System.out.println("-----------------------------------");
                    System.out.println(i);
                }
            }
        }else {
            System.err.println("error");
        }

    }

    @Override
    public void sortByYear(int year) {
        List<Movie> movies = JsonIO.getMovies();

        boolean stiv=true;
        for (Movie i: movies) {


                    if (year == 1 ){

                        Comparator<Movie> comparator = new Comparator<Movie>() {

                            @Override
                            public int compare(Movie o1, Movie o2) {
                                return o2.getYear()- o1.getYear();
                            }
                        };
                        movies.sort(comparator);
                        for (Movie kol:movies) {
                            System.out.println("--------------------------------");
                            System.out.println(kol);
                        }

                    } if (year == 2 ) {

                        Comparator<Movie> comparator = new Comparator<Movie>() {

                            @Override
                            public int compare(Movie o1, Movie o2) {
                                return o1.getYear() - o2.getYear();
                            }
                        };
                        movies.sort(comparator);
                        for (Movie kol : movies) {
                            System.out.println("--------------------------------");
                            System.out.println(kol);
                        }

                    }



        }
    }

    @Override
    public void sortByName() {
        List<Movie> list = JsonIO.getMovies();
        System.out.println("from lower to higher '1' : ");
        System.out.println("high to low '2' :");
        int next = in.nextInt();
        if (next==1){
            Comparator<Movie> comparator = new Comparator<Movie>() {
                @Override
                public int compare(Movie o1, Movie o2) {
                    return o2.getName().compareTo(o1.getName());
                }
            };
            list.sort(comparator);
            for (Movie i:list) {
                System.out.println("-----------------------------");
                System.out.println(i);
            }
        }if (next==2){
            Comparator<Movie> comparator = new Comparator<Movie>() {
                @Override
                public int compare(Movie o1, Movie o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            };
            list.sort(comparator);
            for (Movie i:list) {
                System.out.println("-----------------------------");
                System.out.println(i);
            }
        }



    }

    @Override
    public void sortByDirector() {
        List<Movie> list = JsonIO.getMovies();
        System.out.println("from lower to higher '1' : ");
        System.out.println("high to low '2' :");
        int next = in.nextInt();


            if (next==1){
                Comparator<Movie> comparator = new Comparator<Movie>() {
                    @Override
                    public int compare(Movie o1, Movie o2) {
                        return o2.getDirector().getFullName().compareTo(o1.getDirector().getFullName());
                    }
                };
                list.sort(comparator);
                for (Movie i:list) {
                    System.out.println("-----------------------------");
                    System.out.println(i);
                }
            }if (next==2){
                Comparator<Movie> comparator = new Comparator<Movie>() {
                    @Override
                    public int compare(Movie o1, Movie o2) {
                        return o1.getDirector().getFullName().compareTo(o2.getDirector().getFullName());
                    }
                };
                list.sort(comparator);
                for (Movie i:list) {
                    System.out.println("-----------------------------");
                    System.out.println(i);
                }
            }



    }



}
