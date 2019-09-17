import java.io.*;

public class TknMain {
    public static void main(String[] args) {
        Product[] product = new Product[3];

        product[0] = new Product();
        product[1] = new Product(5.0, "App One Test");
        product[2] = new Product(6.0, "Test of App Two", 2019, 4, 29);

        try{
            RandomAccessFile randomAccessFile = new RandomAccessFile("newFile.txt", "rw");

            Product.writeToFile(product, randomAccessFile);
            randomAccessFile.seek(0);

            Product[] products1 = Product.readFromFile(randomAccessFile);

            for (int i = 0; i < products1.length; i++){
                System.out.println("testing");
                System.out.println(products1[i].getPrice());
                System.out.println(products1[i].getName());
                System.out.println(products1[i].getProductionDate());
                System.out.println("_____________________________");
            }

            try {
                Product secondProduct = new Product();

                secondProduct.readRecord(randomAccessFile, 2);
                System.out.println(secondProduct);
                System.out.println("testttttt--------");

            } catch (RecordMissing error){
                System.out.println(error.getMessage());
            }
            randomAccessFile.close();

        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
