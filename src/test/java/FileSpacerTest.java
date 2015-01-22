import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.AfterClass;
import org.junit.Test;

/**
 * 
 */

/**
 * @author A0108165J
 * 
 */
public class FileSpacerTest {

  /**
   * Test method for {@link FileSpacer#FileSpacer()}.
   */
  @Test
  public void testFileSpacer() {
    String filePathA = getClass().getClassLoader()
                                 .getResource("a.txt")
                                 .toString()
                                 .substring(5);
    FileSpacer spacer = new FileSpacer();
    spacer.input(filePathA)
          .output("out.txt")
          .process();

    /** Assert output generated **/
    File file = new File("out.txt");
    assertTrue(file.exists() && !file.isDirectory());

    /** Check exact number of lines, a way for checking double space **/
    Scanner fScanner;
    try {
      fScanner = new Scanner(file);
      int fileLen = 0;
      while (fScanner.hasNextLine()) {
        fScanner.nextLine();
        fileLen++;
      }
      assertEquals(6, fileLen);
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  @Test
  /**
   * Test for performance in a larger input file.  (scaling up)
   */
  public void testFileSpacerBig() {
    String filePathA = getClass().getClassLoader()
                                 .getResource("long.txt")
                                 .toString()
                                 .substring(5);
    FileSpacer spacer = new FileSpacer();
    spacer.input(filePathA)
          .output("out.txt")
          .process();

    /** Assert output generated **/
    File file = new File("out.txt");
    assertTrue(file.exists() && !file.isDirectory());

    /** Check exact number of lines, a way for checking double space **/
    Scanner fScanner;
    try {
      fScanner = new Scanner(file);
      int fileLen = 0;
      while (fScanner.hasNextLine()) {
        fScanner.nextLine();
        fileLen++;
      }
      System.out.println(fileLen);
      assertEquals(23030, fileLen);
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
    new File("out.txt").delete();
    System.out.println("Test of FileSpacer done.");
  }

}
