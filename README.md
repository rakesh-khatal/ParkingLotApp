# ParkingLotApp

Installation:

 Check out a clone of this repo to a location of your choice using below command
	git clone https://github.com/rakesh-khatal/ParkingLotApp.git;

Pre-requisite:

	JDK and Maven must be installed along with JAVA_HOME and MAVEN_HOME environment variable setup.

Execution:
		 
	1. Interactive command prompt based shell
	
		Enter below shell script name from root directory of application and press enter to execute shell script.
			./parking_lot.sh
			
		Shell script will execute all the commands(mavane clean,build and exec). After buiild success it will give message on console as "Please enter input command",
			then enter valid commands and after command execution it will print desired output in console.
		If you enter wrong command it will give error message as "Please enter valid command".
		
		To exit from the application enter "quit" command and press enter.
		Below are the valid commands-
		
			create_parking_lot
			park
			leave
			status
			registration_numbers_for_cars_with_colour
			slot_numbers_for_cars_with_colour
			slot_number_for_registration_number
		 
	2. Filename as a parameter at the command prompt and read the commands from that file.
	
		Enter below command which is in format as <shell script name><space><input file.txt> and press enter to execute the shell script.
			./parking_lot.sh file_inputs.txt
			
		Give filename(eg. file_input.txt) as input parameter in command prompt after the shell script name. 
		Shell script will read the input line by line from that file and execute all the commands(mavane clean,build and exec)
		 and print desired output in console.
		  