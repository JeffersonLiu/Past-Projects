import java.util.Arrays; 
class ClassRoom{
  String course;
  String teacher;
  ClassRoom(String course, String teacher){
    this.course = course;
    this.teacher = teacher;
  }
  
  public boolean enter (Student me)
  {
    System.out.println ("Student: " + me.name + ".");
    System.out.println (me.name + " came to class " + course + " taught by " + teacher + ".");
    if (!me.myLocker.owner.number.equals (me.number))
    {
      me.sentToOffice ("they do not have a locker");
      me.myLocker.owner = me;
      me.books = Arrays.copyOf(me.books, me.books.length + 1);
      me.books [me.books.length -1] = me.myLocker.getABook (course);
      me.myLocker.putJacket (me.myJacket);
      System.out.println (me.name + " was not allowed into the class.");
      return false;
    }
    else if (me.myLocker.getJacket () == null)
    {
      me.myLocker.putJacket (me.myJacket);
      System.out.println (me.name + " was sent to their locker to put away their jacket.");
      me.myLocker.putJacket (me.myJacket);
      System.out.println (me.name + " was not allowed into the class.");
      return false;
    }
    else if (me.books.length != 1)
    {
      me.sentToOffice ("they do not have the right amount of books");
      me.books = new Book [1];
      me.books = Arrays.copyOf(me.books, me.books.length + 1);
      me.books [me.books.length -1] = me.myLocker.getABook (course);
      System.out.println (me.name + " was not allowed into the class.");
      return false;
    }
    else if (!me.books[0].course.equals (course))
    {
      me.sentToOffice ("they do not have the right amount of books");
      me.books.[0] = null;
      me.books = Arrays.copyOf(me.books, me.books.length - 1);
      me.books [me.books.length -1] = me.myLocker.getABook (course);
      me.books.add (me.myLocker.getABook (course));
      System.out.println (me.name + " was not allowed into the class.");
      return false;
    }
    System.out.println (me.name + " was allowed into the class.");
    return true;
  }
}