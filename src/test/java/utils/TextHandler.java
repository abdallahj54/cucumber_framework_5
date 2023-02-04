package utils;

public class TextHandler {

    public static int getInt(String str){
        return Integer.parseInt(str.replaceAll("[^0-9]", ""));
    }
}
