<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Patient Data</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/resources/css/main.css" type="text/css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link href='css/all.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="/resources/css/usersSyle.css">
    <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
    <script>
        $(document).ready(function(){
            $('[data-toggle="tooltip"]').tooltip();
        });
    </script>
</head>
<body>
<div class="container-xl">
    <div class="table-responsive">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-5">
<%--                        <h2>Patient <b> Data</b></h2>--%>
                    </div>
                    <img src="/resources/images/lap.jpeg" style="float: right;width: 150px;height: 150px">
                </div>
            </div>
            <table class="table table-striped table-hover">
<%--                <thead>--%>
<%--                <tr>--%>
<%--                    <th>Patient Name</th>--%>
<%--                    <th>Passport Number</th>--%>
<%--                    <th>ID Number</th>--%>
<%--                    <th>Nationality</th>--%>
<%--                    <th>Sex</th>--%>
<%--                    <th>Data Of Birth</th>--%>
<%--                    <th>Sample Date</th>--%>
<%--                    <th>Reporting Date</th>--%>
<%--                    <th>RT-PCR-Covid19</th>--%>
<%--                </tr>--%>
<%--                </thead>--%>
                <tbody>
                    <tr>
                        <th style="border-right: 2px solid black;width: 200px">Patient Name</th>
                        <td>${arabPatient.patientName}</td>
                    </tr>
                    <tr>
                        <th style="border-right: 2px solid black;">Passport Number</th>
                        <td>${arabPatient.passportNumber}</td>
                    </tr>
                    <tr>
                        <th style="border-right: 2px solid black">ID Number</th>
                        <td>${arabPatient.national_id}</td>
                    </tr>
                    <tr>
                        <th style="border-right: 2px solid black">Nationality</th>
                        <td>${arabPatient.nationality}</td>
                    </tr>
                    <tr>
                        <th style="border-right: 2px solid black">Sex</th>
                        <td>${arabPatient.sex}</td>
                    </tr>
                    <tr>
                        <th style="border-right: 2px solid black">Date Of Birth</th>
                        <td>${birthDate}</td>
                    </tr>
                    <tr>
                        <th style="border-right: 2px solid black">Sample Date</th>
                        <td>${sampleDate}</td>
                    </tr>
                    <tr>
                        <th style="border-right: 2px solid black">Reporting Date</th>
                        <td>${reportingDate}</td>
                    </tr>
                    <tr>
                        <th style="border-right: 2px solid black">Test</th>
                        <td>${arabPatient.test}</td>
                    </tr>
                    <tr>
                        <th style="border-right: 2px solid black">Result</th>
                        <td>${arabPatient.result}</td>
                    </tr>
<%--                    <tr style="border: 2px solid black">--%>
<%--                        <th style="border-right: 2px solid black">Comment</th>--%>
<%--                        <td>this is certify the aforementioned person has undergone--%>
<%--                            testing for COVID-19 disease by utilizing the highest sensitive--%>
<%--                            molecular technique RT-PCR.<br><br>--%>

<%--                            Nasopharyngeal sample was collected according to WHO--%>
<%--                            guildelines and infection control standards.--%>
<%--                            <br><br>--%>

<%--                            RNA extraction , reverse transcription to complementary--%>
<%--                            DNA subjected for testing to confirm the presence of the--%>
<%--                            known gene sequence of SARS-COV-2 virus in the designated--%>
<%--                            sample.</td>--%>
<%--                    </tr>--%>
                <tr style="border: 2px solid black">
                    <td colspan="2" style="text-align: center"><img src="/resources/images/info.PNG"></td>
                </tr>
                </tbody>
            </table>
            <h4 style="text-align: center;color: black">Test Performed By</h4>
            <h3 style="text-align: center;color: black">Al Shorouk Lab</h3>
        </div>
    </div>
</div>
</body>
</html>