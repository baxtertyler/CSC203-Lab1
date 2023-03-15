package part1;

/**
 * A simple class to demonstrate testing with JUnit.  Note that it contains a
 * bug to show how JUnit reports failures.
 *
 */
public class OddEven {
   private int value;

   public OddEven(int value) {
      this.value = value;
   }

   public boolean odd() {
//      return this.value % 2 ==1;
      return this.value % 2 !=0;
   }

   public boolean even() {
//      return this.value % 2 == 0;
      return !this.odd();
   }
}
