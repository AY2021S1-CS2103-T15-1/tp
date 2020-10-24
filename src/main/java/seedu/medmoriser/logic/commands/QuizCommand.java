package seedu.medmoriser.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.medmoriser.logic.commands.exceptions.CommandException;
import seedu.medmoriser.model.Model;
import seedu.medmoriser.model.qanda.QAndA;
import seedu.medmoriser.model.qanda.QAndAContainsKeywordsPredicate;
import seedu.medmoriser.model.qanda.QuestionContainsKeywordsPredicate;
import seedu.medmoriser.model.qanda.TagContainsKeywordsPredicate;

/**
 * Starts a new Quiz for the user.
 */
public class QuizCommand extends Command {

    public static final String COMMAND_WORD = "quiz";

    public static final String MESSAGE_USAGE = "Quiz time! Heres a question...";

    public static final String MESSAGE_NO_QUESTION_WITH_KEYWORD = "No question with this tag/keyword";

    private static boolean isQuiz = false;

    private final Predicate<QAndA> predicate;

    public QuizCommand(TagContainsKeywordsPredicate predicate) {
        this.predicate = predicate;
    }

    public QuizCommand(QuestionContainsKeywordsPredicate predicate) {
        this.predicate = predicate;
    }

    public QuizCommand(QAndAContainsKeywordsPredicate predicate) {
        this.predicate = predicate;
    }

    public QAndA getRandomQuestion(List<QAndA> list) {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }

    public static boolean getIsQuiz() {
        return isQuiz;
    }

    public static void setIsQuiz(boolean ongoingQuiz) {
        isQuiz = ongoingQuiz;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        model.updateFilteredQAndAList(predicate);
        ObservableList<QAndA> filteredList = model.getFilteredQAndAList();

        if (filteredList.size() > 0) {
            QAndA question = getRandomQuestion(filteredList);
            model.updateFilteredQAndAList(x -> x.equals(question));
            setIsQuiz(true);

            return new CommandResult(MESSAGE_USAGE);
        } else {
            throw new CommandException(MESSAGE_NO_QUESTION_WITH_KEYWORD);
        }
    }
}
