<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script> -->
  <script>
 
	$(document).ready(function() {
		$(document).ready(function() {
			$('.js-example-basic-single').select2();
		});
		 
	});
	function showUserDrapDown(){
		  $(".users").show();
	}
	function bigImg() {
		alert($(this).val())
		 $(".admin").show();
		}
	function showDrapDown(){
		  $(".admin").show();
	  }
	function hidedropdown(){
		  /* $(".admin").hide(); */
	  }
</script>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">User Registartion</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="${pageContext.request.contextPath }/">Register</a></li>
      <li asdf="sdfhdsa"  class="dropdown"><a onclick="showDrapDown()" onmouseover="bigImg()"  onmouseout="hidedropdown()" id="showDrapDown" class="dropdown-toggle" data-toggle="dropdown" href="#">Admin <span class="caret"></span></a>
        <ul class="dropdown-menu admin" >
          <li><a href="${pageContext.request.contextPath}/users">Show All Users</a></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>
      </li>
      <li><a href="#">Page 2</a></li>
        <li class="dropdown"><a onclick="showUserDrapDown()"  class="dropdown-toggle" data-toggle="dropdown" href="#">User <span class="caret"></span></a>
        <ul class="dropdown-menu users" >
          <li><form:form action="${pageContext.request.contextPath }/logout" method="POST">
      <a  href="#">  <input style="width: 158px; height: 44px;margin-top: -4px;margin-bottom: -3px;" class="btn btn-success" type="submit" value="LOGOUT"></a>
      </form:form >
      </li>
         </ul>
    
       
   
  </div>
</nav>
</body>
</html>