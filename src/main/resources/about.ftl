<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Insert | SmaCi</title>

    <!-- Bootstrap Core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/css/smaci.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="/">SmaCi</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                  <li>
                      <a href="about">About</a>
                  </li>
                  <li>
                      <a href="about#services">Services</a>
                  </li>
                  <li>
                      <a href="#">Contact</a>
                  </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Page Content -->
    <div class="container">

        <div class="row">

            <div class="col-md-3">
                <p class="lead">SmaCi</p>
                <div class="list-group">
                  <a href="/insert" class="list-group-item">Register Item</a>
                  <a href="/reports" class="list-group-item">City Reports</a>
                  <a href="/about#api" class="list-group-item">Access our Data | API</a>
                  <a href="/about" class="list-group-item active">About Us</a>
                </div>
            </div>

            <div class="col-md-9">
              <div class="row">
                <div class="col-xs-12">
                  <h1>About Us</h1>
                  <p>SmaCi is an online platform which provides a user friendly way to interact with your city. Here you can report problems to the appropriate authorities by scanning a QR barcode of the faulty city component, or just by using your near field communication features (RFID/NFC) of your smartphone</p>
                  <p>Great example of SmaCi capabillities is also the ability to send signals on traffic lights, which in turn can help people with disabilities cross the roads safely, by prolonging the green light. You only have to scan the QR code, or come closer to the passive RFID tag, which is embeded on the traffic light.</p>
                </div>
              </div>
              <hr/>
              <div class="row" id="services">
                <div class="col-xs-12">
                  <h1>Services</h1>
                  <p>Our platform provides</p>
                  <ul>
                    <li>specialized QR generation and RFID setup</li>
                    <li>Adaptation with traffic light networks</li>
                    <li>Access to our data, through a user friendly API</li>
                  </ul>
                </div>
              </div>
              <hr/>
              <div class="row" id="api">
                <div class="col-xs-12">
                  <h1>API</h1>
                  <p>Our API is still under construction. <a href="/api/reports">Preview reports data</a></p>
                </div>
              </div>
            </div>

        </div>

    </div>
    <!-- /.container -->

    <div class="container">

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; SmaCi 2017</p>
                </div>
            </div>
        </footer>

    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/js/bootstrap.min.js"></script>
</body>

</html>
