package com.example.coursework_3;

import com.example.coursework_3.exeption.UnSufficientQuestionsException;
import com.example.coursework_3.model.Question;
import com.example.coursework_3.service.JavaQuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class JavaQuestionServiceTest {


    private JavaQuestionService javaQuestionService;

    private List<Question> questions = List.of(
            new Question("q1", "a1"),
            new Question("q2", "a2"),
            new Question("q3", "a3"),
            new Question("q4", "a4")
    );

    @BeforeEach
    void setUp() {
        this.javaQuestionService = new JavaQuestionService();
        questions.forEach(javaQuestionService::add);

    }


    @Test
    void addQuestionTest() {
        Question question = new Question("q5", "a5");
        Question actual = this.javaQuestionService.add(question);
        assertThat(actual).isEqualTo(question);
        assertThat(this.javaQuestionService.getAll()).hasSize(5).contains(question);
    }


    @Test
    void removeQuestionTest() {
        Question expected = this.questions.get(0);
        Question actual = this.javaQuestionService.remove(expected);
        assertThat(actual).isEqualTo(expected);
        assertThat(this.javaQuestionService.getAll()).hasSize(3).doesNotContain(expected);


    }

    @Test
    void getRandomQuestion() {
        Question actual = this.javaQuestionService.getRandomQuestion();
        assertThat(actual).isIn(questions);
    }


    @Test
    void getAllTest() {
        assertThat(this.javaQuestionService.getAll()).hasSize(4).containsAll(this.questions);
    }


    @Test
    void questionReturnException(){
        this.javaQuestionService = new JavaQuestionService();
        assertThatThrownBy(()->javaQuestionService.getRandomQuestion()).isInstanceOf(UnSufficientQuestionsException.class);
    }
}

