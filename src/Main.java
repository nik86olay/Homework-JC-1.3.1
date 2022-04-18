import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Main {
    static private final String[] arrayDir = {"D://Games/src", "D://Games/res", "D://Games/savegames",
            "D://Games/temp", "D://Games/src/main", "D://Games/src/test", "D://Games/res/drawables",
            "D://Games/res/vectors", "D://Games/res/icons"};
    static private final String[] arrayFile = {"D://Games/src/main/Main.java", "D://Games/src/main/Utils.java",
            "D://Games/temp/temp.txt"};

    static private final StringBuilder info = new StringBuilder();

    public static void main(String[] args) {

        for (String i : arrayDir) {
            CreatingDir(new File(i));
        }

        for (String i : arrayFile) {
            CreatingFile(new File(i));
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("D://Games/temp/temp.txt"))) {
            bw.write(String.valueOf(info));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    private static void CreatingDir(File dir) {
        if (dir.mkdir()) {
            info.append("Каталог ").append(dir).append(" создан\n");
        } else {
            System.out.println("Error");
        }
    }

    private static void CreatingFile(File file) {
        try {
            if (file.createNewFile()) {
                info.append("Файл ").append(file).append(" создан\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
