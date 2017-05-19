<?php
	//receive the message from remote
	//put message to file
	
	if(!empty($_GET['message'])){
		$message=$_GET['message'];
		$name=$_GET['name'];
		$file=fopen("chat.txt","a");
		fwrite($file,$name);
		fwrite($file," : ");
		fwrite($file,$message);
		fwrite($file,"\n");
		fclose($file);
		
		echo "Message Sent";
	}
	

?>
<html><br><br>
<form>
	<input type='button' name ='name' placeholder='Enter Name' style='padding:10px;margin-bottom:20px;' value="Back"><br>

</html>