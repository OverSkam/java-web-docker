<#--<!DOCTYPE html>-->
<#--<html lang="en">-->
<#--<head>-->
<#--    <meta charset="UTF-8">-->
<#--    <meta name="viewport" content="width=device-width, initial-scale=1.0">-->
<#--    <title>Tinderxxx</title>-->
<#--    <link rel="stylesheet" href="/static/styles.css">-->
<#--</head>-->
<#--<body>-->
<#--<div class="menu-container">-->
<#--    <h1>Matches</h1>-->
<#--    <#list users as user>-->
<#--        <h1>${user.name}</h1>-->
<#--        <h1>${user.surname}</h1>-->
<#--        <form method="post">-->
<#--            <button type="submit" name="action" value=${user.id}>Start chat</button>-->
<#--        </form>-->
<#--    </#list>-->
<#--</div>-->

<#--</body>-->
<#--</html>-->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chat Users</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #1e1e2f; /* Dark background */
            color: #d1d1e0; /* Light text */
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
        }
        h1 {
            text-align: center;
            color: #7289da; /* Heading color */
        }
        .user-list {
            list-style: none;
            padding: 0;
        }
        .user-item {
            display: flex;
            align-items: center;
            background-color: #252539;
            padding: 15px;
            margin: 10px 0;
            border-radius: 8px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .user-item:hover {
            background-color: #33334d;
        }
        .user-avatar {
            width: 50px;
            height: 50px;
            background-color: #444;
            border-radius: 50%;
            margin-right: 15px;
        }
        .user-info {
            flex-grow: 1;
        }
        .user-name {
            font-size: 16px;
            font-weight: bold;
            color: #fff;
        }
        .last-message {
            font-size: 14px;
            color: #aaa;
            margin-top: 5px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Chat Users</h1>
    <ul class="user-list">
        <#-- Iterate over the list of users -->
        <#list users as user>
            <li class="user-item" onclick="window.location.href='/user/${user.id}'">
                <div class="user-avatar"></div>
                <div class="user-info">
                    <div class="user-name">${user.name} ${user.surname}</div>
                </div>
            </li>
        </#list>
    </ul>
</div>
</body>
</html>
