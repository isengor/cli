package ru.fls;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = Main.class.getResourceAsStream("/test.json");
        try {
            Map jsonMap = mapper.readValue(is, Map.class);   //java.util.LinkedHashMap
            Set<String> rmKeySet = new HashSet<>();
            rmKeySet

            jsonMap.keySet().removeAll(rmKeySet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
