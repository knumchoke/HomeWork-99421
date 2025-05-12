package homework;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Controller {
  private final View.ApplicationFormPanel formPanel;

  public Controller(View.ApplicationFormPanel formPanel) {
    this.formPanel = formPanel;
    setupEventHandlers();
  }

  private void setupEventHandlers() {
    formPanel.getOkButton().addActionListener(createOkButtonListener());
  }

  private ActionListener createOkButtonListener() {
    return _ -> {
      View.ApplicationFormPanel.Applicant applicant = formPanel.toApplicant();
      JFrame detailFrame = new JFrame();
      detailFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
      detailFrame.setContentPane(new View.ApplicantDetailPanel(applicant, detailFrame::dispose));
      detailFrame.pack();
      detailFrame.setLocationRelativeTo(formPanel);
      detailFrame.setVisible(true);
    };
  }
}
