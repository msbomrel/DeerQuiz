package service;

import domains.Question;
import utils.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by msb on 9/13/16.
 */
public class QuestionService {
    public List<Question> getQuestionList() {
        List<Question> questionList = new ArrayList<Question>();
        try {
            String query = "select * from questions";
            PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Question question = new Question();
                question.setId(rs.getInt("id"));
                question.setQuestion(rs.getString("question"));
                question.setOption1(rs.getString("option1"));
                question.setOption2(rs.getString("option2"));
                question.setOption3(rs.getString("option3"));
                question.setOption4(rs.getString("option4"));
                question.setCorrectanswer(rs.getString("correctanswer"));
                question.setCategory(rs.getString("category"));

                questionList.add(question);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questionList;
    }

    public static int deleteQuestion(int qId){
        int status = 0;
        try{
            String query = "delete from questions where id = ?";
            PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
            pstm.setInt(1,qId);
            status = pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return status;
    }
    public static int storeQuestion(Question q){
        int status = 0;
        try {
            String query = "insert into questions(question,option1,option2,option3,option4,correctanswer,category)" +
                    "values(?,?,?,?,?,?,?)";
            PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
            pstm.setString(1, q.getQuestion());
            pstm.setString(2,q.getOption1());
            pstm.setString(3,q.getOption2());
            pstm.setString(4,q.getOption3());
            pstm.setString(5,q.getOption4());
            pstm.setString(6,q.getCorrectanswer());
            pstm.setString(7,q.getCategory());
            status = pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return status;
    }
    public Question editQuestionbyId(int id){
        Question q = new Question();
        try {
            String query = "select * from questions where id = ?";
            PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
            pstm.setInt(1,id);

            ResultSet rs = pstm.executeQuery();
            while (rs.next()){
                q.setId(rs.getInt("id"));
                q.setQuestion(rs.getString("question"));
                q.setOption1(rs.getString("option1"));
                q.setOption2(rs.getString("option2"));
                q.setOption3(rs.getString("option3"));
                q.setOption4(rs.getString("option4"));
                q.setCorrectanswer(rs.getString("correctanswer"));
                q.setCategory(rs.getString("category"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return q;
    }
    public static int updateQuestion(Question q){
        int status = 0;
        String query = "update questions set question=?, option1=?, option2=?,option3=?,option4=?," +
                "correctanswer=?,category=? where id=?";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        try {
            pstm.setString(1,q.getQuestion());
            pstm.setString(2,q.getOption1());
            pstm.setString(3,q.getOption2());
            pstm.setString(4,q.getOption3());
            pstm.setString(5,q.getOption4());
            pstm.setString(6,q.getCorrectanswer());
            pstm.setString(7,q.getCategory());
            pstm.setInt(8,q.getId());
            status = pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  status;
    }
    public List<Question> searchByQuestionName(String question){
        List<Question> questionList = new ArrayList<Question>();
        String query = "select * from questions where question like ?";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        try {
            pstm.setString(1,"%"+question+"%");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Question q = new Question();
                q.setQuestion(rs.getString("question"));
                q.setOption1(rs.getString("option1"));
                q.setOption2(rs.getString("option2"));
                q.setOption3(rs.getString("option3"));
                q.setOption4(rs.getString("option4"));
                q.setCorrectanswer(rs.getString("correctanswer"));
                q.setCategory(rs.getString("category"));
                questionList.add(q);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  questionList;
    }

}
