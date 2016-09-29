package org.svend.baiduPush.helper;

/**
 * 控制台输出
 *
 * @author Svend
 * @version 2016-09-29 13:52
 */
public class ConsoleHelper {

    private static final String SYMBOL_LEFT = "{";
    private static final String SYMBOL_RIGHT = "}";

    private static ConsoleHelper consoleHelper = new ConsoleHelper();

    public ConsoleHelper() {
    }

    public static ConsoleHelper getInstance() {
        return consoleHelper;
    }

    public void log(String msg, String... param) {
        msg = replaceMsg(msg, param);
        System.out.println("log:" + msg);
    }

    public void error(String msg, String... param) {
        msg = replaceMsg(msg, param);
        System.out.println("error:" + msg);
    }

    public void warn(String msg, String... param) {
        msg = replaceMsg(msg, param);
        System.out.println("warn:" + msg);
    }

    private String replaceMsg(String msg, String... param) {
        if (param != null && param.length > 0) {
            for (int i = 0; i < param.length; i++) {
                msg = msg.replace(SYMBOL_LEFT + i + SYMBOL_RIGHT, param[i]);
            }
        }
        return msg;
    }
}
