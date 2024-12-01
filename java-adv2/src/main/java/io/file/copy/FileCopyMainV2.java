package io.file.copy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyMainV2 {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        String copyName = "temp/copy.dat";
        String newName = "temp/copy_new.dat";
        
        FileInputStream fis = new FileInputStream(copyName);
        FileOutputStream fos = new FileOutputStream(newName);

        fis.transferTo(fos);

        fis.close();
        fos.close();
        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + "ms");
    }

}
