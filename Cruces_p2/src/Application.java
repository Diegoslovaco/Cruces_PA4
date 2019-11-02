import java.io.File;
import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        DuplicateCounter test = new DuplicateCounter();
        File  myFile = null;
        test.count(myFile);
        test.write(myFile);
    }

}
