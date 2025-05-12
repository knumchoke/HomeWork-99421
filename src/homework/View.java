package homework;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class View {

  Driver label = new Driver();

  public static class MainWindow extends JFrame {
    MainWindow() {
      this.setSize(570, 720);
      this.setLocationRelativeTo((Component) null);
      this.setDefaultCloseOperation(3);
      this.add(new HeaderPanel(), "North");
      ApplicationFormPanel formPanel = new ApplicationFormPanel();
      this.add(formPanel, "Center");
      new Controller(formPanel);
    }
  }

  private static class HeaderPanel extends JPanel {
    HeaderPanel() {
      this.setLayout(new GridLayout(0, 1));
      Font heading = new Font("SansSerif", 1, 18);
      Font sub = new Font("SansSerif", 1, 16);
      Font body = new Font("SansSerif", 1, 14);
      this.add(Driver.label("บริษัท STOU-TEC จำกัด", heading));
      this.add(Driver.label("แบบฟอร์มใบสมัครพนักงาน", sub));
      this.add(Driver.label("ใบสมัครตำแหน่งงานด้าน ICT นี้ ให้ผู้สมัครกรอกรายละเอียดต่อไปนี้เพื่อที่", body));
      this.add(Driver.label("บริษัท STOU-TEC จำกัด จะพิจารณาคัดเลือกตามความเหมาะสม", body));
    }
  }

  public static class ApplicationFormPanel extends JPanel {
    private static final int NUM_QUALS = 5;
    private static final int NUM_POSITIONS = 3;

    public record Applicant(
        String id,
        String name,
        String address,
        String province,
        String sex,
        String education,
        String major,
        List<String> qualifications,
        List<String> desiredPositions) {
    }

    private final JTextField AP_ID = new JTextField(24);
    private final JTextField AP_NAME = new JTextField(24);
    private final JTextField AP_ADDRESS = new JTextField(24);
    private final JTextField AP_CHW = new JTextField(12);
    private final JRadioButton AP_SEX_M = new JRadioButton("ชาย", true);
    private final JRadioButton AP_SEX_F = new JRadioButton("หญิง");
    private final JTextField AP_ED = new JTextField(24);
    private final JTextField AP_MAJ = new JTextField(24);
    @SuppressWarnings("unchecked")
    private final JComboBox<Qualification>[] cbQual = new JComboBox[NUM_QUALS];
    @SuppressWarnings("unchecked")
    private final JComboBox<Position>[] cbPos = new JComboBox[NUM_POSITIONS];
    private final JButton btnOk = new JButton("ตกลง");

    public JButton getOkButton() {
      return btnOk;
    }

    ApplicationFormPanel() {
      super(new GridBagLayout());
      GridBagConstraints g = this.createDefaultConstraints();
      int row = 0;
      row = this.addPersonalInfoSection(g, row);
      row = this.addQualificationSection(g, row);
      row = this.addPositionSection(g, row);
      this.addOkButton(g, row);
    }

    private GridBagConstraints createDefaultConstraints() {
      GridBagConstraints g = new GridBagConstraints();
      g.insets = new Insets(2, 4, 2, 4);
      g.anchor = 17;
      g.fill = 2;
      return g;
    }

    private int addPersonalInfoSection(GridBagConstraints g, int row) {
      Font body = new Font("SansSerif", 0, 14);
      this.addField(g, row++, "เลขประจำตัวของผู้สมัคร (AP_ID):", this.AP_ID);
      this.addField(g, row++, "ชื่อ-นามสกุล (AP_NAME):", this.AP_NAME);
      this.addField(g, row++, "ที่อยู่ (AP_ADDRESS):", this.AP_ADDRESS);
      this.addField(g, row++, "จังหวัด (AP_CHW):", this.AP_CHW);
      ButtonGroup sexGroup = new ButtonGroup();
      sexGroup.add(this.AP_SEX_M);
      sexGroup.add(this.AP_SEX_F);
      this.addField(g, row++, "เพศ (AP_SEX):", this.wrap(this.AP_SEX_M, this.AP_SEX_F));
      this.addField(g, row++, "วุฒิการศึกษาสูงสุด (AP_ED):", this.AP_ED);
      g.gridx = 0;
      g.gridy = row++;
      g.gridwidth = 1;
      JLabel lblEduHint = new JLabel("(เช่น B.S., B.A., M.S., M.BA, M.A.)");
      lblEduHint.setFont(body);
      this.add(lblEduHint, g);
      this.addField(g, row++, "วิชาเอก (AP_MAJ):", this.AP_MAJ);
      return row;
    }

    private int addQualificationSection(GridBagConstraints g, int row) {
      Font body = new Font("SansSerif", 0, 14);
      g.gridx = 0;
      g.gridy = row++;
      g.gridwidth = 2;
      JLabel lblQualDesc = new JLabel(
          "ความรู้ความสามารถหรือคุณสมบัติเฉพาะตำแหน่ง (QUAL_DESC) (ตอบได้ไม่เกิน 5 รายการ)");
      lblQualDesc.setFont(body);
      this.add(lblQualDesc, g);
      g.gridwidth = 1;
      List<Qualification> qualifications = Qualification.getSampleQualifications();

      for (int i = 0; i < this.cbQual.length; ++i) {
        List<Qualification> listWithDefault = new ArrayList<>();
        listWithDefault.add(new Qualification("", "เลือกความรู้ความสามารถ " + (i + 1)));
        listWithDefault.addAll(qualifications);
        this.cbQual[i] = new JComboBox<>(listWithDefault.toArray(new Qualification[0]));
        this.addField(g, row++, "ความรู้ความสามารถ " + (i + 1) + ":", this.cbQual[i]);
      }

      return row;
    }

    private int addPositionSection(GridBagConstraints g, int row) {
      Font body = new Font("SansSerif", 0, 14);
      g.gridx = 0;
      g.gridy = row++;
      g.gridwidth = 2;
      JLabel lblPosDesc = new JLabel("ตำแหน่งที่ต้องการสมัคร (POS_NAME) : (ตอบได้ไม่เกิน 3 ตำแหน่ง)");
      lblPosDesc.setFont(body);
      this.add(lblPosDesc, g);
      g.gridwidth = 1;
      List<Position> positions = Position.getSamplePositions();

      for (int i = 0; i < this.cbPos.length; ++i) {
        List<Position> listWithDefault = new ArrayList<>();
        listWithDefault.add(new Position("", "เลือตำแหน่งที่ต้องการสมัคร " + (i + 1)));
        listWithDefault.addAll(positions);
        this.cbPos[i] = new JComboBox<>(listWithDefault.toArray(new Position[0]));
        this.addField(g, row++, "ตำแหน่งที่ต้องการสมัคร " + (i + 1) + ":", this.cbPos[i]);
      }

      return row;
    }

    private void addOkButton(GridBagConstraints g, int row) {
      g.gridx = 0;
      g.gridy = row;
      g.gridwidth = 2;
      g.anchor = 10;
      this.add(this.btnOk, g);
    }

    private void addField(GridBagConstraints g, int row, String label, JComponent comp) {
      g.gridx = 0;
      g.gridy = row;
      g.gridwidth = 1;
      g.fill = 0;
      g.weightx = 0.0;
      this.add(new JLabel(label), g);
      g.gridx = 1;
      g.gridy = row;
      g.weightx = 0.0;
      g.fill = 0;
      this.add(comp, g);
    }

    private JPanel wrap(JComponent... components) {
      JPanel p = new JPanel(new FlowLayout(0, 5, 0));
      JComponent[] var6 = components;
      int var5 = components.length;

      for (int var4 = 0; var4 < var5; ++var4) {
        JComponent c = var6[var4];
        p.add(c);
      }

      return p;
    }

    public Applicant toApplicant() {
      List<String> qual = new ArrayList<>();
      JComboBox<Qualification>[] var5;
      int var4 = (var5 = this.cbQual).length;

      for (int var3 = 0; var3 < var4; ++var3) {
        JComboBox<Qualification> cb = var5[var3];
        qual.add(cb.getSelectedItem() != null ? cb.getSelectedItem().toString() : "");
      }

      List<String> pos = new ArrayList<>();
      JComboBox<Position>[] var6;
      int var9 = (var6 = this.cbPos).length;

      for (var4 = 0; var4 < var9; ++var4) {
        JComboBox<Position> cb = var6[var4];
        pos.add(cb.getSelectedItem() != null ? cb.getSelectedItem().toString() : "");
      }

      return new Applicant(this.AP_ID.getText().trim(), this.AP_NAME.getText().trim(), this.AP_ADDRESS.getText().trim(),
          this.AP_CHW.getText().trim(), this.AP_SEX_M.isSelected() ? "ชาย" : "หญิง", this.AP_ED.getText().trim(),
          this.AP_MAJ.getText().trim(), qual, pos);
    }
  }

  public static class ApplicantDetailPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    public ApplicantDetailPanel(ApplicationFormPanel.Applicant applicant, Runnable onEdit) {
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

      JLabel title = new JLabel("รายละเอียดของผู้สมัคร");
      title.setFont(new Font("SansSerif", Font.BOLD, 18));
      title.setAlignmentX(Component.CENTER_ALIGNMENT);
      add(title);
      add(Box.createVerticalStrut(20));

      add(new ApplicantInfoPanel(applicant));
      add(Box.createVerticalStrut(20));
      JButton btnEdit = new JButton("แก้ไข");
      btnEdit.setAlignmentX(Component.CENTER_ALIGNMENT);
      btnEdit.addActionListener(_ -> {
        if (onEdit != null)
          onEdit.run();
      });
      add(btnEdit);
    }
  }

  public static class ApplicantInfoPanel extends JPanel {
    public ApplicantInfoPanel(ApplicationFormPanel.Applicant applicant) {
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      setAlignmentX(Component.LEFT_ALIGNMENT);

      addLabel("เลขประจำตัวของผู้สมัคร: " + applicant.id());
      addLabel("ชื่อ-นามสกุล: " + applicant.name());
      addLabel("ที่อยู่: " + applicant.address());
      addLabel("จังหวัด: " + applicant.province());
      addLabel("เพศ: " + applicant.sex());
      addLabel("วุฒิการศึกษาสูงสุด: " + applicant.education());
      addLabel("วิชาเอก: " + applicant.major());

      List<String> qual = applicant.qualifications();
      for (int i = 0; i < qual.size(); i++) {
        addLabel("ความรู้ความสามารถ " + (i + 1) + ": " + qual.get(i));
      }
      List<String> pos = applicant.desiredPositions();
      for (int i = 0; i < pos.size(); i++) {
        addLabel("ตำแหน่งที่ต้องการสมัคร " + (i + 1) + ": " + pos.get(i));
      }
    }

    private void addLabel(String text) {
      JLabel lbl = new JLabel(text);
      lbl.setAlignmentX(Component.LEFT_ALIGNMENT);
      lbl.setHorizontalAlignment(SwingConstants.LEFT);
      add(lbl);
    }
  }
}