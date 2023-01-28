docker stop taller

docker run --rm -d -p7766:80 \
-v /home/ubuntu/TALLER/bolsa:/usr/share/nginx/html \
--name=taller nginx

