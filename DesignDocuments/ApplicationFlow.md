# Application Flow

### User Log In
1. User selects a role and enter username and password on form and submits. 
1. If authentication succeeds, user lands to a designated home page
1. If authentication fails, show error message/page.

### View Client List (user = Owner)

1. User clicks on a link to the Client Search page
1. User enters the search term in a text field and selects search type (button)
1. The action attribute on the form will point to the corresponding search Servlet (ie. client, staff, code table)
1. Servlet uses client dao to select reports along with criteria

1. Page sends a request to view trail reports servlet along with criteria 
(all, region, date, nam table)e, etc).
1. Servlet uses the trailreports dao to select reports according to criteria
1. Dao performs select and creates report objects from results.
1. Dao returns list of report matching criteria to servlet.
1. Servlet sends list back to trail reports jsp.
1. Trail reports jsp displays the reports.
1. Consider paging results so page does not get super long and too much data 
is sent.

