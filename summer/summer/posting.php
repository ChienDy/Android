
<html>
	<head>
		<meta http-equiv='refresh' content='1' />
	</head>
	<body>
<?php
//read the messages

	$filename="chat.txt";
		$file=file($filename);
	
		echo "<table width=100% style='border-collapse:collapse;border:1px solid #808080'; padding:20px;width:100%'>";
			foreach($file as $record){
				echo "<tr>";
					echo "<td>".$record."</td>";
				echo "</tr>";
			}
		echo "</table>";
	
?>
	</body>
</html>