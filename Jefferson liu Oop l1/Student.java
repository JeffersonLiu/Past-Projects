public class Student{
  public String name;
  public int mark1;
  public int mark2;
  public double average;
  
  public Student(String n){
    name = n;
    mark1=0;
    mark2 =0;
    average = 0.0;
  }
  
  public void setMarks(int x, int y) {
    mark1 = x;
    mark2 = y;
  }
  
  public void calcAverage(){ 
    average=(mark1+ mark2)/2;
  }
  
  public String message () {
    return name + "you got an " + average;
  }



  public static void main(String[] args){
    Student student1 = new Student("student1");
    Student student2 = new Student("student2");
    Student student3 = new Student("student3");
    Student student4 = new Student("student4");
    Student student5 = new Student("student5");
    student1.setMarks(90,90);  
    student1.calcAverage();
    student1.message();
    
    System.out.println(student1.message());
  }
}