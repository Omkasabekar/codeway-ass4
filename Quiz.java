import java.util.Scanner;

class QuizQuestion {
    private String question;
    private String[] options;
    private int correctOptionIndex;

    public QuizQuestion(String question, String[] options, int correctOptionIndex) {
        this.question = question;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public boolean isCorrect(int selectedOptionIndex) {
        return selectedOptionIndex == correctOptionIndex;
    }
}

class Quiz {
    private QuizQuestion[] questions;
    private int score;
    private Scanner scanner;

    public Quiz(QuizQuestion[] questions) {
        this.questions = questions;
        this.score = 0;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the Quiz!");
        for (QuizQuestion question : questions) {
            displayQuestion(question);
            int selectedOptionIndex = getSelectedOptionIndex();
            if (question.isCorrect(selectedOptionIndex)) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect!");
            }
        }
        displayResult();
    }

    private void displayQuestion(QuizQuestion question) {
        System.out.println(question.getQuestion());
        String[] options = question.getOptions();
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    private int getSelectedOptionIndex() {
        System.out.print("Enter your answer (1-" + questions[0].getOptions().length + "): ");
        return scanner.nextInt() - 1;
    }
    

    private void displayResult() {
        System.out.println("Quiz ended!");
        System.out.println("Your score: " + score + "/" + questions.length);
    }
}

public class Main {
    public static void main(String[] args) {
        QuizQuestion[] questions = {
            new QuizQuestion("What is the capital of France?",
                new String[]{"Paris", "London", "Berlin", "Rome"}, 0),
            new QuizQuestion("What is the largest mammal?",
                new String[]{"Elephant", "Blue Whale", "Giraffe", "Hippo"}, 1),
           
        };
        
        Quiz quiz = new Quiz(questions);
        quiz.start();
    }
}
