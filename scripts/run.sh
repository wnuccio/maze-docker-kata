#!/bin/bash
cd $(dirname "${BASH_SOURCE[0]}")/..
java -jar ./target/maze-docker-kata-1.0-jar-with-dependencies.jar $1
