package part2;

import org.junit.jupiter.api.Test;
import part1.CourseGrade;
import part1.SimpleIf;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestCases
{
   /*
    * This test is just to get you started.
    */
   @Test
   public void testGetName()
   {
      // This will not compile until you implement the Applicant class
      List<CourseGrade> grades = Arrays.asList(
         new CourseGrade("Intro to CS", 100),
         new CourseGrade("Data Structures", 95),
         new CourseGrade("Algorithms", 91),
         new CourseGrade("Computer Organization", 91),
         new CourseGrade("Operating Systems", 75),
         new CourseGrade("Non-CS", 83)
      );
      Applicant testApplicant = new Applicant("Aakash", grades);
      assertEquals("Aakash", testApplicant.getName());
      assertEquals(testApplicant.getGradeFor("Data Structures"), grades.get(1));
   }

   /*
    * The tests below here are to verify the basic requirements regarding
    * the "design" of your class.  These are to remain unchanged.
    */
   @Test
   public void testImplSpecifics()
      throws NoSuchMethodException
   {
      final List<String> expectedMethodNames = Arrays.asList(
         "getName",
         "getGrades",
         "getGradeFor"
      );

      final List<Class> expectedMethodReturns = Arrays.asList(
         String.class,
         List.class,
         CourseGrade.class
      );

      final List<Class[]> expectedMethodParameters = Arrays.asList(
         new Class[0],
         new Class[0],
         new Class[] { String.class }
         );

      verifyImplSpecifics(Applicant.class, expectedMethodNames,
         expectedMethodReturns, expectedMethodParameters);
   }

   private static void verifyImplSpecifics(
      final Class<?> clazz,
      final List<String> expectedMethodNames,
      final List<Class> expectedMethodReturns,
      final List<Class[]> expectedMethodParameters)
      throws NoSuchMethodException
   {
      assertEquals(0, Applicant.class.getFields().length,
              "Unexpected number of public fields");

      final List<Method> publicMethods = Arrays.stream(
         clazz.getDeclaredMethods())
            .filter(m -> Modifier.isPublic(m.getModifiers()))
            .collect(Collectors.toList());

      assertTrue(expectedMethodNames.size()+1 >= publicMethods.size(),
              "Unexpected number of public methods");

      assertTrue(expectedMethodNames.size() == expectedMethodReturns.size(),
              "Invalid test configuration");
      assertTrue(expectedMethodNames.size() == expectedMethodParameters.size(),
              "Invalid test configuration");

      for (int i = 0; i < expectedMethodNames.size(); i++)
      {
         Method method = clazz.getDeclaredMethod(expectedMethodNames.get(i),
            expectedMethodParameters.get(i));
         assertEquals(expectedMethodReturns.get(i), method.getReturnType());
      }
   }

   @Test
   public void myFilterTest() {
      Applicant tyler = new Applicant("tyler",
              Arrays.asList(
                      new CourseGrade("CPE 123", 94),
                      new CourseGrade("CPE 101", 78),
                      new CourseGrade("CPE 307", 94),
                      new CourseGrade("CPE 203", 100),
                      new CourseGrade("CPE 225", 89)), 15);
      assertTrue(SimpleIf.analyzeApplicant2(tyler, 200));
   }
   @Test
   public void myFilterTest2() {
      Applicant john = new Applicant("john",
              Arrays.asList(
                      new CourseGrade("CPE 123", 68),
                      new CourseGrade("CPE 248", 96),
                      new CourseGrade("CPE 203", 58),
                      new CourseGrade("CPE 225", 87)), 4);
      assertTrue(SimpleIf.analyzeApplicant2(john, 200));
   }
   @Test
   public void myFilterTest3() {
      Applicant jack = new Applicant("jack",
              Arrays.asList(
                      new CourseGrade("CPE 123", 89),
                      new CourseGrade("CPE 202", 99),
                      new CourseGrade("CPE 225", 89)), 106);
      assertTrue(SimpleIf.analyzeApplicant2(jack, 200));
   }
   @Test
   public void myFilterTest4() {
      Applicant steve = new Applicant("steve",
              Arrays.asList(
                      new CourseGrade("CPE 123", 99),
                      new CourseGrade("CPE 101", 99),
                      new CourseGrade("CPE 202", 99),
                      new CourseGrade("CPE 357", 78),
                      new CourseGrade("CPE 123", 97),
                      new CourseGrade("CPE 203", 57),
                      new CourseGrade("CPE 309", 81)), 308);
      assertFalse(SimpleIf.analyzeApplicant2(steve, 200));
      System.out.println(steve.getGrades());
   }
   @Test
   public void myFilterTest5() {
      Applicant hank = new Applicant("hank",
              Arrays.asList(
                      new CourseGrade("CPE 123", 92),
                      new CourseGrade("CPE 101", 90),
                      new CourseGrade("CPE 445", 88),
                      new CourseGrade("CPE 203", 95),
                      new CourseGrade("CPE 225", 87)), 783);
      assertFalse(SimpleIf.analyzeApplicant2(hank, 200));
   }
   @Test
   public void testOther() {
      Applicant hank = new Applicant("hank",
              Arrays.asList(
                      new CourseGrade("CPE 123", 92),
                      new CourseGrade("CPE 101", 90),
                      new CourseGrade("CPE 445", 88),
                      new CourseGrade("CPE 203", 95),
                      new CourseGrade("CPE 225", 87)), 783);
      assertFalse(SimpleIf.analyzeApplicant2(hank, 200));
   }
}
