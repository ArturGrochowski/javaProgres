import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class FridayClasses {
    public static void main(String[] args) {
    System.out.println("tescik");
    float f = Float.parseFloat("4");
    System.out.println(f);
    Integer b = 5;
    System.out.println(b);
    Date data = new Date();
    System.out.println(data.getHours()+" "+data.getMinutes());
    final List<String> lista = new ArrayList<>();
    final List<String> lista2 = new ArrayList<>();
    lista.add("zzzz");
    lista.add("nnn");

    final int num;
    num = 56;
    System.out.println(num);
//    num = 66;

    final int[] tablica = {23,34,19};
    final int[] tablica2 = {33,34,19};
    tablica[0] = 5;
//    System.out.println(tablica[0]);
    for(int g : tablica){
        System.out.println(g);
    }


        System.out.println(lista.remove(0));
        System.out.println(lista.get(0));
    }
}
