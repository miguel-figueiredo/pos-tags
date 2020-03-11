Steps:

mvn io.quarkus:quarkus-maven-plugin:1.2.1.Final:create -DprojectGroupId=com.talkdesk.tdx.nlp -DprojectArtifactId=pos-tags -DclassName="com.talkdesk.tdx.nlp.postags.PosTagsResource" -Dpath=analyze

mvn quarkus:dev

docker run -p 8888:80 --rm --name spacy jgontrum/spacyapi:en_v2

Access UI using: http://localhost:8888/ui

spacy docker API documentation: https://github.com/jgontrum/spacy-api-docker

curl -X POST -d "My name is Miguel" http://localhost:8080/postags

curl -X POST -d '{"text": "My Name is Miguel", "model": "en", "collapse_punctuation": 0, "collapse_phrases": 1}' http://localhost:8888/dep

docker run --rm -p 5432:5432 -v $PWD/pos-tags-db:/docker-entrypoint-initdb.d -e POSTGRES_PASSWORD=postgres  postgres

Build service docker:

cd pos-tags-service
docker build -f src/main/docker/Dockerfile.jvm -t quarkus/pos-tags-service-jvm .

Run services:

docker-compose up

Build client docker:

cd pos-tags-cli
docker build -f src/main/docker/Dockerfile -t pos-tags-cli .

Run client docker:

docker run -i --rm --network pos-tags_default pos-tags-cli -h pos-tags-service -p 8080 -s "My name is Earl"
