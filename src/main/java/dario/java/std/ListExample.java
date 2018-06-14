package dario.java.std;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListExample {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		                
                list.add("3");
		list.add((new Integer(2)).toString());
		list.add("1");
		list.add("4");
		list.add("5");
		list.add("55");
		list.add("8");
		list.add("6");
                list.add("6");

                String elemento = list.get(5);
                
                
		for (String elem : list) {
			System.out.println(elem);
		}
                
                for (int i = 0; i < list.size(); i++) {
                    String integer = list.get(i);
                    System.out.println(integer);
                }
                
                System.out.println(list.contains("10"));
                
                list.forEach(t -> System.out.println(t));
                
                System.out.println(list.indexOf(8));
                
                ///list.remove(list.remove(6));

                //list.removeAll(Arrays.asList(6,6,6,5));
    
                
                list.forEach(pepe -> System.out.println(pepe));
                
                list.sort(null);

                System.out.println("Ordenados:");
                list.forEach(t -> System.out.println(t));
                
                
                list.forEach(System.out::println);

	}

}
