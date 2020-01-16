<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="euc-kr">
<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
<link rel="stylesheet" type="text/css" href="/resources/css/common.css">
<link rel="stylesheet" type="text/css" href="/resources/css/ol.css">
<link rel="stylesheet" type="text/css" href="/resources/css/oxyapp.css">
<link rel="stylesheet" type="text/css" href="/resources/css/swiper.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/resources/js/common.js"></script>
<script type="text/javascript" src="/resources/js/ol.js"></script>
<script type="text/javascript" src="/resources/js/swiper.min.js"></script>
<title>OXY</title>
</head>
<body>

<!-- wrap -->
<div id="wrap">
    <!-- bis panel -->
    <div class="bisp_container">
        <div class="bispanel gradient">
            <div class="bus" id="routeNumber">
                
            </div>
            <div class="station" id="busStopName">
                
            </div>
            <div class="info" id="mainFavoriteInfo">
            
            </div>
            <button type="button" class="star yellow" id="mainFavoriteDelete">favorite</button><!-- button type="button" class="star yellow"></button -->
            <a href="javascript:void(0)" class="bus_add" onclick="selectPassByRoute()" id="currentStopBusListBtn" style="display:none"><spring:message code='R103.3' /></a>
            <input type="text" name="" value="" class="input search" placeholder="<spring:message code='srchBusAndBsst' />" onclick="getBusSearchHistory()" readonly>
        </div>
    </div>
    <!-- /bis panel -->
    <!-- bus list -->
    <div class="bus_list_head main" id="favoriteListTop">
        <p class="title"><spring:message code='fvrt' /></p>
        <div class="btn_area">
            <button type="button" name="button" class="button" onclick="favoriteEdit()">Edit</button>
        </div>
    </div>
    <div class="bus_list main" id="favoriteList">
        <ul>
           
        </ul>
    </div>
</div>
<!-- /wrap -->

<!-- station bus list -->
<div id="bssl">
    <div class="container">
        <a href="javascript:void(0)" class="close" onclick="close_bssl()">Close Bus List</a>
        <p class="subtitle"><spring:message code='crrntBsstBusList' /></p>
        <div class="bus_list" id="currentStopBusList">
            <ul>
                
            </ul>
        </div>
    </div>
</div>
<!-- /station bus list -->

<!-- bus search -->
<div id="bsrc" class="aside">
    <a href="javascript:void(0)" class="back" onclick="close_bsrc()">Close Bus search</a>
    <p class="subtitle"><spring:message code='srchBusAndBsst' /></p>
    <div class="searchbox">
        <input type="text" name="" value="" class="input search" placeholder="<spring:message code='srchBusAndBsst' />" id="searchBox">
        <button type="button" name="" class="button" onclick="searchNearbyBusStop()">지도</button>
    </div>
    <!-- contents -->
    <div class="swiper-container">
        <div class="swiper-pagination" id="searchTab"></div>
    	<div class="swiper-wrapper">
            <!-- 버스노선 -->
    		<div class="swiper-slide">
                <div class="bus_list">
                    <ul id="searchBusRouteHistoryList">
                        
                    </ul>
                </div>
    		</div>
            <!-- /버스노선 -->
            <!-- 버스정류장 -->
    		<div class="swiper-slide">
                <div class="bus_list">
                    <ul id="searchBusStopHistoryList">
                        
                    </ul>
                </div>
            </div>
            <!-- /버스정류장 -->
    	</div>
    </div>
</div>
<!-- /bus search -->

<!-- bus location -->
<div id="bloc" class="aside">
    <a href="javascript:void(0)" class="back" onclick="close_bloc()">Close Bus location</a>
    <p class="subtitle"><spring:message code='manual_23_1' /></p>
    <div class="head_info">
        <p class="title" id="busLocTitle"></p>
        <ul class="infomenu">
            <li>
                <button type="button" class="button refresh" onclick="refreshLocList()"></button>
            </li>
            <li>
                <button type="button" class="button info" id="busInfoBtn" onclick="getBusRotInfo()">info</button>
            </li>
            <li>
                <button type="button" class="button map" id="busStopLineMapBtn">map</button>
            </li>
            <li>
                <button type="button" class="button star white" id="busLocFavoriteYn">favorite</button>
            </li>
        </ul>
    </div>
    <div class="container">
        <ul class="location_list" id="locList">
            
        </ul>
    </div>
</div>
<!-- /bus location -->

<!-- station bus info -->
<div id="stbi" class="aside">
    <a href="javascript:void(0)" class="back" onclick="close_stbi()">Close Station bus info</a>
    <p class="subtitle"><spring:message code='manual_23_2' /></p>
    <div class="head_info">
        <p class="title" id="busStopRouteInfoTitle"></p>
        <ul class="infomenu">
            <li>
                <button type="button" class="button refresh" onclick="refreshBusStopRouteList()"></button>
            </li>
            <li>
                <button type="button" class="button map" id="nearbyBusInfoBtn">map</button>
            </li>
            <li>
                <button type="button" class="button star white" id="stbiFavoriteBtn">favorite</button>
            </li>
        </ul>
    </div>
    <!-- contents -->
    <div class="container">
        <div class="bus_list stationbis">
            <ul id="busStopRouteList">
                
            </ul>
        </div>
    </div>
    <!-- /contents -->
</div>
<!-- /station bus info -->

