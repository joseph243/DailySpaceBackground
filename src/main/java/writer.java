import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class writer {

    private static final String path = "c:\\Users\\Joseph\\Downloads\\";
    private static final String fileName = "dailyspacephoto.txt";
    private static PrintWriter writer;

    public static void writeToFile(String inString)
    {
        try {
            writer = new PrintWriter(path + fileName);
        }
        catch (Exception e){
            System.out.println("cannot find file: " + path + fileName);
        }
        addString(inString);
        writer.close();
    }

    private static void addString(String inString)
    {
        try {
            writer.println(inString);
        }
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
    }


}