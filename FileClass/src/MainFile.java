import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

        List<Flat> flatList = Arrays.asList(new Flat("London", "Chelsea", "King's Road", 3, 80, false, 2500000),
                                             new Flat("Szczecin", "Warszewo", "Miodowa", 6, 230, true, 1500000),
                                             new Flat("Szczecin", "Warszewo", "Duńska", 5, 190, true, 1300000),
                                            new Flat("Warsaw", "Srodmiescie", "Wojska polskigo", 2, 50, true, 900000),
                                             new Flat("Wroclaw", "Pie Pole", "Chopina", 3, 110, true, 800000)
        );

        flatList.stream()
                .filter(flat -> flat.getCity().equals("Szczecin"))
                .filter(flat -> flat.getRooms() > 2)
                .filter(flat -> flat.getPrice() < 3000000)
                .map(flat -> flat.getCity() + " " + flat.getRooms() + " " + flat.getStreet()
                        + " " + flat.getArea() + " " + flat.getRooms() + " " + flat.getPrice())
                .forEach(System.out::println);

        Predicate<Flat> flatCity = flat -> flat.getCity().equals("London");
        List<Flat> listOfFlats = flatList.stream()
                .filter(flatCity)
                .collect(Collectors.toList());
        System.out.println(listOfFlats);

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
