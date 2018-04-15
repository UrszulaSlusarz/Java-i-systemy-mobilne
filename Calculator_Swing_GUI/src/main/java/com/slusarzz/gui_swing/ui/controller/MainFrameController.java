package com.slusarzz.gui_swing.ui.controller;

import com.slusarzz.gui_swing.ui.view.MainFrame;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.awt.event.*;
import org.mariuszgromada.math.mxparser.*;
import java.text.MessageFormat;

public  class MainFrameController extends JFrame implements KeyListener{

    private MainFrame mathscalculator;
    private JButton evalButton;
    private JTextArea historyTextArea;
    private JTextField formulaInput;
    private JList functionsList;
    private String lastInput;
    private String lastResult;
    private String lastResultt;
    private JButton resultBatton;


    public MainFrameController() {
        initComponete();
        initListeners();
    }


    private void initComponete() {
        mathscalculator = new MainFrame();
        evalButton = mathscalculator.getEvalButton();
        historyTextArea = mathscalculator.getHistoryTextArea();
        formulaInput = mathscalculator.getFormulaInput();
        functionsList = mathscalculator.getFunctionsList();
        resultBatton=mathscalculator.getButton1();

        // READ ONLY
        historyTextArea.setEditable(false);
    }

    public void initListeners() {
        evalButton.addActionListener(new TextOut());
        resultBatton.addActionListener(new TextOuttwo());
        formulaInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getExtendedKeyCode()) {
                    case KeyEvent.VK_UP:
                        formulaInput.setText(lastInput);
                        break;
                    case KeyEvent.VK_ENTER:
                        Expression eh = new Expression(formulaInput.getText());
                        if(eh.checkSyntax()) {
                            historyTextArea.append(formulaInput.getText() + " =" + (eh.calculate()) + "\n                         \n" );
                            lastInput = formulaInput.getText();
                            lastResultt=String.valueOf(eh.calculate());
                            formulaInput.setText(lastResultt);
                            formulaInput.setText("");
                        }
                        else
                        JOptionPane.showMessageDialog(null,"Wprowadzono bledne dane.","error", JOptionPane.ERROR_MESSAGE);
                       formulaInput.setText(" ");
                        break;
                }
            }
        });
    }


    //WYSWIETLANIE Z formulaInput
    private class TextOut implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Expression eh = new Expression(formulaInput.getText());
            if(eh.checkSyntax()) {
                historyTextArea.append(formulaInput.getText() + " =" + (eh.calculate()) + "\n                         \n");
                lastInput = formulaInput.getText();
                formulaInput.setText(lastInput);
                lastResult=String.valueOf(eh.calculate());
                formulaInput.setText(lastResult);
                formulaInput.setText("");
            }
            else
            JOptionPane.showMessageDialog(null,"Wprowadzono bledne dane.","error", JOptionPane.ERROR_MESSAGE);
            formulaInput.setText(" ");

        }
    }

    private class TextOuttwo implements ActionListener {
        public void actionPerformed(ActionEvent e) {

        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}


