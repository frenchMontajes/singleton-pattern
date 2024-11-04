public class CentralizeQueuing {
    public static void main(String[] args) {

        QueueManager queue = QueueManager.getInstance();

        queue.addUserToQueue("Cooper");
        queue.addUserToQueue("David");
        queue.addUserToQueue("John");

        queue.serveNextUser(1);
        queue.serveNextUser(2);
        queue.serveNextUser(3);

        queue.resetQueue(1);

        queue.addUserToQueue("George");
        queue.serveNextUser(1);

    }
}