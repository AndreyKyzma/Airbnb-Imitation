<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <%@ page isELIgnored="false" %>
  <link rel="stylesheet" href="../css/bootstrap.min.css">
  <script src="../js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <form action="/user" method="post"  role="form" data-toggle="validator" >
    <c:if test ="${empty action}">
      <c:set var="action" value="add"/>
    </c:if>
    <input type="hidden" id="action" name="action" value="${action}">
    <input type="hidden" id="idUser" name="idUser" value="${user.id}">
    <h2>User</h2>
    <div class="form-group col-xs-4">
      <label for="name" class="control-label col-xs-4">Name:</label>
      <input type="text" name="name" id="name" class="form-control" value="${user.name}" required="true"/>

      <label for="surname" class="control-label col-xs-4">Surname:</label>
      <input type="text" name="surname" id="surname" class="form-control" value="${user.surname}" required="true"/>

      <label for="surname" class="control-label col-xs-4">E-mail:</label>
      <input type="text" name="email" id="email" class="form-control" value="${user.email}" placeholder="smith@aol.com" required="true"/>

      <label for="usertype" class="control-label col-xs-4">User type:</label>
      <input type="text" name="usertype" id="usertype" class="form-control" value="${user.usertype}" required="true"/>

      <br><br>
      <button type="submit" class="btn btn-primary  btn-md">Accept</button>
    </div>
  </form>
</div>
</body>
</html>