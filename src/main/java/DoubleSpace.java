/**
 * 
 */

/**
 * @author A0108165J
 * 
 *         Double File Spacer for CS2010 at NUS.
 * 
 *         Run tests using `mvn clean test`
 * 
 */
public class DoubleSpace {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    for (String s : args) {
      System.out.println("Processing file " + s + "..");
      doubleSpace(s);
    }
    System.out.println("Done.");
  }

  public static void doubleSpace(String fileName) {
    new FileSpacer().input(fileName)
                    .output(fileName + ".ds")
                    .process();
  }

}
