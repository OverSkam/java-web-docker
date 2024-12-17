<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chat Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #1e1e2f; /* Dark background */
            color: #d1d1e0; /* Muted text color */
            display: flex;
            flex-direction: column;
            height: 100vh;
        }
        .chat-container {
            flex: 1;
            display: flex;
            flex-direction: column;
            justify-content: flex-end;
            max-width: 800px;
            margin: 0 auto;
            padding: 30px;
            background-color: #252539; /* Slightly lighter dark color */
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.3);
            border-radius: 8px;
        }
        .messages {
            flex-grow: 1; /* Allow the message container to grow */
            overflow-y: auto; /* Enable vertical scrolling when content overflows */
            max-height: 500px;
            display: flex;/* Set a fixed maximum height for the message area */
            flex-direction: column;
            margin-bottom: 15px; /* Space between messages and input field */
        }
        .messages {
            scrollbar-width: none; /* Make the scrollbar thinner */
            scrollbar-color: #555 #333; /* Set thumb and track colors (thumb color, track color) */
        }
        .message {
            padding: 12px 16px;
            margin: 8px 0;
            border-radius: 8px;
            max-width: 75%; /* Limit message width */
            font-size: 16px;
            line-height: 1.4;
            word-wrap: break-word;
        }
        .message.sent {
            background-color: #056162; /* Telegram-like teal bubble for sent messages */
            color: #ffffff;
            align-self: flex-end;
            text-align: left;
        }
        .message.received {
            background-color: #2a2a40; /* Dark gray bubble for received messages */
            color: #d1d1e0;
            align-self: flex-start;
            text-align: left;
        }
        .sender-name {
            font-size: 12px;
            font-weight: 500;
            color: #7289da; /* Muted blue for sender name */
            margin-bottom: 5px;
        }
        .message-input-container {
            display: flex;
            align-items: center;
            padding-top: 10px;
            border-top: 1px solid #33334d; /* Divider line */
        }
        .message-input-container input {
            flex: 1;
            padding: 10px;
            border: 1px solid #33334d;
            border-radius: 20px;
            background-color: #2a2a40;
            color: #d1d1e0;
            margin-right: 10px;
            font-size: 14px;
        }
        .message-input-container input::placeholder {
            color: #8b8ba7;
        }
        .message-input-container button {
            padding: 10px 15px;
            border: none;
            background-color: #056162;
            color: #ffffff;
            border-radius: 20px;
            cursor: pointer;
            font-size: 14px;
            transition: background-color 0.3s;
        }
        .message-input-container button:hover {
            background-color: #044c4e; /* Darker teal on hover */
        }

    </style>

</head>
<body>
<div class="chat-container">
    <div class="messages">
    </div>
    <div class="message-input-container">
        <form method="post" style="display: flex; width: 100%;">
            <input type="text" name="message" placeholder="Type your message..." required />
            <button type="submit">Send</button>
        </form>
    </div>
</div>
</body>
</html>


