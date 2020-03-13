# Build

## Java Build

```
docker-compose up -d spacy
mvn clean install
```

## Client Docker Build

```
cd pos-tags-cli
docker build -f src/main/docker/Dockerfile -t pos-tags-cli .
cd -
```

# Run

## Run Server

```
docker-compose up -d
```

## Run Client

```
./client.sh "My name is Earl"
```

# Notes

## Quarkus

```
mvn io.quarkus:quarkus-maven-plugin:1.2.1.Final:create -DprojectGroupId=com.talkdesk.tdx.nlp -DprojectArtifactId=pos-tags -DclassName="com.talkdesk.tdx.nlp.postags.PosTagsResource" -Dpath=analyze
mvn quarkus:dev
```

## spaCy

```
docker run -p 8888:80 --rm --name spacy jgontrum/spacyapi:en_v2
```

### Access UI

http://localhost:8888/ui

### spaCy docker API documentation
 
https://github.com/jgontrum/spacy-api-docker

## HTTP Requests

```
curl -X POST -d "My name is Earl" --header 'Content-Type: text/plain' http://localhost:8080/postags
curl -X POST -d '{"text": "My Name is Earl", "model": "en", "collapse_punctuation": 0, "collapse_phrases": 1}' http://localhost:8888/dep
```

