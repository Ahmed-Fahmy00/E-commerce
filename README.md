# E-commerce
This is a java project about an E-commerce shopping program 


src/
├── main/
│   └── ECommerceApp.java
├── controllers/
│   ├── authentication/
│   │   ├── LoginController.java
│   │   ├── SignUpController.java
│   │   └── ForgotPasswordController.java
│   ├── user/
│   │   ├── UserDashboardController.java
│   │   ├── EditProfileController.java
│   │   ├── ChangePasswordController.java
│   │   ├── AddressManagementController.java
│   │   ├── OrderHistoryController.java
│   │   └── OrderDetailsController.java
│   ├── product/
│   │   ├── HomeController.java
│   │   ├── ProductListingController.java
│   │   ├── ProductSearchController.java
│   │   └── ProductDetailsController.java
│   ├── cart/
│   │   ├── ShoppingCartController.java
│   │   └── WishlistController.java
│   ├── checkout/
│   │   ├── ShippingAddressController.java
│   │   ├── PaymentController.java
│   │   ├── OrderReviewController.java
│   │   └── OrderConfirmationController.java
│   ├── admin/
│   │   ├── AdminDashboardController.java
│   │   ├── ManageProductsController.java
│   │   ├── ManageUsersController.java
│   │   ├── ManageOrdersController.java
│   │   └── AnalyticsController.java
│   ├── extras/
│   │   ├── FAQController.java
│   │   ├── ContactUsController.java
│   │   ├── AboutUsController.java
│   │   ├── TermsAndConditionsController.java
│   │   └── PrivacyPolicyController.java
│   └── error/
│       ├── ErrorController.java
│       └── Error404Controller.java
├── pages/
│   ├── authentication/
│   │   ├── LoginPage.java
│   │   ├── SignUpPage.java
│   │   └── ForgotPasswordPage.java
│   ├── user/
│   │   ├── UserDashboardPage.java
│   │   ├── EditProfilePage.java
│   │   ├── ChangePasswordPage.java
│   │   ├── AddressManagementPage.java
│   │   ├── OrderHistoryPage.java
│   │   └── OrderDetailsPage.java
│   ├── product/
│   │   ├── HomePage.java
│   │   ├── ProductListingPage.java
│   │   ├── ProductSearchPage.java
│   │   └── ProductDetailsPage.java
│   ├── cart/
│   │   ├── ShoppingCartPage.java
│   │   └── WishlistPage.java
│   ├── checkout/
│   │   ├── ShippingAddressPage.java
│   │   ├── PaymentPage.java
│   │   ├── OrderReviewPage.java
│   │   └── OrderConfirmationPage.java
│   ├── admin/
│   │   ├── AdminDashboardPage.java
│   │   ├── ManageProductsPage.java
│   │   ├── ManageUsersPage.java
│   │   ├── ManageOrdersPage.java
│   │   └── AnalyticsPage.java
│   ├── extras/
│   │   ├── FAQPage.java
│   │   ├── ContactUsPage.java
│   │   ├── AboutUsPage.java
│   │   ├── TermsAndConditionsPage.java
│   │   └── PrivacyPolicyPage.java
│   └── error/
│       ├── ErrorPage.java
│       └── Error404Page.java
├── models/
│   ├── User.java
│   ├── Product.java
│   ├── ShoppingCart.java
│   ├── Order.java
│   ├── Address.java
│   └── Payment.java
├── utils/
│   ├── DatabaseHelper.java
│   ├── ValidationUtils.java
│   ├── FileHandler.java
│   └── APIClient.java
├── dao/
│   ├── DatabaseConnection.java
│   ├── UserDAO.java
│   ├── ProductDAO.java
│   ├── OrderDAO.java
│   └── CartDAO.java
└── tests/
    ├── LoginControllerTest.java
    ├── ShoppingCartControllerTest.java
    ├── ProductDAOTest.java
    ├── OrderDAOTest.java
    └── ValidationUtilsTest.java
