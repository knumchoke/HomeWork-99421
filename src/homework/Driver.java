package homework;

import javax.swing.SwingUtilities;

public class Driver {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      View.createMainWindow().setVisible(true);
    });
  }
}