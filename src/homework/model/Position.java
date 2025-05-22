package homework.model;

import java.util.List;
import java.util.ArrayList;

/**
 * Represents a job position in the company
 */
public class Position {
  private final String id;
  private final String name;

  public Position(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return name;
  }

  /**
   * Returns a list of sample positions available in the company
   * 
   * @return List of sample positions
   */
  public static List<Position> getSamplePositions() {
    List<Position> positions = new ArrayList<>();
    positions.add(new Position("PS001", "Technical Programmer"));
    positions.add(new Position("PS002", "Web Developer"));
    positions.add(new Position("PS003", "General Manager"));
    positions.add(new Position("PS004", "ICT Specialist"));
    positions.add(new Position("PS005", "E-Business Analyst"));
    positions.add(new Position("PS006", "ICT Documenter"));
    positions.add(new Position("PS007", "Database Administrator"));
    positions.add(new Position("PS008", "PC Administrator"));
    positions.add(new Position("PS009", "Network Specialist"));
    positions.add(new Position("PS010", "ICT Manager"));
    return positions;
  }
}