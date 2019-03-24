import java.io.File;
import java.io.IOException;
import java.util.Date;

public class MainFile {
    public static void main(String[] args) {

        File file = new File("test.txt");
        File catalog = new File("user.dir" + File.separator+ "catalog" +File.separator+ "subCatalog" + File.separator+ "subSubCatalog"); // folder, directory
        File file2 = new File("catalog" +File.separator+ "subCatalog" + File.separator+ "subSubCatalog", "example.txt"); // first param.- path, second - file to create
        File file3 = new File("user.dir" +File.separator+ "subCatalog" + File.separator+ "subSubCatalog", "example2.txt"); // first param.- path, second - file to create
//        catalog.mkdirs();
//        file3.mkdir();

        System.out.println("Does the files exist?.................");
        System.out.println("file = " + file.exists());
        System.out.println("file2 = " + file2.exists());
        System.out.println("file3 = " + file3.exists());
        System.out.println("can I write? " + file.canWrite());
        System.out.println("can I read? " + file.canRead());
        System.out.println("can I execute? " + file.canExecute());
        System.out.println("is hidden? " + file.isHidden());
        System.out.println("is it a file? " + file.isFile());
        System.out.println("last modify? " + new Date(file.lastModified()));
        System.out.println("size in bites? " + file3.length());
        System.out.println("directory: " + System.getProperty("user.dir"));

//        try {
//
//
//            if(!file.exists()) {
//                file.createNewFile();
//
//            }
//            if(!file2.exists()) {
//                file2.createNewFile();
//
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println(e.getMessage());
//        }
//        System.out.println(System.getProperty("user.name"));
//        System.out.println(System.getProperty("user.home"));
//        System.out.println(System.getProperty("user.dir"));
//        System.out.println(System.getProperty("os.name"));
//        System.out.println(System.getProperty("os.version"));
//        System.out.println(System.getProperty("os.arch"));
//        System.out.println(System.getProperty("java.home"));
//        getPath(file);
//        getAbsolutPath(file);
//        getPath(file2);
//        getAbsolutPath(file2);
//        System.out.println("Get Content Method:");
////        getContent(new File(System.getProperty("user.dir")));
        getContent(new File("ToolBar"));
        System.out.println("-----------------------------------");
    }
    static void getPath(File file){
        System.out.println(file.getPath());
    }

    static void getAbsolutPath(File file){
        System.out.println(file.getAbsolutePath());
    }

    static void getContent(File file) {
                String[] content = file.list();
        if (content != null) {
            for (String s : content) {
                File tmp = new File(file, s);
                if(tmp.isFile())
                System.out.println(tmp);
                if (tmp.isDirectory())
                    getContent(new File(tmp.getPath()));

            }
        }
    }
}
