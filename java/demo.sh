#!/bin/bash

case $1 in
    bous)
        java -jar -ea test.jar bous
        ;;
    graphe2)
        java -jar -ea test.jar graphe2
        ;;
    *)
        java -jar -ea test.jar
esac
