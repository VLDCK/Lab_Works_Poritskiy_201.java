package Lab_6_Pack;

import Lab_3_Pack.PrivateAuto;
import Lab_3_Pack.Record;
import Lab_5_Pack.RecordDAO;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

public class Update extends JFrame {

    private JPanel updatePanel;
    private JList list1;
    private JTextField modelField;

    private JButton updateRECORD;
    private JButton menu;
    private JTextField nameField;
    private JLabel successText;

    public static String recordValue;
    public JTextField recordText;
    public RecordDAO recordDAO = new RecordDAO();

    List<Record> recordList = new ArrayList<>(10);

    public Update(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(updatePanel);
        this.successText.setVisible(false);
        this.pack();


        /*recordText.setVisible(true);
        recordText.setText(recordValue);*/

        //int number = record.privateAuto.getNumber();


        recordList = recordDAO.getAll();
        Vector<Record> records = new Vector<>(recordList);
        DefaultComboBoxModel<Record> recordDCBM = new DefaultComboBoxModel<>(records);
        list1.setModel(recordDCBM);


        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame mainPanel = new Main("Main");
                mainPanel.setBounds(615, 315, 750, 450);
                mainPanel.setVisible(true);
                dispose();
            }
        });

        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Record selectedRecord = (Record) list1.getSelectedValue();

                modelField.setText(selectedRecord.privateAuto.getModelOfCar());
                nameField.setText(selectedRecord.privateAuto.getOwner());
            }
        });

        updateRECORD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Record setNewRecord = (Record) list1.getSelectedValue();


                String mod = modelField.getText();
                String name = nameField.getText();

                setNewRecord = new Record(new PrivateAuto(setNewRecord.privateAuto.getNumber(), mod, name,
                        setNewRecord.privateAuto.getParkingDays()), setNewRecord.getDateOfEnter());
                try {
                    recordDAO.update(setNewRecord);
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
                successText.setVisible(true);
            }
        });
    }


    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        updatePanel = new JPanel();
        updatePanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(6, 2, new Insets(0, 0, 0, 0), -1, -1));
        updatePanel.setBackground(new Color(-14407116));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$("Roboto Light", Font.PLAIN, 20, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setForeground(new Color(-6841669));
        label1.setText("Set New Model ");
        updatePanel.add(label1, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        Font label2Font = this.$$$getFont$$$("Roboto Light", Font.PLAIN, 20, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setForeground(new Color(-6841669));
        label2.setText("Set New Name ");
        updatePanel.add(label2, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        updateRECORD = new JButton();
        updateRECORD.setBackground(new Color(-7357510));
        Font updateRECORDFont = this.$$$getFont$$$("Roboto Light", Font.PLAIN, 18, updateRECORD.getFont());
        if (updateRECORDFont != null) updateRECORD.setFont(updateRECORDFont);
        updateRECORD.setForeground(new Color(-13223861));
        updateRECORD.setText("UPDATE RECORD");
        updatePanel.add(updateRECORD, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        menu = new JButton();
        menu.setBackground(new Color(-7357510));
        Font menuFont = this.$$$getFont$$$("Roboto Light", Font.PLAIN, 18, menu.getFont());
        if (menuFont != null) menu.setFont(menuFont);
        menu.setForeground(new Color(-13223861));
        menu.setText("MENU");
        updatePanel.add(menu, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        list1 = new JList();
        list1.setBackground(new Color(-7357510));
        Font list1Font = this.$$$getFont$$$("Roboto Light", Font.PLAIN, 16, list1.getFont());
        if (list1Font != null) list1.setFont(list1Font);
        list1.setForeground(new Color(-14407116));
        updatePanel.add(list1, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        modelField = new JTextField();
        modelField.setBackground(new Color(-7357510));
        Font modelFieldFont = this.$$$getFont$$$("Source Code Pro", Font.BOLD, 16, modelField.getFont());
        if (modelFieldFont != null) modelField.setFont(modelFieldFont);
        modelField.setForeground(new Color(-14407116));
        updatePanel.add(modelField, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        nameField = new JTextField();
        nameField.setBackground(new Color(-7357510));
        Font nameFieldFont = this.$$$getFont$$$("Source Code Pro", Font.BOLD, 16, nameField.getFont());
        if (nameFieldFont != null) nameField.setFont(nameFieldFont);
        nameField.setForeground(new Color(-14407116));
        updatePanel.add(nameField, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        successText = new JLabel();
        Font successTextFont = this.$$$getFont$$$("Roboto Light", Font.PLAIN, 19, successText.getFont());
        if (successTextFont != null) successText.setFont(successTextFont);
        successText.setForeground(new Color(-6841669));
        successText.setText("YOUR RECORD WAS UPGRADED");
        updatePanel.add(successText, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        Font label3Font = this.$$$getFont$$$("Roboto Light", Font.PLAIN, 24, label3.getFont());
        if (label3Font != null) label3.setFont(label3Font);
        label3.setForeground(new Color(-7357510));
        label3.setText("UPDATE RECORD");
        updatePanel.add(label3, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return updatePanel;
    }

}
