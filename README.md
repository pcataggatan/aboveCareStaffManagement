# Pablo Cataggatan's Individual Project

### Problem Statement

A friend of ours from Arlington Heights, Illinois brought her cousin to our place for a weekend visit and we had a great time reminiscing the past that kept us up past midnight enjoying everyone else's stories. During the course of our conversation, Nirmla "Baby" Palogan asked me about my profession and what made me come to the US. I gave a brief description of what I am curently doing and without hesitation she blurted right away if I could help make her life easier in her care giving business. Providing uniterrupted medical and non-medical srevices to her client base is her utmost goal, but managing her staff assigned to these loyal and expanding clients becomes difficult to carry out as she does the data entries manually in a spreadsheet document.

In order to meet her goals, she wanted a solution that will:
1. store and provide view and/or update access her to clients and staff data easily
2. allow her to quickly find a staff for a potential client
3. provide her financial report showing the margin of profits
4. reduce the overall time taken to search for staff availability when their shedule changes

I would like to create a web application to alleviate my friend's staffing and scheduling burdens. It will allow a user based on log in credentials to view, add, update and delete data from the client and staff database. The screens will be user-friendly and easy to use and the data will be rendered nicely on every report page.  

### Project Technologies/Techniques 

* Security/Authentication
  * Owner role: Maintain Hourly Rate table and view reports with financial information (login required)
  * Scheduler: create/read/update/delete client and staff data and view reports without financial information (login required)
* Database (MySQL and Hibernate)
  * Store Users and roles
  * Store Client data
  * Store Staff data
  * Store Client and Staff Hourly Rate information
  * Store Staff schedule information
* Web Services or APIs
  * Zipcodes API for the list of zipcodes within a specified zipcode and radius
* JSON (independent research topic???) or just CSV results from Zipcodes API
* Logging
  * Configurable logging using Log4J. In production, only errors will normally be logged, but logging at a debug level can be turned on to facilitate trouble-shooting. 
* Site and database hosted on AWS
* Unit Testing
  * JUnit tests to achieve at least 80% code coverage 

### Design
* [Screen Design](DesignDocuments/Screens.md)
* [Application Flow](DesignDocuments/ApplicationFlow.md)
* [Database Design](DesignDocuments/DatabaseDiagram.md)

### [Project Plan](ProjectPlan.md)

### [Time Log](TimeLog.md) 
