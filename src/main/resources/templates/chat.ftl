<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link rel="stylesheet" href="/static/styles.css">
</head>
<body>
<div class="login-container">
    <h2>Login</h2>
    <form method="post">
        <label for="username">Username</label>
        <input type="text" name="login" placeholder="Enter your username" required>
        <input type="text" name="password" placeholder="Enter your password" required>

        <button type="submit" name="login" value="login">Login</button>
    </form>


</div>
<div>
    <form method="post" >
        <button type="submit" name="reg" value="reg">Register</button>
    </form>
</div>
</body>
</html>