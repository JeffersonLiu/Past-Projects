/*this is an encryption thing
 */
import java.util.*;
import java.io.*;
public class encryptionThing {
  int tempKey;
  ArrayList<String> message = new ArrayList<String>();
  ArrayList<Integer> key = new ArrayList<Integer>();
  char[] numAndLet = new char ['1','2','3','4','5','6','7','8','9','0','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',' '];
  
  public String[] readfile (){
    int z = 0;
    try {
      Scanner s = new Scanner(new File("message.txt"));//File
      while (s.hasNext()){
        String lineTemp;
        lineTemp = s.nextLine();
        message.add(z,lineTemp);
        z++
      }
      s.close();//Closes file
    }
    catch(FileNotFoundException e) {System.out.println("There is no file by that name");}
  }
  
  public String[] encryptFile (ArrayList<String> message){
    int randInt,z=0;
    for (String line: message){
      for (char numLet: line.toCharArray()){
        randInt = (int) Math.floor(Math.random() * 5);
        numLet += randInt;
        key.add(z,
      }
    }
    System.out.println(message);
  }
  