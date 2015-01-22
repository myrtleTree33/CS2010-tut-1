import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author A0108165J
 * 
 *         This is a helper class to double space files. Use it to chain.
 * 
 */
public class FileSpacer {

  private Scanner input;
  private PrintWriter output;

  /**
   * 
   */
  public FileSpacer() {
    // TODO Auto-generated constructor stub
  }

  /**
   * This opens a filestream. Is chainable.
   * 
   * @param filename
   * @return
   */
  public FileSpacer input(String filename) {
    try {
      this.input = new Scanner(new File(filename));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return this;
  }

  /**
   * This closes a filestream. Is chainable.
   * 
   * @param filename
   * @return
   */
  public FileSpacer output(String filename) {
    try {
      this.output = new PrintWriter(filename, "UTF-8");
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return this;

  }

  /**
   * This processes the file. Note that input file is not stored in memory, and
   * the output file is processed when the pointer moves. This scales well for
   * large files. Is chainable
   * 
   * @return
   */
  public FileSpacer process() {
    while (this.input.hasNextLine()) {
      String line = this.input.nextLine();
      line = line.concat("\n\n");
      this.output.write(line);
    }
    this.close();
    return this;
  }

  /**
   * This closes the file. Is chainable.
   */
  private FileSpacer close() {
    this.output.close();
    this.input.close();
    return this;
  }

}
