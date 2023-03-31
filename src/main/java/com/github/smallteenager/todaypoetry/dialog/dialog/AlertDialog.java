package com.github.smallteenager.todaypoetry.dialog.dialog;

import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.awt.*;

public class AlertDialog extends DialogWrapper {
    private JLabel jLabel;

    public AlertDialog() {
        super(true);
        setTitle("一言");
        init();
    }

    @Override
    protected @Nullable JComponent createCenterPanel() {

        JPanel jPanel = new JPanel();
        jLabel = new JLabel("一言内容");
        jPanel.add(jLabel);
        return jPanel;
    }

    @Override
    protected JComponent createSouthPanel() {
        JPanel jPanel = new JPanel();
        JButton jButton= new JButton("next");
        jButton.addActionListener(e -> {
            jLabel.setText("一言内容+1");
        });
        jPanel.add(jButton);
        return jPanel;
    }
}
