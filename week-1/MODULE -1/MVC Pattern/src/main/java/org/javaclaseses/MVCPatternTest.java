package org.javaclaseses;

public class MVCPatternTest {

    public static void main(String[] args) {

        // Create Model
        Student student = new Student("Sahasra", 101, "A");

        // Create View
        StudentView view = new StudentView();

        // Create Controller
        StudentController controller =
                new StudentController(student, view);

        // Display Initial Details
        controller.updateView();

        System.out.println();

        // Update Student Details
        controller.setStudentName("Rahul");
        controller.setStudentGrade("A+");

        // Display Updated Details
        controller.updateView();
    }
}
