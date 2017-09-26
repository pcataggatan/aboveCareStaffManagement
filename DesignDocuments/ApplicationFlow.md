# Application Flow

### User Log In
1. User selects a role (Owner or Scheduler) and enter username and password on form and submits. 
1. If authentication succeeds, user lands to a designated home page
1. If authentication fails, show error message/page and allow user to try again.

### Client List (user = Owner)
1. Owner clicks link from the side bar sneding request to Client List servlet 
1. Client List servlet forwards the request to searh client JSP to display form for search term and type
1. Owner fills out form fields and submit, sending request to a Search Client servlet  
1. Search Client servlet uses Client Dao to select clients based on search criteria
1. Dao performs select and creates results matching the criteria
1. Search Client servlet forwards request to client list JSP to display the results (includes financial info) 

### Staff List (user = Owner)
1. Similar flow to Client List, but uses Staff Dao

### Potential client for staff (user = Owner)
1. Similar flow to Client List, but uses RateCode Dao
1. Servlet calls zipcodes api to get the list of zipcodes within a specified zipcode and radius

### Rate Code Maintenance (user = Owner)
1. Similar flow to Client List, but uses RateCode Dao


### Client List (user = Scheduler)
1. Scheduler clicks link from the side bar sneding request to Client List servlet 
1. Client List servlet forwards the request to searh client JSP to display form for search term and type
1. Scheduler fills out form fields and submit, sending request to a Search Client servlet  
1. Search Client servlet uses Client Dao to select clients based on search criteria
1. Dao performs select and creates results matching the criteria  
1. Search Client servlet forwards request to client list JSP to display the results (financial info not shown) 

### Staff List (user = Scheduler)
1. Similar flow to Client List, but uses Staff Dao

### Add or update Client (user = Scheduler)
1. Similar flow to Client List, but uses Client Dao

### Add or update Staff (user = Scheduler)
1. Similar flow to Client List, but uses Staff Dao

### Staff Schedule (user = Scheduler)
1. Similar flow to Client, but uses Sched Dao
