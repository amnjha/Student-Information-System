<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>Profile</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
	<meta name="viewport" content="width=device-width" />


	<!-- Bootstrap core CSS     -->
	<link href="assets/css/bootstrap.min.css" rel="stylesheet" />

	<!-- Animation library for notifications   -->
	<link href="assets/css/animate.min.css" rel="stylesheet"/>

	<!--  Paper Dashboard core CSS    -->
	<link href="assets/css/paper-dashboard.css" rel="stylesheet"/>
	<link href="assets/css/demo.css" rel="stylesheet" />

	<!--  Fonts and icons     -->
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
	<link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
	<link href="assets/css/themify-icons.css" rel="stylesheet">

</head>
<body>

<div class="wrapper">
	<div class="sidebar" data-background-color="white" data-active-color="danger">

		<!--
            Tip 1: you can change the color of the sidebar's background using: data-background-color="white | black"
            Tip 2: you can change the color of the active button using the data-active-color="primary | info | success | warning | danger"
        -->

		<div class="sidebar-wrapper">
			<div class="logo">
				<a href="/" class="simple-text">
					Student Information System
				</a>
			</div>

			<ul class="nav">
				<li>
					<a href="/">
						<i class="ti-panel"></i>
						<p>Dashboard</p>
					</a>
				</li>
				<li>
					<a href="/profile-admin">
						<i class="ti-user"></i>
						<p>User Profile</p>
					</a>
				</li>
				<li class="active">
					<a href="/marks-admin">
						<i class="ti-view-list-alt"></i>
						<p>Marks</p>
					</a>
				</li>
				<li>
					<a href="/attendance-admin">
						<i class="ti-pencil-alt2"></i>
						<p>Attendance</p>
					</a>
				</li>
				<li>
					<a href="/add-student">
						<i class="ti-map"></i>
						<p>Add Student</p>
					</a>
				</li>
			</ul>
		</div>
	</div>

	<div class="main-panel">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar bar1"></span>
						<span class="icon-bar bar2"></span>
						<span class="icon-bar bar3"></span>
					</button>
					<a class="navbar-brand" href="#">User Profile</a>
				</div>
				<div class="collapse navbar-collapse">
					<ul class="nav navbar-nav navbar-right">
						<li>
							<a href="/logout">
								<div class="icon-success">
									<i class="ti-control-forward"></i>
									<p>Logout</p>
								</div>
							</a>
						</li>
					</ul>
				</div>
			</div>
		</nav>

		<div class="content">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-4 col-md-5">
						<div class="card card-user">
							<div class="image">
								<img src="assets/img/background.jpg" alt="..."/>
							</div>
							<div class="content">
								<div class="author">
									<img class="avatar border-white" src="assets/img/faces/face-1.jpg" alt="..."/>
									<h4 class="title">${name}<br />
										<a href="#"><small>@admin</small></a>
									</h4>
								</div>
								<p class="description text-center">
									'Admin User' <br>
								</p>
							</div>
							<hr>
							<div class="text-center">
								<div class="row">
									<div class="col-md-3 col-md-offset-1">
										<h5>${designation}<br /><small>Designation</small></h5>
									</div>
								</div>
							</div>
						</div>
					</div>
					<form action="/marks-admin" method="post">
						<div class="col-lg-8 col-md-7">
							<div class="card">
								<div class="header">
									<h4 class="title">Enter Marks</h4>
								</div>
								<div class="content">
									<form>
										<div class="row">
											<div class="col-md-5">
												<div class="form-group">
													<label>Subject</label>
													<select name="subject" class="form-control border-input">
														<c:forEach items="${subjects}" var="item">
															<option value="${item}" selected="selected">${item}</option>
														</c:forEach>
													</select>
												</div>
											</div>
											<div class="col-md-3">
												<div class="form-group">
													<label>Roll Number</label>
													<input name="roll" type="text" class="form-control border-input" placeholder="Roll Number">
												</div>
											</div>
											<div class="col-md-4">
												<div class="form-group">
													<label>Marks</label>
													<input name="mark" type="text" class="form-control border-input">
												</div>
											</div>
										</div>
										<div class="row">
											 <div class="col-md-5">
												 <div class="form-group">
													 <label>Internal</label>
													 <select name="internal" class="form-control border-input">
														 <option value="1">1st</option>
														 <option value="2">2nd</option>
													 </select>
												 </div>
											 </div>
										</div>

										<div class="text-center">
											<button type="submit" class="btn btn-info btn-fill btn-wd">Save Marks</button>
										</div>
										<div class="clearfix"></div>
									</form>
								</div>
							</div>
						</div>
				</div>
			</div>
		</div>
		</form>

		<footer class="footer">
			<div class="container-fluid">
				<div class="copyright pull-right">
					&copy; <script>document.write(new Date().getFullYear())</script>, made with <i class="fa fa-heart heart"></i>
				</div>
			</div>
		</footer>

	</div>
</div>


</body>

<script>
	var message ="${message}"
		if(message!=undefined && message!=null && message!=="")
			alert(message);
</script>
<!--   Core JS Files   -->
<script src="assets/js/jquery.min.js" type="text/javascript"></script>
<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

<!--  Checkbox, Radio & Switch Plugins -->
<script src="assets/js/bootstrap-checkbox-radio.js"></script>

<!--  Charts Plugin -->
<script src="assets/js/chartist.min.js"></script>

<!--  Notifications Plugin    -->
<script src="assets/js/bootstrap-notify.js"></script>

<!--  Google Maps Plugin    -->
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js"></script>

<!-- Paper Dashboard Core javascript and methods for Demo purpose -->
<script src="assets/js/paper-dashboard.js"></script>

<!-- Paper Dashboard DEMO methods, don't include it in your project! -->
<script src="assets/js/demo.js"></script>

</html>
