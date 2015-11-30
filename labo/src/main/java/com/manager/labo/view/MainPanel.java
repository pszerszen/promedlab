package com.manager.labo.view;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.manager.labo.utils.ActionCommand;
import com.manager.labo.view.components.JPanelEnchancer;

public class MainPanel extends JPanel {

    private static final long serialVersionUID = 7268693817742360861L;

    @ActionCommand("Examination-Add")
    private JButton btnNewRequest;

    @ActionCommand("Patient-List")
    private JButton btnPatientsLists;

    @ActionCommand("Examination-List")
    private JButton btnExaminationList;

    public MainPanel() {
        setLayout(null);

        btnNewRequest = new JButton("Nowe zlecenie");
        btnNewRequest.setBounds(10, 49, 131, 23);
        add(btnNewRequest);

        btnPatientsLists = new JButton("Lista Pacjentów");
        btnPatientsLists.setBounds(151, 49, 131, 23);
        add(btnPatientsLists);

        btnExaminationList = new JButton("Lista Badań");
        btnExaminationList.setBounds(292, 49, 131, 23);
        add(btnExaminationList);

        new JPanelEnchancer(this).standardActions().initButtonsActionCommands();
    }

}
