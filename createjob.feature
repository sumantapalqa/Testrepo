Feature: Create Job Request as a Helper file

  # Add a record as a Helper feature file
  Scenario: Add a request in the application as a Helper so that other can call this feature file
    Given url 'http://localhost:9897'
    And path '/normal/webapi/add'
    # Random value generator for job id. Random value is a Javascript function
    * def getrandomvalue = function() {return Math.floor((100)* Math.random());}
    * def id = getrandomvalue()
    And request {"jobId":'#(id)',"jobTitle":"Program Manager","jobDescription":"Project Coordination","experience":["Project Management","VFX","Upscale"],"project":[{"projectName":"Managment basic App","technology":["Full stack","SQL","Excel"]}]}
    And headers {Accept: 'application/json' , Content-Type: 'application/json'}
    When method POST
    Then status 201
