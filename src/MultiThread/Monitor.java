package MultiThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Monitor {
    public static void main(String[] args) throws IOException, InterruptedException {
        String programName = args[0];

        while (true) {
            Process process = new ProcessBuilder("jps").start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(programName)) {
                    String[] tokens = line.split("\\s+");
                    int pid = Integer.parseInt(tokens[0]);
                    try {
                        Process processToMonitor = new ProcessBuilder("kill", "-0", String.valueOf(pid)).start();
                        int exitCode = processToMonitor.waitFor();
                        if (exitCode != 0) {
                            System.out.println("Process with PID " + pid + " was killed. Restarting...");
                            Process newProcess = new ProcessBuilder("java", "-cp", "Forever.jar", "ForeverProcess", tokens[1]).start();
                            System.out.println("Started new process with PID: " + newProcess.hashCode());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            reader.close();
            process.waitFor();
            Thread.sleep(1000);
        }
    }
}

