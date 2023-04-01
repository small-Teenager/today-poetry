package com.github.smallteenager.todaypoetry.dialog;

import com.github.smallteenager.todaypoetry.util.TextUtil;
import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

public class AlertDialog extends DialogWrapper {
    private JLabel jLabel;

    public AlertDialog() {
        super(true);
        setTitle("Today Poetry");
        init();
    }

    @Override
    protected @Nullable JComponent createCenterPanel() {

        JPanel jPanel = new JPanel(new BorderLayout());
        jLabel = new JLabel(TextUtil.getText());
        jPanel.add(jLabel);
        return jPanel;
    }

    @Override
    protected JComponent createSouthPanel() {
        JPanel jPanel = new JPanel(new BorderLayout());
        JButton jButton= new JButton("next");
        jButton.addActionListener(e -> {
            jLabel.setText(TextUtil.getText());
        });
        jPanel.add(jButton);
        return jPanel;
    }
}
