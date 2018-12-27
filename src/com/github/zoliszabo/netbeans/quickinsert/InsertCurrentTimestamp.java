/* 
 * The MIT License
 *
 * Copyright 2018 Zoli Szabó.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.github.zoliszabo.netbeans.quickinsert;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.JTextComponent;
import org.netbeans.api.editor.EditorRegistry;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Source",
        id = "com.github.zoliszabo.netbeans.quickinsert.InsertCurrentTimestamp"
)
@ActionRegistration(
        iconBase = "com/github/zoliszabo/netbeans/quickinsert/assets/time-16x16.png",
        displayName = "#CTL_InsertCurrentTimestamp",
        iconInMenu = false
)
@ActionReferences({
    @ActionReference(path = "Menu/Source", position = 9100, separatorBefore = 9050, separatorAfter = 9150),
    @ActionReference(path = "Shortcuts", name = "DS-U")
})
@Messages("CTL_InsertCurrentTimestamp=Insert Current (UNIX) Timestamp")
public final class InsertCurrentTimestamp implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JTextComponent lastFocusedEditor = EditorRegistry.lastFocusedComponent();
        if (lastFocusedEditor != null) {
            try {
                lastFocusedEditor.getDocument().insertString(
                        lastFocusedEditor.getCaretPosition(),
                        String.valueOf(System.currentTimeMillis() / 1000L),
                        null);
            } catch (BadLocationException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }
}
