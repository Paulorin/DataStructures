package tmp;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class TestIO {

    @Test
    public void shouldTestFileMethods() throws IOException {
        Path path = Paths.get("/home/paul/tmp/test.txt");
        System.out.println(path.getFileSystem());
        System.out.println(path.toAbsolutePath());

        File file = new File(path.toAbsolutePath().toString());
        System.out.println(file.canRead());
        System.out.println(file.exists());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getName());
        System.out.println(file.canExecute());
        System.out.println(file.delete());


        File file2 = new File("/home/paul/tmp/test2.txt");
        System.out.println(file2.createNewFile());
        System.out.println(file.compareTo(file2));
    }

    @Test
    public void test() {
        // Method 1: getRuntime()
        // Getting the current runtime associated
        // with this process
        Runtime run = Runtime.getRuntime();

        // Printing the current free memory for this runtime
        // using freeMemory() method
        System.out.println("" + run.freeMemory());

        // Method 2: freeMemory()
        // Printing the number of free bytes
        System.out.println(
                "" + Runtime.getRuntime().freeMemory());

        // Method 3: totalMemory()
        // Printing the number of total bytes
        System.out.println(
                "" + Runtime.getRuntime().totalMemory());
    }

    @Test
    public void shouldTestRuntimeMethod() {
        // Try block to check for exceptions
        try {

            // Creating a process and execute google-chrome
            Process process = Runtime.getRuntime().exec(
                    "google-chrome");
            System.out.println(
                    "Google Chrome successfully started");
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            // Display the exception on the console
            e.printStackTrace();
        }
    }

    @Test
    public void shouldCopyBytes() throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("testFile.txt");
            out = new FileOutputStream("outagain.txt");
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } finally {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    @Test
    public void shoudCopyCharacters() throws IOException {
        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader("testFile.txt");
            outputStream = new FileWriter("characteroutput.txt");

            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    @Test
    public void shouldCopyLines() throws IOException {
        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("testFile.txt"));
            outputStream = new PrintWriter(new FileWriter("characteroutput.txt"));

            String l;
            while ((l = inputStream.readLine()) != null) {
                outputStream.println(l);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    @Test
    public void shouldTestConsoleMethods() {
        Console c = System.console();
        if (c == null) {
            System.err.println("No console.");
            System.exit(1);
        }

        String login = c.readLine("Enter your login: ");
        char [] oldPassword = c.readPassword("Enter your old password: ");

        if (verify(login, oldPassword)) {
            boolean noMatch;
            do {
                char [] newPassword1 = c.readPassword("Enter your new password: ");
                char [] newPassword2 = c.readPassword("Enter new password again: ");
                noMatch = ! Arrays.equals(newPassword1, newPassword2);
                if (noMatch) {
                    c.format("Passwords don't match. Try again.%n");
                } else {
                    change(login, newPassword1);
                    c.format("Password for %s changed.%n", login);
                }
                Arrays.fill(newPassword1, ' ');
                Arrays.fill(newPassword2, ' ');
            } while (noMatch);
        }

        Arrays.fill(oldPassword, ' ');
    }

    // Dummy change method.
    static boolean verify(String login, char[] password) {
        // This method always returns
        // true in this example.
        // Modify this method to verify
        // password according to your rules.
        return true;
    }

    // Dummy change method.
    static void change(String login, char[] password) {
        // Modify this method to change
        // password according to your rules.
    }

    @Test
    public void shouldWriteAndReadFile() throws IOException {

    }

}
