package homework;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a qualification or skill that an applicant can have
 */
public class Qualification {
  private final String code;
  private final String description;

  public Qualification(String code, String description) {
    this.code = code;
    this.description = description;
  }

  public String getCode() {
    return code;
  }

  public String getDescription() {
    return description;
  }

  @Override
  public String toString() {
    return description;
  }

  /**
   * Returns a list of sample qualifications that can be selected
   * 
   * @return List of sample qualifications
   */
  public static List<Qualification> getSampleQualifications() {
    List<Qualification> qualifications = new ArrayList<>();
    qualifications.add(new Qualification("ASP", "Web_ASP"));
    qualifications.add(new Qualification("C++", "C++"));
    qualifications.add(new Qualification("DB2", "Database Administrator,DB2"));
    qualifications.add(new Qualification("DBA_OR", "Database Administrator,ORACLE"));
    qualifications.add(new Qualification("GRP_DS", "Graphic Design"));
    qualifications.add(new Qualification("JAVA", "JAVA"));
    qualifications.add(new Qualification("MGT", "Management"));
    qualifications.add(new Qualification("NW", "Network"));
    qualifications.add(new Qualification("SE_45", "Secretarial work,45 words/min"));
    qualifications.add(new Qualification("SE_60", "Secretarial work,60 words/min"));
    qualifications.add(new Qualification("SYS_1", "System Analyst, Level 1"));
    qualifications.add(new Qualification("SYS_2", "System Analyst, Level 2"));
    qualifications.add(new Qualification("VB", "Visual Basic"));
    return qualifications;
  }
}