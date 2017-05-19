<html>
<body>
<form action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>"  method="get">
			Name :
			<input type="text" name ="name" placeholder="Enter Name" style="padding:10px;margin-bottom:20px;margin-top:20px;margin-left:17px;"><br>
			Message : 
			<input type="text" name="message" placeholder="Enter Message" style="padding:10px;margin-bottom:20px;height:100px;width:300px"><br>
			<input type="submit" style="margin-left:160px;">
		</form>
</body>

<?php
if($_SERVER["REQUEST_METHOD"] == "GET")
		{
				if(!empty($_GET['message'])){
				$message=$_GET['message'];
				$name=$_GET['name'];
				$file=fopen("chat.txt","a");
				fwrite($file,$name);
				fwrite($file," : ");
				fwrite($file,$message);
				fwrite($file,"\n");
				fclose($file);
				
				echo "<h4 style='color:green;margin-left:144px;'>" ."Message Sent" ."</h4>";
				}
			
		}

?>
</html>