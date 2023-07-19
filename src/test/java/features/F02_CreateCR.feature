Feature: Create a ServiceNow Incident

@smoke
Scenario Outline: TC001_Creating a change request with valid credentials

Given create body by passing data <BodyData> as String 
When Hit the request with POST method.
Then The status code should be 201

Examples:
|BodyData|
|'{"type":"emergency","priority":"1","assignment_group":"d625dccec0a8016700a222a0f7900d06"}'|
