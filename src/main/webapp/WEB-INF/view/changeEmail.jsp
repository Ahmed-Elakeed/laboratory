<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Change Email</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/changePassword.css">
</head>
<body style="padding: 70px 350px 350px 350px;background-color: lightgrey">
<form action="/admin/change-email" method="post">
    <div class="container">
        <h1>Change Email</h1>
        <hr>

        <label for="email"><b>Current Email</b></label>
        <input type="email" placeholder="Current Email" name="old_email" id="email" required>

        <label for="psw"><b>New Email</b></label>
        <input type="email" placeholder="New Email" name="new_email" id="psw" required>

        <hr>

        <button type="submit" class="registerbtn" style="background-color: blue">Change</button>
    </div>
</form>
<script src="js/home.js"></script>
</body>
</html>