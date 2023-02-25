public class Main {

    public static void main(String[] args) {

        StudentClass studentClass = new StudentClass();
        studentClass.setEmail("test1@gmail.com");
        studentClass.setName("Test");

        System.out.println(studentClass);

        StudentRecord studentRecord = new StudentRecord("Test2",
                "test2@gmail.com" );

        System.out.println(studentRecord.name());
        System.out.println(studentRecord.externalFunction());

       // System.out.println(studentRecord);

    }
}
