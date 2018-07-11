package dario.java.std;

import java.util.Random;

public class ConjeturaDeCollatz {

    public static void main(String[] args) {
        
        
        Random random = new Random();
        
        int num = random.nextInt();
        System.out.println(num);

        do {
            if (num%2==0) {
                num=num/2;
            } else {
                num=(num*3)+1;
            }
        
            System.out.println(num);
        } while  (num!=1);
        
        
        
        
    }


    
}
