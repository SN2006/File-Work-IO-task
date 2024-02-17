package app.services;

import app.util.Constants;

import java.io.File;

public class DeleteFileService {

    public String deleteFile(String filename){
        File file = new File(Constants.BASE_PATH + filename);
        if (!file.exists()){
            return "There is no file with that name";
        }
        if (file.delete()){
            return "File was deleted";
        }else{
            return "Failed to delete file";
        }
    }

}
