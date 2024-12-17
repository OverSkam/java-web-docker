document.addEventListener("DOMContentLoaded", () => {
    const messageContainer = document.getElementById("message-container");
    const messageInput = document.getElementById("message-input");
    const sendButton = document.getElementById("send-button");

    // Mock previous messages (you'll replace this with real DB data)
    const previousMessages = [
        { content: "Hello!", sender: "other" },
        { content: "Hi there!", sender: "self" },
        { content: "How are you?", sender: "other" },
    ];

    // Load previous messages
    previousMessages.forEach(msg => {
        const messageElement = createMessageElement(msg.content, msg.sender);
        messageContainer.appendChild(messageElement);
    });

    // Scroll to the bottom to see the latest messages
    messageContainer.scrollTop = messageContainer.scrollHeight;

    // Handle sending a message
    sendButton.addEventListener("click", () => {
        const message = messageInput.value.trim();
        if (message) {
            const messageElement = createMessageElement(message, "self");
            messageContainer.appendChild(messageElement);
            messageInput.value = ""; // Clear input
            messageContainer.scrollTop = messageContainer.scrollHeight;

            // Simulate saving the message to a server
            console.log("Message sent:", message);
        }
    });

    // Create a message element
    function createMessageElement(content, sender) {
        const messageElement = document.createElement("div");
        messageElement.classList.add("message");
        if (sender === "self") {
            messageElement.classList.add("sent");
        }
        messageElement.textContent = content;
        return messageElement;
    }
});
