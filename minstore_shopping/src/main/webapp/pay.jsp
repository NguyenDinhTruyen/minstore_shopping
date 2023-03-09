<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
  <head>
    <script
      src="https://checkout.stripe.com/checkout.js"
      class="stripe-button"
      data-key="pk_test_your_public_key"
      data-amount="2000"
      data-name="My Example Store"
      data-description="Example charge"
      data-image="https://stripe.com/img/documentation/checkout/marketplace.png"
      data-locale="auto"
      data-zip-code="true"
    >
    </script>
  </head>
  <body>
    <h1>Accept Payments with HTML and JavaScript</h1>
    <p>Click the button below to make a payment:</p>
  </body>
</html>