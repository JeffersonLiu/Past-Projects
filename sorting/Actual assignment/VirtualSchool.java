public class VirtualSchool
{
  public static void main (String[] args)
  {
    Student alex = new Student ("Alex"); // not the correct book
    Student eric = new Student ("Bob"); // not enough books
    Student carter = new Student ("Carter"); // no locker
    Student dennis = new Student ("Dennis"); // jacket not in locker
    Student eric = new Student ("Eric"); // allowed in class
    ClassRoom mathClass = new ClassRoom ("MPM2D1", "Mr. McAdam");

    alex.books.add (alex.myLocker.getABook ("SNC2D1"));
    alex.myLocker.putJacket (alex.myJacket);
    mathClass.enter (alex);
    System.out.println ();
    
    bob.myLocker.putJacket (bob.myJacket);
    mathClass.enter (bob);
    System.out.println ();
    
    carter.myLocker.assignOwner (new Student ("Fred"));
    mathClass.enter (carter);
    System.out.println ();
    
    dennis.books.add (dennis.myLocker.getABook ("MPM2D1"));
    mathClass.enter (dennis);
    System.out.println ();
    
    eric.books.add (eric.myLocker.getABook ("MPM2D1"));
    eric.myLocker.putJacket (eric.myJacket);
    mathClass.enter (eric);
  }
}