package org.example.springwork.xhtml;

import org.apache.commons.collections4.Get;
import org.example.springwork.GetHtmlFile.GetHtmlIframe;
import org.example.springwork.pojo.IframeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@Component
public class getXhtml {
    @Autowired
    private GetHtmlIframe getHtmlIframe;
    public String  getXhtml(String tartpath) throws IOException {
        List<IframeBean> iframeBeans =getHtmlIframe.getIframeBeans(tartpath);
       /* iframeBeans.sort(Comparator.comparing(IframeBean::getSrc));*/
        StringBuilder builder=new StringBuilder();

        builder.append("<!DOCTYPE html>");
        builder.append("<html>");
        builder.append("<head>");
        builder.append("<title>Dynamic Table</title>");
        builder.append("<style>");
        builder.append("table {border-collapse: collapse; width: 100%;}");
        builder.append("th, td {border: 1px solid black; padding: 16px; text-align: left;}");
        builder.append("</style>");
        builder.append("</head>");
        builder.append("<body>");
        builder.append("<table>");
// 表头
        builder.append("<tr>");
        builder.append("<th>index</th>");
        builder.append("<th>src</th>");
        builder.append("<th>title</th>");
        builder.append("<th>width</th>");
        builder.append("<th>height</th>");
        builder.append("</tr>");
        for(IframeBean iframeBean:iframeBeans){
            String title = iframeBean.getTitle();
            if (title  == ""){
                title = "NoHaveTitle";
            }
            builder.append("<tr>");
            builder.append("<td style=\"width: 80px;\">"+iframeBean.getData_chaucer_element_id()+"</td>");
            builder.append("<td style=\"width: 250px;\"> <a href  = '"+iframeBean.getSrc()+"'>"+iframeBean.getSrc()+"</a></td>");
            builder.append("<td style=\"width: 80px;\" >"+title+"</td>");
            builder.append("<td style=\"width: 50px;\">"+iframeBean.getWidth()+"</td>");
            builder.append("<td style=\"width: 50px;\">"+iframeBean.getHeight()+"</td>");
            builder.append("</tr>");

        }
        builder.append("</table></body></html>");
        return builder.toString();
    }

}


