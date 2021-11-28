#!/bin/bash
cd $(dirname "${BASH_SOURCE[0]}")/..
mvn clean
mvn package -Dmaven.test.skip