<!-- bus route -->
<div id="brout" class="aside">
    <a href="javascript:void(0)" class="back" onclick="close_brout()">Close Bus route</a>
    <p class="subtitle" id="busRouteInfoTitle"></p>
    <div class="swiper-container">
        <div class="swiper-pagination"></div>
    	<div class="swiper-wrapper">
            <!-- 월~금 -->
    		<div class="swiper-slide">
                <table class="table">
                    <tr>
                        <td rowspan="2" class="bdr" id="startDName1">OOO OOO OO<br>방면</td>
                        <td><spring:message code='strtpFstvhclTime' /></td>
                        <td id="startDFirstTime1">-- : --</td>
                    </tr>
                    <tr>
                        <td><spring:message code='strtpLstvhclTime' /></td>
                        <td id="startDLastTime1">-- : --</td>
                    </tr>
                    <tr>
                        <td rowspan="2" class="bdr" id="endDName1">OO OOOO<br>방면</td>
                        <td><spring:message code='turnpFstvhclTime' /></td>
                        <td id="endDFirstTime1">-- : --</td>
                    </tr>
                    <tr>
                        <td><spring:message code='turnpLstvhclTime' /></td>
                        <td id="endDLastTime1">-- : --</td>
                    </tr>
                    <tr>
                        <td class="bdr"><spring:message code='busOprnIntv' /></td>
                        <td colspan="2" id="dispatchInterval1">-- <spring:message code='min' /></td>
                    </tr>
                </table>
    		</div>
            <!-- /월~금 -->
            <!-- 토요일 -->
    		<div class="swiper-slide">
                <table class="table">
                    <tr>
                        <td rowspan="2" class="bdr" id="startDName2">OOO OOO OO<br>방면</td>
                        <td><spring:message code='strtpFstvhclTime' /></td>
                        <td id="startDFirstTime2">-- : --</td>
                    </tr>
                    <tr>
                        <td><spring:message code='strtpLstvhclTime' /></td>
                        <td id="startDLastTime2">-- : --</td>
                    </tr>
                    <tr>
                        <td rowspan="2" class="bdr" id="endDName2">OO OOOO<br>방면</td>
                        <td><spring:message code='turnpFstvhclTime' /></td>
                        <td id="endDFirstTime2">-- : --</td>
                    </tr>
                    <tr>
                        <td><spring:message code='turnpLstvhclTime' /></td>
                        <td id="endDLastTime2">-- : --</td>
                    </tr>
                    <tr>
                        <td class="bdr"><spring:message code='busOprnIntv' /></td>
                        <td colspan="2" id="dispatchInterval2">-- <spring:message code='min' /></td>
                    </tr>
                </table>
            </div>
            <!-- /토요일 -->
            <!-- 휴일 -->
    		<div class="swiper-slide">
                <table class="table">
                    <tr>
                        <td rowspan="2" class="bdr" id="startDName3">OOO OOO OO<br>방면</td>
                        <td><spring:message code='strtpFstvhclTime' /></td>
                        <td id="startDFirstTime3">-- : --</td>
                    </tr>
                    <tr>
                        <td><spring:message code='strtpLstvhclTime' /></td>
                        <td id="startDLastTime3">-- : --</td>
                    </tr>
                    <tr>
                        <td rowspan="2" class="bdr" id="endDName3">OO OOOO<br>방면</td>
                        <td><spring:message code='turnpFstvhclTime' /></td>
                        <td id="endDFirstTime3">-- : --</td>
                    </tr>
                    <tr>
                        <td><spring:message code='turnpLstvhclTime' /></td>
                        <td id="endDLastTime3">-- : --</td>
                    </tr>
                    <tr>
                        <td class="bdr"><spring:message code='busOprnIntv' /></td>
                        <td colspan="2" id="dispatchInterval3">-- <spring:message code='min' /></td>
                    </tr>
                </table>
            </div>
            <!-- /휴일 -->
    	</div>
    </div>
</div>
<!-- /bus route -->

<!-- map view -->
<div id="mapv" class="aside">
    <a href="javascript:void(0)" class="back" onclick="close_mapv()">Close Map</a>
    <p class="subtitle" id="mapTitle"></p>
    <div class="map_area" id="mapArea">
    
    </div>
</div>
<!-- /map view -->

<div id="popup" class="modal">
    <div class="modalcontent">
        <div class="container">
           
            <div class="btn_area">
                <button type="button" name="button" class="button grey" onclick="document.getElementById('popup').style.display='none'"><spring:message code='sayNo' /></button>
                <button type="button" name="button" class="button blue" onclick="document.getElementById('popup').style.display='none'" id="popupYesBtn"><spring:message code='sayYes' /></button>
            </div>
        </div>
    </div>
</div>

<!-- popup1 : confirm -->
<div id="popup1" class="modal">
    <div class="modalcontent">
        <div class="container">
            
            <div class="btn_area">
                <button type="button" name="button" class="button blue" onclick="document.getElementById('popup').style.display='none'; document.getElementById('popup1').style.display='none'"><spring:message code='cfn' /></button>
            </div>
        </div>
    </div>
</div>
<!-- /popup1 : confirm -->

