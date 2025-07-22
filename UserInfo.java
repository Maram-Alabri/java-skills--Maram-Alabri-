public class UserInfo{
  private String name;
  private int age;
  private String email;
  private boolean isActive;

  public UserInfo(String name, int age, String email, boolean isActive){
    this.name = name;
    this.age = age;
    this.email = email;
    this.isActive = isActive;
  }

  public String getName(){
    return name;
  }

  public int getAge(){
    return age;
  }

  public String getEmail(){
    return email;
  }

  public boolean getitsActive(){
    return isActive;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setActive(boolean active) {
    isActive = active;
  }

  public void displayInfo() {
    System.out.println("Name  :"+name);
    System.out.println("age  :"+age);
    System.out.println("email  :"+email);
    System.out.println("Active   : " + (isActive ? "Yes" : "No"));
    System.out.println();
  }

  public static void main(String[] args) {
    UserInfo u1 = new UserInfo("Maram", 23, "Maram@gmail.com", true);
    UserInfo u2 = new UserInfo("Mai", 24, "Mai@gmail.com", true);
    UserInfo u3 = new UserInfo("Fatma", 24, "Fatma@gmail.com", false);
    UserInfo u4 = new UserInfo("MS", 22, "MS@gmail.com", false);

    u1.displayInfo();
    u2.displayInfo();
    u3.displayInfo();
    u4.displayInfo();

    u1.setEmail("Maram@gmail");
    System.out.println("Maram new email: "+u1.getEmail());
  }
}