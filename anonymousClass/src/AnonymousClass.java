public class AnonymousClass {
    public static void main(String[] args) {
        Button b = new Button();
        b.addAcction(new clickAcction() {
            @Override
            public void acction() {
                System.out.println("I'm clicking from Anonymous class");
            }
        }  );
    }
}




    interface clickAcction{
        void acction();
    }

    class Button{
        void addAcction(clickAcction c){
            c.acction();
        }
    }
