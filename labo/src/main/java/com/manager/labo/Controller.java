package com.manager.labo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.manager.labo.service.ExaminationService;
import com.manager.labo.service.IcdService;
import com.manager.labo.service.PatientService;
import com.manager.labo.utils.ActionCommands;
import com.manager.labo.view.ExaminationDetails;
import com.manager.labo.view.ExaminationList;
import com.manager.labo.view.MainPanel;
import com.manager.labo.view.PatientList;
import com.manager.labo.view.components.JPanelEnchancer;

@Component
public class Controller extends JFrame implements ActionListener {

    private static final long serialVersionUID = -8827922871122450688L;

    private MainPanel mainPanel;

    private ExaminationList examinationList;

    private PatientList patientList;

    private ExaminationDetails examinationDetails;

    @Autowired
    private IcdService icdService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private ExaminationService examinationService;

    public Controller() {
        super("PRO-LAB-MANAGER");
        setMainPanel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Patient-See":
                break;
            case "Examination-See":
                break;
        }
    }

    private void setMainPanel() {
        if (mainPanel == null) {
            mainPanel = new MainPanel();
            new JPanelEnchancer(mainPanel)
                    .addAction(ActionCommands.EXAMINATION_ADD, e -> {
                        examinationDetails = new ExaminationDetails();
                        setExaminationDetailsActions();
                    })
                    .addAction(ActionCommands.PATIENT_LIST, e -> setPatientList())
                    .addAction(ActionCommands.EXAMINATION_LIST, e -> setExaminationList());
        }
        setCurrentPanel(mainPanel);
    }

    private void setPatientList() {
        if (patientList == null) {
            patientList = new PatientList();
            new JPanelEnchancer(patientList)
                    .addAction(ActionCommands.EXIT, e -> {
                        System.exit(0);
                    })
                    .addListeners(this, null);
        }
        // TODO patient model list
        patientList.reloadTable(null);
        setCurrentPanel(patientList);
    }

    private void setExaminationList() {
        if (examinationList == null) {
            examinationList = new ExaminationList();
            new JPanelEnchancer(examinationList)
                    .addAction(ActionCommands.EXIT, e -> {
                        System.exit(0);
                    })
                    .addListeners(this, null);
        }
        examinationList.reloadTable(examinationService.getExaminationModels());
        setCurrentPanel(examinationList);
    }

    private void setExaminationDetailsActions() {
        if (examinationDetails != null) {
            examinationDetails.initExaminationGroups(icdService.getGroups());
            new JPanelEnchancer(examinationDetails)
                    .addAction(ActionCommands.SWITCH_AVAILABLE_EXAMINATIONS, e -> {
                        examinationDetails.rewriteAvailableExaminations(
                                icdService.getExaminationsFromGroup(
                                        examinationDetails.getCurrentExaminationGroup()));
            })
                    .addAction(ActionCommands.SEARCH_FOR_PATIENT, e -> {

            })
                    .addAction(ActionCommands.REMOVE_FROM_EXAMINATIONS, e -> {

            })
                    .addAction(ActionCommands.ADD_TO_EXAMINATIONS, e -> {

            });
        }
        setCurrentPanel(examinationDetails);
    }

    private void setCurrentPanel(JPanel jPanel) {
        setContentPane(jPanel);
        setSize(jPanel.getWidth() + 50, jPanel.getHeight() + 50);
    }
}
