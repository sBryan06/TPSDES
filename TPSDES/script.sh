#!/bin/bash

javac ./src/*.java -d bins/ -nowarn

cd bins

java Main
