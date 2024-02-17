package app.services;

import app.util.Constants;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReadService {

    public String readFile(String filename){
        try(BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(Constants.BASE_PATH + filename)
                )
        )){
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null){
                stringBuilder
                        .append(line)
                        .append("\n");
            }
            return stringBuilder.toString();
        }catch (IOException e){
            return "Something went wrong: " + e.getMessage();
        }
    }

}
