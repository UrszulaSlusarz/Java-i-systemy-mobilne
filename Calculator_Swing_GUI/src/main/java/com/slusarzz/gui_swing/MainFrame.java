package com.slusarzz.gui_swing.ui.view;


import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.*;

public class MainFrame  extends JFrame{
    private JPanel mainPanel;
    private JTextArea historyTextArea;
    private JButton evalButton;
    private JTextField formulaInput;
    private JList<LengthName> functionsList;
    private JButton button1;
    private DefaultList defaultList=new DefaultList();
    private JButton resultButton;

    public JButton getButton1() {
        return button1;
    }

    public MainFrame(){
        setSize(WIDTH,HEIGHT);
        setContentPane(mainPanel);
        setLocationRelativeTo(null);

        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500, 500);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu options = new JMenu("MENU");
        menuBar.add(options);

        JMenuItem reset = new JMenuItem("reset");
        JMenuItem exit = new JMenuItem("exit");
        options.add(reset);
        options.add(exit);

functionsList.setModel(defaultList.listModel);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                historyTextArea.setText("");
                formulaInput.setText("");
            }

        });

        functionsList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(e.getClickCount()==2){
                  String s=functionsList.getSelectedValue().getShortName();
                  formulaInput.setText(s);
                  formulaInput.requestFocus();
                  formulaInput.setCaretPosition(formulaInput.getText().length()-1);
                }
            }
        });

    }


    public JTextArea getHistoryTextArea() {
        return historyTextArea;
    }

    public JButton getEvalButton() {
        return evalButton;
    }

    public JTextField getFormulaInput() {
        return formulaInput;
    }

    public JList getFunctionsList() {
        return functionsList;
    }

    public static class DefaultList extends JFrame{

        DefaultListModel<LengthName> listModel ;
        LengthName lengthName1;
        LengthName lengthName2;
        LengthName lengthName3;
        LengthName lengthName4;
        LengthName lengthName5;
        LengthName lengthName6;
        LengthName lengthName7;
        LengthName lengthName8;
        LengthName lengthName9;

        public DefaultList() {
            lengthName1  = new LengthName("sin()", "sinus");
            lengthName2 = new LengthName("cos()", "cosinus");
            lengthName3 = new LengthName("tan()", "tangens");
            lengthName4 = new LengthName("log(,)", "logarytm");
            lengthName5 = new LengthName("mod(,)", "modulo");
            lengthName6 = new LengthName("C(,)", "Binomial_coefficient");
            lengthName7 = new LengthName("pi", "liczba_pi");
            lengthName8 = new LengthName("e", "liczba_e");
            lengthName9 = new LengthName("[phi]", "liczba_phi");


            listModel=new DefaultListModel<LengthName>();
            listModel.addElement(lengthName1);
            listModel.addElement(lengthName2);
            listModel.addElement(lengthName3);
            listModel.addElement(lengthName4);
            listModel.addElement(lengthName5);
            listModel.addElement(lengthName6);
            listModel.addElement(lengthName7);
            listModel.addElement(lengthName8);
            listModel.addElement(lengthName9);

        }
    }

    public static class LengthName extends JFrame{

       private String shortName;
       private String longName;

        public LengthName(String shortName, String longName) {
            this.shortName = shortName;
            this.longName = longName;
        }

        public String getShortName() {
            return shortName;
        }

        public void setShortName(String shortName) {
            this.shortName = shortName;
        }

        public String getLongName() {
            return longName;
        }

        public void setLongName(String longName) {
            this.longName = longName;
        }

        @Override

        public String toString() {
            return longName;
        }
    }
}

