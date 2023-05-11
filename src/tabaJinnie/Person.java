package tabaJinnie;


public class Person implements Comparable<Person> {
  // Declare variables
  private String name;
  private String occupation;
  private String job;
  private Boolean maritalStatus;
  private String sex;
  private String address;
  private int age;

  // Constructor for Person
  public Person(String name, String occupation, String job, Boolean maritalStatus, String sex, String address,
      int age) {
    this.name = name;
    this.occupation = occupation;
    this.job = job;
    this.maritalStatus = maritalStatus;
    this.sex = sex;
    this.address = address;
    this.age = age;
  }

  // Getter and setters for each element
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getOccupation() {
    return occupation;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  public String getJob() {
    return job;
  }

  public void setJob(String job) {
    this.job = job;
  }

  public Boolean getMaritalStatus() {
    return maritalStatus;
  }

  public void setMaritalStatus(Boolean maritalStatus) {
    this.maritalStatus = maritalStatus;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  // Define the comparable Person object using age
  @Override
  public int compareTo(Person p) {
    // If the age is equal
    if (this.age == p.age) {
      return 0;

      // If the age is older (higher number) than the person comparing to
    } else if (this.age > p.age) {
      return 1;

      // If the age is younger (lower number) than the person comparing to
    } else {
      return -1;
    }
  }
  




  

  // Create toString method for presentation
  @Override
  public String toString() {
    return "Person{\nName: " + name + "\nOccupation: " + occupation + "\nJob: " + job + "\nMarital Status: "
        + maritalStatus + "\nSex: " + sex + "\nAddress: " + address + "\nAge: " + age + "\n}";
  }
}