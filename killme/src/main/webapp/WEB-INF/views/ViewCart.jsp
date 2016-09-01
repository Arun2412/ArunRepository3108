<%@include file="header2.jsp"%>
<div class="container">
  <div ng-app="myApp" ng-controller="dataCtrl">
Enter Name/Id: <input type="text"  ng-model="search">&nbsp&nbsp<span class="glyphicon glyphicon-search"></span>
    <hr></hr>
    <table class="table table-striped">
    <tr>
    <th>Id</th>
    <th>Image</th>
    <th>Quantity</th>
    <th>Price</th>
    
    </tr>
        <tr ng-repeat="resource in names | filter:search">
            <td>{{resource.cartItemId}}</td>
            <td><img src="resources/images/{{resource.itemId}}.jpg" style="width:100px; height:100px"></td>
            <td>{{resource.quantity}}</td>
            <td>{{resource.totalPrice}}</td>
            <!-- <td>{{resource.}}</td> -->
            <td><a href="deleteCartItem?id={{resource.cartItemId}}"><span class="glyphicon glyphicon-trash"></span> Remove</a></td>
        </tr> 
        <tr>
            <td></td>
            <td></td>
            <td>Grand Total(in Rs.)</td>
            <td>${grandTotal}</td>
            
         </tr>   
    </table>
    <div align="left">
    <a href="CheckCustomer" class="btn btn-default center">Continue Shopping</a>&nbsp;&nbsp;&nbsp;
    <a href="toPlaceOrder" class="btn btn-default center">Place Order</a>
    </div>
</div>
</div>
<script>
angular.module('myApp',[]).controller('dataCtrl',function($scope)
		{
		$scope.names=${CartItemsListKey};
		$scope.orderByMe=function(x)
		{
			$scope.myOrderBy=x;
			}
		});
</script>

<%@include file="footer.jsp"%>