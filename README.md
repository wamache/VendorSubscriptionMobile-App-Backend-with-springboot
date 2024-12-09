# VendorSubscriptionMobile-App-Backend-with-springboot
The Mobile app allows vendors to register their businesses

localhost:8080/api/auth/vendors

{
  "name": "Blesira john",
  "email": "newndtgro@example.com",
  "password": "password123",
  "phoneNumber": "+254702385716"
}

localhost:8080/api/auth/businesses

{
  "address": "123 Maihn usts",
  "contactInfo": "12364-456-7291",
  "name": "Techs Soloutionso",
  "vendorId": 8
}

localhost:8080/api/auth/branches

{
    "businessId": 4,
    "name": "New Branch",
    "address": "123 Main Street",
    "contactInfo": "123-456-7890"
}

localhost:8080/api/auth/subscriptions

{
  "plan": "pro"
}

localhost:8080/api/auth/api/auth/payments

{
  "vendorId": 7,
  "amount":410.52,
  "paymentMethod":"mpesa"
}
