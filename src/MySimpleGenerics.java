import java.lang.reflect.Array;

public class MySimpleGenerics {

    public static void main(String[] arg){

        int[] arr = new int[6];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;
        arr[5] = 6;
        Integer I = new Integer("5");
        //we are going to create SimpleGeneric object with String as type parameter
        SimpleGeneric<String, Integer> sgs = new SimpleGeneric<String, Integer>("JAVA2NOVICE", 4, 67);
        sgs.printType();

//        //we are going to create SimpleGeneric object with Boolean as type parameter
//        SimpleGeneric<Boolean, Array> sgb = new SimpleGeneric<Boolean, Integer>(true, , 89);
//        sgb.printType();
    }
}