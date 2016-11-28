package service;

import domains.Question;
import utils.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by msbomrel on 11/15/16.
 */
public class QuizService {
    public Question getRandomQuestion(){
        Question question = null;
        try {
            String query = "    SELECT DISTINCT * FROM questions  \n" +
                    "    ORDER BY RAND()  \n" +
                    "    LIMIT 1  ";
            PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                question = new Question();
                question.setId(rs.getInt("id"));
                question.setQuestion(rs.getString("question"));
                question.setOption1(rs.getString("option1"));
                question.setOption2(rs.getString("option2"));
                question.setOption3(rs.getString("option3"));
                question.setOption4(rs.getString("option4"));
                question.setCorrectanswer(rs.getString("correctanswer"));
                question.setCategory(rs.getString("category"));
            }
        }
        catch (SQLException e) {
                e.printStackTrace();
            }
            return question;
    }

    public int storeResults(int userid,int correctAnswers){
        int status = 0;
        String query = "insert into quizscore(userid, scores) values(?,?)";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);

        try
        {
            pstm.setInt(1,userid);
            pstm.setInt(2,correctAnswers);
            status = pstm.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return status;
    }
}
