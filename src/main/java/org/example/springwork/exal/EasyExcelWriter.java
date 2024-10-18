package org.example.springwork.exal;

import org.example.springwork.GetHtmlFile.File.FileList;
import com.alibaba.excel.EasyExcel;
import org.springframework.stereotype.Component;
import org.example.springwork.pojo.IframeBean;

import java.util.ArrayList;
import java.util.List;
@Component
public class EasyExcelWriter {
    public  boolean WriteExal(String fileName){
        List<IframeBean> list = new ArrayList<>();
        boolean flag  = false;
        //提供文件路径和文件名
        EasyExcel.write(fileName, FileList.class)
                .sheet(fileName)
                .doWrite(list);// 执行写入操作，data 是要写入的数据，包含了要写入 Excel 文件的数据
        flag = true;
        return flag;
    }

}
