/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Hieu
 */
public class DiaLogMes {
    public void alert(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message,
                "Phần Mềm Hệ Thống", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean confirm(Component parent, String message) {
        int result = JOptionPane.showConfirmDialog(parent, message,
                "Phần Mềm Hệ Thống",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        return result == JOptionPane.YES_OPTION;
    }

    public String prompt(Component parent, String message) {
        return JOptionPane.showInputDialog(parent, message,
                "Phần Mềm Hệ Thống", JOptionPane.INFORMATION_MESSAGE);

    }
}
