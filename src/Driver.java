import java.io.File;
import java.io.FileNotFoundException;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/input.txt");
        Output.output(file);
    }
}
