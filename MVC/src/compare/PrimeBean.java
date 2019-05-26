package compare;

import java.math.BigInteger;

public class PrimeBean {
    private BigInteger prime;

    public PrimeBean(String lengthString){
        int length = 150;
        try {
            length = Integer.parseInt(lengthString);
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        setPrime(Primes.nextPrime(Primes.random(length)));
    }

    public BigInteger getPrime() {
        return prime;
    }

    public void setPrime(BigInteger prime) {
        this.prime = prime;
    }
}
