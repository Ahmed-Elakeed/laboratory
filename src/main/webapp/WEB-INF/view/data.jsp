<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>Patients Data</title>
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
	<link rel="stylesheet" type="text/css" href="/resources/css/util.css">
	<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">

	<script>
		$(document).ready(function(){
			$('[data-toggle="tooltip"]').tooltip();
		});
	</script>
</head>
<body>
<div class="select2-container--classic" style="width: content-box">
	<div class="col-sm-0" style="float: right;  top:0;right:0;">
		<a href="/admin/logout" class="btn btn-secondary" style="background-color: red"><span>Logout</span></a>
	</div>
	<a href="/admin/change-email-form" class="btn btn-secondary" style="background-color: green"><span>Update Email</span></a>
	<a href="/admin/change-password-form" class="btn btn-secondary" style="background-color: green"><span>Update Password</span></a>
	<div class="table-responsive" style="width: content-box">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-5">
						<h2>Patients <b> Data</b></h2>
					</div>
					<div class="col-sm-7">
						<a href="/patients/addArabForm" class="btn btn-secondary"><i class="material-icons">&#xE147;</i> <span>Add New Arab Patient</span></a>
						<a href="/patients/addForeignForm" class="btn btn-secondary"><i class="material-icons">&#xE147;</i> <span>Add New Foreign Patient</span></a>
					</div>
					<div class="w3-container" style="position:relative">
						<form action="/patients/search" method="post" enctype="multipart/form-data">
							<input type="text" class='w3-input w3-border' name='searchText' id='sendmsg'  required placeholder="type search here">
							<button  class="w3-btn w3-blue w3-border  w3-round-xlarge " style="position:absolute;top:2px;right:16px;" >GO</button>
						</form>
					</div>
					<div class="w3-container" style="position:relative">
						<form action="/patients/delete" method="post" enctype="multipart/form-data">
							<input type="text" class='w3-input w3-border' name='passportNumber' id='passportNum'  required placeholder="passport number">
							<button  class="w3-btn w3-red w3-border  w3-round-xlarge " style="position:absolute;top:2px;right:16px;" >Delete</button>
						</form>
					</div>
				</div>
			</div>
			<table class="table table-striped table-hover">
				<thead>
				<tr>
					<th>Patient Name</th>
					<th>Passport Number</th>
					<th>ID Number</th>
					<th>Nationality</th>
					<th>Sex</th>
					<th>DateOfBirth (year/month/day)</th>
					<th>SampleDate (year/month/day)</th>
					<th>ReportingDate (year/month/day)</th>
					<th>Test</th>
					<th>Result</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach items="${arabPatients}" var="patient">
					<tr style="border: 2px solid black">
						<td>${patient.patientName}</td>
						<td>${patient.passportNumber}</td>
						<td>${patient.national_id}</td>
						<td>${patient.nationality}</td>
						<td>${patient.sex}</td>
						<td>${patient.birthDate}</td>
						<td>${patient.sampleDate}</td>
						<td>${patient.reportingDate}</td>
						<td>${patient.test}</td>
						<td>${patient.result}</td>
					</tr>
				</c:forEach>
				<c:forEach items="${foreignPatients}" var="patient">
					<tr style="border: 2px solid black">
						<td>${patient.surName}${" "}${patient.given_names}</td>
						<td>${patient.passportNumber}</td>
						<td>No National ID</td>
						<td>${patient.nationality}</td>
						<td>${patient.sex}</td>
						<td>${patient.birthDate}</td>
						<td>${patient.sampleDate}</td>
						<td>${patient.reportingDate}</td>
						<td>${patient.test}</td>
						<td>${patient.result}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>