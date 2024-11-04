import java.util.LinkedList;
import java.util.Queue;

public class QueueManager {
    private static QueueManager instance;
    private int currentNumber = 0;
    private Queue<User> users = new LinkedList<>();
    private boolean isUserQueued;

    private QueueManager(){
    }

    public static QueueManager getInstance(){
        if(instance == null){
            instance = new QueueManager();

        }
        return instance;
    }


    public  synchronized void addUserToQueue(String name){
            User user = new User(name,currentNumber++);
            users.add(user);
            System.out.println(name + " added to queue with number " + user.getNumber());

            displayQueue();
    }

    public synchronized void serveNextUser(int deskNumber){
        User nextUser = users.poll();
        if(nextUser != null){
            System.out.println(nextUser.getName() + " served at " + deskNumber);
            System.out.println("Next Queue Number " + nextUser.getNumber());
        } else {
            System.out.println("No user in queue ");
        }
        displayQueue();
    }

    public synchronized void resetQueue(int newNumber) {
        System.out.println("Queue number reset to: " + newNumber);
        currentNumber = newNumber;
        System.out.println();
    }

    private synchronized void displayQueue() {
        if (users.isEmpty()) {
            System.out.println("\nQueue is empty.\n");
        } else {
            System.out.println("Next user in queue: " + users.peek().getName() +
                    " (Queue number: " + users.peek().getNumber() + ")");
            System.out.println("Total users in queue: " + users.size());
            System.out.println();
        }
    }

}
