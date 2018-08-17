Feature: Perform integrated tests on the Avengers registration API

Background:
* url 'https://7cpsx8lbbf.execute-api.us-east-2.amazonaws.com/dev'



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

