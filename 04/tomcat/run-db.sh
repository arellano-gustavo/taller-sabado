docker stop curso-db-2
docker rm curso-db-2

docker run -d \
--name curso-db-2 \
--restart unless-stopped \
-p 5555:3306 \
-e MYSQL_ROOT_PASSWORD=gustavo \
mariadb
