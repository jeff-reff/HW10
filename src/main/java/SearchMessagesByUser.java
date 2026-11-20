import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class SearchMessagesByUser implements Iterator<Message> {
    private final List<Message> messages;
    private final User userToSearchWith;
    private int nextIndex = 0;

    public SearchMessagesByUser(List<Message> messages, User userToSearchWith){
        this.messages = messages;
        this.userToSearchWith = userToSearchWith;
        findMatch();
    }

    private void findMatch() {
        while (nextIndex < messages.size() && !messages.get(nextIndex).getSender().equals(userToSearchWith) && !messages.get(nextIndex).getRecipients().contains(userToSearchWith)){
            nextIndex++;
        }
    }

    @Override
    public boolean hasNext() {
        return nextIndex < messages.size();
    }

    @Override
    public Message next(){
        if (!hasNext()){
            throw new NoSuchElementException("there are no more messages for this user");
        }
        Message result = messages.get(nextIndex++);
        findMatch();
        return result;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("cannot change chat history through iterator");
    }
}
