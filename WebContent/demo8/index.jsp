<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Unity WebGL Player | ParkingLotScene</title>
    <link rel="shortcut icon" href="TemplateData/favicon.ico">
    <link rel="stylesheet" href="TemplateData/style.css">
    <script src="TemplateData/UnityProgress.js" charset="UTF-8"></script>  
    <script src="Build/UnityLoader.js" charset="UTF-8"></script>
    <script>
      var gameInstance = UnityLoader.instantiate("gameContainer", "Build/demo8.json", {onProgress: UnityProgress});
    </script>
    
	
	<script type="text/javascript" charset="UTF-8" src="jquery-3.3.1.js" ></script>
	<script>
      function search(car_park_license){
		
		console.log(car_park_license);

		var msg = "car_park_license=" + car_park_license;	
		$.ajax({
			type:"POST",
			url:"../carport/findCar.action",
			data: msg,
			dataType:"json",
			async:true,	
			success: function(date){
				if(date.trim() != "车辆不存在"){
					gameInstance.SendMessage ("Main Camera", "GoNextScence", date);
				}else{
					alert(date);
				}
			}
		})
	  }
    </script>

  </head>
  <body>
    <div class="webgl-content">
      <div id="gameContainer" style="width: 1280px; height: 760px"></div>
      <div class="footer">
<!--         <div class="webgl-logo"></div> -->
        <div class="fullscreen" onclick="gameInstance.SetFullscreen(1)"></div>
<!--         <div class="title">ParkingLotScene</div> -->
      </div>
    </div>
  </body>
</html>