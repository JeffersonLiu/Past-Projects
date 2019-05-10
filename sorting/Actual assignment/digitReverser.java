import java.util.*;
public class digitReverser
{
  public static int revDigits (int integ){
    if ((int)Math.log10(integ) + 1 == 1)//if its a single digit number it returns it
      return integ;
    return (int) ((integ % 10) * Math.pow(10, (int) Math.log10(integ))) + revDigits(integ / 10);//calls itself but with the last number of integ removed, and the whole number shifted down
  }
  public static void main (String[] main)
  {
    Scanner s = new Scanner(System.in);
    int integer = 0;
    integer= s.nextInt();
    System.out.println(revDigits(integer));
  }
}