import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Logger class using Singleton Pattern
class Logger {
    // Step 1: Create a private static instance (only one)
    private static Logger instance;

    // Step 2: Make constructor private (so no one can create another object)
    private Logger() {}

    // Step 3: Provide a public static method to access the single instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Method to log messages with timestamps
    public void log(String message) {
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println("[" + time + "] " + message);
    }
}

// Demo class to test the Singleton pattern
public class SingletonDemo {
    public static void main(String[] args) {
        // Get two Logger instances
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Log some messages
        logger1.log("This is the first log message.");
        logger2.log("This is another message from the same instance.");

        // Verify both are the same instance
        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 refer to the SAME instance.");
        } else {
            System.out.println("Different instances exist! Singleton not working.");
        }
    }
}