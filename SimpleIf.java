package part1;
import part2.Applicant;


public class SimpleIf {

  /**
   * Takes an applicant's average score and accepts the applicant if the average
   * is higher than 85.
   * 
   * @param avg The applicant's average score
   * @param threshold The threshold score
   * @return true if the applicant's average is over the threshold, and false otherwise
   */
  public static boolean analyzeApplicant(double avg, double threshold) {
    /*
     * TO DO: Write an if statement to determine if the avg is larger than the threshold and
     * return true if so, false otherwise
     */
    return avg > threshold;// A bit pessimistic!
  }

  /**
   * Takes two applicants' average scores and returns the score of the applicant
   * with the higher average.
   * 
   * @param avg1 The first applicant's average score
   * @param avg2 The second applicant's average score
   * @return the higher average score
   */
  public static double maxAverage(double avg1, double avg2) {
    /*
     * TO DO: Write an if statement to determine which average is larger and return
     * that value.
     */
    if (avg1 > avg2) return avg1;
    else return avg2;

    // return 0; // Clearly not correct, but testable.
  }

  /* Here is the analyzeApplicant for my personal filter. The filter I chose to use is
     UR, which represents "University Rating." I decided this would be a good filter because
     the school the applicant attends is most-likely relevant when it comes to the
     hiring process. With this, I included a threshold variable that represents the
     "minimum" university rating for the applicant to still be considered
  */
  public static boolean analyzeApplicant2 (Applicant applicant, int threshold)
  {
    if (applicant.getUR() <= threshold)
    {
      return true;
    }
    return false;
  }
}
