
all: clean compile 

clean:
	rm -rf build/*
	rm -f dist/app.jar
	find . -name "*.class" -exec rm -rf {} \;

app: compile
	cd build ; jar -cvfe ../dist/app.jar GameServer .

test: compile app
	java -cp dist/restlet.jar:dist/restlet-json.jar:dist/json.jar:dist/app.jar api.GameServer

compile: 
	javac -cp dist/restlet.jar:dist/restlet-json.jar:dist/json.jar -d build \
	src/gameServer/*.java \
	src/api/*.java

run:
	echo Starting Service at:  http://localhost:8080
	java -cp build:dist/restlet.jar:dist/restlet-json.jar:dist/json.jar api.GameServer

loadtest:
	echo Starting Load Test on localhost
	java -cp build:dist/restlet.jar:dist/restlet-json.jar:dist/json.jar RunLoadTest 5

docker-build: app
	docker build -t server .
	docker images

docker-clean:
	docker stop server
	docker rm server
	docker rmi server

docker-run:
	docker run --name server -td server
	docker ps

docker-run-host:
	docker run --name server -td --net=host server
	docker ps

docker-run-bridge:
	docker run --name server -td -p 80:8080 server
	docker ps

docker-network:
	docker network inspect host
	docker network inspect bridge

docker-stop:
	docker stop server
	docker rm server

docker-shell:
	docker exec -it server bash 
	
