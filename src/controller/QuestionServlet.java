package controller;

import domains.Question;
import domains.User;
import service.QuestionService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by msb on 9/13/16.
 */
@WebServlet(name = "QuestionServlet")
public class QuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("page");
        System.out.println("page-->" + action);
        String id = request.getParameter("id");
        if(action==null){
            action = "abc";
        }
        if(!action.equalsIgnoreCase("login")){
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
        if (action.equalsIgnoreCase("list")){
            List<Question> questionList = new QuestionService().getQuestionList();
            request.setAttribute("questionList",questionList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("question/list.jsp");
            requestDispatcher.forward(request,response);
        }
        if (action.equalsIgnoreCase("addQuestion")){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("question/addQuestion.jsp");
            requestDispatcher.forward(request,response);
        }
        if(action.equalsIgnoreCase("store")){
            String question =request.getParameter("question");
            String option1 =request.getParameter("option1");
            String option2 =request.getParameter("option2");
            String option3 =request.getParameter("option3");
            String option4 =request.getParameter("option4");
            String correctanswer =request.getParameter("correctanswer");
            String category =request.getParameter("category");
            Question q = new Question();
            q.setQuestion(question);
            q.setOption1(option1);
            q.setOption2(option2);
            q.setOption3(option3);
            q.setOption4(option4);
            q.setCorrectanswer(correctanswer);
            q.setCategory(category);
            int status = QuestionService.storeQuestion(q);
            if (status>0){
                System.out.println("New Question Added successfully !");
                redirectToList(request, response);
            }
            else {
                System.out.println("Question not added !");
            }
        }
        if(action.equalsIgnoreCase("edit")){
            int questionId = Integer.parseInt(id);
            Question question = new QuestionService().editQuestionbyId(questionId);
            System.out.println(question.getQuestion());
            request.setAttribute("question",question);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("question/editQuestion.jsp");
            requestDispatcher.forward(request,response);
        }
        if (action.equalsIgnoreCase("delete")){
            int qId = Integer.parseInt(id);
            int status = QuestionService.deleteQuestion(qId);
            if (status > 0){
                System.out.println("Question Deleted Successfully");
                redirectToList(request,response);
            }
            else {
                System.out.println("Not deleted");
            }
        }
        if (action.equalsIgnoreCase("update")){

            String question = request.getParameter("question");
            String option1 = request.getParameter("option1");
            String option2 = request.getParameter("option2");
            String option3 = request.getParameter("option3");
            String option4 = request.getParameter("option4");
            String correctanswer = request.getParameter("correctanswer");
            String category = request.getParameter("category");
            int i = Integer.parseInt(id);
            Question q = new Question();
            q.setQuestion(question);
            q.setOption1(option1);
            q.setOption2(option2);
            q.setOption3(option3);
            q.setOption4(option4);
            q.setCorrectanswer(correctanswer);
            q.setCategory(category);
            q.setId(i);
            int status = QuestionService.updateQuestion(q);
            System.out.println(status);
            if (status > 0){
                System.out.println("Question edited successfully");
                redirectToList(request,response);
            }
            else {
                System.out.println("Question not edited");
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    private void redirectToList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Question> questionList = new QuestionService().getQuestionList();
        request.setAttribute("questionList", questionList);
        RequestDispatcher rq = request.getRequestDispatcher("question/list.jsp");
        rq.forward(request,response);
    }
}
