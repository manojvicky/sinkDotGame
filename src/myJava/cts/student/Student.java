package myJava.cts.student;

public class Student {
int id;
String name;
String sex;
double height;

public Student(int id, String name, String sex, double height){
	this.id=id;
	this.name=name;
	this.sex = sex;
	this.height = height;
}
public Student(Student s){
	this.id=s.id;
	this.name=s.name;
	this.sex = s.sex;
	this.height = s.height;
}

public void getData(){
	System.out.println("Student :"+id+ " " + name+ " " + sex+ " " +height);
}
}
