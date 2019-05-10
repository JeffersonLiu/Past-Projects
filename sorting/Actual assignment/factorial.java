import java.util.*;
public class stringReverser
{
  public static String stringReverse (String string){
    if (str.startsWith ("."))
          return ".";
    return stringReverse (str.subString(string.indexOf( '\n') + 1) + '\n' + str.subString(0, string.indexOf("\n")));
  }
  public static void main (String[] main)
  {
    Scanner s = new Scanner(System.in);
    String str = "";
    String tem = "";
    while (!tem.equals(".")){
      tem= s.next();
      str += "\n" + temp;
    }
    System.out.println(reverse(str));
  }
}