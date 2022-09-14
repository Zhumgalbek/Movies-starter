package com.company.services.impl;

import com.company.JsonIO;
import com.company.models.Cast;
import com.company.models.Movie;
import com.company.services.FindAble;

import java.util.*;

public class FindAbleImpl implements FindAble {

    private static Scanner in= new Scanner(System.in);

    @Override
    public void findMoviesByActor() {
        List<Movie> movies = JsonIO.getMovies();
        System.out.println("write castName name : ");
        String actorName = in.nextLine().trim();
        for (int i = 0; i <JsonIO.getMovies().size() ; i++) {
            for (int j = 0; j < movies.get(i).getCast().size(); j++) {
                if (JsonIO.getMovies().get(i).getCast().get(j).getFullName().toUpperCase().equals(actorName.toUpperCase())
                || JsonIO.getMovies().get(i).getCast().get(j).getFullName().toLowerCase().contains(actorName.toLowerCase())){
                    System.out.println("Movies : " +JsonIO.getMovies().get(i).getName());
                    System.out.println("\nActor name : "+JsonIO.getMovies().get(i).getCast().get(j).getFullName());
                }
            }


        }
    }



    @Override
    public void findMoviesByDirector() {
        List<Movie> movies = JsonIO.getMovies();
        System.out.println("write castName name : ");
        String actorName = in.nextLine().trim();
        for (int i = 0; i <movies.size() ; i++) {
            for (int j = 0; j < movies.get(i).getDirector().getFullName().length(); j++) {
                if (movies.get(i).getDirector().getFullName().toUpperCase().equals(actorName.toUpperCase())
                        || movies.get(i).getDirector().getFullName().toLowerCase().contains(actorName.toLowerCase())){
                    System.out.println("\nMovies : " +movies.get(i).getName());
                    System.out.println("Actor director : "+movies.get(i).getDirector().getFullName());
                    break;
                }
            }


        }
    }

    @Override
    public void findMoviesByYear() {
        List<Movie> movies = JsonIO.getMovies();
        System.out.print("Введите год выхода Movies :");
        int year = in.nextInt(), i=0;
        for (Movie m:movies) {
            if (movies.get(i).getYear()==year){
                System.out.println(m);
            }
            i++;

        }

    }

    @Override
    public void findMoviesAndRoleByActor() {
        List<Movie> movies = JsonIO.getMovies();
        System.out.print("Введите имя Actor :");
        String name = in.nextLine();

        for (int i = 0; i < movies.size(); i++) {
                for (int j = 0; j < movies.get(i).getCast().size(); j++) {
                    if (movies.get(i).getCast().get(j).getFullName().equals(name)
                            || movies.get(i).getCast().get(j).getFullName().contains(name)) {
                        System.out.println("\nActor : " + movies.get(i).getCast().get(j).getFullName());
                        System.out.println("Move : " + movies.get(i).getName());
                        System.out.println("Role: "+movies.get(i).getCast().get(j).getRole());
                    }
                }

        }



    }

    @Override
    public void showActorRoles() {
        List<Movie> movies = JsonIO.getMovies();
        TreeSet<Cast> treeSet = new TreeSet<>();
        System.out.println("from lower to higher '1' : ");
        System.out.println("high to low '2' :");
        String number = in.nextLine();

        for (int i = 0; i < movies.size(); i++) {
            treeSet.addAll( JsonIO.getMovies().get(i).getCast());
        }
        if (number.charAt(0)=='2') {
            for (Cast cast : treeSet) {
                System.out.println("__________________________________________");
                System.out.println("actor name : "+cast.getFullName());
                for (int i = 0; i < movies.size(); i++) {
                    for (int j = 0; j < movies.get(i).getCast().size(); j++) {
                        if (cast.getFullName().equals(movies.get(i).getCast().get(j).getFullName())){
                            System.out.println("movies name : "+movies.get(i).getName());
                            System.out.println("role : "+movies.get(i).getCast().get(j).getRole());
                        }
                    }
                }
            }

        }
        TreeSet<Cast> castTreeSet = (TreeSet<Cast>) treeSet.descendingSet();
        if (number.charAt(0)=='1'){
            for (Cast cast: castTreeSet) {
                System.out.println("__________________________________________");
                System.out.println("actor name : "+cast.getFullName());
                for (int i = 0; i < movies.size(); i++) {
                    for (int j = 0; j < movies.get(i).getCast().size(); j++) {
                        if (cast.getFullName().equals(movies.get(i).getCast().get(j).getFullName())){
                            System.out.println("movies name : "+movies.get(i).getName());
                            System.out.println("role : "+movies.get(i).getCast().get(j).getRole());
                        }
                    }
                }
            }

        }


    }
}











