#!/bin/bash

case $1 in
    bous)
        java -jar -ea test.jar bous
        ;;
    *)
        java -jar -ea test.jar
esac
