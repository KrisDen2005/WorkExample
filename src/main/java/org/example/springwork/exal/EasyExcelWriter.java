package org.example.springwork.exal;

import org.example.springwork.GetHtmlFile.File.FileList;
import com.alibaba.excel.EasyExcel;
import org.example.springwork.GetHtmlFile.GetHtmlIframe;
import org.springframework.stereotype.Component;
import org.example.springwork.pojo.IframeBean;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Component
public class EasyExcelWriter {
    public  boolean WriteExal(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            file.mkdirs();
        }
        String exalFileName = "workp.xlsx";
        FileList fileList = new FileList();
        String targetpath = "D:\\xtmlWork\\xhtml";
        List<String> xhtmlFile = fileList.getXhtmlFile(targetpath);
        GetHtmlIframe getHtmlIframe = new GetHtmlIframe();
        List<IframeBean> iframeBeans = new ArrayList<>();
        for (String path : xhtmlFile) {
            List<IframeBean> xhtmlAttribute = getHtmlIframe.getXhtmlAttribute(path);
            for (IframeBean iframeBean : xhtmlAttribute) {
                iframeBeans.add(iframeBean);
            }
        }

        boolean flag  = false;
        //提供文件路径和文件名
        EasyExcel.write(fileName+"\\"+exalFileName, FileList.class)
                .sheet(exalFileName)
                .doWrite(iframeBeans);// 执行写入操作，data 是要写入的数据，包含了要写入 Excel 文件的数据
        flag = true;
        return flag;
    }

}
