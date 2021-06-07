package CLI;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class delete {

    public static void main(String arg[]) throws IOException {
        FileWriter fwOb = new FileWriter("matchDetails.txt", false);
        PrintWriter pwOb = new PrintWriter(fwOb, false);
        pwOb.flush();
        pwOb.close();
        fwOb.close();
        FileWriter fwOb1 = new FileWriter("footballClubDetails.txt", false);
        PrintWriter pwOb1 = new PrintWriter(fwOb1, false);
        pwOb1.flush();
        pwOb1.close();
        fwOb1.close();
    }
}
