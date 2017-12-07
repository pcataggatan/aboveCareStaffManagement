package edu.matc.controller;

import edu.matc.entity.Client;
import edu.matc.entity.Staff;
import edu.matc.persistence.GenericDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;

/**
 * This is the DeleteStaff servlet. It retrieves the Staff id from the request parameter and calls the generic dao's
 * delete() method to delete the Staff from the staff table. It then forwards the request/response to the
 * deletePerson.jsp page.
 *
 *@author Pablo Cataggatan
 */
@WebServlet(
        name = "deleteStaff",
        urlPatterns = {"/delete-staff"}
)
public class DeleteStaff extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    /**
     *  Handles HTTP GET requests.
     *
     *@param  req             the HttpRequest
     *@param  resp            the HttpResponse
     *@exception  ServletException  if there is a general servlet exception
     *@exception  IOException       if there is a general I/O exception
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        int staffId = (Integer) session.getAttribute("deleteStaffId");

        GenericDao staffDao = new GenericDao(Staff.class);
        Staff staff = (Staff) staffDao.get(staffId);

        if (staff == null) {
            session.setAttribute("deleteMsg", "Staff does not exist anymore");
        } else {
            deleteStaff(session, staff, staffId);
        }

        session.setAttribute("searchType", "viewAll");
        session.setAttribute("personType", "Staff");

        RequestDispatcher dispatcher = req.getRequestDispatcher("deletePerson.jsp");
        dispatcher.forward(req, resp);
    }


    /**
     * Disassociates the Staff from the Client(s) and then deletes the Staff from the staff table.
     * @param session the HttpSeesion
     * @param staff A Staff object
     * @param staffId The Staff's id
     */
    public void deleteStaff(HttpSession session, Staff staff, int staffId) {

        Set<Client> clients = staff.getClients();

        //disassociate all clients assigned to this staff
        for (Client client : clients) {
            GenericDao updtClientDao = new GenericDao(Client.class);
            Client updtClient = (Client) updtClientDao.get(client.getClientId());
            updtClient.setStaff(null);
            String updtMsg = updtClientDao.update(updtClient);
        }

        String deleteStaffName = staff.getFirstName() + " " + staff.getLastName();

        GenericDao staffDao = new GenericDao(Staff.class);
        String deleteMsg = staffDao.delete(staffId);

        if (deleteMsg.equals("Success")) {
            session.setAttribute("deleteMsg", "Staff " + deleteStaffName + " is successfully deleted");
        } else {
            session.setAttribute("deleteMsg", "Error deleting Staff " + deleteStaffName);
            log.error("There's an error when deleting a Staff from the staff table");
        }

    }
}

