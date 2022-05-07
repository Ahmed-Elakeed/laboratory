<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Validation</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="/resources/fonts/material-icon/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="/resources/vendor/jquery-ui/jquery-ui.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>

<div class="main">

    <section class="signup">
        <!-- <img src="images/signup-bg.jpg" alt=""> -->
        <div class="container">
            <div class="signup-content">
                <form method="post" id="signup-form" class="signup-form" style="height: auto" action="/patients/yourData">
                    <div class="form-row">
                        <div class="form-group">
                            <label for="validation">Passport Number</label>
                            <input type="text" class="form-input" name="passportNumber" id="validation" required/>
                        </div>
                    </div>
                    <div class="form-group">
                        <input type="submit" name="submit" id="submit" class="form-submit" value="Submit"/>
                    </div>
                </form>
            </div>
        </div>
    </section>

</div>

<!-- JS -->
<script src="/resources/vendor/jquery/jquery.min.js"></script>
<script src="/resources/vendor/jquery-ui/jquery-ui.min.js"></script>
<%--    <script src="/resources/vendor/jquery-validation/dist/jquery.validate.min.js"></script>--%>
<script src="/resources/vendor/jquery-validation/dist/additional-methods.min.js"></script>
<script src="/resources/js/main.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>