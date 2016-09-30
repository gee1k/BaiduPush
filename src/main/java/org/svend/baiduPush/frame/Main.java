/*
 * Created by JFormDesigner on Thu Sep 29 16:18:10 CST 2016
 */

package org.svend.baiduPush.frame;

import org.svend.baiduPush.helper.BaiduSitemapParseHelper;
import org.svend.baiduPush.helper.SitemapParseHelper;
import org.svend.baiduPush.util.HttpUtils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * @author Jin Svend
 */
public class Main extends JFrame {
    private static final String SYMBOL_LEFT = "{";
    private static final String SYMBOL_RIGHT = "}";

    public Main() {
        initComponents();
        readConfig();
        simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
    }

    private void readConfig() {
        Properties prop = loadProperty();
        String pushAddress = prop.getProperty("pushAddress");
        String sitemapAddress = prop.getProperty("sitemapAddress");
        String urls = prop.getProperty("urls");
        changePushMethod(Boolean.valueOf(prop.getProperty("sitemapSelectd", "false")));
        pushUrlTextField.setText(pushAddress);
        sitemapTextField.setText(sitemapAddress);
        urlsArea.setText(urls);

    }

    private void setConfig(boolean sitemapIsSelectd, String pushAddress, String sitemapAddress, String urls) {
        OutputStream fos = null;
        try {
            String relativelyPath = System.getProperty("user.dir");
            fos = new FileOutputStream(relativelyPath + "\\config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop = loadProperty();
        prop.setProperty("sitemapSelectd", String.valueOf(sitemapIsSelectd));
        prop.setProperty("pushAddress", pushAddress);
        prop.setProperty("sitemapAddress", sitemapAddress);
        prop.setProperty("urls", urls);
        try {
            prop.store(fos, simpleDateFormat.format(new Date()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 保存值到配置文件
     */
    private void saveConfig() {
        setConfig(sitemapRadio.isSelected(), pushUrlTextField.getText(), sitemapTextField.getText(), urlsArea.getText());
        log("已保存配置到配置文件！");
    }

    /**
     * 重置配置文件中的值
     */
    private void resetConfig() {
        changePushMethod(false);
        pushUrlTextField.setText("");
        sitemapTextField.setText("");
        urlsArea.setText("");
        setConfig(false, "", "", "");
        log("已重置配置文件！");
    }

    private Properties loadProperty() {
        Properties prop = new Properties();
        try {
            String relativelyPath = System.getProperty("user.dir");
            FileInputStream is = new FileInputStream(relativelyPath + "\\config.properties");
//            InputStream is = this.getClass().getResourceAsStream("/config.properties");
            prop.load(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.setTitle("百度站长链接主动提交");
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        main.setVisible(true);
    }

    /**
     * sitemap方式
     *
     * @param e event
     */
    private void sitemapRadioMouseClicked(MouseEvent e) {
        changePushMethod(true);
    }

    /**
     * urls方式
     *
     * @param e event
     */
    private void urlRadioMouseClicked(MouseEvent e) {
        changePushMethod(false);
    }

    /**
     * 提交
     *
     * @param e event
     */
    private void pushBtnMouseClicked(MouseEvent e) {
        String pushUrl = pushUrlTextField.getText();

        if (pushUrl.trim().length() == 0) {
            log("接口调用地址不能为空！");
            return;
        }

        String[] urls = null;
        if (sitemapRadio.isSelected()) {
            String sitemapAddress = sitemapTextField.getText();
            if (sitemapAddress.length() == 0) {
                log("sitemap地址为空，请填写！");
                return;
            }
            sitemapParseHelper = new BaiduSitemapParseHelper(sitemapAddress);
            urls = sitemapParseHelper.parseURL();

        } else if (urlRadio.isSelected()) {
            String text = urlsArea.getText();
            if (text.length() == 0) {
                log("自定义URL为空，请填写！");
                return;
            }
            urls = text.split("\n");
        }
        if (urls != null && urls.length > 0) {
            log("----------准备提交的URL----------");

            String param = "";
            for (String s : urls) {
                param += s + "\n";
                log(s);
            }
            log("----------共提交{0}条URL----------", String.valueOf(urls.length));
            String json = HttpUtils.sendPost(pushUrl, param);//执行推送方法
            log("推送结果：{0}", json);
        }

    }

    private void log(String msg, String... param) {
        if (param != null && param.length > 0) {
            for (int i = 0; i < param.length; i++) {
                msg = msg.replace(SYMBOL_LEFT + i + SYMBOL_RIGHT, param[i]);
            }
        }
        consoleTextArea.append(msg + "----" + simpleDateFormat.format(new Date()) + "\n");
    }

    private void changePushMethod(boolean isSitemap) {
        sitemapRadio.setSelected(isSitemap);
        urlRadio.setSelected(!isSitemap);
        sitemapTextField.setEnabled(isSitemap);
        urlsArea.setEnabled(!isSitemap);
    }

    private void saveConfigBtnMouseClicked(MouseEvent e) {
        saveConfig();
    }

    private void clearConfigBtnMouseClicked(MouseEvent e) {
        resetConfig();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Jin Svend
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        panel1 = new JPanel();
        label2 = new JLabel();
        pushUrlTextField = new JTextField();
        methodLabel = new JLabel();
        pushPanel = new JPanel();
        sitemapPanel = new JPanel();
        sitemapRadio = new JRadioButton();
        sitemapTextField = new JTextField();
        urlPanel = new JPanel();
        urlRadio = new JRadioButton();
        scrollPane1 = new JScrollPane();
        urlsArea = new JTextArea();
        label1 = new JLabel();
        consolePanel = new JPanel();
        scrollPane2 = new JScrollPane();
        consoleTextArea = new JTextArea();
        buttonBar = new JPanel();
        pushBtn = new JButton();
        saveConfigBtn = new JButton();
        clearConfigBtn = new JButton();

        //======== this ========
        setMinimumSize(new Dimension(850, 630));
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout(0, 6));

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setMaximumSize(new Dimension(850, 550));
            dialogPane.setMinimumSize(new Dimension(850, 550));

            // JFormDesigner evaluation mark
            dialogPane.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                            "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                            javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                            java.awt.Color.red), dialogPane.getBorder()));
            dialogPane.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                public void propertyChange(java.beans.PropertyChangeEvent e) {
                    if ("border".equals(e.getPropertyName())) throw new RuntimeException();
                }
            });

            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setMaximumSize(new Dimension(850, 550));
                contentPanel.setMinimumSize(new Dimension(850, 550));
                contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

                //======== panel1 ========
                {
                    panel1.setMaximumSize(new Dimension(850, 30));
                    panel1.setMinimumSize(new Dimension(850, 24));
                    panel1.setLayout(new BoxLayout(panel1, BoxLayout.X_AXIS));

                    //---- label2 ----
                    label2.setText("\u63a5\u53e3\u8c03\u7528\u5730\u5740\uff1a");
                    label2.setMaximumSize(new Dimension(100, 17));
                    label2.setMinimumSize(new Dimension(100, 17));
                    panel1.add(label2);

                    //---- pushUrlTextField ----
                    pushUrlTextField.setMaximumSize(new Dimension(850, 30));
                    panel1.add(pushUrlTextField);
                }
                contentPanel.add(panel1);

                //---- methodLabel ----
                methodLabel.setText("\u63d0\u4ea4\u65b9\u5f0f\uff1a");
                contentPanel.add(methodLabel);

                //======== pushPanel ========
                {
                    pushPanel.setMaximumSize(new Dimension(850, 270));
                    pushPanel.setMinimumSize(new Dimension(850, 270));
                    pushPanel.setLayout(new BoxLayout(pushPanel, BoxLayout.Y_AXIS));

                    //======== sitemapPanel ========
                    {
                        sitemapPanel.setMaximumSize(new Dimension(850, 35));
                        sitemapPanel.setMinimumSize(new Dimension(850, 35));
                        sitemapPanel.setLayout(new BoxLayout(sitemapPanel, BoxLayout.X_AXIS));

                        //---- sitemapRadio ----
                        sitemapRadio.setText("sitemap\u65b9\u5f0f");
                        sitemapRadio.setMaximumSize(new Dimension(100, 300));
                        sitemapRadio.setMinimumSize(new Dimension(100, 30));
                        sitemapRadio.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                        sitemapRadio.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                sitemapRadioMouseClicked(e);
                            }
                        });
                        sitemapPanel.add(sitemapRadio);

                        //---- sitemapTextField ----
                        sitemapTextField.setMaximumSize(new Dimension(745, 35));
                        sitemapTextField.setMinimumSize(new Dimension(745, 35));
                        sitemapPanel.add(sitemapTextField);
                    }
                    pushPanel.add(sitemapPanel);

                    //======== urlPanel ========
                    {
                        urlPanel.setMaximumSize(new Dimension(850, 230));
                        urlPanel.setMinimumSize(new Dimension(850, 230));
                        urlPanel.setLayout(new BoxLayout(urlPanel, BoxLayout.X_AXIS));

                        //---- urlRadio ----
                        urlRadio.setText("\u586b\u5199URL\u65b9\u5f0f");
                        urlRadio.setMaximumSize(new Dimension(100, 23));
                        urlRadio.setMinimumSize(new Dimension(100, 23));
                        urlRadio.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                urlRadioMouseClicked(e);
                            }
                        });
                        urlPanel.add(urlRadio);

                        //======== scrollPane1 ========
                        {
                            scrollPane1.setMaximumSize(new Dimension(750, 200));
                            scrollPane1.setMinimumSize(new Dimension(750, 200));
                            scrollPane1.setAutoscrolls(true);

                            //---- urlsArea ----
                            urlsArea.setColumns(5);
                            urlsArea.setMaximumSize(new Dimension(850, 200));
                            scrollPane1.setViewportView(urlsArea);
                        }
                        urlPanel.add(scrollPane1);
                    }
                    pushPanel.add(urlPanel);
                }
                contentPanel.add(pushPanel);

