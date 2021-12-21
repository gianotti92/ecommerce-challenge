# ecommerce-challenge
backend challenge of an ecommerce with an endpoint of search products


_RequestExample_

`curl --request GET \
--url 'http://localhost:8080/product?startDate=2020-06-14T00%3A00%3A00' \
--cookie JSESSIONID=FA74884DDC572F0C9D913B9C612C094B`

_Response example_

`[
{
"productCode": 35455,
"brandGroupCode": 1,
"rate": 1,
"startDate": "2020-06-14T00:00:00",
"endDate": "2020-12-31T23:59:59",
"finalPrice": 35.5
}
]`