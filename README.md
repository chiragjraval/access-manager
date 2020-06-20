# access-manager
This is a sample application demonstrating how to implement Role based authentication.

System defines 5 entity classes User, Role, Resource, ActionType, Environment
  - A User can have multiple roles
  - A Role can have multiple allowed actions per Environment
  - A Resource is attached to a belongs to a particular Environment

# Assumptions
  - System will provide CLI for grant, revoke and verify operation for roles over a user. CommandExecutor interface is defined and implemented as GrantCommandExecutor, RevokeCommandExecutor and VerifyCommandExecutor.
  - ExitCommandExecutor and InvalidCommandExecutor are implemented to handle special scenarios
  - System will support CRUD operations on User, Role and Resource entities. DAOs are implemented for same. (CRUD operations are not exposed through CLI). Please check UserDao, RoleDao and ResourceDao.
  
# Supported Commands
  - grant -user <userId> -role <roleId1> -role <roleId2>...
  - revoke -user <userId> -role <roleId1> -role <roleId2>...
  - verify -user <userId> -actiontype <actionType> -resource <resourceId>

For demonstration purpose some of the data points are built-in the system.
Below Data points are defined in DaoConstants class and are loaded in memory by individual constructors of UserDao, RoleDao and ResourceDao to simulate data storage access.

# Users
  - chirag
  - lucas

# Roles
  - member
    - Environment.DEV (READ, ADD, WRITE, DELETE)
    - Environment.QA (READ)
    - Environment.PROD (No Actions Allowed)
  - mgr
    - Environment.DEV (READ, ADD, WRITE, DELETE)
    - Environment.QA (READ, ADD, WRITE)
    - Environment.PROD (READ)
  - admin
    - Environment.DEV (READ, ADD, WRITE, DELETE)
    - Environment.QA (READ, ADD, WRITE, DELETE)
    - Environment.PROD (READ, ADD, WRITE, DELETE)
 
# Resources
  - lucasDevDb (Environment.DEV)
  - lucasQaDb (Environment.QA)
  - lucasProdDb (Environment.PROD)

# Sample execution
```bash
mvn clean package
java -jar .\target\access-manager-0.0.1-SNAPSHOT-jar-with-dependencies.jar                                                               

$help
usage: grant
 -role,--role <arg>   <Role ID>
 -user,--user <arg>   <User ID>
usage: revoke
 -role,--role <arg>   <Role ID>
 -user,--user <arg>   <User ID>
usage: verify
 -actiontype,--actiontype <arg>   <Action Type>
 -resource,--resource <arg>       <Resource ID>
 -user,--user <arg>               <User ID>

$verify -user chirag -actiontype WRITE -resource lucasDevDb
User chirag cannot take WRITE action on resource lucasDevDb

$verify -user chirag -actiontype WRITE -resource lucasQaDb
User chirag cannot take WRITE action on resource lucasQaDb

$grant -user chirag -role member -role mgr
Roles [member, mgr] granted to chirag

$verify -user chirag -actiontype WRITE -resource lucasDevDb
User chirag can take WRITE action on resource lucasDevDb

$verify -user chirag -actiontype WRITE -resource lucasQaDb
User chirag can take WRITE action on resource lucasQaDb

$revoke -user chirag -role mgr
Roles [mgr] revoked for chirag

$verify -user chirag -actiontype WRITE -resource lucasDevDb
User chirag can take WRITE action on resource lucasDevDb

$verify -user chirag -actiontype WRITE -resource lucasQaDb
User chirag cannot take WRITE action on resource lucasQaDb

$exit
Exit requested
```