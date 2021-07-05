package BankSystem;

//interface need to be implemented from interface
// otherwise there will be violation of Open Close Principle
public class EventLogger {

    public void Log(String event){
        System.out.println(event);
    }
}
