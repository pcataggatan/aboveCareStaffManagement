# Application Flow

### User Log In
1. User logs in by supplying a username and a password in the login form.
1. User credentials are autherticated making sure the user is authorized to use the system
1. If authentication succeeds, user lands to a designated home page
1. If authentication fails, error message/page is displayed telling user that the supplied username and password are invalid.

### Client List (users = Owner, Staff Worker)
1. User clicks link from the side bar menu sending request to Client List servlet 
1. Client List servlet forwards the request to search client JSP to display form with search term and type
1. User fills out search fields and submit, sending request to a Search Client servlet  
1. Search Client servlet uses Client Dao to retrieve list of clients based on search criteria from the client table
1. Dao performs select and creates results matching the criteria
1. Search Client servlet forwards request to client list JSP to display the results  

### Staff List  (users = Owner, Staff Worker)
1. Similar flow to Client List, but uses Staff Dao

### Potential client for staff (user = Owner only)
1. User clicks link from the sidebar menu sending request to ClientZipCodeAPI servlet 
1. Servlet calls webservice from zipcodesapi.com to get the list of zipcodes within a specified zipcode and radius
1. Loops through the list of all Staff and finds matching zipcodes
1. ClientZipCodeAPI servlet forwards requests to Possible Staff JSP to displays list of Staff found

### Create (Add) Client  (users = Owner, Staff Worker)
1. User clicks link from the side bar menu sending request to Add Client servlet
1. Add Client servlet forwards the request to add client JSP to display blank client form
1. User fills form data and sublit request to Add Client servlet
1. Add Client servlet uses Client dao to add new client to the client table
1. Dao performs create to add the new client

### Read (Retrieve) Client  (users = Owner, Staff Worker)
1. User clicks link from the list of Client page sending request to Update Client Detail servlet
1. Client Detail servlet forwards the request to client detail JSP to display client data
1. Client Detail servlet uses Client dao to retreive existing client from the client table
1. Dao performs get to retrieve the specified client

### Update Client  (users = Owner, Staff Worker)
1. User clicks link from the list of Client page sending request to Update Client servlet
1. Update Client servlet forwards the request to update client JSP to display exisitng client data on form for update
1. User updates form data and sublit request to Update Client servlet
1. Update Client servlet uses Client dao to update existing client data in the client table
1. Dao performs save or update to apply updates made to specidied client

### Delete Client  (users = Owner, Staff Worker)
1. User clicks link from the list of Client page sending request to Confrm Delete Client servlet
1. Confirm Delete Client servlet forwards the request to delete client JSP asking for delete confirmation
1. User confirms delete of existing client and sends request to Delete Client servlet
1. Delete Client servlet uses Client dao to delete client from the client table
1. Dao performs delete to delete specified client

### Create (Add) Staff  (users = Owner, Staff Worker)
1. Similar flow as Add Client but uses Staff Dao

### Read (Retrieve)  Staff  (users = Owner, Staff Worker)
1. Similar flow as Read Client but uses Staff Dao

### Update Staff  (users = Owner, Staff Worker)
1. Similar flow as Update Client but uses Staff Dao

### Delete Staff  (users = Owner, Staff Worker)
1. Similar flow as Delete Client but uses Staff Dao
