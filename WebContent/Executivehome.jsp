<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  .carousel-inner img {
      -webkit-filter: grayscale(90%);
      filter: grayscale(90%); /* make all photos black and white */ 
      width: 82%; /* Set width to 100% */
      margin: auto;
      height: 30%;
  }
  .carousel-caption h3 {
      color: #fff !important;
  }
  @media (max-width: 600px) {
    .carousel-caption {
      display: none; /* Hide the carousel text when the screen is less than 600 pixels wide */
    }
  }

  .thumbnail {
      padding: 0 0 15px 0;
      border: none;
      border-radius: 0;
  }
  .thumbnail p {
      margin-top: 15px;
      color: #555;
  }

  .navbar {
      font-family: "Times New Roman", Times, serif;
      margin-bottom: 0;
      background-color: #2d2d30;
      border: 0;
      font-size: 14px !important;
      letter-spacing: 4px;
      opacity: 0.9;
      color: red;
  }

  .navbar-nav li a:hover {
      color: #fff !important;
  }
  .navbar-nav li.active a {
      color: #fff !important;
      background-color: #29292c !important;
  }
.footer {
  position: absolute;
  right: 0;
  bottom: 0;
  left: 0px;
  padding: 1rem;
  background-color: #efefef;
  text-align: center;
}

li
{
color: red;
}
  </style>
<title>WELCOME EXECUTIVE</title>
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#myPage" style="color: white;font-family: Montserrat, sans-serif;font-size: 18px"><strong>TATA GLOBAL BANK</strong></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="Executivehome.jsp" style="color: white;">HOME</a></li>
        <li><a href="executive.jsp" style="color: white;">CUSTOMER MANAGEMENT</a></li>
        <li><a href="AccountHome.jsp" style="color: white;">ACCOUNT MANAGEMENT</a></li>
        <li><a href="searchCustomer.jsp"style="color: white;"><span class="glyphicon glyphicon-search">SEARCH</span></a></li>
        <li><a href="NewFile.html"style="color: white;"><span class="glyphicon glyphicon-log-out">Logout</span></a></li>
      </ul>
    </div>
  </div>
</nav>
<div style="height: 30%">
<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="/Project_RetailBanking/Images/Capture1.PNG" alt="New York" width="50%" height="50%">
        <div class="carousel-caption">
          <h3>WORLD CLASS BANKING SOLUTION</h3>
          <p>Faster and User friendly trasactions</p>
        </div>      
      </div>

      <div class="item">
        <img src="https://cdn.moneycrashers.com/wp-content/uploads/2016/04/bank-window-bonus-promotion-918x516.jpg" alt="Chicago" width="50%" height="50%">
        <div class="carousel-caption">
          <h3>Anywhere and at Anytime</h3>
          <p>Access our ATMs worldwide</p>
        </div>      
      </div>
    
      <div class="item">
        <img src="http://static-news.moneycontrol.com/static-mcnews/2017/08/banking-770x433.jpg" alt="Los Angeles" width="50%" height="65%">
        <div class="carousel-caption">
          <h3>Worldclass Infrastructure-Services</h3>
          <p>Your trust Account</p>
        </div>      
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div>
</div>

<!-- Footer -->
<div class="footer">
		All Rights Reserved <strong>&copy; 2017</strong>.
	</div>
</body>
</html>