import java.io.File;
import java.io.IOException;

public class Application {
    public static void main(String args[]) throws IOException {
        DuplicateRemover test = new DuplicateRemover();
        File myFile = null;
        test.remove(myFile);
        test.write(myFile);
    }
}
