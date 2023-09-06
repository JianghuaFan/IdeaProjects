package MultiThread;

import java.io.IOException;

public class Forever {
    public static void main(String[] args) throws IOException, InterruptedException {
        for (String arg : args) {
            Process process = new ProcessBuilder("java", "-cp", "Forever.jar", "ForeverProcess", arg).start();
            System.out.println("Started process with PID: " + process.hashCode());
        }
    }
}

class ForeverProcess {
    public static void main(String[] args) throws IOException {
        while (true) {
            // do something here forever
        }
    }
}

