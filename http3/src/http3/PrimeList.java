package http3;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * 处理后台线程
 * 为指定的一组值创建质数列表
 */
public class PrimeList implements Runnable{

    //储存质数的集合
    private ArrayList<BigInteger> primesFound;
    //公钥个数，位数
    private int numPrimes, numDigits;

    //初始化并启动线程
    public PrimeList(int numPrimes, int numDigits,
                     boolean runInBackground){
        //设置了质数集合的大小
        primesFound = new ArrayList<>(numPrimes);
        this.numPrimes = numPrimes;
        this.numDigits = numDigits;
        //后台线程
        if (runInBackground){
            Thread t = new Thread( this);
            t.setPriority(Thread.MIN_PRIORITY);
            t.start();
        }else {
            run();
        }
    }

    public void run(){
        //随机获取一个numDigits位的大数字
        BigInteger start = Primes.random(numDigits);
        for (int i=0;i<numPrimes;i++){
            //寻找数字之后的质数
            start = Primes.nextPrime(start);
            synchronized (this){
                //添加到集合
                primesFound.add(start);
            }
        }
    }

    //公钥集合被填满
    public synchronized boolean isDone(){
        return primesFound.size() == numPrimes;
    }

    public synchronized ArrayList getPrimes(){
        if (isDone()){
            return primesFound;
        }else {
            return (ArrayList)primesFound.clone();
        }
    }

    public int numDigits(){
        return numDigits;
    }

    public int numPrimes(){
        return numPrimes;
    }

    public synchronized  int numCalculatePrimes(){
        return primesFound.size();
    }
}
