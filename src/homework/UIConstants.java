package homework;

import java.awt.Font;

public class UIConstants {
  // Window dimensions
  public static final int WINDOW_WIDTH = 570;
  public static final int WINDOW_HEIGHT = 720;

  // Fonts
  public static final Font HEADING_FONT = new Font("SansSerif", Font.BOLD, 18);
  public static final Font SUBHEADING_FONT = new Font("SansSerif", Font.BOLD, 16);
  public static final Font BODY_FONT = new Font("SansSerif", Font.BOLD, 14);
  public static final Font NORMAL_FONT = new Font("SansSerif", Font.PLAIN, 14);

  // Form limits
  public static final int MAX_QUALIFICATIONS = 5;
  public static final int MAX_POSITIONS = 3;

  // Layout constants
  public static final int GRID_INSET = 2;
  public static final int GRID_PADDING = 4;

  private UIConstants() {
    // Prevent instantiation
  }
}