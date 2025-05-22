package homework.view;

import homework.UIConstants;
import homework.model.Applicant;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ApplicantInfoPanel extends JPanel {
  public ApplicantInfoPanel(Applicant applicant) {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    setAlignmentX(Component.LEFT_ALIGNMENT);
    addPersonalInfo(applicant);
    addQualifications(applicant.qualifications());
    addPositions(applicant.desiredPositions());
  }

  private void addPersonalInfo(Applicant applicant) {
    addLabel("เลขประจำตัวของผู้สมัคร: " + applicant.id());
    addLabel("ชื่อ-นามสกุล: " + applicant.name());
    addLabel("ที่อยู่: " + applicant.address());
    addLabel("จังหวัด: " + applicant.province());
    addLabel("เพศ: " + applicant.sex());
    addLabel("วุฒิการศึกษาสูงสุด: " + applicant.education());
    addLabel("วิชาเอก: " + applicant.major());
  }

  private void addQualifications(List<String> qualifications) {
    for (int i = 0; i < qualifications.size(); i++) {
      addLabel("ความรู้ความสามารถ " + (i + 1) + ": " + qualifications.get(i));
    }
  }

  private void addPositions(List<String> positions) {
    for (int i = 0; i < positions.size(); i++) {
      addLabel("ตำแหน่งที่ต้องการสมัคร " + (i + 1) + ": " + positions.get(i));
    }
  }

  private void addLabel(String text) {
    JLabel lbl = new JLabel("<html><div style='width:350px;'>" + text + "</div></html>");
    lbl.setFont(UIConstants.NORMAL_FONT);
    lbl.setAlignmentX(Component.LEFT_ALIGNMENT);
    add(lbl);
    add(Box.createVerticalStrut(4));
  }
}