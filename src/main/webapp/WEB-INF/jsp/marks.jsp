<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>Marks</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="assets/css/animate.min.css" rel="stylesheet"/>

    <!--  Paper Dashboard core CSS    -->
    <link href="assets/css/paper-dashboard.css" rel="stylesheet"/>

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
                    <a href="/profile">
                        <i class="ti-user"></i>
                        <p>User Profile</p>
                    </a>
                </li>
                <li class="active">
                    <a href="/marks">
                        <i class="ti-view-list-alt"></i>
                        <p>Marks</p>
                    </a>
                </li>
                <li>
                    <a href="/attendance">
                        <i class="ti-pencil-alt2"></i>
                        <p>Attendance</p>
                    </a>
                </li>
                <li>
                    <a href="maps.html">
                        <i class="ti-map"></i>
                        <p>Maps</p>
                    </a>
                </li>
                <li>
                    <a href="notifications.html">
                        <i class="ti-bell"></i>
                        <p>Notifications</p>
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
                    <a class="navbar-brand" href="#">Student Marks</a>
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
                    <div class="col-md-12">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Test 1 Marks</h4>
                                <p class="category">1st Internals</p>
                            </div>
                            <div class="content table-responsive table-full-width">
                                <table class="table table-striped">
                                    <thead>
                                        <th>Sl. No.</th>
                                    	<th>Subject Name</th>
                                    	<th>Marks</th>
                                    </thead>
                                    <tbody>
                                        <tr>
                                        	<td>1</td>
                                        	<td>${t1_subject1}</td>
                                        	<td>${t1_subject1_marks}</td>
                                        </tr>
                                        <tr>
                                        	<td>2</td>
                                            <td>${t1_subject2}</td>
                                            <td>${t1_subject2_marks}</td>
                                        </tr>
                                        <tr>
                                        	<td>3</td>
                                            <td>${t1_subject3}</td>
                                            <td>${t1_subject3_marks}</td>
                                        </tr>
                                        <tr>
                                        	<td>4</td>
                                            <td>${t1_subject4}</td>
                                            <td>${t1_subject4_marks}</td>
                                        </tr>
                                        <tr>
                                        	<td>5</td>
                                            <td>${t1_subject5}</td>
                                            <td>${t1_subject5_marks}</td>
                                        </tr>
                                        <tr>
                                        	<td>6</td>
                                            <td>${t1_subject6}</td>
                                            <td>${t1_subject6_marks}</td>
                                        </tr>
                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>


                    <div class="col-md-12">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Test 2 Marks</h4>
                                <p class="category">2nd Internals</p>
                            </div>
                            <div class="content table-responsive table-full-width">
                                <table class="table table-striped">
                                    <thead>
                                    <th>Sl. No.</th>
                                    <th>Subject Name</th>
                                    <th>Marks</th>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td>${t2_subject1}</td>
                                        <td>${t2_subject1_marks}</td>
                                    </tr>
                                    <tr>
                                        <td>2</td>
                                        <td>${t2_subject2}</td>
                                        <td>${t2_subject2_marks}</td>
                                    </tr>
                                    <tr>
                                        <td>3</td>
                                        <td>${t2_subject3}</td>
                                        <td>${t2_subject3_marks}</td>
                                    </tr>
                                    <tr>
                                        <td>4</td>
                                        <td>${t2_subject4}</td>
                                        <td>${t2_subject4_marks}</td>
                                    </tr>
                                    <tr>
                                        <td>5</td>
                                        <td>${t2_subject5}</td>
                                        <td>${t2_subject5_marks}</td>
                                    </tr>
                                    <tr>
                                        <td>6</td>
                                        <td>${t2_subject6}</td>
                                        <td>${t2_subject6_marks}</td>
                                    </tr>
                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>


                </div>
            </div>
        </div>

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
    <link href="assets/css/demo.css" rel="stylesheet" />

	<!-- Paper Dashboard DEMO methods, don't include it in your project! -->
	<script src="assets/js/demo.js"></script>


</html>
