# CRM API

Implements business logic of CRM system.

## Building

Project uses 'gradle' build tool.

### Runing crm-api service

```
> gradlew run
```

Point your browser at http://localhost:8080/customers

### Distribution build

```
> gradlew distZip
```

You would find distribution package in 'build/distributions'. In order to run the service
you need to unzip the packege and 'cd' into it.

```
> bin/crm-api server config/crm-api-dev.yml
```

## REST API

All data should be sent in JSON (application/vnd.api+json), http://jsonapi.org/

### POST /customers
create new customer

### POST /customers/:id/services
create new service for given customer

### GET /regions
list of available regions

### GET /products
list of available products

## Technology
* Dropwizard (http://dropwizard.codahale.com)
* Gradle (http://www.gradle.org/)
* JSON API (http://jsonapi.org/)
* RAML (http://raml.org)
