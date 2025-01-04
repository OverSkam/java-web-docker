<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register Page</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #1a1a2e;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .login-container {
            background-color: #232946;
            padding: 2rem;
            border-radius: 10px;
            box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.2);
            text-align: center;
            width: 300px;
        }
        .login-container h2 {
            color: #fff;
            margin-bottom: 1.5rem;
        }
        .login-container input {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: none;
            border-radius: 5px;
            font-size: 1rem;
        }
        .login-container input[type="text"],
        .login-container input[type="password"] {
            background-color: #2c2c54;
            color: #fff;
        }
        .login-container input[type="text"]:focus,
        .login-container input[type="password"]:focus {
            outline: none;
            border: 2px solid #4ecca3;
        }
        .login-container button {
            width: 100%;
            padding: 10px;
            margin-top: 15px;
            font-size: 1rem;
            font-weight: bold;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .register-btn {
            background-color: #4caf50;
        }
        .register-btn:hover {
            box-shadow: 0 0 20px 10px rgba(76, 175, 80, 0.6);
        }
    </style>
</head>
<body>
<div class="login-container">
    <h2>Register</h2>

    <form method="post">
        <input type="text" name="login" placeholder="Enter your login" required>
        <input type="text" name="password" placeholder="Enter your password" required>
        <input type="text" name="name" placeholder="Enter your name" required>
        <input type="text" name="surname" placeholder="Enter your surname" required>
        <button type="submit" class="register-btn">Register</button>
    </form>
</div>
</body>
</html>
