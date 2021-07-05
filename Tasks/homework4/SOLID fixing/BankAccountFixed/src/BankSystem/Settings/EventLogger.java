package BankSystem.Settings;

// Class is responsible only for actions associated with this class, therefore S principle is not violated
// represent logger
public class EventLogger implements ILogger {
    //static field which contain single instance ot the class
    private static EventLogger instance;

    // closed constructor to guarantee only one instance of class will be created
    private EventLogger() {
    }

    //static initialization of static field by using private constructor
    //such approach guarantee only one instance of class will be created
    static {
        instance = new EventLogger();
    }

    // getter for single field
    public static EventLogger getInstance() {
        return instance;
    }

    @Override
    public void log(String event) {
        System.out.println(event);
    }
}
