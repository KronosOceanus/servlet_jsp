package servlets;

public class ServletUtils {

    public static final String DOCTYPE = "<!DOCTYPE html>";
    public static String headWith(String title){
        return "<html><head><meta charset=\"UTF-8\">" +
                "<title>" + title + "</title></head>";
    }

}
