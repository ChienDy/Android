<?php 
	
	if(!empty($_GET["username"])&&!empty($_GET["password"])){
		$username=$_GET["username"];
		$password=$_GET["password"];

	$message=($username=="porio"&&$password=="porio")?"Login Accepted":"Invalid Password";
	echo $message;	

	}
	else echo "Please fill all fields";
?>