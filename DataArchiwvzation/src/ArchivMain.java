import java.io.*;
import java.util.zip.*;

public class ArchivMain {

    public static final int BUFFOR = 1024;
    public static void main(String[] args) {

        String[] stringsTab = new String[]{ "base.txt", "newFile.txt"};

        byte[] tmpData = new byte[BUFFOR];
        try {
            ZipOutputStream zipOutputStr = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream("file.zip"), BUFFOR));

            for (int i = 0; i < stringsTab.length; i++){
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(stringsTab[i]), BUFFOR);
                zipOutputStr.putNextEntry(new ZipEntry(stringsTab[i]));
                int counter;
                while ((counter = bufferedInputStream.read(tmpData, 0, BUFFOR)) != -1){
                    zipOutputStr.write(tmpData, 0, counter);
                }
                zipOutputStr.closeEntry();
                bufferedInputStream.close();
            }

            zipOutputStr.close();

        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
