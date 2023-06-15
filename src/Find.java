import java.io.*;
import java.util.ArrayList;

public class Find {
    private static ArrayList<String> tempFile;
    public static User searchByFirstLine(String name, String path){
        try {
            File folder = new File(path);
            if (folder.exists()) {
                File[] files = folder.listFiles();
                for (int i = 0; i < files.length; i++) {
                    tempFile = new ArrayList<>();
                    File file = files[i];
                    FileReader fr = new FileReader(file);
                    BufferedReader reader = new BufferedReader(fr);
                    String line = reader.readLine();
                    if (!line.equals(name)) {
                        continue;
                    }
                    while (line != null) {
                        tempFile.add(line);
                        line = reader.readLine();
                    }
                    break;
                }
                if (tempFile.isEmpty()) {
                    return null;
                }
                User user = new User();
                user.setName(tempFile.get(0));
                user.setSurname(tempFile.get(1));
                user.setAge(Integer.parseInt(tempFile.get(2)));
                user.setAbsolutePath(folder.getAbsolutePath());
                return user;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void searchByFilename(String filename, String path){
        File folder = new File(path);
        if (folder.exists()){
            File[] files = folder.listFiles();
            for (int i = 0; i < files.length; i++){
                File file = files[i];
                if (file.isDirectory()){
                    searchByFilename(filename, file.getAbsolutePath());
                }
                if (file.getAbsolutePath().contains(filename)){
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }
}
