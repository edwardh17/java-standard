package dario.java.std;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
// import java.sql.Date;
// DateTime (guava)

public class Extras {
    
    public static void main(String[] args) throws ParseException {
        Date date = new Date(System.currentTimeMillis());
        System.out.println(date);
        
        SimpleDateFormat sdf = new SimpleDateFormat(); // MM/dd/yyyy
        System.out.println(sdf.format(date));
        
        Date otraFecha = sdf.parse("16/07/01 19:28");
        System.out.println(otraFecha);
        
        for (int j=0;j < 20; j++) {
            List<Integer> numeros = new ArrayList(Arrays.asList(1,2,3,4,5,6,7,8,9));
            for (int i=0;i<9; i++) {
                Random random = new Random();        
                int r = random.nextInt(numeros.size());          
                int numero = numeros.remove(r);            
                System.out.print(numero+" ");
            }
            System.out.println("");
        }
        

        
        
    }
    
}
