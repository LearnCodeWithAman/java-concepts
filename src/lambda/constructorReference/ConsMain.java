package lambda.constructorReference;

public class ConsMain {

    public static void main(String[] args) {

        // through lambda expression
        /*Provider provider = () -> {
            return new Student();
        };*/

        // constructor reference
        Provider provider = Student::new;
        Student student = provider.getStudent();
        student.display();

    }
}
