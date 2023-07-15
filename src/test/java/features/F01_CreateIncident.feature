Feature: Create Incident

@issue=AAT-32
@tmsLink=AAT-36
@severity=minor
Scenario: TC001_Creating an incident with valid credentials

Given create body using "createIncident.json" data file
When Hit the request with POST method.
Then The status code should be 201
And and the response time should be less than a seconds.


@known
@severity=minor
@issue=AAT-32
@tmsLink=AAT-36
Scenario: TC002_Creating an incident with invalid credentials

Given create body using "createIncident.json" data file
When Hit the request with POST method.
Then The status code should be 401
And and the response time should be less than a seconds.