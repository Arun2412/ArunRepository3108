<%@include file="header1.jsp"%> 
<div>
<center><img src="resources/images/arts/art.jpg" style="width:300px;height: 300px"></center>
</div>
<div class="container">
  <div ng-app="myApp" ng-controller="dataCtrl">
Enter Name/Id: <input type="text"  ng-model="search">&nbsp&nbsp<span class="glyphicon glyphicon-search"></span>
    <hr></hr>
    <table class="table table-striped">
    <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Description</th>
    <th>Category</th>
    <th>Price</th>
    </tr>
        <tr ng-repeat="resource in names | filter:search">
            <td>{{resource.id}}</td>
            <td>{{resource.name}}</td>
            <td>{{resource.description}}</td>
            <td>{{resource.category}}</td>
            <td>{{resource.price}}</td>
            <td><img src="resources/images/{{resource.id}}.jpg" style="width:100px; height:100px"></td>
            <td><a href="toDeleteItem?id={{resource.id}}"><span class="glyphicon glyphicon-trash"></span> Delete</a></td>
            <td><a href="toEditItem?id={{resource.id}}"><span class="glyphicon glyphicon-edit"></span> Edit</a></td>
        </tr>    
    </table>
</div>
</div>
<script>
angular.module('myApp',[]).controller('dataCtrl',function($scope)
		{
	
		$scope.names=${allItems};
		$scope.orderByMe=function(x)
		{
			$scope.myOrderBy=x;
			}
		});
</script>
<%@include file="footer.jsp"%> 
