package com.manager.labo.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaneTester extends JFrame implements ActionListener, KeyListener {

    public PaneTester(JPanel jPanel) {
        super();
        setSize(jPanel.getSize());
        getContentPane().add(jPanel);
        setVisible(true);
    }

    public PaneTester(ExaminationRequest jPanel) {
        this();
        setSize(jPanel.getSize());
        getContentPane().add(jPanel);
        jPanel.addListeners(this, this);
        setVisible(true);
    }

    public PaneTester() {
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static final long serialVersionUID = -2906661714721221941L;

    public static void main(String[] args) {
        new PaneTester(new ExaminationRequest());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

}
