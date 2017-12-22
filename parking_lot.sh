#!/bin/sh
echo Start of execution..
# maven clean project
mvn clean

# maven build project

mvn install

# maven execute project

if [ $1 == '']
then
	mvn exec:java -D"exec.mainClass"="com.parkingapp.service.ParkingLotApp"
else

	mvn exec:java -D"exec.mainClass"="com.parkingapp.service.ParkingLotApp" -Dexec.args="$1"
fi
