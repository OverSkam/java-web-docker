<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tinderxxx</title>
    <link rel="stylesheet" href="/static/styles.css">
</head>
<body>
<div class="menu-container">
    <h1>Matches</h1>
    <#list users as user>
        <h1>${user.name}</h1>
        <h1>${user.surname}</h1>
        <form method="post">
            <button type="submit" name="action" value=${user.id}>Start chat</button>
        </form>
    </#list>
</div>

</body>
</html>
