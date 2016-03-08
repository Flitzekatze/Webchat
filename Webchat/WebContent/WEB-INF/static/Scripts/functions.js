
// JavaScript Document
$(document).ready(function(){
  // jQuery methods go here...


	var year		= new Date().getFullYear(),
		url			= document.URL,
		root 		= location.protocol+"//"+location.host,
		content 	= $("#content"),
		standardPg 	= "home.jsp"
		loggedIn 	= false;

	$("body").delegate(".dynContentLink","click",function(event){
		location.hash = $(this).attr("href");
		$(window).trigger("hashchange");
		return false;
	});

	$(window).bind("hashchange",function(){
		newHash = location.hash.substring(1);
		$(window).scrollTop(0);
		if(newHash){
			content.load(cp+"/SpringMVCTest/static/Templates/"+newHash+".jsp");	
		}	
	});

	$(window).trigger("hashchange");

   	$('#navigation').load( cp+"/navigation" );
	$('#footer').load(cp+"/footer");
	$('#popupContainer').load(cp+"/popuplogin");
	
	$(window).load(function(){
		for (var count=0; count<=100; count++){
			$("#yearSelect").append(
	        	new Option(year-count, year-count)
	    	);
		}
	});
	
	$("#loginLink").click(function(event) {
		event.preventDefault();
    	$('#popupContainer').show();
		$('body').css("position","fixed");
		$('body').css("overflow-y","scroll");
		$('body').css("width","100%");
	});
	
	$(document.body).on("click", "#loginToggle", function(){
		if($("#login").is(":hidden")){
			$("#login").show();
			$("#signup").hide();
			$("#loginToggle").removeClass("inactiveBtn");
			$("#signupToggle").addClass("inactiveBtn");
		}
	});
	
	$(document.body).on("click", "#signupToggle", function(){
		if(!$("#signup").is(":visible")){
			$("#signup").show();
			$("#login").hide();
			$("#loginToggle").addClass("inactiveBtn");
			$("#signupToggle").removeClass("inactiveBtn");
		}
	});
	
	$(document.body).on("click", "#popupContainer", function(){
		event.stopPropagation();
		$('#popupContainer').hide();
		$('body').css("position","static");
	});
	
	$(window).keydown(function(event){
		if(event.keyCode === 27){
			$('#popupContainer').hide();
			$('body').css("position","static");
		}
	});
	
	$("body").delegate("#popupLogin, #popupContainer","DOMmousescroll mousewheel click", function(event){
		event.stopPropagation();
	});
	
	$(document.body).on("click", "#account", function(){
		$('#accLink')[0].click();
	});
	
	$("#settings").click(function(){
		var h = $("#drdwSettings").height() == 0 ? 450 : 0;
		$("#drdwSettings").height(h);
	});
	
//	$("#yearSelect")
});