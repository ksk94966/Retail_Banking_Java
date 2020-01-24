function createAccountValidation()
{
	var customerId=document.getElementById("CustID").value;
	var amt=document.getElementById("DepAmt").value;
	
	if((customerId=="")||(amt==""))
		{
		alert('Please enter all fields');
	  return false;
		}
	else if(isNaN(customerId))
		{
		alert('Enter valid customer ID');
		return false;
		}
	else if(0==document.getElementsByTagName('select')[0].selectedIndex)
	 {
	 alert('Select one option');
	return false;
	 }
	else if((amt!="" )&& (isNaN(amt)))
		{
		alert('Enter amount');
		}
}