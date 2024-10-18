package org.example.springwork.GetHtmlFile.File;



import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
@Component
public class FileList {

    public File[] getFile(String path) {
        File pathFile = new File(path);
        File[] files = pathFile.listFiles();
        return files;
    }

    public List<String> XhtmlFile(File file) {
        List<String> result = new ArrayList<>();
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    result.addAll(XhtmlFile(f));
                }
            }
        } else if (file.getName().endsWith("xhtml")) {
            result.add(file.getAbsolutePath());
        }

        return result;
    }
    public  List<String> getXhtmlFile(String path) {
        File[] files = this.getFile(path);
        List<String> XhtmlFilePath = new ArrayList<>();
        for (File file : files) {
           XhtmlFilePath.addAll(this.XhtmlFile(file));
        }

        return XhtmlFilePath;
    }


    public static void main(String[] args) {
       String path="D:\\老师项目\\liang\\OPS\\xhtml";
       FileList fileList = new FileList();
        List<String> xhtmlFile = fileList.getXhtmlFile(path);
        for (String s : xhtmlFile) {
            System.out.println(s);
        }


    }

}

