<%@include file="taglib.jsp"%>

<div class="col-md-10 text-left">
  <br>
  <c:choose>
    <c:when test="${loggedIn == 'Yes'}">
        <h1 style="text-align:center;">Providing Quality Care For Men And Women</h1><br>
        <p style="text-align:center;"><img src="images/asiancaregiver02_680_380.jpg" class="post-img" alt="StaffPic"></p>
    </c:when>
    <c:otherwise>
        <h1 style="text-align:center;">Welcome to Above Care Staffing Agency!</h1><br>
        <p style="text-align:center;"><img src="images/familypic_680_380.jpg" class="post-img" alt="Family"></p>
    </c:otherwise>
  </c:choose>
  <br>
</div>
