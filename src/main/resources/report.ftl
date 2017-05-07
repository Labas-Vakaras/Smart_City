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
                  <a href="/about" class="list-group-item">About Us</a>
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
                  <p>type: ${type}</p>
                  <p>description: ${description}</p>
                </div>
                <div class="col-md-6">
                  <div id="map" style="width:100%;height:300px">
                </div>
              </div>
              <hr/>
              <div class="row">
                <div class="col-xs-12">
                  <div id="thank-you" class="text-center hidden">
                    <h2>We really appriciate your contribution</h2>
                  </div>
                  <form action="/item/report" id="report-form" method="POST">
                    <input type="hidden" name="id" value="${id}" />
                    <div class="form-group">
                      <label for="priority">Priority:</label>
                      <select class="form-control" id="type" name="priority" >
                        <option value="1">Low</option>
                        <option value="2">Medium</option>
                        <option value="3">High</option>
                      </select>
                      <small id="priorityHelp" class="form-text text-muted">Low -> should be consdidered, Medium -> check/resolve in 1-2 days, High -> Life in danger</small>
                    </div>
                    <div class="form-group">
                      <label for="comments">Comments</label>
                      <textarea class="form-control" id="comments" name="comment" rows="3"></textarea>
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

    <!-- SmaCi custom JavaScript -->
    <script src="/js/smaci.js"></script>

    <script>
        function initMap() {
            var mapOptions = {
                center: new google.maps.LatLng(${lng}, ${lat}),
                zoom: 14,
                mapTypeId: google.maps.MapTypeId.ROADMAP
            };
            var map = new google.maps.Map(document.getElementById("map"), mapOptions);
            var marker = new google.maps.Marker({
                position: new google.maps.LatLng(${lng}, ${lat}),
                map: map,
                title: 'Item'
            });
        }
    </script>

    <!-- Google Maps API -->
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA99K2u7AtDby-uVfuePRLMd4YxgK0oD4k&callback=initMap"></script>
</body>

</html>
