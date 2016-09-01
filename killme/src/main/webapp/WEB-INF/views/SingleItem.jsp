<%@include file="header2.jsp"%>
<div class="container">
  <div ng-app="myApp" ng-controller="dataCtrl">
    <hr></hr>
    <table class="table table-striped">
    <tr>
    <th>Image</th>
    <th>Description</th>
    </tr>
    <td><img src="resources/images/${addItemKey.id}.jpg" style="width:400px; height:400px"></td>
            <td><h3><b>Id:</b>${addItemKey.id}</h3><br><br>
            <b><h3>Name:</b>${addItemKey.name}</h3><br><br>
            <b><h3>Description:</b>${addItemKey.description}</h3><br><br>
            <b><h3>Price:</b>${addItemKey.price}</h3></td>
            <td><h3><a href="toAddToCart?id=${addItemKey.id}">Add To Cart</a></h3></td>
        </tr>    
    </table>
</div>
</div>
<script>
angular.module('myApp',[]).controller('dataCtrl',function($scope)
		{
	
		$scope.names=${addItemKey};
		$scope.orderByMe=function(x)
		{
			$scope.myOrderBy=x;
			}
		});
</script>

<%@include file="footer.jsp" %>