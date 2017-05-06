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
                        <a href="#">About</a>
                    </li>
                    <li>
                        <a href="#">Services</a>
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
                    <a href="#" class="list-group-item active">Register Item</a>
                    <a href="#" class="list-group-item">Download existing QR</a>
                    <a href="#" class="list-group-item">City Reports</a>
                    <a href="#" class="list-group-item">Access our Data | API</a>
                    <a href="#" class="list-group-item">About Us</a>
                </div>
            </div>

            <div class="col-md-9">
              <div class="row">
                <div class="col-xs-12">
                  <h1>Report</h1>
                </div>
              </div>
              <hr/>
              <div class="row">
                <div class="col-md-6">
                  <h2>Details</h2>
                  <p>id: ${id}</p>
                  <p>type: not implemented yet</p>
                </div>
                <div class="col-md-6">
                  <p>Google maps placeholder</p>
                </div>
              </div>
              <hr/>
              <div class="row">
                <div class="col-xs-12">
                  <form action="#" method="POST">
                    <div class="form-group">
                      <label for="priority">Priority:</label>
                      <select class="form-control" id="type" name="priority" >
                        <option value="1">Low</option>
                        <option value="2">Medium</option>
                        <option value="3">High</option>
                      </select>
                      <small id="priorityHelp" class="form-text text-muted">Low -> should be condisdered, Medium -> check/resolve in 1-2 days, High -> Life in danger</small>
                    </div>
                    <div class="form-group">
                      <label for="comments">Comments</label>
                      <textarea class="form-control" id="comments" name="comments" rows="3"></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                  </form>
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
                    <p>Copyright &copy; Your Website 2014</p>
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
