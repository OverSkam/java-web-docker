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
            background-color: #f4f4f9;
            display: flex;
            flex-direction: column;
            height: 100vh;
        }
        .chat-container {
            flex: 1;
            display: flex;
            flex-direction: column;
            justify-content: flex-end;
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #ffffff;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }
        .messages {
            overflow-y: auto;
            flex-grow: 1;
            margin-bottom: 10px;
        }
        .message {
            padding: 10px;
            margin: 5px 0;
            border-radius: 5px;
        }
        .message.sent {
            background-color: #e0ffe0;
            align-self: flex-end;
        }
        .message.received {
            background-color: #f0f0f0;
            align-self: flex-start;
        }
        .message-input-container {
            display: flex;
            align-items: center;
        }
        .message-input-container input {
            flex: 1;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            margin-right: 10px;
        }
        .message-input-container button {
            padding: 10px 15px;
            border: none;
            background-color: #007bff;
            color: #ffffff;
            border-radius: 4px;
            cursor: pointer;
        }
        .message-input-container button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="chat-container">
    <div class="messages">
        <#-- Iterate through the messages stored in the model -->
        <#list messages as ms>
            <div class="message ${ms.type}">
                ${ms.message}
            </div>
        </#list>
    </div>
    <div class="message-input-container">
        <form action="/sendMessage" method="post" style="display: flex; width: 100%;">
            <input type="text" name="newMessage" placeholder="Type your message..." required />
            <button type="submit">Send</button>
        </form>
    </div>
</div>
</body>
</html>
