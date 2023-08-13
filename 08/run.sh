# docker stop taller-nodejs-example

docker run \
--rm -it \
--name=taller-nodejs-example \
-p3000:3000 \
-w /app \
gustavoarellano/taller-nodejs bash

# inside the container: node server.js
# then, go to: http://localhost:3000





