package Task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Testfile {
	public static void main(String[] args) {
		Student student1 = new Student(1, "John Doe", 2022);
		Student student2 = new Student(2, "Jane Doe", 2021);
		Student student3 = new Student(3, "Bob Smith", 2022);
		
		List<Student> c1 = new ArrayList<>();
		c1.add(student1);
		c1.add(student2);
		c1.add(student3);
		List<Student> c2 = new ArrayList<>();
		c2.add(student1);
		
		
		Course course1 = new Course(101, "UXUI", "thực hành",c1, "Hung");
		Course course2 = new Course(102, "CTDL", "lý thuyết",c2, "Tam");
		
		List<Course> f= new ArrayList<>();
		Faculty faculty = new Faculty("DHNL", "CNTT", f);
	}
}
