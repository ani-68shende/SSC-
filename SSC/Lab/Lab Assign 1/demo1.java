import java.io.File;
import java.util.Scanner;

class demo1 {
  public static void main(String[] args) {

    try {
      // create a new file object
      File file = new File("/Users/ani/Desktop/Tri-9/SSC/Lab/Lab Assign 1/demofile.txt");

      Scanner sc = new Scanner(file);
      System.out.println("Reading File Using Scanner:");
      while(sc.hasNextLine()) {
        System.out.println(sc.nextLine());
      }
      sc.close();
    } catch (Exception e) {
      e.getStackTrace();
    }
    
  }
}