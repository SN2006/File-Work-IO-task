package app.services;

import app.util.Constants;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriteService {

    public String handleFile(String text, String filename){
        try (FileOutputStream fileOutputStream =
                new FileOutputStream(Constants.BASE_PATH + filename)){
            byte[] byteArray = text.getBytes();
            fileOutputStream.write(byteArray);
        }catch (IOException e){
            return "Something went wrong: " + e.getMessage();
        }
        return "Success!";
    }

}
