package http3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * 查找公钥密码学使用的质数
 * Primes,PrimeList
 */
@WebServlet(name = "http3.PrimeNumberServlet",
    urlPatterns = {"/http3.PrimeNumberServlet"})
public class PrimeNumberServlet extends HttpServlet {

    //质数列表集合，用于缓存
    private ArrayList<PrimeList> primeListCollection = new ArrayList<>();
    private int maxPrimeLists = 30;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int numPrimes =
                ServletUtils.getIntParameter(req,"numPrimes",50);
        int numDigits =
                ServletUtils.getIntParameter(req,"numDigits",120);
        PrimeList primeList = findPrimeList(primeListCollection,numPrimes,numDigits);
        //新建质数列表，添加到集合中（类似缓存）
        if (primeList == null){
            primeList = new PrimeList(numPrimes,numDigits,true);
            synchronized (primeListCollection){
                //相当于缓存
                if (primeListCollection.size() >= maxPrimeLists){
                    primeListCollection.remove(0);
                }
                primeListCollection.add(primeList);
            }
        }
        //得到当前的质数列表
        ArrayList currentPrimes = primeList.getPrimes();
        int numCurrentPrimes = currentPrimes.size();
        //该列表还需要计算多少个质数
        int numPrimesRemaining = numPrimes - numCurrentPrimes;
        boolean isLastResult = numPrimesRemaining == 0;
        //该列表计算未完成
        if (! isLastResult){
            //5s刷新一次
            resp.setIntHeader("Refresh",5);
        }


        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String title = "Some " + numDigits + "-Digit Prime Numbers";
        out.println(ServletUtils.DOCTYPE + ServletUtils.headWith(title) + "\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                "<H2 ALIGN=CENTER>" + title + "</H2>\n" +
                "<H3>Primes found with " + numDigits +
                "or more digits: " + numCurrentPrimes + ".</H3>");
        if (isLastResult){
            out.println("<B>Done searching.</B>");
        }else {
            out.println("<B> Still looking for " + numPrimesRemaining +
                    " more<BLINK>...</BLINK></B>");
        }
        out.println("<OL>");
        for (int i=0;i<numCurrentPrimes;i++){
            out.println("   <LI>" + currentPrimes.get(i));;
        }
        out.println("</OL>");
        out.println("</BODY></HTML>");
    }

    //从质数列表集合中寻找某个质数列表
    private PrimeList findPrimeList(ArrayList<PrimeList> primeListCollection,
                                    int numPrimes,
                                    int numDigits){
        synchronized (primeListCollection){
            for (int i=0;i<primeListCollection.size();i++){
                PrimeList primes = primeListCollection.get(i);
                if (numPrimes == primes.numPrimes() &&
                    numDigits == primes.numDigits()){
                    return primes;
                }
            }
            return null;
        }
    }
}
