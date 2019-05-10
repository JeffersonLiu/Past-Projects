public class Book
{
  String title;
  String course;
  
  public Book ()
  {
    title = "";
    course = "";
  }
  
  public void setTitle (String thisTitle)
  {
    title = thisTitle;
  }
  
  public void setCourse (String course)
  {
    this.course = course;
  }
  
  public String toString ()
  {
    return title + " for " + course;
  }
}