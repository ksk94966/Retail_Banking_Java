function validation()
{
	var ssnid=document.getElementById("ssnid").value;
	var custid=document.getElementById("custid").value;
	var accid=document.getElementById("accid").value;
	if((ssnid=="")&&(custid=="")&&(accid==""))
		{
		alert('Please Enter any one');
		return false;

		}
	else if(isNaN(ssnid))
		{
		alert('Enter valid SSNID');
		return false;
		}
	else if(isNaN(custid))
	{
	alert('Enter valid Customer ID');
	return false;
	}
	else if((ssnid!="") &&(ssnid.length!=7))
		{
		alert('Check SSNID !!');
		return false;
		}
	}

	

