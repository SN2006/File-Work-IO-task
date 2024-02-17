package app;

import app.services.DeleteFileService;
import app.services.FileReadService;
import app.services.FileWriteService;

import java.util.Scanner;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        getOutput(getData());
    }

    public static String getData(){
        String selectedAction = selectAction();
        String filename, text;
        switch (selectedAction){
            case "1" -> {
                filename = getFilename();
                text = getText();
                return new FileWriteService().handleFile(text, filename + ".txt");
            }
            case "2" -> {
                filename = getFilename();
                return new FileReadService().readFile(filename + ".txt");
            }
            case "3" -> {
                filename = getFilename();
                return new DeleteFileService().deleteFile(filename + ".txt");
            }
            default -> {
                return "You have chosen a non-existent option!";
            }
        }
    }

    public static String selectAction(){
        System.out.println("""
                ----------------------------------
                Select an action:
                1 - create and write data to file
                2 - read data from file
                3 - delete file by filename
                ----------------------------------
                """);
        return SCANNER.nextLine();
    }

    private static String getFilename(){
        System.out.println("Input file name: ");
        return SCANNER.nextLine();
    }

    private static String getText(){
        System.out.println("Enter you text: ");
        return SCANNER.nextLine();
    }

    private static void getOutput(String output) {
        System.out.println(output);
    }
}
