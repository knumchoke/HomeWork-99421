package homework.model;

import java.util.List;

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
  public static final class Builder {
    private String id;
    private String name;
    private String address;
    private String province;
    private String sex;
    private String education;
    private String major;
    private List<String> qualifications;
    private List<String> desiredPositions;

    public Builder id(String id) {
      this.id = id;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder address(String address) {
      this.address = address;
      return this;
    }

    public Builder province(String province) {
      this.province = province;
      return this;
    }

    public Builder sex(String sex) {
      this.sex = sex;
      return this;
    }

    public Builder education(String education) {
      this.education = education;
      return this;
    }

    public Builder major(String major) {
      this.major = major;
      return this;
    }

    public Builder qualifications(List<String> qualifications) {
      this.qualifications = qualifications;
      return this;
    }

    public Builder desiredPositions(List<String> desiredPositions) {
      this.desiredPositions = desiredPositions;
      return this;
    }

    public Applicant build() {
      return new Applicant(id, name, address, province, sex, education, major, qualifications, desiredPositions);
    }
  }
}