import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JavaCreateDirectory {

    public static void main(String[] args) throws IOException {

       // String fileName = "/home/janbodnar/tmp/newdir";
 String fileNames = "C:\\ApacheTomcat9\\customer_data";
        Path path = Paths.get(fileNames);

        if (!Files.exists(path)) {
            
            Files.createDirectory(path);
            System.out.println("Directory created");
        } else {
            
            System.out.println("Directory already exists");
        }
    }
}