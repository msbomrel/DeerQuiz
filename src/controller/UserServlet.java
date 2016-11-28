package controller;

import domains.User;
import service.UserService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static java.lang.System.out;

/**
 * Created by msb on 8/19/2016.
 */
@WebServlet(name = "UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter("page");
        String id = request.getParameter("id");
        checkSession(request,response,page);
        if (page.equalsIgnoreCase("login")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = new UserService().getUser(username, password);
            if (user!=null) {
                request.setAttribute("message","Login Success!");
                HttpSession session = request.getSession(false);
                session.setAttribute("user", user);
                RequestDispatcher rd = request.getRequestDispatcher("user/home.jsp");
                rd.forward(request,response);
            }else{
                HttpSession session = request.getSession(false);
                session.invalidate();
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request,response);
            }
        }
        if (page.equalsIgnoreCase("logout")) {
            HttpSession session = request.getSession(false);
            session.invalidate();
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request,response);
        }
        if (page.equalsIgnoreCase("home")) {
            RequestDispatcher rd = request.getRequestDispatcher("user/home.jsp");
            rd.forward(request,response);
        }
        if (page.equalsIgnoreCase("list")) {
            List<User> userList = new UserService().getUserList();
            request.setAttribute("userList",userList);
            RequestDispatcher rd = request.getRequestDispatcher("user/list.jsp");
            rd.forward(request, response);
        }
        if(page.equalsIgnoreCase("addUser")){
            RequestDispatcher rq = request.getRequestDispatcher("user/addUser.jsp");
            rq.forward(request,response);
        }
        if (page.equalsIgnoreCase("storeUser")){
            String username =request.getParameter("username");
            String password =request.getParameter("password");
            String role =request.getParameter("role");
            User user = new User();
            user.setName(username);
            user.setPassword(password);
            user.setRole(role);
            int status = UserService.storeUser(user);
            if (status>0){
                out.println("New User Added successfully !");
                redirectToList(request, response);
            }
            else {
                out.println("User not added !");
            }

        }
        if (page.equalsIgnoreCase("delete")){
            int userId = Integer.parseInt(id);
            int status = UserService.deleteUser(userId);

            if (status >0 ){
                out.println("Deleted Successfully !");
                redirectToList(request,response);
            }
            else {
                out.println("Unable to delete");
            }
        }
        if (page.equalsIgnoreCase("edit")){
            int userId =  Integer.parseInt(id);
            User user= new UserService().editUserById(userId);
            request.setAttribute("user",user);
            RequestDispatcher rq = request.getRequestDispatcher("user/editUser.jsp");
            rq.forward(request,response);
        }
        if (page.equalsIgnoreCase("update")){
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String role = request.getParameter("role");
            int i = Integer.parseInt(id);
            User user = new User();
            user.setName(username);
            user.setPassword(password);
            user.setRole(role);
            user.setId(i);
            int status = UserService.updateUser(user);
            if(status>0){
                System.out.println("Record edited successfully!");
                redirectToList(request, response);
            }else{
                System.out.println("Sorry! unable to edit the record");
            }

        }

    }
    public void checkSession(HttpServletRequest request, HttpServletResponse response, String page){
        if(page==null){
            page = "xyz";
        }
        if(!page.equalsIgnoreCase("login")){
            HttpSession session = request.getSession(false);
            User user = (User) session.getAttribute("user");
            if(user==null){
                String message = "Login First !!!";
                try {
                    request.setAttribute("message",message);
                    request.getRequestDispatcher("index.jsp").forward(request,response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    public void redirectToList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = new UserService().getUserList();
        request.setAttribute("userList", userList);
        RequestDispatcher rq = request.getRequestDispatcher("user/list.jsp");
        rq.forward(request,response);
    }
}
