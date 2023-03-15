package part1;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import part1.CourseGrade;

public class ExampleMap {

  /**
   * Return a list of "high scoring" students --- High scoring students are
   * students who have all grades strictly greater than the given threshold.
   * 
   * @param scoresByApplicantName A map of applicant names to applicant scores
   * @param scoreThreshold        The score threshold
   * @return The list of high-scoring applicant names
   */
  public static List<String> highScoringStudents(Map<String, List<CourseGrade>> scoresByApplicantName, int scoreThreshold) {
    List<String> highScoringStudents = new LinkedList<>();

    /*
     * Build a list of the names of applicants who have scores strictly greater than
     * the given threshold.
     */

    for (Map.Entry<String, List<CourseGrade>> current : scoresByApplicantName.entrySet()) {
      List<CourseGrade> scores = current.getValue();
      int count_course = 0;
      int count_pass = 0;
      for (CourseGrade c : scores) {
        count_course++;
        if (c.getScore() > scoreThreshold) count_pass++;
      }
      if (count_course == count_pass) highScoringStudents.add(current.getKey());
    }
    return highScoringStudents;
  }
}
