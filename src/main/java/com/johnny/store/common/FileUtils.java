package com.johnny.store.common;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {

    /**
     * 写log文件
     * @param dir 日期存储目录
     * @param fileName 日志文件名
     * @param fileContent 日志内容
     * @throws IOException
     */
    public static void write(String dir, String fileName, String fileContent) throws IOException {
        //创建目录
        File fileDir = new File(dir);
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }

        //创建文件
        File file = new File(dir, fileName);
        if(!file.exists()){
            file.createNewFile();
        }

        //写入文件内容
        FileWriter fileWriter = null;
        fileWriter = new FileWriter(file, true);
        fileWriter.write(fileContent);
        fileWriter.close();
    }
}
