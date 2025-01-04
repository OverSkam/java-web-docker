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
<#--    <h1>Tinder on steroids</h1>-->
<#--    <p>${name}</p>-->
<#--    <p>${surname}</p>-->
<#--    <p>${age}</p>-->
<#--    <p>${about}</p>-->
<#--</div>-->
<#--<form method="post" >-->
<#--    <button type="submit" name="action" value="skip">Skip</button>-->
<#--</form>-->
<#--<form method="post" >-->
<#--    <button type="submit" name="action" value="like">Like</button>-->
<#--</form>-->
<#--<form method="post" >-->
<#--    <button type="submit" name="navigation" value="logout">Logout</button>-->
<#--</form>-->
<#--</body>-->
<#--</html>-->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #1e1e2f; /* Dark background */
            color: #d1d1e0; /* Light text color */
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .profile-container {
            text-align: center;
            background-color: #252539;
            padding: 30px;
            border-radius: 12px;
            width: 350px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.3);
        }

        .profile-photo {
            width: 120px;
            height: 120px;
            background-color: #444;
            border-radius: 50%;
            overflow: hidden;
            margin: 0 auto;
        }

        .profile-photo img {
            width: 100%;
            height: 100%;
            object-fit: cover; /* Ensure the image fits nicely inside the circle */
        }

        .user-name {
            font-size: 24px;
            font-weight: bold;
            margin-top: 15px;
            color: #ffffff;
        }

        .user-age {
            font-size: 18px;
            margin-top: 5px;
            color: #aaa;
        }

        .user-bio {
            margin-top: 15px;
            font-size: 16px;
            color: #d1d1e0;
            line-height: 1.5;
        }

        /* styles.css */

        body {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #1e1e2f; /* Dark background */
            font-family: Arial, sans-serif;
        }

        .container {
            text-align: center;
            margin-bottom: 40px;
            font-size: 24px;
            color: #333;

        }

        .button-group {
            display: flex;
            justify-content: center;
            gap: 50px; /* Space between green and red buttons */
            margin-bottom: 20px; /* Space between this row and the blue button */
        }

        button {
            all: unset; /* Reset default button styles */
            width: 80px;
            height: 80px;
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
            background-color: #ff4081;
        }

        button.red:hover {
            box-shadow: 0 0 20px 10px rgba(255, 64, 129, 0.6);
        }

        /* Blue Button */
        button.blue {
            background-color: #2196f3;
        }

        button.blue:hover {
            box-shadow: 0 0 20px 10px rgba(33, 150, 243, 0.6);
        }



    </style>
</head>
<body>
<div class="container">
    <div class="profile-container">
        <div class="profile-photo">
            <#if photoUrl?has_content>
                <img src="${photoUrl}" alt="User Photo">
            <#else>
                <!-- Placeholder photo if no URL is provided -->
                <img src="${image}" alt="User Photo">
            </#if>
        </div>
        <div class="user-name">${name} ${surname}</div>
        <div class="user-age">Age: ${age}</div>
        <div class="user-bio">${about}</div>
    </div>
</div>
<div class="button-group">
    <div class="button green">
        <form method="post">
            <button type="submit" name="action" value="skip" class="button green">
                <span>&#8592;</span> <!-- Left Arrow Icon -->
            </button>
        </form>
    </div>
    <form method="post">
        <button type="submit" name="action" value="like" class="button red">
            <span>&#10084;</span> <!-- Heart Icon -->
        </button>
    </form>
</div>
<form method="post">
    <button type="submit" name="navigation" value="matches" class="button blue">
        <span>&#9993;</span> <!-- Paper Airplane Icon -->
    </button>
</form>
</body>
</html>



