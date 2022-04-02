import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class main {

    private static final String apiKeyNASADemo = "DEMO_KEY";
    private static final String url = "https://api.nasa.gov/planetary/apod";
    private static final String localPath = "c:\\Users\\Joseph\\Downloads\\";
    private static final String fileName = "dailyspacephoto.jpg";

    public static void main(String[] args) throws Exception
    {
        String query = url + "?api_key=" + apiKeyNASADemo;
        HttpResponse<JsonNode> response = Unirest.get(query).asJson();
        System.out.println("Server Response = " + response.getStatus());
        try
        {
           downloadFile(response.getBody().getObject().get("url").toString(),fileName);
        }
        catch (Throwable e)
        {
            System.out.println("error" + e.toString());
        }
        writer.writeToFile(response.getBody().getObject().get("explanation").toString());
    }

    public static void downloadFile(String inURL, String infileName) throws Throwable
    {
        InputStream inputStream = new URL(inURL).openStream();
        Long bytes = Files.copy(inputStream, Paths.get(localPath + infileName), StandardCopyOption.REPLACE_EXISTING);
        inputStream.close();
        System.out.println("file copy: " + bytes + " bytes read from:");
        System.out.println(inURL);
        System.out.println("Saved to: " + localPath + infileName);
    }

    public static void refreshWindowsBackground() throws Throwable{
//    [DllImport("user32.dll", SetLastError = true)]
//            private static extern IntPtr SendMessageTimeout(IntPtr hWnd, int Msg, IntPtr wParam, string lParam, uint fuFlags, uint uTimeout, IntPtr lpdwResult);
//
//            private static readonly IntPtr HWND_BROADCAST = new IntPtr(0xffff);
//            private const int WM_SETTINGCHANGE = 0x1a;
//            private const int SMTO_ABORTIFHUNG = 0x0002;
//
//            SendMessageTimeout(HWND_BROADCAST, WM_SETTINGCHANGE, IntPtr.Zero, null, SMTO_ABORTIFHUNG, 100, IntPtr.Zero);
    }
}
