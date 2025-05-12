package homework;

import java.awt.*;
import javax.swing.*;

public class Driver {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      (new View.MainWindow()).setVisible(true);
    });
  }

  public static JLabel label(String text, Font f) {
    JLabel lbl = new JLabel(text, 0);
    lbl.setFont(f);
    return lbl;
  }
}