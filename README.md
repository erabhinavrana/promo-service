
# promo-service

This service is to manage the promotions for the online book store application.

## API Reference

#### Get Promo Details

```http
  GET /api/v1/promos/${code}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `code`      | `string` | **Required**. promoCode of Promo to fetch |

#### getPromoDetails(code)

Takes promo code and returns the available Promo Details.

#### Sample JSON Response for Promo Service

```
{
    "id": 111,
    "promoCode": "FICTION10",
    "promoType": "FICTION",
    "promoValue": 10.0,
    "maxDiscount": 100.0,
    "expiry": "2022-04-01T20:00:00.000+00:00"
}
```
## Documentation

| Service Name |  link |
| :-------- | :------- | 
| `promo-service`      | [swagger-ui](http://localhost:8000/swagger-ui/index.html) |



## Run Locally

Clone the project

```bash
  git clone https://github.com/erabhinavrana/promo-service
```

Go to the project directory

```bash
  cd promo-service
```

Start the server

```bash
  ./mvnw spring-boot:run
```


## Appendix

Docker Image: abhinavrana/bsv1-promo-service:0.0.1-SNAPSHOT

