<%@include file="taglib.jsp"%>

<div class="col-md-2 text-left"></div>
<div class="col-md-6 text-left">
    <c:choose>
    <c:when test="${loggedIn == 'Yes'}">
      <br><h1 style="text-align:center; color: #344F8C">Providing Quality Care For Men & Women</h1><br>

      <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
            <li data-target="#myCarousel" data-slide-to="3"></li>
            <li data-target="#myCarousel" data-slide-to="4"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner">

            <div class="item active">
                <img src="images/caregiver01_680_380.jpg" alt="Loving" style="height:50%; width:100%;">
                <div class="carousel-caption">
                    <h1>Caring</h1>
                </div>
            </div>

            <div class="item">
                <img src="images/caregiver07_680_380.jpg" alt="Loving" style="height:50%; width:100%;">
                <div class="carousel-caption">
                    <h1>Loving</h1>
                </div>
            </div>

            <div class="item">
                <img src="images/caregiver06_680_380.jpg" alt="Passionate" style="height:50%; width:100%;">
                <div class="carousel-caption">
                    <h1>Passionate</h1>
                </div>
            </div>

            <div class="item">
                <img src="images/caregiver04_680_380.jpg" alt="Kind Hearted" style="height:50%; width:100%;">
                <div class="carousel-caption">
                    <h1>Kind Hearted</h1>
                </div>
            </div>

            <div class="item">
                <img src="images/caregiver09_680_380.jpg" alt="Dedicated" style="height:50%; width:100%;">
                <div class="carousel-caption">
                    <h1>Dedicated</h1>
                </div>
            </div>
        </div>

        <!-- Left and right controls -->
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
            <span class="sr-only">Next</span>
        </a>
      </div>

    </c:when>

    <c:otherwise>
      <br><h1 style="text-align:center; color: #344F8C">Welcome to Above Care Staffing Agency</h1><br>
      <p style="text-align:center;"><img src="images/familypic_680_380.jpg" alt="Family" style="height:50%; width:100%;"></p>
    </c:otherwise>
  </c:choose>

</div>
<div class="col-md-2 text-left"></div>
