import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.zip.*;


public class ArchivUznipMain {
    public static int BUFFOR = 1024;
    public static void main(String[] args) {

     File catalog = new File(System.getProperty("user.dir") + File.separator + "file");
     ZipEntry zipEntry = null;
     byte[] tmpData = new byte[BUFFOR];

     try {

         if (!catalog.exists())
             catalog.mkdir();

         ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream("file.zip"));

         zipInputStream.getNextEntry();
         while((zipEntry = zipInputStream.getNextEntry()) != null){
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(catalog+File.separator+zipEntry.getName()), BUFFOR);

             int counter;
             while((counter = zipInputStream.read(tmpData, 0, BUFFOR)) != -1){
                 bufferedOutputStream.write(tmpData, 0, BUFFOR);

                 bufferedOutputStream.close();
                 zipInputStream.close();
             }

             bufferedOutputStream.close();
             zipInputStream.close();
         }

         zipInputStream.close();

     } catch (IOException e) {
         System.out.println(e.getMessage());
        }
    }
}
