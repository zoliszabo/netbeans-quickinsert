/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.zoliszabo.netbeans.quickinsert;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Source",
        id = "com.github.zoliszabo.netbeans.quickinsert.InsertCurrentTimestamp"
)
@ActionRegistration(
        iconBase = "com/github/zoliszabo/netbeans/quickinsert/assets/time-16x16.png",
        displayName = "#CTL_InsertCurrentTimestamp"
)
@ActionReferences({
    @ActionReference(path = "Menu/Source", position = 9100, separatorBefore = 9050, separatorAfter = 9150),
    @ActionReference(path = "Shortcuts", name = "DS-U")
})
@Messages("CTL_InsertCurrentTimestamp=Insert Current (UNIX) Timestamp")
public final class InsertCurrentTimestamp implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO implement action body
    }
}
