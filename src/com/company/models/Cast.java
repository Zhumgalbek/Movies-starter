package com.company.models;

import java.util.Comparator;

public class Cast implements Comparable<Cast> {

    private String fullName;
    private String role;

    public String getFullName()
    {
        return fullName;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return
                "\nfullName - " + fullName + '\'' +
                "\nrole - " + role ;
    }
    Comparator<Movie> comparator = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            int i=-1;
            i++;
            return o1.getCast().get(i).getFullName().compareTo(o2.getCast().get(i).getFullName());
        }
    };


    @Override
    public int compareTo(Cast o) {
        return this.getFullName().compareTo(o.getFullName());
    }
}
