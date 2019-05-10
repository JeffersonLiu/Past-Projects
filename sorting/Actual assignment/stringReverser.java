import java.util.*;
public class stringReverser
{
    public static String stringReverse (String str){
        if (str.startsWith ("."))
            return str;
        return stringReverse(str.substring(str.indexOf( '\n') + 1) + str.substring(0, str.indexOf('\n') + 1));
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String string = "";
        String temp = "";
        while(!temp.equals(".")){
            temp = s.next();
            string += "\n" + temp;
        }
        System.out.println(stringReverse(string));
    }
}