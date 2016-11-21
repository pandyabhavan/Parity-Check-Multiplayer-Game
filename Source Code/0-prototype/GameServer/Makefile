
all: clean compile 

clean:
	rm -rf build/*
	rm -f dist/app.jar
	find . -name "*.class" -exec rm -rf {} \;

app: compile
	cd build ; jar -cvfe ../dist/app.jar gameserver .

test: compile app
	java -cp dist/*.jar api.gameserver

compile: 
	javac -cp dist/restlet.jar:dist/restlet-json.jar:dist/json.jar -d build \
	src/gameserver/*.java \
	clients/loadtestclient/*.java \
	src/api/*.java

run:
	echo Starting Service at:  http://localhost:8080
	java -cp build:dist/restlet.jar:dist/restlet-json.jar:dist/json.jar api.gameserver

loadtest:
	echo Starting Load Test on localhost
	java -cp build:dist/restlet.jar:dist/restlet-json.jar:dist/json.jar RunLoadTest 5

docker-build: app
	docker build -t gameserver .
	docker images

docker-clean:
	docker stop gameserver
	docker rm gameserver
	docker rmi gameserver

docker-run:
	docker run --name gameserver -td gameserver
	docker ps

docker-run-host:
	docker run --name gameserver -td --net=host gameserver
	docker ps

docker-run-bridge:
	docker run --name gameserver -td -p 80:8080 gameserver
	docker ps

docker-network:
	docker network inspect host
	docker network inspect bridge

docker-stop:
	docker stop gameserver
	docker rm gameserver

docker-shell:
	docker exec -it gameserver bash 
	