</body>
<script type="text/javascript">
    //@EDIT BY juggle21 2019-03-14
    var interfaceMode = "T";    //T: test, O: operation
	var aToken = "";
	var firstBusStopId = "";
	var selectRouteId = "";
	var selectRouteName = "";
	var qrUserId = "";
	
	var map = "";
	var vectorSource = new ol.source.Vector({});
	
	var swiper = new Swiper('.swiper-container', {
		pagination: {
			el: '.swiper-pagination',
			clickable: true
		},
	});

	$(function() {
		/* @Description : Native APP Embedded 이후 수정 대상
		 * @SessionToken : window.android.getSessionToken()
		 * @qrUserId : window.android.getUserId()
         * @EDIT BY  : juggle21 2019-03-14
		 */
		if(interfaceMode == "T") {
			$.ajax({
				type : "POST",
				url : "/oauth/token?client_id=clientapp&grant_type=password&username=test&password=test",
				contentType : "application/json;charset=UTF-8",
				dataType : "json",
				success : function(data) {
					
					console.log('auth data ----->', data);
					
					aToken = data.access_token;
					loadFavoriteList();
				}
			}) 
			
			qrUserId = 'bis';
		} else {
	        qrUserId = window.android.getUserId();
	        aToken = window.android.getSessionToken();
	        loadFavoriteList();
		}
		
		$("#searchBox").keydown(function(key) {
			if (key.keyCode == 13) {
				searchEvent();
			}
		});
		/* 
		$(window).bind("pageshow", function(event) {
		    if (event.originalEvent.persisted) {
		        document.location.reload();
		        alert("뒤로가기버튼");
		    }
		});
		 */
		map = new ol.Map({
		  layers: [
		      new ol.layer.Tile({
		    	  source: new ol.source.OSM()
		      }),
		      new ol.layer.Vector({
		          source: vectorSource
		      })
		  ],
		  target: 'mapArea',
		  view: new ol.View({
		    center: ol.proj.fromLonLat([132.925049,43.004627]),
		    zoom: 8
		  })
		});
		 
		//$("#bsrc .swiper-pagination > span:nth-child(1)::after").text("테스트");

	});
	
	function loadFavoriteList(editMode){
		
		var busStopArriveList  = new Array();
		var busPosition1 = new Object();
		
		busPosition1.busStopName = "테스트 정류장";
		busPosition1.routeId = "100000020";
		busPosition1.routeNumber = "97";
		busPosition1.arrivalSequence = 1;
		busPosition1.locationNum = 2;
		busPosition1.passTime = 0;
		
		busStopArriveList.push(busPosition1);
		
		var jsonData = JSON.stringify(busStopArriveList);
		
		$.ajax({
			type : "POST",
			url : "/app/bis/mainScreen/getMain.json?qrUserId="+qrUserId,
			beforeSend : function(xhr){
	            xhr.setRequestHeader("Authorization", "bearer "+aToken);
	        },
			contentType : "application/json;charset=UTF-8",
			dataType : "json",
			/* data : {
				qrUserId : '011dfhzu'
			}, */
			success : function(data) {
				var fList = data.favoriteList;
				if(data.favoriteList.length > 0){
					$.ajax({
						type : "POST",
						url : "/app/bis/busStop/selectArrivingBusListByBusStop.json?busStopId="+fList[0].busStopId,
						beforeSend : function(xhr){
				            xhr.setRequestHeader("Authorization", "bearer "+aToken);
				        },
						contentType : "application/json;charset=UTF-8",
						dataType : "json",
						success : function(data2) {
							var busStopArriveList = data2.busStopArriveList;
							//var busStopArriveList = JSON.parse(jsonData);
							
							$("#favoriteList ul").empty();
							
							
							if(fList[0].favoriteType == "3"){
								$("#routeNumber").text(fList[0].routeNumber);
								$("#busStopName").text(fList[0].busStopName);
								firstBusStopId = fList[0].busStopId;
								$("#currentStopBusListBtn").show();
								
								var tempSpringMessage = "<spring:message code='confirm.delFvrt' />"
								
								$("#mainFavoriteDelete").attr("onclick","setPopup('"+tempSpringMessage+"','editFavorite("+fList[0].busStopId+","+fList[0].routeId+",\"D\")')")
							}else if(fList[0].favoriteType == "2"){
								$("#routeNumber").text("");
								$("#busStopName").text(fList[0].busStopName);
								firstBusStopId = fList[0].busStopId;
								$("#currentStopBusListBtn").show();
								
								var tempSpringMessage = "<spring:message code='confirm.delFvrt' />"
								
								$("#mainFavoriteDelete").attr("onclick","setPopup('"+tempSpringMessage+"','editFavorite("+fList[0].busStopId+",\"\",\"D\")')")
							}else if(fList[0].favoriteType == "1"){
								$("#routeNumber").text(fList[0].routeNumber);
								$("#busStopName").text("");
								$("#currentStopBusListBtn").hide();
								
								var tempSpringMessage = "<spring:message code='confirm.delFvrt' />"
								
								$("#mainFavoriteDelete").attr("onclick","setPopup('"+tempSpringMessage+"','editFavorite(\"\","+fList[0].routeId+",\"D\")')")
							}
							
			                //@EDIT BY juggle21 2019-03-14
							console.log('$("#busStopName").text()--->', $("#busStopName").text());
		                    console.log('$("#routeNumber").text()--->', $("#routeNumber").text());
		                    
		                    if($("#busStopName").text()) {
		                        $('#busStopName').click( function() {
		                            openLocList(fList[0].busStopId,fList[0].busStopName,'Y')    
		                        });
		                    }
		                    
		                    if($("#routeNumber").text()) {
		                        $('#routeNumber').click( function() {
		                            openLocList(fList[0].routeId, fList[0].routeNumber,'Y')    
		                        });
		                    }   
							
							if(busStopArriveList.length >= 2){
								$("#mainFavoriteInfo").empty();
								$("#mainFavoriteInfo").append("<p>"+busStopArriveList[0].locationNum+"<spring:message code='aFewPrev' /></p>");
								$("#mainFavoriteInfo").append("<p>"+busStopArriveList[1].locationNum+"<spring:message code='aFewPrev' /></p>");
							}else if(busStopArriveList.length == 1){
								$("#mainFavoriteInfo").empty();
								$("#mainFavoriteInfo").append("<p>"+busStopArriveList[0].locationNum+"<spring:message code='aFewPrev' /></p>");
							}else{
								$("#mainFavoriteInfo").empty();
							}
							
							for(var i = 1; i < fList.length; i++){
								var fText = "";
								var type = "";
								var openType = false;
								if(fList[i].favoriteType == "3"){
									fText = fList[i].busStopName + " (" +fList[i].routeNumber + ")";
									type = "station";
									openType = true;
								}else if(fList[i].favoriteType == "2"){
									fText = fList[i].busStopName;
									type = "station";
									openType = false;
								}else if(fList[i].favoriteType == "1"){
									fText = fList[i].routeNumber;
									type = "bus";
									openType = true;
								}
								if(editMode){
									$("#favoriteList ul").append('<li><label class="checklabel"><span class='+type+'>'+fText+'</span>' + 
									'<input type="checkbox" onclick=checkboxToggle(this)><span class="checkmark"></span></label>' +
									'<p class="delete fR" id="mainFavoriteListDel'+i+'" onclick=editFavorite('+fList[i].busStopId+','+fList[i].routeId+',"D")>delete</p></li>');
									
									var tempSpringMessage = "<spring:message code='confirm.delFvrt' />"
									
									$("#mainFavoriteListDel"+i).attr("onclick","setPopup('"+tempSpringMessage+"','editFavorite("+fList[i].busStopId+","+fList[i].routeId+",\"D\",true)')")	
								}else{
									if(openType){
										$("#favoriteList ul").append('<li onclick="openLocList('+fList[i].routeId+',\''+fList[i].routeNumber+'\',\'Y\')"><p class='+type+'>'+fText+'</p><p class="star yellow fR"></p></li>')
									}else{
										$("#favoriteList ul").append('<li onclick="openBusStopRouteList('+fList[i].busStopId+',\''+fList[i].busStopName+'\',\'Y\')"><p class='+type+'>'+fText+'</p><p class="star yellow fR" id=""></p></li>')
									}
								}
							}
						}
					}) 
				}
			}
		})
	}
	
	function selectPassByRoute(){
		
		/* var params = {
			qrUserId : "011dfhzu",
			busStopId : firstBusStopId				
		} */
		
		$("#currentStopBusList ul").empty();
		$.ajax({
			type : "POST",
			url : "/app/bis/busRoute/selectPassByRoute.json?qrUserId="+qrUserId+"&busStopId="+firstBusStopId,
			beforeSend : function(xhr){
	            xhr.setRequestHeader("Authorization", "bearer "+aToken);
	        },
			contentType : "application/json;charset=UTF-8",
			dataType : "json",
			//data : JSON.stringify(params),
			success : function(data) {
				var busRouteList = data.busRouteList;
				for(var i = 0; i < busRouteList.length; i++){
					var favoriteYn = busRouteList[i].favoriteYn=="Y"?"yellow":"blank";
					var editType = busRouteList[i].favoriteYn=="Y"?"D":"C";
					var editText =  busRouteList[i].favoriteYn=="Y"?"<spring:message code='confirm.delFvrt' />":"<spring:message code='confirm.addFvrt' />";
					$("#currentStopBusList ul").append('<li><p class=bus>'+busRouteList[i].routeNumber+'</p><p class="star '+favoriteYn+' fR" id="currentStopBusRouteList'+i+'")></p></li>');
					/* onclick=editFavorite('+firstBusStopId+','+busRouteList[i].routeId+',"C" */
					$("#currentStopBusRouteList"+i).attr("onclick","setPopup('"+editText+"','editFavorite(\""+firstBusStopId+"\","+busRouteList[i].routeId+",\""+editType+"\",false,\"selectPassByRoute()\")')")
				}
				open_bssl();
			}
		})
		
	}
	
	function favoriteEdit(){
		
		$("#favoriteListTop>p").text("<spring:message code='manual_21_3' />");
		
		$("#favoriteListTop>div").empty()
		
		$("#favoriteListTop>div").html(
				'<button type="button" name="button" class="button mr10" onclick="">Delete</button>' + 
	            '<button type="button" name="button" class="button" onclick="cancelEditMode()">Cancel</button>'
		)
		
		var text = '<spring:message javaScriptEscape="true" code="confirm.delFvrt" />'
		
		$("#favoriteListTop>div>button:first").attr("onclick","setPopup('"+text+"','delCheckedfavorite()')");
		
		$.ajax({
			type : "POST",
			url : "/app/bis/mainScreen/getMain.json?qrUserId="+qrUserId,
			beforeSend : function(xhr){
	            xhr.setRequestHeader("Authorization", "bearer "+aToken);
	        },
			contentType : "application/json;charset=UTF-8",
			dataType : "json",
			/* data : {
				qrUserId : '011dfhzu'
			}, */
			success : function(data) {
				if(data.favoriteList.length > 0){
					$("#favoriteList ul").empty();
					
					var fList = data.favoriteList;
					if(fList[0].favoriteType == "3"){
						$("#routeNumber").text(fList[0].routeNumber);
						$("#busStopName").text(fList[0].busStopName);
						firstBusStopId = fList[0].busStopId;
						$("#currentStopBusListBtn").show();
					}else if(fList[0].favoriteType == "2"){
						$("#busStopName").text(fList[0].busStopName);
						firstBusStopId = fList[0].busStopId;
						$("#currentStopBusListBtn").show();
					}else if(fList[0].favoriteType == "1"){
						$("#routeNumber").text(fList[0].routeNumber);
						$("#currentStopBusListBtn").hide();
					}
					
					//@EDIT BY juggle21 2019-03-14
					console.log('$("#busStopName").text()--->', $("#busStopName").text());
					console.log('$("#routeNumber").text()--->', $("#routeNumber").text());
					
					if($("#busStopName").text()) {
						$('#busStopName').click( function() {
                            openLocList(fList[0].busStopId,fList[0].busStopName,'Y')    
                        });
					}
					
                    if($("#routeNumber").text()) {
                        $('#routeNumber').click( function() {
                            openLocList(fList[0].routeId, fList[0].routeNumber,'Y')    
                        });
                    }					
						
					for(var i = 1; i < fList.length; i++){
						var fText = "";
						var type = "";
						if(fList[i].favoriteType == "3"){
							fText = fList[i].busStopName + " (" +fList[i].routeNumber + ")";
							type = "station";
						}else if(fList[i].favoriteType == "2"){
							fText = fList[i].busStopName;
							type = "station";
						}else if(fList[i].favoriteType == "1"){
							fText = fList[i].routeNumber;
							type = "bus";
						}
						
						$("#favoriteList ul").append('<li><span><label class="checklabel"><span class='+type+'>'+fText+'</span>' + 
						'<input type="checkbox" onclick=checkboxToggle(this) value="'+fList[i].busStopId+','+fList[i].routeId+'"><span class="checkmark"></span></label>' +
						'<p class="delete fR" id="mainFavoriteListDel'+i+'" onclick=editFavorite('+fList[i].busStopId+','+fList[i].routeId+',"D")>delete</p></li>');
						
						var tempSpringMessage = "<spring:message code='confirm.delFvrt' />";
						
						$("#mainFavoriteListDel"+i).attr("onclick","setPopup('"+tempSpringMessage+"','editFavorite("+fList[i].busStopId+","+fList[i].routeId+",\"D\",true)')")	
					}
				}
				
			}
		})
		
	}
	
	function cancelEditMode(){
		$("#favoriteListTop>p").text("<spring:message code='fvrt' />");
		
		$("#favoriteListTop>div").empty()
		
		$("#favoriteListTop>div").html(
				'<button type="button" name="button" class="button" onclick="favoriteEdit()">Edit</button>'
		)
		
		loadFavoriteList();
	}
	
	function editFavorite(busStopId,routeId,requestType,editMode,callbackFunction){
		var type = "추가"
		if(requestType=="D"){
			type = "삭제";
		}
		
			var favoriteType = "";
			
			if(!busStopId){
				favoriteType = "1";
				busStopId = "000000000"
			}else if(!routeId){
				favoriteType = "2";
				routeId = "000000000"
			}else{
				favoriteType = "3";
			}
			
			
			$.ajax({
				type : "POST",
				url : "/app/bis/mainScreen/editFavorite.json?qrUserId="+qrUserId+"&favoriteType="+favoriteType+"&routeId="+routeId+"&busStopId="+busStopId+"&requestType="+requestType,
				beforeSend : function(xhr){
		            xhr.setRequestHeader("Authorization", "bearer "+aToken);
		        },
				contentType : "application/json;charset=UTF-8",
				dataType : "json",
				success : function(data) {
					if(data==0){
						if(requestType=="D"){
							setPopup1("<spring:message code='allowed.dlt' />");
						}else{
							setPopup1("<spring:message code='allowed.prcgNrml' />");
						}
						loadFavoriteList(editMode);
						//if(historyMode)getBusSearchHistory();
						//if(searchMode)searchEvent();
						Function(callbackFunction)();

						//$("#popup").hide();
					}
				}
			}) 
	}
	
    var busPositionBusStopList = null;
	var busLocElementList = [];

	function openLocList(routeId,routeName,favoriteYn){
		busPosition_electedRouoteId = routeId;
		
		var busPositionList = new Array();
		var busPosition1 = new Object();
		
		busPosition1.busId = "100000000";
		busPosition1.busNumber = "ВО825";
		busPosition1.lastBusStopId = "100001103";
		busPosition1.distanceRate = 0;
		busPosition1.correctLat = 131.912735;
		busPosition1.correctLon = 43.167202;
		
		var busPosition2 = new Object();
		
		busPosition2.busId = "100000001";
		busPosition2.busNumber = "ВО797";
		busPosition2.lastBusStopId = "100000960";
		busPosition2.distanceRate = 0;
		busPosition2.correctLat = 131.961334;
		busPosition2.correctLon = 43.110909;
		
		var busPosition3 = new Object();
		
		busPosition3.busId = "100000003";
		busPosition3.busNumber = "ВО798";
		busPosition3.lastBusStopId = "100001135";
		busPosition3.distanceRate = 0;
		busPosition3.correctLat = 131.91597;
		busPosition3.correctLon = 43.131489;
		
		busPositionList.push(busPosition1);
		busPositionList.push(busPosition2);
		busPositionList.push(busPosition3);
		
		var jsonData = JSON.stringify(busPositionList);
		
		if(favoriteYn=="Y"){
			$("#busLocFavoriteYn").removeClass("white");
			$("#busLocFavoriteYn").addClass("yellow");
			$("#busLocFavoriteYn").removeAttr("onclick");
			$("#busLocFavoriteYn").attr("onclick","setPopup('즐겨찾기를 삭제하시겠습니까.','editFavorite(\"\","+routeId+",\"D\")')");
		}else{
			$("#busLocFavoriteYn").removeClass("yellow");
			$("#busLocFavoriteYn").addClass("white");
			$("#busLocFavoriteYn").removeAttr("onclick");
			$("#busLocFavoriteYn").attr("onclick","setPopup('즐겨찾기를 추가하시겠습니까.','editFavorite(\"\","+routeId+",\"C\")')");
		}
		$.ajax({
			type : "POST",
			url : "/app/bis/busRoute/selectBusStopList.json?routeId="+routeId,
			beforeSend : function(xhr){
	            xhr.setRequestHeader("Authorization", "bearer "+aToken);
	        },
			contentType : "application/json;charset=UTF-8",
			dataType : "json",
			success : function(data) {
				
				$.ajax({
					type : "POST",
					url : "/app/bis/busRoute/selectRouteBusPositionList.json?routeId="+routeId,
					beforeSend : function(xhr){
			            xhr.setRequestHeader("Authorization", "bearer "+aToken);
			        },
					contentType : "application/json;charset=UTF-8",
					dataType : "json",
					success : function(data2) {
						$("#locList").empty();
						$("#busLocTitle").html(routeName);
						var busStopList = data.busStopList;
						
						//@EDIT BY : juggle21 2019-03-18 FOR BUS Position Refresh
						busPositionBusStopList = busStopList;
						busLocElementList = [];
						
						var busPositionList = data2.busPositionList;
						
						//var busPositionList = JSON.parse(jsonData);
						selectRouteId = routeId;
						selectRouteName = routeName;
						for(var i=0;i<busStopList.length;i++){
							var busLoc = "";
							
							for(var j=0;j<busPositionList.length;j++){
								if(busPositionList[j].lastBusStopId == busStopList[i].busStopId){
									var busLocId = 'busLocId_' + j;
									busLoc = '<div id="' + busLocId + '" class="bus">';
									busLocElementList.push(busLocId);
								}
							}
							
							var stationId = 'station_' + busStopList[i].busStopId;
							$("#locList").append('<li id="' + stationId + '">'+busLoc+'<p class="station" id="stationList'+i+'">'+busStopList[i].busStopName+'</p></li>');
							
							$("#busStopLineMapBtn").attr("onclick","addLine("+routeId+",\""+routeName+"\")");
							
							$("#stationList"+i).attr("onclick","moveSearchStation(\""+busStopList[i].busStopName+"\")");
							
			            	//<li><div class="bus"></div><p class="station">15 - 04</p></li>
						}
						
						open_bloc();
					}
				}) 
			}
		}) 
	}
	
	/* @Description : Route Bus Position Refresh
     * @EDIT BY  : juggle21 2019-03-18
     */
    function refreshLocList() {
        if(selectRouteId != null) {
            $.ajax({
                type : "POST",
                url : "/app/bis/busRoute/selectRouteBusPositionList.json?routeId=" + selectRouteId,
                beforeSend : function(xhr){
                    xhr.setRequestHeader("Authorization", "bearer "+aToken);
                },
                contentType : "application/json;charset=UTF-8",
                dataType : "json",
                success : function(data2) {
                    console.log('refreshLocList data2------->', data2);
                    var busPositionList = data2.busPositionList;
                    
                    //remove before bus position
                    for(var idx=0; idx<busLocElementList.length; idx++) {
                    	$('#' + busLocElementList[idx]).remove()
                    }
                    
                    
                    for(var i=0;i<busPositionBusStopList.length;i++){
                        var busLoc = "";
                        
                        for(var j=0;j<busPositionList.length;j++){
                            if(busPositionList[j].lastBusStopId == busStopList[i].busStopId){
                                busLoc = '<div class="bus">';
                                var stationId = 'station_' + busStopList[i].busStopId;
                                $('#' + stationId).append(busLoc);
                            }
                        }
                    }
                    
                    open_bloc();
                }
            }) 
            }
    }	
	
	function getBusRotInfo(){
		routeId = selectRouteId;
		$.ajax({
			type : "POST",
			url : "/app/bis/busRoute/selectRouteOperation.json?routeId="+routeId+"&wdayType=1",
			beforeSend : function(xhr){
	            xhr.setRequestHeader("Authorization", "bearer "+aToken);
	        },
			contentType : "application/json;charset=UTF-8",
			dataType : "json",
			success : function(data1) {
				$.ajax({
					type : "POST",
					url : "/app/bis/busRoute/selectRouteOperation.json?routeId="+routeId+"&wdayType=2",
					beforeSend : function(xhr){
			            xhr.setRequestHeader("Authorization", "bearer "+aToken);
			        },
					contentType : "application/json;charset=UTF-8",
					dataType : "json",
					success : function(data2) {
						$.ajax({
							type : "POST",
							url : "/app/bis/busRoute/selectRouteOperation.json?routeId="+routeId+"&wdayType=3",
							beforeSend : function(xhr){
					            xhr.setRequestHeader("Authorization", "bearer "+aToken);
					        },
							contentType : "application/json;charset=UTF-8",
							dataType : "json",
							success : function(data3) {
								
								if(data1.routeOperation)setBusRotInfo(data1,"1");
								if(data2.routeOperation)setBusRotInfo(data2,"2");
								if(data3.routeOperation)setBusRotInfo(data3,"3");
								$("#busRouteInfoTitle").text(selectRouteName);
								open_brout();
							}
						})
					}
				})
			}
		})
	}
	
	function setBusRotInfo(data,type){
		
		var info = data.routeOperation;
		$("#startDName"+type).html(info.startDName);
		$("#startDFirstTime"+type).html(info.startDFirstTime.slice(0, 2)+" : "+info.startDFirstTime.slice(2));
		$("#startDLastTime"+type).html(info.startDLastTime.slice(0, 2)+" : "+info.startDLastTime.slice(2));
		$("#endDName"+type).html(info.endDName);
		$("#endDFirstTime"+type).html(info.endDFirstTime.slice(0, 2)+" : "+info.endDFirstTime.slice(2));
		$("#endDLastTime"+type).html(info.endDLastTime.slice(0, 2)+" : "+info.endDLastTime.slice(2));
		$("#dispatchInterval"+type).html(info.dispatchInterval);
	}
	
	function getBusSearchHistory(){
		$.ajax({
			type : "POST",
			url : "/app/bis/busRoute/selectBusRouteHistory.json?qrUserId="+qrUserId,
			beforeSend : function(xhr){
	            xhr.setRequestHeader("Authorization", "bearer "+aToken);
	        },
			contentType : "application/json;charset=UTF-8",
			dataType : "json",
			//data : JSON.stringify(params),
			success : function(data) {
				
				$.ajax({
					type : "POST",
					url : "/app/bis/busStop/selectBusStopHistory.json?qrUserId="+qrUserId,
					beforeSend : function(xhr){
			            xhr.setRequestHeader("Authorization", "bearer "+aToken);
			        },
					contentType : "application/json;charset=UTF-8",
					dataType : "json",
					//data : JSON.stringify(params),
					success : function(data2) {
						var busRouteList = data.busRouteList;
						$("#searchBusRouteHistoryList").empty();
						for(var i=0;i<busRouteList.length;i++){
							var favoriteYn = busRouteList[i].favoriteYn=="Y"?"yellow":"blank";
							var editType = busRouteList[i].favoriteYn=="Y"?"D":"C";
							var editText =  busRouteList[i].favoriteYn=="Y"?"<spring:message code='confirm.delFvrt' />":"<spring:message code='confirm.addFvrt' />";
							$("#searchBusRouteHistoryList").append('<li><p class="star '+favoriteYn+'" id="searchBusRouteListEditFavorite'+i+'"></p><p class="bus" onclick="openLocList('+busRouteList[i].routeId+',\''+busRouteList[i].routeNumber+'\',\''+busRouteList[i].favoriteYn+'\')">'+busRouteList[i].routeNumber+'</p>' + 
									'<p class="delete fR" id="searchBusRouteHistoryDel'+i+'">delete</p></li>');
							$("#searchBusRouteListEditFavorite"+i).attr("onclick","setPopup('"+editText+"','editFavorite(\"\",\""+busRouteList[i].routeId+"\",\""+editType+"\",false,\"getBusSearchHistory()\")')");
							
							var tempSpringMessage = '<spring:message code="confirm.delSrchHist" />'
							
							$("#searchBusRouteHistoryDel"+i).attr("onclick","setPopup('"+tempSpringMessage+"','delBusRouteHistory(\""+busRouteList[i].routeId+"\")')")	;
						}
						if(busRouteList){
							$("#searchBusRouteHistoryList").append('<p class="clear_history" id="delBusRouteHistoryList"><spring:message code="ltlrSrchRotAllDlt" /></p>');
							
							var tempSpringMessage = '<spring:message code="confirm.delSrchHist" />'
							
							$("#delBusRouteHistoryList").attr("onclick","setPopup('"+tempSpringMessage+"','delBusRouteHistory()')")	;
						}

						var busStopList = data2.busStopList;
						$("#searchBusStopHistoryList").empty();
						for(var i=0;i<busStopList.length;i++){
							var favoriteYn = busStopList[i].favoriteYn=="Y"?"yellow":"blank";
							var editType = busStopList[i].favoriteYn=="Y"?"D":"C";
							var editText =  busStopList[i].favoriteYn=="Y"?"<spring:message code='confirm.delFvrt' />":"<spring:message code='confirm.addFvrt' />";
							$("#searchBusStopHistoryList").append('<li><p class="star '+favoriteYn+'" id="searchBusStopListEditFavorite'+i+'"></p><p class="bus" onclick="openBusStopRouteList('+busStopList[i].busStopId+',\''+busStopList[i].busStopName+'\',\''+busStopList[i].favoriteYn+'\')">'+busStopList[i].busStopName+'</p>' + 
									'<p class="delete fR" id="searchBusStopHistoryDel'+i+'">delete</p></li>');
							$("#searchBusStopListEditFavorite"+i).attr("onclick","setPopup('"+editText+"','editFavorite(\""+busStopList[i].busStopId+"\",\"\",\""+editType+"\",false,\"getBusSearchHistory()\")')")
							
							var tempSpringMessage = '<spring:message code="confirm.delSrchHist" />'
							
							$("#searchBusStopHistoryDel"+i).attr("onclick","setPopup('"+tempSpringMessage+"','delBusStopHistory(\""+busStopList[i].busStopId+"\")')")	
						}
						
						if(busStopList){
							$("#searchBusStopHistoryList").append('<p class="clear_history" id="delBusStopHistoryList"><spring:message code="ltlrSrchBsstAllDlt" /></p>');
							
							var tempSpringMessage = '<spring:message code="confirm.delSrchHist" />'
							
							$("#delBusStopHistoryList").attr("onclick","setPopup('"+tempSpringMessage+"','delBusStopHistory()')")	;
						}
						
						open_bsrc();
					}
				})
			}
		})
	}
	
	function openBusStopRouteList(busStopId,busStopName,favoriteYn){
		
		//@EDIT BY juggle21 : 2019-03-18
		selectedBusStopId = busStopId;
		
		var busStopArriveList  = new Array();
		var busPosition1 = new Object();
		
		busPosition1.busStopName = "테스트 정류장";
		busPosition1.routeId = "100000020";
		busPosition1.routeNumber = "97";
		busPosition1.arrivalSequence = 1;
		busPosition1.locationNum = 2;
		busPosition1.passTime = 0;
		/* 
		var busPosition2 = new Object();
		
		busPosition2.busStopName = "테스트 정류장";
		busPosition2.routeId = "100000003";
		busPosition2.routeNumber = "95";
		busPosition2.arrivalSequence = 2;
		busPosition2.locationNum = 4;
		busPosition2.passTime = 0;
		
		var busPosition3 = new Object();
		
		busPosition3.busStopName = "테스트 정류장";
		busPosition3.routeId = "100000004";
		busPosition3.routeNumber = "66";
		busPosition3.arrivalSequence = 3;
		busPosition3.locationNum = 6;
		busPosition3.passTime = 0;
		 */
		busStopArriveList.push(busPosition1);
		 /* 
		busStopArriveList.push(busPosition2);
		busStopArriveList.push(busPosition3);
		 */
		var jsonData = JSON.stringify(busStopArriveList);
		
		$("#busStopRouteList").empty();
		$("#busStopRouteInfoTitle").text(busStopName);
		if(favoriteYn=="Y"){
			$("#stbiFavoriteBtn").removeClass("white");
			$("#stbiFavoriteBtn").addClass("yellow");
			$("#stbiFavoriteBtn").removeAttr("onclick");
			$("#stbiFavoriteBtn").attr("onclick","setPopup('즐겨찾기를 삭제하시겠습니까.','editFavorite("+busStopId+",\"\",\"D\")')");
		}else{
			$("#stbiFavoriteBtn").removeClass("yellow");
			$("#stbiFavoriteBtn").addClass("white");
			$("#stbiFavoriteBtn").removeAttr("onclick");
			$("#stbiFavoriteBtn").attr("onclick","setPopup('즐겨찾기를 추가하시겠습니까.','editFavorite("+busStopId+",\"\",\"C\")')");
		}
		
		$.ajax({
			type : "POST",
			url : "/app/bis/busStop/selectArrivingBusListByBusStop.json?busStopId="+busStopId,
			beforeSend : function(xhr){
	            xhr.setRequestHeader("Authorization", "bearer "+aToken);
	        },
			contentType : "application/json;charset=UTF-8",
			dataType : "json",
			success : function(data) {
				var busStopArriveList = data.busStopArriveList;
				
				for(var i=0;i<busStopArriveList.length;i++){
					
					var favoriteYn2 = busStopArriveList[i].favoriteYn=="Y"?"yellow":"blank";
					var editType = busStopArriveList[i].favoriteYn=="Y"?"D":"C";
					var editText =  busStopArriveList[i].favoriteYn=="Y"?"<spring:message code='confirm.delFvrt' />":"<spring:message code='confirm.addFvrt' />";
					
					$("#busStopRouteList").append('<li><p class="bus" onclick="open_bloc()">'+busStopArriveList[i].routeNumber+'</p>' + 
					        '<p class="info">'+busStopArriveList[i].locationNum+'<spring:message code="aFewPrev" /></p><p class="star '+favoriteYn2+' fR" id="BusStopRouteInfofavorite'+i+'"></p></li>');
					$("#nearbyBusInfoBtn").attr("onclick","addMarker("+busStopId+")");
					$("#BusStopRouteInfofavorite"+i).attr("onclick","setPopup('"+editText+"','editFavorite(\""+busStopId+"\",\""+busStopArriveList[i].routeId+"\",\""+editType+"\",false,\"openBusStopRouteList("+busStopId+",\\\'"+busStopName+"\\\',\\\'"+favoriteYn+"\\\')\")')");
					
					        
				}
				open_stbi();
			}
		}) 
		
		/* 
		'<li><p class="bus" onclick="open_bloc()">00 (Bus Number)</p>' + 
        '<p class="info">5번째 전</p><p class="star blank fR"></p></li>'
         */
	}
	
    /* @Description : refresh arriving bus info
     * @EDIT BY  : juggle21 2019-03-18
     */
    var selectedBusStopId = null;
	function refreshBusStopRouteList() {
		if(selectedBusStopId != null) {
			$("#busStopRouteList").empty();
			
			$.ajax({
		        type : "POST",
		        url : "/app/bis/busStop/selectArrivingBusListByBusStop.json?busStopId=" + selectedBusStopId,
		        beforeSend : function(xhr){
		            xhr.setRequestHeader("Authorization", "bearer "+aToken);
		        },
		        contentType : "application/json;charset=UTF-8",
		        dataType : "json",
		        success : function(data) {
		        	
		        	console.log('refreshBusStopRouteList--->', data);
		        	
		            var busStopArriveList = data.busStopArriveList;
		            
		            for(var i=0;i<busStopArriveList.length;i++){
		                var favoriteYn2 = busStopArriveList[i].favoriteYn=="Y"?"yellow":"blank";
		                $("#busStopRouteList").append('<li><p class="bus" onclick="open_bloc()">'+busStopArriveList[i].routeNumber+'</p>' + 
		                        '<p class="info">'+busStopArriveList[i].locationNum+'<spring:message code="aFewPrev" /></p><p class="star '+favoriteYn2+' fR" id="BusStopRouteInfofavorite'+i+'"></p></li>');
		            }
		            //open_stbi();
		        }
		    }); 
		}
	}
	
	function searchBusRouteList(searchBusRouteNumber){
		$.ajax({
			type : "POST",
			url : "/app/bis/busRoute/searchBusRoute.json?qrUserId="+qrUserId+"&routeNumber="+searchBusRouteNumber,
			beforeSend : function(xhr){
	            xhr.setRequestHeader("Authorization", "bearer "+aToken);
	        },
			contentType : "application/json;charset=UTF-8",
			dataType : "json",
			success : function(data) {
				var busRouteList = data.busRouteList;
				$("#searchBusRouteHistoryList").empty();
				if(busRouteList.length==0){
					$("#searchBusRouteHistoryList").append('<p class="clear_history">검색 결과가 없습니다.</p>')
				}
				for(var i=0;i<busRouteList.length;i++){
					var favoriteYn = busRouteList[i].favoriteYn=="Y"?"yellow":"blank";
					var editType = busRouteList[i].favoriteYn=="Y"?"D":"C";
					var editText =  busRouteList[i].favoriteYn=="Y"?"<spring:message code='confirm.delFvrt' />":"<spring:message code='confirm.addFvrt' />";
					$("#searchBusRouteHistoryList").append('<li><p class="star '+favoriteYn+'" id="searchBusRouteList'+i+'"></p><p class="bus" onclick="openLocList('+busRouteList[i].routeId+',\''+busRouteList[i].routeNumber+'\',\''+busRouteList[i].favoriteYn+'\')">'+busRouteList[i].routeNumber+'</p></li>')
					$("#searchBusRouteList"+i).attr("onclick","setPopup('"+editText+"','editFavorite(\"\",\""+busRouteList[i].routeId+"\",\""+editType+"\",false,\"searchEvent()\")')");
				}
			}
		})
	}
	
	function searchBusStopList(searchBusStopName){
		$.ajax({
			type : "POST",
			url : "/app/bis/busStop/searchBusStop.json?qrUserId="+qrUserId+"&busStopName="+searchBusStopName,
			beforeSend : function(xhr){
	            xhr.setRequestHeader("Authorization", "bearer "+aToken);
	        },
			contentType : "application/json;charset=UTF-8",
			dataType : "json",
			success : function(data) {
				var busStopList = data.busStopList;
				$("#searchBusStopHistoryList").empty();
				if(busStopList.length==0){
					$("#searchBusStopHistoryList").append('<p class="clear_history">검색 결과가 없습니다.</p>')
				}
				for(var i=0;i<busStopList.length;i++){
					var favoriteYn = busStopList[i].favoriteYn=="Y"?"yellow":"blank";
					var editType = busStopList[i].favoriteYn=="Y"?"D":"C";
					var editText =  busStopList[i].favoriteYn=="Y"?"<spring:message code='confirm.delFvrt' />":"<spring:message code='confirm.addFvrt' />";
					$("#searchBusStopHistoryList").append('<li><p class="star '+favoriteYn+'" id="searchBusStopList'+i+'"></p><p class="bus" onclick="openBusStopRouteList('+busStopList[i].busStopId+',\''+busStopList[i].busStopName+'\')">'+busStopList[i].busStopName+'</p></li>')
					$("#searchBusStopList"+i).attr("onclick","setPopup('"+editText+"','editFavorite(\""+busStopList[i].busStopId+"\",\"\",\""+editType+"\",false,\"searchEvent()\")')");
				}
			}
		})
	}
	
	function checkboxToggle(target){
		if($(target).is(":checked")){
			//$(target).attr("checked",false);
			$(target).addClass("selected");
		}else{
			//$(target).attr("checked",true);
			$(target).removeClass("selected");
		}
	}
	
	function searchEvent(){
		/* 
		if($("#searchTab>span:eq(0)").hasClass("swiper-pagination-bullet-active")){
			searchBusRouteList(searchKeyword);
		}else{
			searchBusStopList(searchKeyword);
		}
		 */
		var searchKeyword = $("#searchBox").val();
		searchBusRouteList(searchKeyword);
		searchBusStopList(searchKeyword);
	}
	
	function delBusRouteHistory(routeId){
		if(!routeId)routeId="";
		$.ajax({
			type : "POST",
			url : "/app/bis/busRoute/deleteBusRouteHistory.json?qrUserId="+qrUserId+"&routeId="+routeId,
			beforeSend : function(xhr){
	            xhr.setRequestHeader("Authorization", "bearer "+aToken);
	        },
			contentType : "application/json;charset=UTF-8",
			dataType : "json",
			success : function(data) {
				if(data==0){
					setPopup1("<spring:message code='info.delSrchHist' />");
					getBusSearchHistory();
					$("#popup").hide();
				}
			}
		}) 
	}
	
	function delBusStopHistory(busStopId){
		if(!busStopId)busStopId="";
		$.ajax({
			type : "POST",
			url : "/app/bis/busStop/deleteBusStopHistory.json?qrUserId="+qrUserId+"&busStopId="+busStopId,
			beforeSend : function(xhr){
	            xhr.setRequestHeader("Authorization", "bearer "+aToken);
	        },
			contentType : "application/json;charset=UTF-8",
			dataType : "json",
			success : function(data) {
				if(data==0){
					setPopup1("<spring:message code='info.delSrchHist' />");
					getBusSearchHistory();
					$("#popup").hide();
				}
			}
		}) 
	}
	
	function setPopup(text,clickFn){
		$("#popup .container").contents()[0].textContent = text;
		$("#popupYesBtn").attr("onclick",clickFn);
		$("#popup").show();
	}
	
	function setPopup1(text){
		$("#popup1 .container").contents()[0].textContent = text;
		$("#popup1").show();
	}
	
	function delCheckedfavorite(){
		var checkedList = $("input:checkbox:checked");
		var result = 0;
		for(var i=0;i<checkedList.length;i++){
			var checkedVal = $(checkedList[i]).val();
			var checkedBusStopId = checkedVal.split(",")[0]!="null"?checkedVal.split(",")[0]:"000000000";
			var checkedBusRouteId = checkedVal.split(",")[1]!="null"?checkedVal.split(",")[1]:"000000000";
			var favoriteType = "";
			if(checkedBusStopId=="000000000"){
				favoriteType = "1";
			}else if(checkedBusRouteId=="000000000"){
				favoriteType = "2";
			}else{
				favoriteType = "3";
			}
			
			$.ajax({
				type : "POST",
				url : "/app/bis/mainScreen/editFavorite.json?qrUserId="+qrUserId+"&favoriteType="+favoriteType+"&routeId="+checkedBusRouteId+"&busStopId="+checkedBusStopId+"&requestType='D'",
				beforeSend : function(xhr){
		            xhr.setRequestHeader("Authorization", "bearer "+aToken);
		        },
				contentType : "application/json;charset=UTF-8",
				dataType : "json",
				success : function(data) {
					if(data==0){
						
					}
				}
			}) 
			
		}
		
		setPopup1("<spring:message code='allowed.dlt' />");
		
		$("#popup").hide();
		cancelEditMode();
		function test(a){
			

		}
	}
	
	function addMarker(busStopId){
		
		vectorSource.clear();
		
		$.ajax({
			type : "POST",
			url : "/app/bis/busStop/selectBusStopPosition.json?&busStopId="+busStopId,
			beforeSend : function(xhr){
	            xhr.setRequestHeader("Authorization", "bearer "+aToken);
	        },
			contentType : "application/json;charset=UTF-8",
			dataType : "json",
			success : function(data) {
				var busStopList = data.busStopList;
				
				var iconFeature = new ol.Feature({
				    geometry: new ol.geom.Point(ol.proj.transform([busStopList[0].lon, busStopList[0].lat], 'EPSG:4326', 'EPSG:3857')),
				    name: 'busStopName',
				});
				
				var iconStyle = new ol.style.Style({
				    image: new ol.style.Icon(/** @type {olx.style.IconOptions} */({
				        anchor: [0.5, 46],
				        anchorXUnits: 'fraction',
				        anchorYUnits: 'pixels',
				        src: '/resources/images/ic_location.svg'
				    }))
				});
				
				iconFeature.setStyle(iconStyle);
				vectorSource.addFeature( iconFeature );
				
				map.getView().setCenter(ol.proj.transform([busStopList[0].lon, busStopList[0].lat], 'EPSG:4326', 'EPSG:3857'));
				
				map.getView().setZoom(15);
				
				$("#mapTitle").text(busStopList[0].busStopName);
				
				open_mapv();
			}
		}) 
	}
	
	function addLine(routeId,routeName){
		
		vectorSource.clear();
		
		$.ajax({
			type : "POST",
			url : "/app/bis/busRoute/selectRoutePosition.json?routeId="+routeId,
			beforeSend : function(xhr){
	            xhr.setRequestHeader("Authorization", "bearer "+aToken);
	        },
			contentType : "application/json;charset=UTF-8",
			dataType : "json",
			success : function(data) {
				var line = data.busRoutePositionList;
				
				var points = [];
				
				var extent = "";
								
				for(var i=0;i<line.length;i++){
					var sectorSeq = line[i].sectorSeq;
					if(!(points[sectorSeq]))points[sectorSeq] = [];
					points[sectorSeq].push(ol.proj.transform([line[i].longitude,line[i].latitude], 'EPSG:4326', 'EPSG:3857'));
				}
				
				
				for(var j=1;j<points.length;j++){
					
					var lineString = new ol.geom.LineString(points[j]);
					//lineString.transform('EPSG:4326', 'EPSG:3857');
					
					var featureLine = new ol.Feature({
					    geometry: lineString
					});
					
					vectorSource.addFeature( featureLine );
					
					//extent = ol.extent.boundingExtent(points[j]);
				}
				
				var lightStroke = new ol.style.Style({
					  stroke: new ol.style.Stroke({
					    color: [255, 0, 0, 0.6],
					    width: 2,
					    lineDash: [4,8],
					    lineDashOffset: 6
					  })
					});
					
					var darkStroke = new ol.style.Style({
					  stroke: new ol.style.Stroke({
					    color: [0, 0, 0, 0.6],
					    width: 2,
					    lineDash: [4,8]
					  })
					});
				
				var vectorLine = new ol.layer.Vector({
					   source: vectorSource,
					   style: [lightStroke, darkStroke]
					});

				map.addLayer(vectorLine);
				
				map.getView().fit(vectorSource.getExtent(), map.getSize());
				
				$("#mapTitle").text(routeName);
				
				open_mapv();
				
			}
		}) 
	}
	
	function searchNearbyBusStop(){
		 if (!!navigator.geolocation){
		    navigator.geolocation.getCurrentPosition(successCallback,errorCallback);  
		  }else{
		    alert("이 브라우저는 Geolocation를 지원하지 않습니다");
		  }
	}
	
	function errorCallback(error){
	    alert("error : "+error.message);
	}    

	function successCallback(position) { 
	        var lat = position.coords.latitude;
	        var lon = position.coords.longitude;
	        
	        //테스트용 좌표
	        lat = 43.094725;
	        lon = 131.941123;
	        //테스트용
	        
	        $.ajax({
				type : "POST",
				url : "/app/bis/busStop/selectBusStopPosition.json?lat="+lat+"&lon="+lon,
				beforeSend : function(xhr){
		            xhr.setRequestHeader("Authorization", "bearer "+aToken);
		        },
				contentType : "application/json;charset=UTF-8",
				dataType : "json",
				success : function(data) {
					vectorSource.clear();
					var busStopList = data.busStopList;
					for(var i=0;i<busStopList.length;i++){
						var iconFeature = new ol.Feature({
						    geometry: new ol.geom.Point(ol.proj.transform([busStopList[i].lon, busStopList[i].lat], 'EPSG:4326', 'EPSG:3857')),
						    name: busStopList[i].busStopName,
						});
						
						var iconStyle = new ol.style.Style({
						    image: new ol.style.Icon(/** @type {olx.style.IconOptions} */({
						        anchor: [0.5, 46],
						        anchorXUnits: 'fraction',
						        anchorYUnits: 'pixels',
						        src: '/resources/images/ic_location.svg'
						    }))
						});
						
						iconFeature.setStyle(iconStyle);
						vectorSource.addFeature( iconFeature );
					}
					
					
					map.getView().setCenter(ol.proj.transform([lon, lat], 'EPSG:4326', 'EPSG:3857'));
					
					map.getView().setZoom(15);
					
					$("#mapTitle").text("<spring:message code='manual_22_5' />");

					
					open_mapv();
					
				}
			}) 
	       
	}
	
	function moveSearchStation(stationName){
		$("#searchBox").val(stationName);
		
		searchEvent();
		
		$("#searchTab>span:nth-child(2)").click();
		
		open_bsrc();
		
		close_bloc();
		
	}
</script>
</html>
