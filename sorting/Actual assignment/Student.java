class Student{
  String number;
  String name;
  Locker myLocker;
  Jacket myJacket;
  Book books[];
  
  Student (String name){
    this.name=name;
    number = "0";
    myJacket = new Jacket(this);
    myLocker = new Locker(this);
    books = new Book[4];
  }
  void sentToOffice(String reason){
    System.out.println("The reason that " +name+" got sent to the office, is " + reason);
  }
  String toString(){
    return "Student: " + name;
  }
}