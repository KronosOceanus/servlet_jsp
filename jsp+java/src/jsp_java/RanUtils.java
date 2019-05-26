package jsp_java;

public class RanUtils {

    public static int randomInt(int range){
        return 1 + (int) (Math.random() * range);
    }

    //测试
    public static void main(String[] args){
        int range = 10;
        try{
            range = Integer.parseInt(args[0]);
        }catch (Exception ignored){

        }
        for(int i=0;i<100;i++){
            System.out.println(randomInt(range));
        }
    }
}
