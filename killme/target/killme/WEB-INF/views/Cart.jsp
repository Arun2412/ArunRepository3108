<%@include file="header2.jsp"%>
<div class="container">
  <div ng-app="myApp" ng-controller="dataCtrl">
Enter Name/Id: <input type="text"  ng-model="search">&nbsp&nbsp<span class="glyphicon glyphicon-search"></span>
    <hr></hr>
    <table class="table table-striped">
    <tr>
    <th>Id</th>
    <th>Name</th>
    <td>Description</td>
    <th>Price</th>
    <th>Image</th>
    </tr>
            <td>${CartItemsKey.id}</td>
            <td>${CartItemsKey.name}</td>
            <td>${CartItemsKey.description}</td>
            <td>${CartItemsKey.price}</td>
            <td><img src="resources/images/${CartItemsKey.id}.jpg" style="width:100px; height:100px"></td>
            
        </tr>    
    </table>
</div>
</div>
<script>
var cartApp = angular.module ("addToCartApp", []);

cartApp.controller("addToCartCtrl", function ($scope, $http){
	
	 /*
     * retrieveCart method is used to get all cart items at the starting of the application
     */
    $scope.retrieveCart = function (cartId) {
		 alert('inside retrieve cart');
        $scope.cartId = cartId;
        $scope.refreshCartItems(cartId);
    };
    
    $scope.showAlert = function () {
        alert("This is an example of ng-click");
    }
    
    
    /*
     * removeItemFromCart method is used to remove a item from the cart
     */
    $scope.removeItemFromCart = function (itemId) {
    	alert('inside remove method'+itemId);
        $http.put('http://localhost:8760/ekart/usercart/cart/removeItem/'+itemId).success(function (data) {
        	alert('pls refresh now');
            $scope.refreshCartItems();
        });
    };

	 /*
     * addItemToCart method is used to add items into the cart
     */
    $scope.addItemToCart = function (itemId) {
    	 alert("test");
        $http.put('http://localhost:8760/ekart/usercart/cart/addItem/'+itemId).success(function () {
            alert("Item added to the cart!")
        });
    };
   
   
    /*
     * GrandTotalOfItems method is called on cart page to calculate grand total for the added items
     */
    $scope.GrandTotalOfItems = function () {
        var grandTotal=0;

        for (var i=0; i<$scope.cart.cartItems.length; i++) {
            grandTotal+=$scope.cart.cartItems[i].totalPrice;
       }

        return grandTotal;
    };
    /*
	 * refreshCartItems method is called by others methods in same controller to refresh the cart
	 */
    $scope.refreshCartItems = function () {
    	alert("inside refresh cart items");
        $http.get('http://localhost:8760/ekart/usercart/cart/refreshCart/'+$scope.cartId).success(function (data) {
           $scope.cart=data;
        });
    };
    /*
     * clearCartItems method is used to delete all items from the cart
     */
    $scope.clearCartItems = function () {
    	$http['delete']('http://localhost:8760/ekart/usercart/cart/clearCartItems/'+$scope.cartId).success(function (data) {$scope.refreshCartItems()});
    };
});
</script>
</script>

<%@include file="footer.jsp" %>