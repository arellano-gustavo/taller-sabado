docker stop dockerized-register-artemisa-srv
docker rm dockerized-register-artemisa-srv

docker pull ghcr.io/qbits-mx/dockerized-register-artemisa

docker run -d \
--name=dockerized-register-artemisa-srv \
--restart=unless-stopped \
-p7770:9998 \
ghcr.io/qbits-mx/dockerized-register-artemisa
