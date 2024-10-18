package org.example.springwork.controller;
import org.example.springwork.GetHtmlFile.GetHtmlIframe;
import org.example.springwork.exal.EasyExcelWriter;
import org.example.springwork.pojo.IframeBean;
import org.example.springwork.xhtml.getXhtml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
public class WorkController {
    @Autowired
    private EasyExcelWriter excelWriter;
    @Autowired
    private  GetHtmlIframe getHtmlIframe;
    @Autowired
    private getXhtml getXhtml;

    @GetMapping("/writeExal")
    @ResponseBody
    public  void  WriteExal(@RequestParam String fileName){
        excelWriter.WriteExal(fileName);
    }
    @GetMapping("/json")
    @ResponseBody
    public  List<IframeBean>  JSON(@RequestParam(required = false , defaultValue = "D:\\老师项目\\liang\\OPS\\xhtml") String targetpath){
        try {
           return  getHtmlIframe.getIframeBeans(targetpath);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @ResponseBody
    @GetMapping("/html")
    public String getHtml(@RequestParam(required = false , defaultValue = "D:\\老师项目\\liang\\OPS\\xhtml")String targetpath){
        String xhtml ;
        try {
            xhtml = getXhtml.getXhtml(targetpath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return xhtml;

    }
}
