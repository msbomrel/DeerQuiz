package controller;

import domains.Question;
import domains.QuestionAnswer;
import domains.User;
import service.QuestionService;
import service.QuizService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by msbomrel on 11/15/16.
 */
@WebServlet(name = "QuizServlet")
public class QuizServlet extends HttpServlet {
    private ArrayList<Integer> selectedQuestions = new ArrayList<>();
    int  totalQuestions = 0;
    int totalCorrectAnswers = 0;
    QuestionAnswer questionAnswer= new QuestionAnswer();
    private ArrayList<QuestionAnswer> questionAndSelectedAnswers = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserServlet userServlet = new UserServlet();

        String action = request.getParameter("page");
        userServlet.checkSession(request, response, action);

        System.out.println(action);

        if (action.equalsIgnoreCase("play")) {
            setUniqueQuestion(request, response);
        }

        if (action.equalsIgnoreCase("submitAnswer")) {
            String id = request.getParameter("id");
            String selectedAnswer = request.getParameter("answer");

            QuestionService questionService = new QuestionService();
            Question question = questionService.editQuestionbyId(Integer.parseInt(id));

            if (question.getCorrectanswer().equalsIgnoreCase(selectedAnswer)) {
                totalCorrectAnswers++;
            }
            totalQuestions++;

            QuestionAnswer questionAnswer = new QuestionAnswer();
            questionAnswer.setQuestion(question);
            questionAnswer.setAnswer(selectedAnswer);
            questionAndSelectedAnswers.add(questionAnswer);

            if (totalQuestions < 5) {
                HttpSession session = request.getSession(false);
                User user = (User) session.getAttribute("user");
                setUniqueQuestion(request, response);
            } else {

                request.setAttribute("totalQuestions", totalQuestions);
                request.setAttribute("totalCorrectAnswers", totalCorrectAnswers);
                request.setAttribute("questionAndSelectedAnswers", questionAndSelectedAnswers);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("quiz/quizresult.jsp");
                requestDispatcher.forward(request, response);
                HttpSession session = request.getSession(false);
                User user = (User) session.getAttribute("user");
                Integer userid = user.getId();
                System.out.println(userid);
                System.out.println(totalCorrectAnswers);
                QuizService quizService = new QuizService();
                int status = quizService.storeResults(userid, totalCorrectAnswers);
                if (status > 0){
                    System.out.println("Scores added to the table");
                }
                else {
                    System.out.println("Scores not added");
                }

            }

        }
    }

    private void setUniqueQuestion(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        QuizService quizService = new QuizService();
        Question question = quizService.getRandomQuestion();

        if(selectedQuestions.contains(question.getId())){
            setUniqueQuestion(request,response);
        }
        else {
            selectedQuestions.add(question.getId());
            request.setAttribute("question", question);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("quiz/playquiz.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
