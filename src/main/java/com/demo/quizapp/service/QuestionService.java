package com.demo.quizapp.service;

import com.demo.quizapp.dao.Question;
import com.demo.quizapp.repository.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {


    @Autowired
    private QuestionDao questionDao;

    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        List<Question> temp = questionDao.findByCategoryLikeIgnoreCase(category);
        for(Question q : temp )
        System.out.println(q.getCategory());
        return temp;

    }

    public String addQuestion(Question question) {
        questionDao.save(question);
        return "success";
    }
}
