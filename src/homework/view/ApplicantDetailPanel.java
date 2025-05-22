package homework.view;

import homework.UIConstants;
import homework.model.Applicant;
import javax.swing.*;
import java.awt.*;

public class ApplicantDetailPanel extends JPanel {
  private static final long serialVersionUID = 1L;

  public ApplicantDetailPanel(Applicant applicant, Runnable onEdit) {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    addTitle();
    add(Box.createVerticalStrut(10));
    ApplicantInfoPanel infoPanel = new ApplicantInfoPanel(applicant);
    add(infoPanel);
    add(Box.createVerticalStrut(10));
    addEditButton(onEdit);
  }

  private void addTitle() {
    JLabel title = new JLabel("รายละเอียดของผู้สมัคร");
    title.setFont(UIConstants.HEADING_FONT);
    title.setAlignmentX(Component.LEFT_ALIGNMENT);
    title.setMaximumSize(new Dimension(Integer.MAX_VALUE, title.getPreferredSize().height));
    title.setHorizontalAlignment(SwingConstants.LEFT);
    add(title);
  }

  private void addEditButton(Runnable onEdit) {
    JButton btnEdit = new JButton("แก้ไข");
    btnEdit.setAlignmentX(Component.LEFT_ALIGNMENT);
    btnEdit.addActionListener(_ -> {
      if (onEdit != null) {
        onEdit.run();
      }
    });
    add(btnEdit);
  }
}