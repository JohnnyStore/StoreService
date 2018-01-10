package com.johnny.store.common;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static List<String> getFileList(String dirName) throws Exception{
        List<String> fileList = new ArrayList<>();
        File file = new File(dirName);
        if(!file.exists()){
            throw new FileNotFoundException("The directory is not exists:" + dirName);
        }
        if(!file.isDirectory()){
            throw new Exception("The path is not directory:" + dirName);
        }

        File[] files = file.listFiles();
        for (File f : files) {
            fileList.add(f.getAbsolutePath());
        }

        return fileList;
    }

    public static boolean createFile(String fileName) throws IOException {
        File file = new File(fileName);

        return !file.exists() && file.createNewFile();
    }

    public static void createFile(String fileName, String content) throws IOException{
        File file = new File(fileName);
        if(!file.exists()){
            file.createNewFile();
            addContentToFile(fileName, content, true);
        }
    }

    public static void createFolder(String dirName) throws IOException {
        File file = new File(dirName);
        if(!file.exists()){
            file.mkdirs();
        }
    }
    public static boolean deleteFile(String fileName){
        File file = new File(fileName);
        return file.exists() && file.delete();
    }

    private static void addContentToFile(String fileName, String content, boolean append) throws IOException{
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName, append);
            fileWriter.write(content);

        }finally {
            if(fileWriter != null){
                fileWriter.close();
            }
        }
    }
}
