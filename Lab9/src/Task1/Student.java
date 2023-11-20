package Task1;

public class Student {
	private int id;
	private String name;
	private int year;


	public Student(int id, String name, int year) {
		this.id = id;
		this.name = name;
		this.year = year;
	}

	// Getter and setter methods for id, name, and year go here

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getYear() {
		return year;
	}
}