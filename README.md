Movie REST API and test coverage instructions.
** MovieInitializer.class is used for the seed data, It automatically runs while loading the application in container.

Below are the REST APIs for movie application.
-----------------------------------------------
1. save movie
	
	url:localhost:8080/movie/add
	header: key:Content-Type
			value: application/json
	body: 
	{
	    "id": 7,
	    "name": "KGF",
	    "year": 2019,
	    "rating": 5
	}

2. update movie year and ratings by name.
	
	url: localhost:8080/movie/update
	header: key:Content-Type
			value: application/json
	body: (body should be in json format like below. change the year and rating to reflect it in db)
	{
        "id": 4,
        "name": "Raid",
        "year": 2015,
        "rating": 4.5
    }

3. Fetch all movies
	
	url: localhost:8080/movie/getall

4. Fetch movie based on year
	
	url: localhost:8080/movie/byyear/2020

5. Fetch movie based on ratings
	
	url:localhost:8080/movie/byratings/4

6. This application is running based on JUnit 4.x
so while running test cases, you need to change test runner to 'JUnit4'
project > coverage as > coverage configurations > test runner > junit4