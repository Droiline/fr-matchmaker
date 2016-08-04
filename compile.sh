#!/bin/bash

find -name  "*.java" > sources.txt
javac -Xlint:unchecked @sources.txt
