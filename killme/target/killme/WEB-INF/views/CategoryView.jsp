<%@include file="header2.jsp"%>
<div class="container">
  <div ng-app="myApp" ng-controller="dataCtrl">
Enter Name/Id: <input type="text"  ng-model="search">&nbsp&nbsp<span class="glyphicon glyphicon-search"></span>
    <hr></hr>
    <table class="table table-striped">
    <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Description</th>
    <th>Price</th>
    <th>Image</th>
    </tr>
        <tr ng-repeat="resource in names | filter:search">
            <td>{{resource.id}}</td>
            <td>{{resource.name}}</td>
            <td>{{resource.description}}</td>
            <td>{{resource.price}}</td>
            <td><img src="resources/images/{{resource.id}}.jpg" style="width:100px; height:100px"></td>
            <td><a href="viewSingleItem?id={{resource.id}}">View Product Details</a></td>
        </tr>    
    </table>
</div>
</div>
<script>
angular.module('myApp',[]).controller('dataCtrl',function($scope)
		{
	
		$scope.names=${CategoryKey};
		$scope.orderByMe=function(x)
		{
			$scope.myOrderBy=x;
			}
		});
</script>

<%@include file="footer.jsp"%>