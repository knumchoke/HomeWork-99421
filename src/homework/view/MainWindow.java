package homework.view;

import homework.UIConstants;
import homework.controller.Controller;
import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
  public MainWindow() {
    setSize(UIConstants.WINDOW_WIDTH, UIConstants.WINDOW_HEIGHT);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    add(new HeaderPanel(), BorderLayout.NORTH);
    ApplicationFormPanel formPanel = new ApplicationFormPanel();
    add(formPanel, BorderLayout.CENTER);

    new Controller(formPanel);
  }
}