                //---- label1 ----
                label1.setText("\u63a7\u5236\u53f0\uff1a");
                label1.setNextFocusableComponent(consoleTextArea);
                contentPanel.add(label1);

                //======== consolePanel ========
                {
                    consolePanel.setMaximumSize(new Dimension(850, 300));
                    consolePanel.setMinimumSize(new Dimension(850, 220));
                    consolePanel.setLayout(new BoxLayout(consolePanel, BoxLayout.Y_AXIS));

                    //======== scrollPane2 ========
                    {
                        scrollPane2.setMaximumSize(new Dimension(850, 300));

                        //---- consoleTextArea ----
                        consoleTextArea.setMaximumSize(new Dimension(850, 300));
                        scrollPane2.setViewportView(consoleTextArea);
                    }
                    consolePanel.add(scrollPane2);
                }
                contentPanel.add(consolePanel);
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setMaximumSize(new Dimension(850, 35));
                buttonBar.setInheritsPopupMenu(true);
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout) buttonBar.getLayout()).columnWidths = new int[]{0, 0, 80};
                ((GridBagLayout) buttonBar.getLayout()).columnWeights = new double[]{1.0, 0.0, 0.0};

                //---- pushBtn ----
                pushBtn.setText("\u63d0\u4ea4");
                pushBtn.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        pushBtnMouseClicked(e);
                    }
                });
                buttonBar.add(pushBtn, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                //---- saveConfigBtn ----
                saveConfigBtn.setText("\u4fdd\u5b58\u914d\u7f6e");
                saveConfigBtn.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        saveConfigBtnMouseClicked(e);
                    }
                });
                buttonBar.add(saveConfigBtn, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                //---- clearConfigBtn ----
                clearConfigBtn.setText("\u6e05\u9664\u914d\u7f6e");
                clearConfigBtn.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        clearConfigBtnMouseClicked(e);
                    }
                });
                buttonBar.add(clearConfigBtn, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Jin Svend
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JPanel panel1;
    private JLabel label2;
    private JTextField pushUrlTextField;
    private JLabel methodLabel;
    private JPanel pushPanel;
    private JPanel sitemapPanel;
    private JRadioButton sitemapRadio;
    private JTextField sitemapTextField;
    private JPanel urlPanel;
    private JRadioButton urlRadio;
    private JScrollPane scrollPane1;
    private JTextArea urlsArea;
    private JLabel label1;
    private JPanel consolePanel;
    private JScrollPane scrollPane2;
    private JTextArea consoleTextArea;
    private JPanel buttonBar;
    private JButton pushBtn;
    private JButton saveConfigBtn;
    private JButton clearConfigBtn;

    private SimpleDateFormat simpleDateFormat;
    private SitemapParseHelper sitemapParseHelper;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
