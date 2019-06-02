package com.javarush.task.task14.task1414;

/* 
MovieFactory
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String ganre;
        Movie movie;

        while (true) {
            ganre = buffer.readLine();

            movie = MovieFactory.getMovie(ganre);

            if ( ! (ganre.equals("soapOpera") ||
                    ganre.equals("thriller") || ganre.equals("cartoon") ) ) {
                break;
            }

            System.out.println(movie.getClass().getSimpleName());
        }
    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            } else if ("thriller".equals(key)) {
                movie = new Thriller();
            } else if ("cartoon".equals(key)) {
                movie = new Cartoon();
            }

            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    static class Cartoon extends Movie {
    }

    static class Thriller extends Movie {
    }
}
