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
        .wrapper {
            display: flex;
            flex-direction: column; /* Stack the container and buttons vertically */
            justify-content: center;
            align-items: center;
            text-align: center;
        }

        .chat-container {
            flex: 1;
            display: flex;
            flex-direction: column;
            justify-content: flex-end;
            max-width: 800px;
            padding: 30px;
            background-color: #252539; /* Slightly lighter dark color */
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.3);
            border-radius: 8px;
            margin-bottom: 15px;

        }

        .messages {
            flex-grow: 1; /* Allow the message container to grow */
            overflow-y: auto; /* Enable vertical scrolling when content overflows */
            max-height: 470px;
            min-height: 470px;
            display: flex; /* Set a fixed maximum height for the message area */
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
        .buttons {
            display: flex;
            justify-content: center; /* Align buttons in a row */
            margin-top: 20px; /* Space between container and buttons */
        }

        .button-group {
            display: flex;
            justify-content: center;
            gap: 20px; /* Space between green and red buttons */
            margin-bottom: 20px; /* Space between this row and the blue button */
        }
        button {
            all: unset; /* Reset default button styles */
            width: 40px;
            height: 40px;
            border-radius: 50%;
            display: flex;
            justify-content: center;
            align-items: center;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            transition: box-shadow 0.3s ease, transform 0.3s ease;
            cursor: pointer;
        }

        button span {
            color: white;
            font-size: 36px;
            pointer-events: none;
        }

        button:hover {
            box-shadow: 0 0 20px 10px rgba(0, 0, 0, 0.3);
            transform: scale(1.1);
        }

        /* Green Button */
        button.green {
            background-color: #4caf50;
        }

        button.green:hover {
            box-shadow: 0 0 20px 10px rgba(76, 175, 80, 0.6);
        }

        /* Red Button */
        button.red {
            background-color: #cf170a;
        }

        button.red:hover {
            box-shadow: 0 0 20px 10px rgba(145, 22, 13, 0.6);
        }

        /* Blue Button */
        button.blue {
            background-color: #2196f3;
        }

        button.blue:hover {
            box-shadow: 0 0 20px 10px rgba(33, 150, 243, 0.6);
        }

        /* Grey Button with Door Icon */
        button.grey {
            background-color: #9e9e9e; /* Grey color */
        }

        button.grey:hover {
            box-shadow: 0 0 20px 10px rgba(255, 0, 0, 0.8); /* Glowing red effect */
            transform: scale(1.1);
        }

    </style>

</head>
<body>
<div class="wrapper">
    <div class="chat-container">
        <div class="messages">
            <#-- Iterate through the messages stored in the model -->
            <#list messages as ms>
                <div class="message ${ms.type}">
                    <div class="sender-name">
                        ${ms.owner}
                    </div>
                    ${ms.message}

                </div>
            </#list>
        </div>
        <div class="message-input-container">
            <form method="post" style="display: flex; width: 100%;">
                <input type="text" name="message" placeholder="Type your message..." required/>
                <button type="submit" name="action" value="send">Send</button>
            </form>
        </div>
    </div>
    <div class="button-group">
        <form method="post">
            <button type="submit" name="action" value="back" class="button blue">
                <span>&#8592;</span> <!-- Left Arrow Icon -->
            </button>
        </form>
        <form method="post">
            <button type="submit" name="action" value="logout" class="button red">
                <span>&#x21bb;</span> <!-- Exit (X) Icon -->
            </button>
        </form>
    </div>
</div>
</body>
</html>


