<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RPG Main Menu</title>
</head>
<body>
<div class="menu-container">
    <h1>Welcome to the RPG</h1>
    <p>${pname}       ${ename}</p>
    <p>${php}       ${ehp}</p>
    <p>${pdmg}       ${edmg}</p>
    <p>${plvl}       ${elvl}</p>
    <p>${pgold}       ${egold}</p>
    <h1>${roll}</h1>
</div>
<form method="post" >
    <button type="submit" name="action" value="attack">Attack</button>
</form>
<form method="post" >
    <button type="submit" name="action" value="heal">Heal</button>
</form>
</body>
</html>
