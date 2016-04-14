import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jessicahuffstutler on 4/13/16.
 */
public class Secret {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter an integer.");
        int inputNum = in.nextInt();
        in.close();

        System.out.println(Arrays.toString(primes(inputNum)));

        if (additive(inputNum)) {
            System.out.println("The function 'secret()' is additive");
        } else {
            System.out.println("The function 'secret()' is not additive");
        }
    }

    //finding all of the primes less than inputNum using Sieve of Eratosthenes
    public static int[] primes(int inputNum){
        boolean[] isComposite = new boolean[inputNum + 1];
        for (int i = 2; i * i <= inputNum; i++){
            if (!isComposite [i]) {
                for (int j = i; i * j <= inputNum; j++) {
                    isComposite [i*j] = true;
                }
            }
        }
        int numPrimes = 0;
        for (int i = 2; i <= inputNum; i++) {
            if (!isComposite [i]) numPrimes++;
        }
        int [] primes = new int [numPrimes];
        int index = 0;
        for (int i = 2; i <= inputNum; i++) {
            if (!isComposite [i]) primes [index++] = i;
        }
        return primes;
    }

    public static int secret(int inputNum){
        return 2 * inputNum;
    }

    public static boolean additive(int inputNum){
        int[] primesArray = primes(inputNum);
        for (int p = 0; p < primesArray.length; p++) {
            for (int r = 0; r < primesArray.length; r++) {
                if (p != r && secret(primesArray[p]) + secret(primesArray[r]) != secret(primesArray[p] + primesArray[r])) {
                    return false;
                }
            }
        }
        return true;
    }
}
