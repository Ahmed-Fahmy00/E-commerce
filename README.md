## E-commerce
**E-commerce Desktop shopping Application.**
**This is a project for FoE- ASU CSE241.**

# Team
-Ahmed Mohamed fahmy<br>
-Ahmed Mohamed Naguib<br>
-Mohamed Ahmed Beder<br>
-Nour Essam Eldin<br>
-Yousef Amr Said<br>

# Files Structure

src/main/java 
├── main/ 
│ └── ECommerceApp.java 
├── Backend/ 
│ ├── dao/ 
│ │ ├── AdminDAO.java 
│ │ ├── CartDAO.java 
│ │ ├── CategoryDAO.java 
│ │ ├── CustomerDAO.java 
│ │ ├── OrderDAO.java 
│ │ ├── ProductDAO.java 
│ ├── entity/ 
│ │ ├── Admin.java 
│ │ ├── Cart.java 
│ │ ├── Category.java 
│ │ ├── Customer.java 
│ │ ├── Gender.java 
│ │ ├── Order.java 
│ │ ├── PaymentMethod.java 
│ │ ├── Product.java 
│ │ ├── User.java 
│ ├── service/ 
│ │ ├── AdminService.java 
│ │ ├── CartService.java 
│ │ ├── CustomerService.java 
│ │ ├── OrderService.java 
│ │ ├── ProductService.java 
│ │ ├── UserActions.java 
│ │ ├── UserService.java 
├── Database/ 
│ ├── Database.java 
├── test/ 
│ ├── LoginControllerTest.java 
│ ├── ShoppingCartControllerTest.java 
│ ├── ProductDAOTest.java 
│ ├── OrderDAOTest.java 
│ ├── ValidationUtilsTest.java
├── Frontend/ 
│ ├── controllers/ 
│ │ ├── admin/ 
│ │ │ ├── AdminDashboardController.java 
│ │ │ ├── ManageProductsController.java 
│ │ │ ├── ManageUsersController.java 
│ │ │ ├── ManageOrdersController.java 
│ │ ├── authentication/ 
│ │ │ ├── LoginController.java 
│ │ │ ├── SignUpController.java 
│ │ ├── user/ 
│ │ │ ├── UserDashboardController.java 
│ │ │ ├── EditProfileController.java 
│ │ ├── product/ 
│ │ │ ├── HomeController.java 
│ │ │ ├── ProductListingController.java 
│ │ │ ├── ProductSearchController.java 
│ │ │ ├── ProductDetailsController.java 
│ │ ├── cart/ 
│ │ │ ├── ShoppingCartController.java 
│ │ ├── checkout/ 
│ │ │ ├── OrderReviewController.java 
│ │ │ ├── OrderConfirmationController.java 
│ │ │ ├── OrderHistoryController.java 
│ │ │ ├── OrderDetailsController.java 
├── resources/Frontend/ 
│ ├── Images/ 
│ ├── Icons/ 
│ ├── CSS/ 
│ │ ├── Styles.css
│ ├── pages/ 
│ │ ├── admin/ 
│ │ │ ├── ManageProductsPage.java 
│ │ │ ├── ManageUsersPage.java 
│ │ │ ├── ManageOrdersPage.java 
│ │ ├── authentication/ 
│ │ │ ├── LoginPage.java 
│ │ │ ├── SignUpPage.java 
│ │ ├── user/ 
│ │ │ ├── EditProfilePage.java 
│ │ │ ├── OrderHistoryPage.java 
│ │ │ ├── OrderDetailsPage.java 
│ │ ├── product/ 
│ │ │ ├── HomePage.java 
│ │ │ ├── ProductListingPage.java 
│ │ │ ├── ProductSearchPage.java 
│ │ │ ├── ProductDetailsPage.java 
│ │ ├── cart/ 
│ │ │ ├── ShoppingCartPage.java 
│ │ ├── checkout/ 
│ │ │ ├── OrderReviewPage.java 
│ │ │ ├── OrderConfirmationPage.java 
│ │ │ ├── OrderHistoryController.java 
│ │ │ ├── OrderDetailsController.java 
