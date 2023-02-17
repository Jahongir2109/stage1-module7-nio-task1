package com.epam.mjc.nio;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Map<String, String> map=new HashMap<>();
        String str;
        try(InputStream inputStream=new FileInputStream(file)) {
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            while (bufferedReader.ready()){
                str=bufferedReader.readLine();
                map.put(str.substring(0,str.indexOf(": ")),str.substring(str.indexOf(": ")+2));
            }
        } catch (IOException e) {
            throw new MyCustomException(e.getMessage());
        }
        return new Profile(map.get("Name"),Integer.valueOf(map.get("Age")),map.get("Email"),Long.valueOf(map.get("Phone")));
    }
}
