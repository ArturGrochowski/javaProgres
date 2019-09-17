import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

public class Product {

    public void readData(DataInput dataInput) throws IOException{
        this.price = dataInput.readDouble();
        StringBuffer temporaryString = new StringBuffer(Product.NAME_LENGTH);
        for(int i = 0; i<Product.NAME_LENGTH; i++){
            char temporaryChar = dataInput.readChar();
            if(temporaryChar != '\0')
                temporaryString.append(temporaryChar);
        }

        this.name = temporaryString.toString();

        int year = dataInput.readInt();
        int motnh = dataInput.readInt();
        int day = dataInput.readInt();

        GregorianCalendar calendar = new GregorianCalendar(year, motnh-1 ,day);
        this.productionDate = calendar.getTime();
    }

    public void readRecord (RandomAccessFile randomAccessFile, int n) throws IOException, RecordMissing {
        if (n <= randomAccessFile.length() / Product.RECORD_LENGHT) {
        randomAccessFile.seek((n - 1) * Product.RECORD_LENGHT);
        this.readData(randomAccessFile);
        }
        else
            throw new RecordMissing("No Record");
    }


    public static final int NAME_LENGTH = 30;
    public static final int  RECORD_LENGHT = (Character.SIZE * NAME_LENGTH + Double.SIZE + 3 * Integer.SIZE/8);
    private double price;
    private String name;
    private Date productionDate;

    public Product(){
        this.price = 0.0;
        this.name = " ";
        this.productionDate = new GregorianCalendar().getTime();
    }

    public Product(double price, String name){
        this();
        this.price = price;
        this.name = name;
    }

    public Product(double price, String name, int year, int month, int day){
        this(price, name);
        GregorianCalendar calendar = new GregorianCalendar(year, month-1, day);
        this.productionDate = calendar.getTime();
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public String toString(){
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(this.productionDate);
        return String.format("price: %.2f PLN; name: %s; production date: %tD", this.price, this.name, calendar.getTime());
    }

    public static void writeToFile(Product[] products, DataOutput outStreem) throws IOException {

        for (int i = 0; i<products.length; i++) {
            products[i].saveData(outStreem);
        }
    }

    public static Product[] readFromFile (RandomAccessFile randomAccessFile) throws IOException {

        int length = (int)(randomAccessFile.length()/Product.RECORD_LENGHT);
        Product[] products = new Product[length];

        for (int i = 0; i < length; i++){
            products[i] = new Product();
            products[i].readData(randomAccessFile);
        }

        return products;
    }

    public void saveData(DataOutput dataOut) throws IOException {
        dataOut.writeDouble(this.price);

        StringBuffer stringBuffer = new StringBuffer(Product.NAME_LENGTH);
        stringBuffer.append(this.name);
        stringBuffer.setLength(Product.NAME_LENGTH);

        dataOut.writeChars(stringBuffer.toString());

        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(this.productionDate);
        dataOut.writeInt(calendar.get(Calendar.YEAR));
        dataOut.writeInt((calendar.get(Calendar.MONTH)+1));
        dataOut.writeInt(calendar.get(Calendar.DAY_OF_MONTH));
    }
}
