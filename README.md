# Demo Project

## Caching app for [PositionStack](https://positionstack.com/)

# API:

After launching, the documentation will be available at http://localhost:300/swagger-ui.html

# To start with Docker:

Environment variables to start with Docker:
> ACCESS_KEY inside of docker-compose.yml. Must be filled with your PositionStack access key.

```sh
git clone https://github.com/tre3p/ktSampleGeoCache geoCache
cd geoCache
docker-compose up
```

App will be launched at 3000 port.

# To start local:

Environment variables to start local:
> ACCESS_KEY must be filled with your PositionStack access key.

> REDIS_HOST if your redis hosted on another server. Default: localhost

> REDIS_PORT if your redis started with another port. Default: 6379

> PORT if you want to start app on another port. Default: 3000

```sh
redis-server
git clone https://github.com/tre3p/ktSampleGeoCache geoCache
cd geoCache
make start
```
