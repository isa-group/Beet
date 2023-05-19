package agora.beet.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Juan C. Alonso
 */
public class FileManager {


    public static void writeFile(String filepath, String content) {
        try {
            FileWriter myWriter = new FileWriter(filepath);
            myWriter.write(content);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static String readFileAsString(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    public static boolean deleteFile(String path) {
        File file = new File(path);
        return file.delete();
    }

    public static Boolean checkIfExists(String path) {
        File file = new File(path);
        return file.exists();
    }

    public static Boolean createFileIfNotExists(String path) {
        File file = new File(path);
        try {
            return file.createNewFile();
        } catch (IOException e) {
            System.err.println("Exception: "  + e);
        }
        return null;
    }

}
