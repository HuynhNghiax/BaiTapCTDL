package Task1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Faculty {
	    private String name;
	    private String address;
	    private List<Course> courses;

	    public Faculty(String name, String address, List<Course> courses) {
	        this.name = name;
	        this.address = address;
	        this.courses = courses;
	    }

	    public Course getMaxPracticalCourse() {
	        Course maxPracticalCourse = null;
	        int maxStudentCount = 0;

	        for (Course course : courses) {
	            if (course.getType().equals("thực hành") && course.getStudents().size() > maxStudentCount) {
	                maxStudentCount = course.getStudents().size();
	                maxPracticalCourse = course;
	            }
	        }

	        return maxPracticalCourse;
	    }

	    public Map<Integer, List<Student>> groupStudentsByYear() {
	        Map<Integer, List<Student>> studentsByYear = new HashMap<>();

	        for (Course course : courses) {
	            for (Student student : course.getStudents()) {
	                int year = student.getYear();

	                // Add student to the corresponding year in the map
	                studentsByYear.computeIfAbsent(year, k -> new ArrayList<>()).add(student);
	            }
	        }

	        return studentsByYear;
	    }

	    public Set<Course> filterCourses(String type) {
	        Set<Course> filteredCourses = new TreeSet<>(Comparator.comparingInt(c -> ((Course) c).getStudents().size()).reversed());

	        for (Course course : courses) {
	            if (course.getType().equals(type)) {
	                filteredCourses.add(course);
	            }
	        }

	        return filteredCourses;
	    }
}
