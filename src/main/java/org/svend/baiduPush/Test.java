package org.svend.baiduPush;

import org.svend.baiduPush.helper.BaiduSitemapParseHelper;
import org.svend.baiduPush.helper.SitemapParseHelper;
import org.svend.baiduPush.util.HttpUtils;

/**
 * @author Svend
 * @version 2016-09-29 11:27
 */
public class Test {
    /**
     * @param args
     */
    public static void main(String[] args) {
        String url = "http://data.zz.baidu.com/update?site=www.svend.cc&token=xfPQLQ7nWkFUz31D";//网站的服务器连接
        SitemapParseHelper sitemapParseHelper = new BaiduSitemapParseHelper("http://svend.cc/baidusitemap.xml");
        String[] urls = sitemapParseHelper.parseURL();
        String param = "";
        for (String s : urls) {
            param += s + "\n";
        }
        String json = HttpUtils.sendPost(url, param);//执行推送方法
        System.out.println("结果是" + json);  //打印推送结果
    }
}
