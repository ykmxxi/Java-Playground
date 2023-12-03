package 파일읽기;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReaderApplication {

    public static List<String> readFile(final String path) {
        List<String> names = new ArrayList<>();
        File file = new File(path);
        try (
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader)
        ) {
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                names.addAll(Arrays.asList(line.split(" ")));
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("해당 파일이 존재하지 않습니다.");
        }
        return names;
    }

}
