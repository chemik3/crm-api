# CRM API

Implements business logic of CRM system.

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
* Java Servlet, Jersey (https://jersey.java.net/), Jacson (http://jackson.codehaus.org/)
* Maven (http://maven.apache.org/) or Gradle (http://www.gradle.org/)
* JSON API (http://jsonapi.org/)
* RAML (http://raml.org)
