import java.io.File;

import org.junit.AfterClass;
import org.junit.Test;

public class DoubleSpaceTest {

  @Test
  public void test() {
    DoubleSpace.main(new String[] { "a.txt", "b.txt" });
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
    new File("a.txt.ds").delete();
    new File("b.txt.ds").delete();
    System.out.println("Test of main program done.");
  }

}
