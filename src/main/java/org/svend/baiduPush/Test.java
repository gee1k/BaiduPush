package org.svend.baiduPush;

/**
 * @author Svend
 * @version 2016-09-29 11:27
 */
public class Test {
    /**
     * @param args
     */
    public static void main(String[] args) {
//        String url = "http://data.zz.baidu.com/urls?site=www.svend.cc&token=xfPQLQ7nWkFUz31D";//网站的服务器连接
//        SitemapParseHelper sitemapParseHelper = new BaiduSitemapParseHelper("http://svend.cc/baidusitemap.xml");
//        String[] urls2 = sitemapParseHelper.parseURL();
//        String[] urls = new String[]{
//                "http://svend.cc/posts/52411/"
//        };
//        String param = "";
//        for (String s : urls2) {
//            param += s + "\n";
//        }
//        String json = HttpUtils.sendPost(url, param);//执行推送方法
//        System.out.println("结果是" + json);  //打印推送结果
        String relativelyPath=System.getProperty("user.dir");
        System.out.println(relativelyPath);
    }
}
