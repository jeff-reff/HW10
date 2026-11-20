public class Driver {
    public static void main(String[] args){
        ChatServer server = new ChatServer();
        User bob = new User("bob", server);
        User jake = new User("jake", server);
        User dave = new User("dave", server);

        System.out.println("Sending a message to one or more other users through chat server:");
        bob.sendMessage("hello jake and dave", jake, dave);

        System.out.println("Undoing last message:");
        bob.undoLastMessage();

        System.out.println("Blocking messages from a specific users and receiving message from other users:");
        bob.sendMessage("this is not a blocked message", jake);
        server.blockUserMessages(jake, bob);
        bob.sendMessage("this is a blocked message", jake);
        dave.sendMessage("this is not a blocked message", jake);

        System.out.println("View chat history for a specific user:");
        for (Message message : bob.viewChatHistory()){
            System.out.println(message);
        }
    }
}
