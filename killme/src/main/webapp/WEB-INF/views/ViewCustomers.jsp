<%@include file="header1.jsp" %>  
<script>document.write('<base href="' + document.location + '" />');</script>
<div>   
<center><img src="resources/images/arts/art.jpg" style="width:300px;height: 300px"></center>
</div>
<div>
<div class="container">
  <div ng-app="myApp" ng-controller="dataCtrl">
Enter Name/Email ID: <input type="text"  ng-model="search">&nbsp&nbsp<span class="glyphicon glyphicon-search"></span>
    <hr></hr>
    <table class="table table-striped">
    <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Mobile</th>
    <th>Email</th>
    </tr>
        <tr ng-repeat="resource in names | filter:search">
             <td>{{resource.id}}</td>
            <td>{{ resource.name}}</td>
            <td>{{ resource.mobile}}</td>
            <td>{{ resource.email}}</td>
            <td><a href="deleteCustomer?id={{resource.id}}">Delete</a></td>
        </tr>    
    </table>
</div>
</div>
<script>
angular.module('myApp',[]).controller('dataCtrl',function($scope)
		{
	
		$scope.names=${allCustomers};
		$scope.orderByMe=function(x)
		{
			$scope.myOrderBy=x;
			}
		});
</script>
<%@include file="footer.jsp" %>
