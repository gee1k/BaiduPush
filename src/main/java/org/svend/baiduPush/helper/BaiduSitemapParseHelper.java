package org.svend.baiduPush.helper;

import org.dom4j.Document;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Svend
 * @version 2016-09-29 13:30
 */
public class BaiduSitemapParseHelper extends SitemapParseHelper {
    private String sitemapURL;

    private Document document;

    public BaiduSitemapParseHelper(String url) {
        this.sitemapURL = url;
        this.document = parseToXML(sitemapURL);
    }

    /**
     * 将XML对象解析中的URL解析到数组
     *
     * @return 解析完成的URL数组
     */
    public String[] parseURL() {
        List<String> list = new ArrayList<String>();
        if (document == null)
            return new String[]{};
        Element rootElement = document.getRootElement();
        List elements = rootElement.elements("url");
        Iterator iterator = elements.iterator();

        consoleHelper.log("----------解析URL开始----------");
        while (iterator.hasNext()) {
            Element element = (Element) iterator.next();
            String loc = element.element("loc").getText();
            list.add(loc);
            consoleHelper.log(loc);
        }
        consoleHelper.log("----------解析完成，共{0}条URL记录----------", String.valueOf(list.size()));
        return list.toArray(new String[list.size()]);
    }

    public String getSitemapURL() {
        return sitemapURL;
    }

    public void setSitemapURL(String sitemapURL) {
        this.sitemapURL = sitemapURL;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
