package annotation;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by brook on 2017/5/8.
 */
public class AnnotationExample {
  public static void main(String[] args) {
  }

  @MethodInfo(author = "Pankaj", comments = "Main method", date = "Nov 17 2012", revision = 1)
  public String toString() {
    return "Overriden toString method";
  }

  @MethodInfo(comments = "deprecated method", date = "Nov 17 2012")
  public static void oldMethod() {
    System.out.println("old method, don't use it.");
  }

  @MethodInfo(author = "Pankaj", comments = "Main method", date = "Nov 17 2012", revision = 10)
  public static void genericsTest() throws FileNotFoundException {
    List l = new ArrayList();
    l.add("abc");
    oldMethod();
  }
}
