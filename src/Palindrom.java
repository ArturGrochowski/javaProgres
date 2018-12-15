import java.util.ArrayList;
import java.util.Scanner;

public class Palindrom {

    static String singleNextLetter (String base, int i){
        int start = i;
        int end = ++i;
        return base.substring(start,end);
    }

    static boolean isTrue (String word){
        if(word.equals("stop")){
            return false;
        }else{
            return true;
        }
    }

    static String palindrom(String[] tabLetter, String base){
        int a = 0;
        int b = 0;
        int i = 0;
        String palindrom = "No palindrome in here.";
        for(i = 0; i<tabLetter.length;i++){
            int y = i;
            int z = i+2;
            int w = 0;
            int tabLength = tabLetter.length;
            if(z == tabLength) {
                break;
            }else{
                while (w<tabLength-1) {
                    w++;
                    while (tabLetter[y].equals(tabLetter[z])) {
                        if (y == 0) {
                            a = y;
//                            b = ++z;
//                            System.out.println("linia 41 return = " + base.substring(a, b));
//                            return base.substring(a, b);
                        } else {
                            a = y--;
                        }
                        if (b == tabLength - 1) { //jak podałem b==tablength to pokazał że jest zawsze false.
                            b = z + 1;
                            System.out.println(base.substring(a, b));
                            return base.substring(a, b);
                        } else if (b<tabLetter.length){
                            b = ++z;
                        }
                        if (b != tabLength) {
                            System.out.println(base.substring(a, b));
                            palindrom = base.substring(a, b);
                        }
                        if (b == tabLength) {
                            System.out.println(base.substring(a, b));
                            return base.substring(a, b);
                        }
                    }
                }
            }
        }
        if(a==0 && b==0){
            System.out.println(palindrom);
            return "";
        }else {
            return base.substring(a, b);
        }
    }


    public static void main(String[] args) {
        System.out.println("Write some random letters.");
        ArrayList<String> arrayList = new ArrayList<>(1);
        Scanner sc = new Scanner(System.in);
        String base = sc.nextLine();
        while(isTrue(base)){
            String[] tabLetters = new String[base.length()];
            for (int i = 0; i < tabLetters.length; i++) {
                tabLetters[i] = singleNextLetter(base, i);
            }
            arrayList.add(palindrom(tabLetters, base));
            System.out.println("Write next word.");
            base = sc.nextLine();
        }
        while(arrayList.size()>1){
            String s1 = arrayList.get(0);
            String s2 = arrayList.get(1);
            if(s1.length()>s2.length()){
                arrayList.remove(1);
            } else {
                arrayList.remove(0);
            }
        }
        System.out.println("The longest palindrom is: " + arrayList.get(0));
        sc.close();
        System.out.println("See you soon! :) ");
    }
}