package compare;

import java.math.BigInteger;

/**
 * 质数类
 */
public class Primes {

    //错误率常量（1/2^100）
    private static final int ERR_VAL = 100;

    //计算下一个质数
    public static BigInteger nextPrime(BigInteger start){
        //是偶数+1，否则+2
        if (isEven(start)){
            start = start.add(BigInteger.ONE);
        }else {
            start = start.add(BigInteger.TWO);
        }
        //如果可能是质数（错误率为1/2^100）
        if (start.isProbablePrime(ERR_VAL)){
            return start;
        }else {
            //递归调用
            return nextPrime(start);
        }
    }

    //判断是否是偶数
    private static boolean isEven(BigInteger n){
        return n.mod(BigInteger.TWO).equals(BigInteger.ZERO);
    }


    //数字缓冲字符串
    private static StringBuffer[] digits ={
            new StringBuffer("0"),new StringBuffer("1"),
            new StringBuffer("2"),new StringBuffer("3"),
            new StringBuffer("4"),new StringBuffer("5"),
            new StringBuffer("6"),new StringBuffer("7"),
            new StringBuffer("8"),new StringBuffer("9")
    };

    //根据该位能否为0，给出数字缓冲字符串数组的随机数下标
    private static StringBuffer randomDigit(boolean isZeroOK){
        int index;
        if (isZeroOK){
            //<=某个数的最大整数（相当于[]）
            index = (int)Math.floor(Math.random() * 10);
        }else {
            index = 1 + (int)Math.floor(Math.random() * 9);
        }
        return digits[index];
    }

    //缓冲字符串拼接之后，转化为BigInteger数字
    public static BigInteger random(int numDigits){
        StringBuffer s = new StringBuffer("");
        for (int i=0;i<numDigits;i++){
            if (i == 0){
                s.append(randomDigit(false));
            }else {
                s.append(randomDigit(true));
            }
        }
        return new BigInteger(s.toString());
    }


    public static void main(String[] args) {
        int numDigits;
        try{
            numDigits = Integer.parseInt(args[0]);
        }catch (Exception e){
            numDigits = 150;
        }
        BigInteger start = random(numDigits);
        for (int i=0;i<50;i++){
            start = nextPrime(start);
            System.out.println("Prime " + i + " = " + start);
        }
    }
}
