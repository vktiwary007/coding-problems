package com.vivekasu;

import java.util.*;

public class Favoritegenre {

    public static void main(String[] args){
        Map<String, List<String>> userSongs = new HashMap<>();
        Map<String, List<String>> songGenres = new HashMap<>();
        String[] song1 = {"song1", "song2", "song3", "song4", "song8"};
        String[] song2 = {"song5", "song6", "song7"};

        String[] genre1 = {"song1", "song3"};
        String[] genre2 = {"song7"};
        String[] genre3 = {"song2", "song4"};
        String[] genre4 = {"song5", "song6"};
        String[] genre5 = {"song8", "song9"};

        userSongs.put("David", Arrays.asList(song1));
        userSongs.put("Emma", Arrays.asList(song2));

        songGenres.put("Rock", Arrays.asList(genre1));
        songGenres.put("Dubstep",Arrays.asList(genre2));
        songGenres.put("Techno", Arrays.asList(genre3));
        songGenres.put("Pop", Arrays.asList(genre4));
        songGenres.put("Jazz", Arrays.asList(genre5));

        Map<String, List<String>> favoritegenre = getfavoritegenre(userSongs, songGenres);
        for(String user:favoritegenre.keySet()){

            for(String genre: favoritegenre.get(user)){
                System.out.println(user+ "::"+genre);
            }
        }

    }

    public static Map<String, List<String>> getfavoritegenre(Map<String, List<String>> userSongs, Map<String, List<String>> songGenres){
        Map<String, List<String>> userfavoritegenres = new HashMap<>();

        Map<String, String> songgenre = new HashMap<>();

        for(String genre: songGenres.keySet()){
            for(String song: songGenres.get(genre)){
                songgenre.put(song,genre);
            }
        }


        for(String user: userSongs.keySet()){
            int maxcount = 0;
            HashMap<String, Integer> hm = new HashMap<>();
            for(String song:userSongs.get(user)){
                String genre = songgenre.get(song);
                if(!hm.containsKey(genre)){
                    hm.put(genre,1);
                }
                else{
                    hm.put(genre, hm.get(genre)+1);
                }
                if(hm.get(genre)>maxcount){
                    maxcount = hm.get(genre);
                }
            }

            List<String> genres = new ArrayList<>();
            for(String genre:hm.keySet()){
                if(hm.get(genre)>1 && maxcount==hm.get(genre))
                    genres.add(genre);
            }
            userfavoritegenres.put(user,genres);
        }

        return  userfavoritegenres;
    }
}
