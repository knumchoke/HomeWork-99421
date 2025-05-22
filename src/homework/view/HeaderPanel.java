package homework.view;

import homework.UIConstants;
import javax.swing.*;
import java.awt.*;

public class HeaderPanel extends JPanel {
  public HeaderPanel() {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    add(createLabel("บริษัท STOU-TEC จำกัด", UIConstants.HEADING_FONT));
    add(Box.createVerticalStrut(5));
    add(createLabel("แบบฟอร์มใบสมัครพนักงาน", UIConstants.SUBHEADING_FONT));
    add(Box.createVerticalStrut(5));
    add(createLabel("ใบสมัครตำแหน่งงานด้าน ICT นี้ ให้ผู้สมัครกรอกรายละเอียดต่อไปนี้เพื่อที่", UIConstants.BODY_FONT));
    add(createLabel("บริษัท STOU-TEC จำกัด จะพิจารณาคัดเลือกตามความเหมาะสม", UIConstants.BODY_FONT));
  }

  private JLabel createLabel(String text, Font font) {
    JLabel label = new JLabel(text);
    label.setFont(font);
    label.setAlignmentX(Component.CENTER_ALIGNMENT);
    return label;
  }
}