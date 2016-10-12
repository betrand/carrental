# README #

Run the CarRental.jar from the commandline ensuring port 8888 is free
Once the server starts
Use this URI to access the api

[protocol]://[host]:8888/CarRental/api/CarRental/calculateTotalExpense e.g.
http://localhost:8888/CarRental/api/CarRental/calculateTotalExpense

### What is this repository for? ###

* Version 1.0.0

#Car rental application – one of the feature problem statement
 
A vehicle can be rented for a trip. Vehicle can be a SUV, car, van, bus, etc.
The standard rate for a petrol vehicle for a standard trip is 15 Rs/Km. Additional 2 Rs/Km charge is applicable for AC vehicles. Diesel vehicles cost a rupee less than standard rate.
2% discount is applicable for bus on standard rate.
Additional charges of 1 Rs/Km/Person are charged if number of passengers exceeds the max limit of a vehicle.
Example distance:
                        Pune - Mumbai: 200 KM
                        Pune - Bangalore: 1000 KM
                        Mumbai - Delhi: 2050 KM
                        Mumbai - Chennai: 1234.5 KM
In this big car rental application you are tasked to develop an API which calculates the total expense for a given trip. Do not use any property file to store the values mentioned above. Instead think in terms of injectable interfaces to provide the information assuming members of your team will be responsible to develop the same. You develop a default implementation for the same where data is hard coded. Actual implementation of those may pull data from database, file or http service.
Example trip:    Swift, Diesel, NON AC, Pune-Mumbai-Bangalore-Pune, 3 Passengers


### How do I get set up? ###

* Summary of set up
* Configuration - None Required
* Dependencies - Autofetched and bundled with Maven
* Database configuration - None required - in memory storage is used
* How to run tests - 
* Deployment instructions - None required this is a plain core Java project. Running the main class starts the server

### For more information ###

* Contact Repo owner or admin at betrand_ugorji@yahoo.co.uk