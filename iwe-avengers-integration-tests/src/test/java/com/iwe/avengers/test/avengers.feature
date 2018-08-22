Feature: Perform integrated tests on the Avengers registration API

Background:
* url 'https://7cpsx8lbbf.execute-api.us-east-2.amazonaws.com/dev'


Scenario: Should return unathorized access

Given path 'avengers', 'anyid'
When method get
Then status 401

Scenario: Registry a new Avenger

Given path 'avengers'
And request {name: 'Captain America' ,  secretIdentity: 'Steve Rogers'}
When method post
Then status 201
And match response == {id: '#string' , name: 'Captain America', secretIdentity: 'Steve Rogers'}

* def savedAvenger = response

#get Avenger by id
Given path 'avengers', savedAvenger.id
When method get
Then status 200
And match $ == savedAvenger



Scenario: Atualizando Avenger

Given path 'avengers', 'sdsa-sasa-asas-sasa'
And request {name: 'Captain America' ,  secretIdentity: 'Steve Rogers'}
When method put
Then status 200

Scenario: Register Avenger with 

Given path 'avengers'
And request {secretIdentity: 'Steve Rogers'}
When method post
Then status 400

Scenario: Register Avenger with invalid payload

Given path 'avengers', 'sdsa-sasa-asas-sasa'
And request {secretIdentity: 'Steve Rogers'}
When method put
Then status 400






Scenario: Delete Dynamic

#Create a new Avenger
Given path 'avengers'
And request {name: 'Hulk' , secretIdentity: 'Bruce Banner'}
When method post
Then status 201

* def avengerToDelete = response

#Delete the Avenger
Given path 'avengers', avengerToDelete.id
When method delete
Then status 204

#Search deleted Avenger
Given path 'avengers', avengerToDelete.id
When method get
Then status 404





Scenario: Updates the Avenger data

#create a new Avenger
Given path 'avengers'
And request {name: 'Captain', secretIdentity: 'Steve Rogers'}
When method post
Then status 201

* def avengerToUpdate = response

Given path 'avengers', avengerToUpdate.id
And request {name: 'Captain America', secretIdentity: 'Steve Rogers'}
When method put 
Then status 200
And match $.id == avengerToUpdate.id
And match $.name == 'Captain America'
And match $.secretIdentity == 'Steve Rogers'









