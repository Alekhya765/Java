import java.util.ArrayList;
import java.util.Scanner;

// Question class
class Question {
    private String questionText;
    private String[] options;
    private int correctAnswer;

    // Constructor
    public Question(String questionText, String[] options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    // Getters
    public String getQuestionText() {
        return questionText;
    }

    public String[] getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}

// Quiz class
class Quiz {
    private ArrayList<Question> questions;
    private int score;

    // Constructor
    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
    }

    // Method to add a question to the quiz
    public void addQuestion(Question question) {
        questions.add(question);
    }

    // Method to conduct the quiz
    public void conductQuiz() {
        Scanner scanner = new Scanner(System.in);

        for (Question question : questions) {
            System.out.println(question.getQuestionText());
            String[] options = question.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }

            int userAnswer = 0;
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.print("Your answer: ");
                    userAnswer = scanner.nextInt();
                    if (userAnswer < 1 || userAnswer > options.length) {
                        System.out.println("Invalid input. Please enter a number between 1 and " + options.length + ".");
                    } else {
                        validInput = true;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // Consume invalid input
                }
            }

            if (userAnswer == question.getCorrectAnswer()) {
                score++;
            }
        }
    }

    // Method to get the final score
    public int getScore() {
        return score;
    }

    // Method to get the total number of questions
    public int getTotalQuestions() {
        return questions.size();
    }
}

// Main class
public class QuizApplication {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        // Adding questions to the quiz
        String[] options1 = {"Java", "Python", "C++", "Ruby"};
        Question q1 = new Question("Which programming language is known as the 'write once, run anywhere' language?", options1, 1);
        quiz.addQuestion(q1);

        String[] options2 = {"1", "2", "3", "4"};
        Question q2 = new Question("How many bits are there in a byte?", options2, 3);
        quiz.addQuestion(q2);

        String[] options3 = {"Alan Turing", "Tim Berners-Lee", "Bill Gates", "Linus Torvalds"};
        Question q3 = new Question("Who is known as the father of computer science?", options3, 1);
        quiz.addQuestion(q3);

        // Conducting the quiz
        quiz.conductQuiz();

        // Displaying the final score
        System.out.println("Your final score is: " + quiz.getScore() + " out of " + quiz.getTotalQuestions());
    }
}
