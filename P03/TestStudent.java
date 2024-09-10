public class TestStudent {
    public static void main(String[] args) {
        int failureCount = 0;

        Student student1 = new Student("Brianna Cabero", 10001234, "bc1234@mavs.uta.edu");
        if (!student1.toString().equals("Brianna Cabero (10001234, bc1234@mavs.uta.edu, Account #1)")) {
            System.err.println("FAIL: Incorrect Student.toString() output: " + student1.toString());
            failureCount++;
        }

        try {
            Student student2 = new Student("Sarah Al-Noubani", 10005678, "st5678@gmail.com");
            System.err.println("FAIL: No exception thrown for non-UTA email");
            failureCount++;
        } catch (IllegalArgumentException e) {
            if (!e.getMessage().equals("Non-UTA email address: san5678@gmail.com")) {
                System.err.println("FAIL: Incorrect exception message: " + e.getMessage());
                failureCount++;
            }
        } catch (Exception e) {
            System.err.println("FAIL: Unexpected exception: " + e);
            failureCount++;
        }

        Student student3 = new Student("Malak Al-Noubani", 10007890, "ma7890@mavs.uta.edu");
        Media media = new Media("Public Domain Film", "https://example.com/film");
        String mediaRequestResult = student3.requestMedia(media);
        if (!mediaRequestResult.equals("Playing Public Domain Film (https://example.com/film)")) {
            System.err.println("FAIL: Incorrect media request result: " + mediaRequestResult);
            failureCount++;
        }

        System.exit(failureCount);
    }
}
