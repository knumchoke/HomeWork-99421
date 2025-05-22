package homework.view;

import homework.UIConstants;
import homework.model.Applicant;
import homework.model.Qualification;
import homework.model.Position;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ApplicationFormPanel extends JPanel {
  private final JTextField idField = new JTextField(24);
  private final JTextField nameField = new JTextField(24);
  private final JTextField addressField = new JTextField(24);
  private final JTextField provinceField = new JTextField(12);
  private final JRadioButton maleRadio = new JRadioButton("ชาย", true);
  private final JRadioButton femaleRadio = new JRadioButton("หญิง");
  private final JTextField educationField = new JTextField(24);
  private final JTextField majorField = new JTextField(24);
  @SuppressWarnings("unchecked")
  private final JComboBox<Qualification>[] qualificationComboBoxes = new JComboBox[UIConstants.MAX_QUALIFICATIONS];
  @SuppressWarnings("unchecked")
  private final JComboBox<Position>[] positionComboBoxes = new JComboBox[UIConstants.MAX_POSITIONS];
  private final JButton submitButton = new JButton("ตกลง");

  public ApplicationFormPanel() {
    super(new GridBagLayout());
    initializeComponents();
    layoutComponents();
  }

  private void initializeComponents() {
    ButtonGroup sexGroup = new ButtonGroup();
    sexGroup.add(maleRadio);
    sexGroup.add(femaleRadio);

    initializeQualificationComboBoxes();
    initializePositionComboBoxes();
  }

  private void initializeQualificationComboBoxes() {
    List<Qualification> qualifications = Qualification.getSampleQualifications();
    for (int i = 0; i < qualificationComboBoxes.length; i++) {
      List<Qualification> listWithDefault = new ArrayList<>();
      listWithDefault.add(new Qualification("", "เลือกความรู้ความสามารถ " + (i + 1)));
      listWithDefault.addAll(qualifications);
      qualificationComboBoxes[i] = new JComboBox<>(listWithDefault.toArray(new Qualification[0]));
    }
  }

  private void initializePositionComboBoxes() {
    List<Position> positions = Position.getSamplePositions();
    for (int i = 0; i < positionComboBoxes.length; i++) {
      List<Position> listWithDefault = new ArrayList<>();
      listWithDefault.add(new Position("", "เลือกตำแหน่งที่ต้องการสมัคร " + (i + 1)));
      listWithDefault.addAll(positions);
      positionComboBoxes[i] = new JComboBox<>(listWithDefault.toArray(new Position[0]));
    }
  }

  private void layoutComponents() {
    GridBagConstraints g = createDefaultConstraints();
    int row = 0;

    row = addPersonalInfoSection(g, row);
    row = addQualificationSection(g, row);
    row = addPositionSection(g, row);
    addSubmitButton(g, row);
  }

  private GridBagConstraints createDefaultConstraints() {
    GridBagConstraints g = new GridBagConstraints();
    g.insets = new Insets(UIConstants.GRID_INSET, UIConstants.GRID_PADDING,
        UIConstants.GRID_INSET, UIConstants.GRID_PADDING);
    g.anchor = GridBagConstraints.WEST;
    g.fill = GridBagConstraints.HORIZONTAL;
    return g;
  }

  private int addPersonalInfoSection(GridBagConstraints g, int row) {
    addField(g, row++, "เลขประจำตัวของผู้สมัคร (AP_ID):", idField);
    addField(g, row++, "ชื่อ-นามสกุล (AP_NAME):", nameField);
    addField(g, row++, "ที่อยู่ (AP_ADDRESS):", addressField);
    addField(g, row++, "จังหวัด (AP_CHW):", provinceField);
    addField(g, row++, "เพศ (AP_SEX):", createSexPanel());
    addField(g, row++, "วุฒิการศึกษาสูงสุด (AP_ED):", educationField);
    addEducationHint(g, row++);
    addField(g, row++, "วิชาเอก (AP_MAJ):", majorField);
    return row;
  }

  private JPanel createSexPanel() {
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
    panel.add(maleRadio);
    panel.add(femaleRadio);
    return panel;
  }

  private void addEducationHint(GridBagConstraints g, int row) {
    g.gridx = 0;
    g.gridy = row;
    g.gridwidth = 1;
    JLabel lblEduHint = new JLabel("(เช่น B.S., B.A., M.S., M.BA, M.A.)");
    lblEduHint.setFont(UIConstants.NORMAL_FONT);
    add(lblEduHint, g);
  }

  private int addQualificationSection(GridBagConstraints g, int row) {
    addSectionHeader(g, row++, "ความรู้ความสามารถหรือคุณสมบัติเฉพาะตำแหน่ง (QUAL_DESC) (ตอบได้ไม่เกิน 5 รายการ)");

    for (int i = 0; i < qualificationComboBoxes.length; i++) {
      addField(g, row++, "ความรู้ความสามารถ " + (i + 1) + ":", qualificationComboBoxes[i]);
    }
    return row;
  }

  private int addPositionSection(GridBagConstraints g, int row) {
    addSectionHeader(g, row++, "ตำแหน่งที่ต้องการสมัคร (POS_NAME) : (ตอบได้ไม่เกิน 3 ตำแหน่ง)");

    for (int i = 0; i < positionComboBoxes.length; i++) {
      addField(g, row++, "ตำแหน่งที่ต้องการสมัคร " + (i + 1) + ":", positionComboBoxes[i]);
    }
    return row;
  }

  private void addSectionHeader(GridBagConstraints g, int row, String text) {
    g.gridx = 0;
    g.gridy = row;
    g.gridwidth = 2;
    JLabel header = new JLabel(text);
    header.setFont(UIConstants.NORMAL_FONT);
    add(header, g);
    g.gridwidth = 1;
  }

  private void addSubmitButton(GridBagConstraints g, int row) {
    g.gridx = 0;
    g.gridy = row;
    g.gridwidth = 2;
    g.anchor = GridBagConstraints.CENTER;
    add(submitButton, g);
  }

  private void addField(GridBagConstraints g, int row, String label, JComponent component) {
    g.gridx = 0;
    g.gridy = row;
    g.gridwidth = 1;
    g.fill = GridBagConstraints.NONE;
    g.weightx = 0.0;
    add(new JLabel(label), g);

    g.gridx = 1;
    g.gridy = row;
    g.weightx = 0.0;
    g.fill = GridBagConstraints.NONE;
    add(component, g);
  }

  public JButton getSubmitButton() {
    return submitButton;
  }

  public Applicant toApplicant() {
    List<String> qualifications = new ArrayList<>();
    for (JComboBox<Qualification> cb : qualificationComboBoxes) {
      qualifications.add(cb.getSelectedItem() != null ? cb.getSelectedItem().toString() : "");
    }

    List<String> positions = new ArrayList<>();
    for (JComboBox<Position> cb : positionComboBoxes) {
      positions.add(cb.getSelectedItem() != null ? cb.getSelectedItem().toString() : "");
    }

    return new Applicant.Builder()
        .id(idField.getText().trim())
        .name(nameField.getText().trim())
        .address(addressField.getText().trim())
        .province(provinceField.getText().trim())
        .sex(maleRadio.isSelected() ? "ชาย" : "หญิง")
        .education(educationField.getText().trim())
        .major(majorField.getText().trim())
        .qualifications(qualifications)
        .desiredPositions(positions)
        .build();
  }
}