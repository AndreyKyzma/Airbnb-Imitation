<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <%@ page isELIgnored="false" %>
  <link rel="stylesheet" href="../css/bootstrap.min.css">
  <script src="../js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
  <h2>Users</h2>
  <!--Search Form -->
  <form action="/user" method="get" id="seachUserForm" role="form">
    <input type="hidden" id="searchAction" name="searchAction" value="searchByName">
    <div class="form-group col-xs-5">
      <input type="text" name="userName" id="userName" class="form-control" required="true" placeholder="Type the Name or Last Name of the user"/>
    </div>
    <button type="submit" class="btn btn-info">
      <span class="glyphicon glyphicon-search"></span> Search
    </button>
    <br><br>
    <br><br>
  </form>

  <!--Users List-->
  <c:if test="${not empty message}">
  <div class="alert alert-success">
      ${message}
  </div>
  </c:if>
  <form action="/user" method="post" id="userForm" role="form" >
    <input type="hidden" id="idUser" name="idUser">
    <input type="hidden" id="action" name="action">
    <c:choose>
      <c:when test="${not empty userList}">
        <table  class="table table-striped">
          <thead>
          <tr>
            <td>#</td>
            <td>Name</td>
            <td>Surname</td>
            <td>E-mail</td>
            <td>Usertype</td>
            <td></td>
          </tr>
          </thead>
          <c:forEach var="user" items="${userList}">
            <c:set var="classSucess" value=""/>
            <c:if test ="${idUser == user.id}">
              <c:set var="classSucess" value="info"/>
            </c:if>
            <tr class="${classSucess}">
              <td>
                <a href="/user?idUser=${user.id}&searchAction=searchById">${user.id}</a>
              </td>
              <td>${user.name}</td>
              <td>${user.surname}</td>
              <td>${user.email}</td>
              <td>${user.usertype}</td>
              <td><a href="#" id="remove"
                     onclick="document.getElementById('action').value = 'remove';
                             document.getElementById('idUser').value = '${user.id}';
                             document.getElementById('userForm').submit();">
                <span class="glyphicon glyphicon-trash"/>
              </a>

              </td>
            </tr>
          </c:forEach>
        </table>
      </c:when>
      <c:otherwise>
        <br>
        <div class="alert alert-info">
          No people found matching your search criteria
        </div>
      </c:otherwise>
    </c:choose>
  </form>
  <form action ="jsp/new-user.jsp">
    <br><br>
    <button type="submit" class="btn btn-primary  btn-md">New user</button>
  </form>
</div>
</body>
</html>