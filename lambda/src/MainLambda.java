import java.sql.SQLOutput;

public class MainLambda {
        public static void main(String[] args) {
            Button b = new Button();
            b.addAcction(() -> System.out.println("I'm clicking from Anonymous class"), "I'm printing from defalut method inside interface", 74, 49);

        }
    }



    interface clickAcction{
        void acction();
        default void print (String text){
            System.out.println(text);
        }
        default void plus (int a, int b){
            int result = a + b;
            System.out.println("Result of " + a + " plus " + b + " equals " + result );
        }
    }



    class Button{
        void addAcction(clickAcction c, String s, int a, int b){
            c.acction();
            c.print(s);
            c.plus(a, b);
        }
    }
