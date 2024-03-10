package com.tech.blog.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class Helper {

    public static boolean deleteFile(String path)
    {
        boolean f=false;
        try {

            File file=new File(path);
            f=file.delete();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return  f;
    }

    public static boolean saveFile(InputStream inputStream, String path) {
        boolean f=false;
        try {

            byte[] b=new byte[inputStream.available()];
            // it will read data from the inputstream and store into byte array.
            inputStream.read(b);

            FileOutputStream fos=new FileOutputStream(path);
            fos.write(b);
            fos.flush();
            fos.close();
            f=true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }
}
