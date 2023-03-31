package com.github.smallteenager.todaypoetry.compontent;

import com.github.smallteenager.todaypoetry.dialog.dialog.AlertDialog;
import com.intellij.openapi.components.ApplicationComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyApplicationComponent implements ApplicationComponent {

    private static final Logger log = LoggerFactory.getLogger(MyApplicationComponent.class);

    @Override
    public void initComponent(){
        log.info("initComponent start");
        AlertDialog alertDialog = new AlertDialog();
        alertDialog.show();
    }

}
