package homework.controller;

import homework.view.ApplicationFormPanel;
import homework.view.ApplicantDetailPanel;
import homework.model.Applicant;
import javax.swing.*;

public class Controller {
  private static final int DETAIL_WINDOW_WIDTH = 400;
  private static final int DETAIL_WINDOW_HEIGHT = 600;
  private static final String DETAIL_WINDOW_TITLE = "รายละเอียดผู้สมัคร";

  private final ApplicationFormPanel formPanel;
  private JFrame detailWindow;

  public Controller(ApplicationFormPanel formPanel) {
    if (formPanel == null) {
      throw new IllegalArgumentException("Form panel cannot be null");
    }
    this.formPanel = formPanel;
    setupEventHandlers();
  }

  private void setupEventHandlers() {
    formPanel.getSubmitButton().addActionListener(e -> handleSubmit());
  }

  private void handleSubmit() {
    try {
      Applicant applicant = formPanel.toApplicant();
      validateApplicant(applicant);
      showApplicantDetails(applicant);
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(
          formPanel,
          "กรุณากรอกข้อมูลให้ครบถ้วน",
          "ข้อมูลไม่ครบถ้วน",
          JOptionPane.ERROR_MESSAGE);
    }
  }

  private void validateApplicant(Applicant applicant) {
    if (applicant.id().trim().isEmpty() ||
        applicant.name().trim().isEmpty() ||
        applicant.address().trim().isEmpty() ||
        applicant.province().trim().isEmpty() ||
        applicant.education().trim().isEmpty() ||
        applicant.major().trim().isEmpty()) {
      throw new IllegalArgumentException("Required fields cannot be empty");
    }
  }

  private void showApplicantDetails(Applicant applicant) {
    if (detailWindow != null) {
      detailWindow.dispose();
    }

    detailWindow = new JFrame(DETAIL_WINDOW_TITLE);
    detailWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    detailWindow.setSize(DETAIL_WINDOW_WIDTH, DETAIL_WINDOW_HEIGHT);
    detailWindow.setLocationRelativeTo(null);

    JPanel detailPanel = new ApplicantDetailPanel(applicant, this::closeDetailWindow);
    detailWindow.add(detailPanel);
    detailWindow.setVisible(true);
  }

  private void closeDetailWindow() {
    if (detailWindow != null) {
      detailWindow.dispose();
      detailWindow = null;
    }
  }
}