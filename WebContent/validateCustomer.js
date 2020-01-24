function validation()
{
	var ssnid=document.getElementById("ssnid").value;
	var custid=document.getElementById("custid").value;
	if((ssnid=="")&&(custid==""))
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

function deleteAccountValidation()
{

	var ssnid=document.getElementById("ssnId").value;
	var custid=document.getElementById("custId").value;
	if((ssnid=="")||(custid==""))
		{
		alert('Please Enter all fields');
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