/*
 * Created by JFormDesigner on Thu Sep 29 16:18:10 CST 2016
 */

package org.svend.baiduPush.frame;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * @author Jin Svend
 */
public class Main extends JFrame {
    public Main() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Jin Svend
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        pushPanel = new JPanel();
        sitemapPanel = new JPanel();
        radioButton2 = new JRadioButton();
        textField1 = new JTextField();
        urlPanel = new JPanel();
        radioButton3 = new JRadioButton();
        scrollPane1 = new JScrollPane();
        urlTextArea = new JTextArea();
        consolePanel = new JPanel();
        label1 = new JLabel();
        scrollPane2 = new JScrollPane();
        consoleTextArea = new JTextArea();
        buttonBar = new JPanel();
        okButton = new JButton();

        //======== this ========
        setMinimumSize(new Dimension(850, 550));
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
                    java.awt.Color.red), dialogPane.getBorder())); dialogPane.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setMaximumSize(new Dimension(850, 550));
                contentPanel.setMinimumSize(new Dimension(850, 550));
                contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

                //======== pushPanel ========
                {
                    pushPanel.setMaximumSize(new Dimension(850, 300));
                    pushPanel.setMinimumSize(new Dimension(850, 300));
                    pushPanel.setLayout(new BoxLayout(pushPanel, BoxLayout.Y_AXIS));

                    //======== sitemapPanel ========
                    {
                        sitemapPanel.setMaximumSize(new Dimension(850, 35));
                        sitemapPanel.setMinimumSize(new Dimension(850, 35));
                        sitemapPanel.setLayout(new BoxLayout(sitemapPanel, BoxLayout.X_AXIS));

                        //---- radioButton2 ----
                        radioButton2.setText("sitemap\u65b9\u5f0f");
                        radioButton2.setMaximumSize(new Dimension(100, 300));
                        radioButton2.setMinimumSize(new Dimension(100, 30));
                        sitemapPanel.add(radioButton2);

                        //---- textField1 ----
                        textField1.setMaximumSize(new Dimension(745, 35));
                        textField1.setMinimumSize(new Dimension(745, 35));
                        sitemapPanel.add(textField1);
                    }
                    pushPanel.add(sitemapPanel);

                    //======== urlPanel ========
                    {
                        urlPanel.setMaximumSize(new Dimension(850, 260));
                        urlPanel.setMinimumSize(new Dimension(850, 260));
                        urlPanel.setLayout(new BoxLayout(urlPanel, BoxLayout.X_AXIS));

                        //---- radioButton3 ----
                        radioButton3.setText("\u586b\u5199URL\u65b9\u5f0f");
                        radioButton3.setMaximumSize(new Dimension(100, 23));
                        radioButton3.setMinimumSize(new Dimension(100, 23));
                        urlPanel.add(radioButton3);

                        //======== scrollPane1 ========
                        {
                            scrollPane1.setMaximumSize(new Dimension(750, 200));
                            scrollPane1.setMinimumSize(new Dimension(750, 200));
                            scrollPane1.setAutoscrolls(true);

                            //---- urlTextArea ----
                            urlTextArea.setColumns(5);
                            urlTextArea.setMaximumSize(new Dimension(850, 200));
                            scrollPane1.setViewportView(urlTextArea);
                        }
                        urlPanel.add(scrollPane1);
                    }
                    pushPanel.add(urlPanel);
                }
                contentPanel.add(pushPanel);

                //======== consolePanel ========
                {
                    consolePanel.setMaximumSize(new Dimension(850, 220));
                    consolePanel.setMinimumSize(new Dimension(850, 220));
                    consolePanel.setLayout(new BoxLayout(consolePanel, BoxLayout.Y_AXIS));

                    //---- label1 ----
                    label1.setText("\u63a7\u5236\u53f0\uff1a");
                    label1.setNextFocusableComponent(consoleTextArea);
                    consolePanel.add(label1);

                    //======== scrollPane2 ========
                    {

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
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0};

                //---- okButton ----
                okButton.setText("OK");
                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
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
    private JPanel pushPanel;
    private JPanel sitemapPanel;
    private JRadioButton radioButton2;
    private JTextField textField1;
    private JPanel urlPanel;
    private JRadioButton radioButton3;
    private JScrollPane scrollPane1;
    private JTextArea urlTextArea;
    private JPanel consolePanel;
    private JLabel label1;
    private JScrollPane scrollPane2;
    private JTextArea consoleTextArea;
    private JPanel buttonBar;
    private JButton okButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
