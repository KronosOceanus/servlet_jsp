package http2;

public class ServletUtils {

    public static final String DOCTYPE = "<!DOCTYPE html>";

    public static String headWith(String title){
        return "<html><head><meta charset=\"UTF-8\">" +
                "<title>" + title + "</title></head>";
    }

    /**
     * 使用HTML实体替换HTML特殊字符
     * 字符串高效复制到过滤后的版本
     */
    public static String filter(String input){
        if(! hasSpecialChars(input)){
            return input;
        }
        StringBuffer filtered = new StringBuffer(input.length());
        char c;
        for(int i=0;i<input.length();i++){
            c = input.charAt(i);
            switch(c){
                case '>':filtered.append("&gt");break;
                case '<':filtered.append("&lt");break;
                case '"':filtered.append("&quot");break;
                case '&':filtered.append("&amp");break;
                default:filtered.append(c);
            }
        }
        return filtered.toString();
    }

    //判断字符串是否含有HTML特殊字符
    private static boolean hasSpecialChars(String input){
        boolean flag = false;
        if((input != null) && (input.length())> 0){
            for(int i=0;i<input.length();i++) {
                switch (input.charAt(i)) {
                    case '>': flag = true;break;
                    case '<': flag = true;break;
                    case '"': flag = true;break;
                    case '&': flag = true;break;
                }
            }
        }
        return flag;
    }
}
