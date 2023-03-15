package part2;

import java.util.List;
import java.util.LinkedList;

import part1.Course;
import part1.CourseGrade;


public class Applicant
{

    private String name;
    private List<CourseGrade> grades;

    private int universityRating;

    public Applicant (String name, List<CourseGrade> grades)
    {
        this.name = name;
        this.grades = grades;
        this.universityRating = 0;
    }

    public Applicant (String name, List<CourseGrade> grades, int universityRating)
    {
        this.name = name;
        this.grades = grades;
        this.universityRating = universityRating;
    }
    public String getName()
    {
        return name;
    }

    public List<CourseGrade> getGrades()
    {
        return grades;
    }

    public int getUR()
    {
        return universityRating;
    }

    public CourseGrade getGradeFor(String course)
    {
        for (CourseGrade g : grades) {
            if (g.getCourseName().equals(course)) {
                return g;
            }
        }
        CourseGrade e = new CourseGrade("Course does not exist", 0);
        return e;
    }
}
