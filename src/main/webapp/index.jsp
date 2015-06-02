
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>RSS Feed</title>

    <!-- Bootstrap core CSS -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/resources/css/justified-nav.css" rel="stylesheet">
    <script src="/resources/js/jquery-2.1.4.min.js"></script>
    <script src="/resources/js/urlReader.js"></script>
   
  </head>

  <body>

    <div class="container">

      <!-- The justified navigation menu is meant for single line per list item.
           Multiple lines will require custom code not provided by Bootstrap. -->
      <div class="masthead">
        <h3 class="text-muted">RSS FEED Service</h3>
        <nav>
          <ul class="nav nav-justified">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#">About</a></li>
            <li><a href="#">Contact</a></li>
          </ul>
        </nav>
      </div>

     <!-- Jumbotron -->
      <div class="jumbotron">
        <h1>Enter the feed URL</h1>
        <p><input type="text" class="form-control" placeholder="Feed URL..." id="urlText"></p>
        <p><button type="button" class="btn btn-lg btn-success" id="urlFeedButtons">Load Feed Data</button></p>
      </div>
      
      <!-- Example row of columns -->
      <div class="row" id="rssFeed">
        
      </div>

      <!-- Site footer -->
      <footer class="footer">
        <p>&copy; Company 2014</p>
      </footer>

    </div> <!-- /container -->
  </body>
</html>
