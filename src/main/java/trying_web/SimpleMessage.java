package trying_web;

public class SimpleMessage {
    public String message;
    public String owner;
    public String type;
    public SimpleMessage(String message, String owner, String type) {
        this.message = message;
        this.owner = owner;
        this.type = type;
    }

    public String getMessage() { return message; }
    public String getOwner() { return owner; }
    public String getType() { return type; }
}
