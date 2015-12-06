package com.manager.labo.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.manager.labo.model.ExaminationModel;
import com.manager.labo.model.ExaminationRequestModel;
import com.manager.labo.view.components.JPanelEnchancer;

public class PaneTester extends JFrame implements ActionListener, KeyListener {

    public PaneTester(JPanel jPanel) {
        this();
        setSize(jPanel.getSize());
        setContentPane(jPanel);
        new JPanelEnchancer(jPanel).addListeners(this, this);
        setVisible(true);
    }

    public PaneTester() {
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static final long serialVersionUID = -2906661714721221941L;

    public static void main(String[] args) {
        ExaminationRequestModel model = new ExaminationRequestModel();

        model.setAddress1("address1");
        model.setAddress2("address2");
        model.setCity("city");
        model.setExaminationId(0L);
        model.setFirstName("name");
        model.setLastName("surname");
        model.setPesel("91080208596");
        model.setPhone("798749030");
        model.setZipCode("20-570");
        model.addExamination(new ExaminationModel("A", "description A1"));
        model.addExamination(new ExaminationModel("A", "description A2"));
        model.addExamination(new ExaminationModel("A", "description A3"));
        model.addExamination(new ExaminationModel("B", "description B1"));
        model.addExamination(new ExaminationModel("B", "description B2"));
        model.addExamination(new ExaminationModel("B", "description B3"));
        model.addExamination(new ExaminationModel("C", "description C1"));
        model.addExamination(new ExaminationModel("C", "description C2"));
        model.addExamination(new ExaminationModel("C", "description C3"));

        final ExaminationDetails jPanel = new ExaminationDetails(model);
        new PaneTester(jPanel);
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
