<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Add Patient</title>

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
                <h2 style="text-align: center;color: darkblue">Add Foreign Patient</h2>
                <form method="post" id="signup-form" class="signup-form" action="/patients/add-foreign">
                    <div class="form-row">
                        <div class="form-group">
                            <label for="surname">Surname</label>
                            <input type="text" class="form-input" name="surname" id="surname" required/>
                        </div>
                        <div class="form-group">
                            <label for="givenNames">Given Names</label>
                            <input type="text" class="form-input" name="givenNames" id="givenNames" required/>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group">
                            <label for="passport">Passport Number</label>
                            <input type="text" class="form-input" name="passportNumber" id="passport" required/>
                        </div>
                        <div class="form-group">
                            <label for="nationality">Nationality</label>
                            <input type="text" class="form-input" name="nationality" id="nationality" required/>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-radio">
                            <label>Sex</label>
                            <div class="form-flex">
                                <input type="radio" name="gender" value="Male" id="male" checked="checked" required/>
                                <label for="male">Male</label>

                                <input type="radio" name="gender" value="Female" id="female" required/>
                                <label for="female">Female</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label>Birth Date</label>
                            <input type="date" class="form-input" name="birth_date" id="birth_Date" placeholder="yyyy-MM-dd" required/>
                        </div>

                    </div>
                    <div class="form-row">
                        <div class="form-group">
                            <label>Sample Date</label>
                            <input type="date" class="form-input" name="sampleDate" id="sampleDate" placeholder="yyyy-MM-dd" required/>
                        </div>
                        <div class="form-group">
                            <label>Reporting Date</label>
                            <input type="date" class="form-input" name="reportingDate" id="reportingDate" placeholder="yyyy-MM-dd" required/>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group">
                            <label>Test</label>
                            <input name="test" list="tests" class="form-input" placeholder="test" required/>
                            <datalist id="tests">
                                <option value="RT-PCR-Covid19">
                                <option value="Covid19-Rapid Antigen Test">
                            </datalist>
                        </div>
                        <div class="form-group">
                            <label>Result</label>
                            <input name="result" list="results" class="form-input" placeholder="result" required/>
                            <datalist id="results">
                                <option value="Positive">
                                <option value="Negative">
                            </datalist>
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