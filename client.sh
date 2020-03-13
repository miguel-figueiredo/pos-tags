#!/bin/bash

text=$1
docker run -i --rm --network pos-tags_default pos-tags-cli -h pos-tags-service -p 8080 -s "$text"