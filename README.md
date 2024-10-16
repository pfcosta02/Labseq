# **LABSEQ Sequence**

REST service, built with **Spring Boot**, returning a value from the labseq sequence, defined as follows:

- `l(0) = 0`
- `l(1) = 1`
- `l(2) = 0`
- `l(3) = 1`
- For `n > 3`, `l(n) = l(n-4) + l(n-3)`


This includes a simple JavaScript-based web GUI is provided for easy interaction with the API.


## Getting Started

### Requirements

- **Java 17** or higher;
- **Maven 3.6+**;
- **Docker** (optional);

## Installation

### 1. Clone the Repository

First, clone the repository to your local machine using Git:

```bash
git clone https://github.com/pfcosta02/Labseq.git
cd labseq
```

### 2. Build the Project

Use Maven to build the project:

```bash
mvn clean package
```

## Running the Application

### 1. Execute the JAR File

```bash
java -jar target/labseq-0.0.1-SNAPSHOT.jar
```

### 2. Verify the Application is Running

Open your browser and navigate to http://localhost:8080. You should see the web GUI interface.

## Running the Application (Using Docker)

### 1. Build the Docker Image

Ensure Docker is installed and running on your system.

```bash
docker build -t labseq .
```

### 2. Run the Docker Container

```bash
docker run -d -p 8080:8080 --name labseq labseq
```

### 3. Verify the Container is Running

```bash
docker ps
```
You should see **labseq** listed among the running containers.

### 4. Access the Application

Open your browser and navigate to http://localhost:8080. You should see the web GUI interface.

### 5. Stopping and Removing the Container

To stop the running container:

```bash
docker stop labseq
```

To remove the container:

```bash
docker rm labseq
```

## Accessing the REST API

### API Endpoint

The Labseq Service exposes the following REST endpoint, as requested:

```bash
GET /labseq/{n}
```

- **n** is the index in the Labseq sequence. Must be a non-negative integer.


#### Example Request (Using Curl)

```bash
curl http://localhost:8080/labseq/10
```

#### Example Response (Using Curl)

```bash
StatusCode        : 200
StatusDescription :
Content           : 3
RawContent        : HTTP/1.1 200
                    Transfer-Encoding: chunked
                    Keep-Alive: timeout=60
                    Connection: keep-alive
                    Content-Type: application/json     
                    Date: Wed, 16 Oct 2024 11:09:18 GMT

                    3 
Forms             : {}
Headers           : {[Transfer-Encoding, chunked], [Keep-Alive, timeout=60], [Connection, keep-alive], [Content-Type, application/json]...}
Images            : {}
InputFields       : {}
Links             : {}
ParsedHtml        : mshtml.HTMLDocumentClass
RawContentLength  : 1
```

### Swagger UI Documentation

REST API documentation is available through Swagger UI.

- You can access it by navigating to http://localhost:8080/swagger-ui.html in your web browser

### Web GUI

A simple JavaScript-based web interface is provided to interact with the Labseq REST API without needing external tools like Postman or Curl.

- You can access it by navigating to http://localhost:8080/index.html in your web browser