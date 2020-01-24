<!DOCTYPE html>
<html lang="en">
<head>
  <title>TATA GLOBAL BANK</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  
    /* Remove the navbar's default margin-bottom and rounded borders */ 
   .carousel-inner{
  width:100%;
  height:100%;
}
    .navbar 
    {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {
    height: 120px;
    }
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 40%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
      
      .carousel-inner{
        width:60%;
        max-height: 0px !important;
}
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) 
    {
      .sidenav {
        height: 50px;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
  </style>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
  
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
       <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
 
      <a class="navbar-brand" href="refer.jsp" >TATA GLOBAL BANK</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="about.jsp">About Us</a></li>
        <li><a href="contact.jsp">Contact Us</a></li>
                   <li><a href="NewFile.html"style="color: white;"><span class="glyphicon glyphicon-log-out">Logout</span></a></li>
        
        
      </ul>
      
    </div>
  </div>
</nav>

<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" ></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="Images/mani.JPG" style=width:100%; style=height:50%; alt="Image">
        <div class="carousel-caption">
        <script>
function blinker() 
{
	$('.blinking').fadeOut(500);
	$('.blinking').fadeIn(500);
}
setInterval(blinker, 1000);
</script>

<h2 class="blinking" >CORPORATE BANKING</h2>
          
          <h4>Comprehensive Banking Solution For Enterprises</h4>
        </div>      
      </div>

      <div class="item">
        <img src="Images/ex5.jpg" style=width:100%; style=height:50%;  alt="Error in loading image">
        <div class="carousel-caption">
          <h3></h3>
          <p></p>
        </div>      
      </div>
    
    
    <div class="item">
        <img src="Images/money.JPG"" style=width:100%; style=height:50%; alt="Error in loading image">
        <div class="carousel-caption">
          <h3></h3>
          <p></p>
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
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div>
  <br>
  
<div class="container-fluid text-center" style="position: relative;left: 0%;">    
  <div class="row content">

      <p><a href="deposit.jsp"><b>Deposit</b></a></p>
      <p><a href="withdraw.jsp"><b>Withdraw</a></p>
      <p><a href="transfer.jsp"><b>Transfer</a></p>
      <p><a href="ministatement.jsp"><b>Mini Statement</a>
    </div>
    
   
    
    
  </div>
</div>

<br>



<footer class="container-fluid text-center">
  <script>
function blinker() 
{
	$('.blinking').fadeOut(500);
	$('.blinking').fadeIn(500);
}
setInterval(blinker, 1000);
</script>

<p class="blinking" >Update Your Aadhaar Card before December 31st</p>
</footer>

</body>
</html>
