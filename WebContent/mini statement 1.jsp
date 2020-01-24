<!DOCTYPE html>
<html lang="en">
<head>
  <title>TATA GLOBAL BANK</title>
  <script>
function validate()
{
	var tn=document.formname.id.value;
	
	var disc=document.formname.trans.value;
	if(tn=="" || disc=="")
		{
		alert("enter all fields");
		return false;
		}
	return true;
	}
</script>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar 
    {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {
    height: 450px
    }
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) 
    {
      .sidenav {
        height: auto;
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
        
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="refer.jsp"><span class="glyphicon glyphicon-log-in"></span>  Home</a></li>
      </ul>
    </div>
  </div>
</nav>

<img id="myImg" src="Images/mini2.png" width="1400" height="200">
        
        
<div class="container">
  <h2>MiniStatement</h2>
  <form class="form-horizontal" name="formname" action="ServletAction" method="post" onsubmit="return validate()">
    <div class="form-group">
      <label class="control-label col-sm-2" for="Account">Enter AccountId</label>
        <div class="col-sm-10">
        <input type="text" class="form-control" id="accid" placeholder="Enter AccountId" name="id">
      </div>
    </div>
    
   <form>
   <div class="form-group">
   <label class="control-label col-sm-2" for="Account">Choose No. of Transactions</label>
  <select name="trans">
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
<option value="6">6</option>
<option value="7">7</option>
<option value="8">8</option>
<option value="9">9</option>
<option value="10">10</option>
</select>

  <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
      <center>
        <button type="submit" class="btn btn-success" name="action" value="get">Submit</button>
        </center>
      </div>
    </div>
    </form>
</div>

<br>
<br>

<br>
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

