package org.svend.baiduPush.helper;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.svend.baiduPush.util.HttpUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Svend
 * @version 2016-09-29 13:36
 */
public class SitemapParseHelper {

    ConsoleHelper consoleHelper = ConsoleHelper.getInstance();

    Document parseToXML(String url) {
        Map<String, String> header = new HashMap<String, String>();
        header.put("Host", "data.zz.baidu.com");
        header.put("User-Agent", "curl/7.12.1");
        header.put("Content-Length", "83");
        header.put("Content-Type", "text/plain");
        String result = HttpUtils.sendGet(url, "", header);
        if (result == null || result.trim().length() == 0) {
            consoleHelper.error("获取sitemap失败，请检查sitemap地址是否正确：" + url);
            return null;
        }

        Document document = null;
        try {
            document = DocumentHelper.parseText(result);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return document;
    }

    /**
     * 将XML对象解析中的URL解析到数组
     *
     * @return 解析完成的URL数组
     */
    public String[] parseURL() {
        String[] urls = new String[]{};
        return urls;
    }
}
