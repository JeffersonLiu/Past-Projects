public class Locker
{
  int number;
  Student owner;
  private Jacket studentJacket;
  private Book[] books;
  
  public Locker (Student me)
  {
    String[] bookTitles = {"Pearson Math Makes Sense 10", "Nelson Science Perspectives 10", "McGraw-Hill Ryerson Creating Canada History", "Barrons AP ICS textbook"};
    String[] bookCourses = {"MPM2D1", "SNC2D1", "CHC2D1", "ICS4U0"};
    owner = me;
    number = 1+(int)(1000*Math.random());
    studentJacket = null;
    books = new Book[4];
    for (int i = 0; i < 4; i++)
    {
      books[i] = new Book ();
      books[i].title = bookTitles[i];
      books[i].course = bookCourses[i];
    }    
  }
  
  public Book getABook (String course)
  {
    for (int i = 0; i < 4; i++)
    {
      if (books[i].course.equals (course))
      {
        Book tempBook = books[i];
        books[i] = null;
        return tempBook;
      }
    }
    return null;
  }
  
  public void putABook (Book book)
  {
    for (int i = 0; i < 4; i++)
    {
      if (books[i] == null)
      {
        books[i] = book;
        break;
      }
    }
  }
  
  public void setOwner (Student thisStudent)
  {
    owner = thisStudent;
  }
  
  public Jacket getJacket ()
  {
    return studentJacket;
  }
  
  public String checkJacket ()
  {
    if (studentJacket == null)
      return "";
    return studentJacket.owner.name;
  }
  
  public void putJacket (Jacket thisJacket)
  {
    studentJacket = thisJacket;
  }
  
  public String toString ()
  {
    return "The locker number is " + number + ". The owner is " + owner.name + ".";
  }
}