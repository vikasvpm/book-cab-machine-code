Find cabs for a booking
Problem statement
You have been given a list of trips which the driver and passenger have completed. At the end of the trip, the driver has given a rating to the passenger and the passenger has given a rating to the driver as well. Ratings can be 1 to 5. With 5 being a good rating and 1 being bad rating.
1. Given a passenger name and available drivers based on the historical trips you need to find the eligible cabs for the passenger. Here are the rules for choosing the eligible cabs
   a. The average rating of the cab driver should be equal or higher than the average rating of the passenger.
   b. If there are no matching drivers available for the criteria #1 then you may consider drivers with whom the passenger has rode before but given them rating of more than 1.
2. Given a driver location and a passenger location, sort the eligible drivers (from 1st point) based on their proximity to the passenger or rating
   
   Expected Output:
   Given a passenger name
1. Print average rating of the passenger
2. Print eligible driver names sorted by the average rating
3. Print eligible driver names sorted by the euclidean distance √ ((x2 − x1)^2 + (y2 − y1)^2)
   
   Bonus question:
1. Passenger can choose a preferred cab type (Hatchback, Sedan, SUV) and application
   should respect the preference.
2. Calculate fare for the trip based on cab type, distance and driver rating (Choose your
   own formula)

Sample history ride data

driver  driver-rating passenger passenger-rating
  d1         4           c1           5         
  d1         5           c2           4         
  d1         1           c3           2         
  d1         5           c1           1         
  d1         5           c2           5         
  d1         4           c3           5         
  d1         3           c1           2         
  d1         4           c2           5         
  d1         3           c3           3         

Sample Input:
Available Drivers: (name, x ,y)
d1, 1, 0
d2, 2, 0
d3, 3, 0 d4, 4, 0
Passenger: (name, x, y) c2, 1, 0

Sample Output
Average Rating: 4.67 Eligible Drivers:
D2, 4.67
Eligible Drivers by distance: D2, 2

   Expectations
1. Code should be demo-able (very important), either by using a main driver program or test cases.
2. Create the sample data yourself. You can put it into a file, test case or main driver program itself. Don’t waste time if you’re having trouble reading data from a file, hard code it in the driver/main program.
3. Avoid writing monolithic code.
4. Code should be readable, modular, testable, extensible with proper naming conventions.
   It should be easy to add/remove functionality without rewriting the entire codebase.
5. Code should handle edge cases properly and fail gracefully.
6. Don’t use any database, store all the data in memory.
   
   Guidelines
1. Input can be read from file or can be hard coded/used.
2. Please do not access internet for anything EXCEPT syntax
3. You are free to use the language of your choice.