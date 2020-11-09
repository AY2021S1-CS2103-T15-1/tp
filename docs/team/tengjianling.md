---
layout: page
title: Teng Jian Ling's Project Portfolio Page
---

### Project: Medmoriser

Medmoriser is a desktop app to help medical students organise, memorise and revise their content. The user interacts with it using a CLI, and it has a GUI created with JavaFX and is written in Java.

Given below are my contributions to the project.

- **Code contributed:** [RepoSense Link](https://nus-cs2103-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=tengjianling)

- **New feature:** Added a `next` command for the user to move on to the next question in the quiz.
  - What it does: allows the user to be tested on another question based on the same keywords provided for the current quiz session, without having to end the quiz first.
  - Justification: This feature improves the product significantly because a user may want to test themselves on multiple questions with the same keywords specified, and the app should provide a convenient way for them to do this.
  - Highlights: The implementation of this enchancement was challenging due to the following reasons:
    - This enhancement required an in-depth analysis of design alternatives to find the best design choice.
    - There was a need to make sure repeated questions are not shown
    - There was a need to detect when there are no more questions with the keyword specified
    - There was a need to check whether there is an ongoing quiz when this command is entered
    - It required changes to existing commands such as `QuizCommand` and `AnswerCommand`

- **Enhancements to Existing features:**
  - Changed the usage message in the `edit` command to the context of questions and answers: [#41](https://github.com/AY2021S1-CS2103T-W15-1/tp/pull/41)
  - Renamed all uses of `QuestionSet` and `questionSet` to `QAndA` and `qAndA` to avoid confusion between sets and lists: [#43](https://github.com/AY2021S1-CS2103T-W15-1/tp/pull/43), [#44](https://github.com/AY2021S1-CS2103T-W15-1/tp/pull/44), [#64](https://github.com/AY2021S1-CS2103T-W15-1/tp/pull/64)
  - Changed restrictions on `question`, `answer`, and `tag` fields when adding a QAndA: [#66](https://github.com/AY2021S1-CS2103T-W15-1/tp/pull/66)
  - Changed implementation of `QuizCommand` and `QuizCommandParser` to include ability to start a quiz based on multiple keywords or tags: [#73](https://github.com/AY2021S1-CS2103T-W15-1/tp/pull/73)
  - Wrote the following additional tests: `QuizCommandTest`, `QuizCommandParserTest`, `ExitCommandTest`: [#73](https://github.com/AY2021S1-CS2103T-W15-1/tp/pull/73)
    - increased code coverage by 2.96%
  - Updated the GUI for quiz to be centralised and remove the question index number: [#83](https://github.com/AY2021S1-CS2103T-W15-1/tp/pull/83)
  - Removed unnecessary 'F1' from the help menu: [#143](https://github.com/AY2021S1-CS2103T-W15-1/tp/pull/143)
  - Wrote the following addtional tests: `AnswerCommandTest` and `AnswerCommandParserTest`: [#157](https://github.com/AY2021S1-CS2103T-W15-1/tp/pull/157)
    - increased code coverage by  1.54%

- **Documentation:**
  - User Guide:
    - Added documentation for the features `add` , `delete`, `edit` and `next`: [#18](https://github.com/AY2021S1-CS2103T-W15-1/tp/pull/18), [#83](https://github.com/AY2021S1-CS2103T-W15-1/tp/pull/83), [#92](https://github.com/AY2021S1-CS2103T-W15-1/tp/pull/92), [#153](https://github.com/AY2021S1-CS2103T-W15-1/tp/pull/153)
  - Developer Guide:
    - Added use cases for Medmoriser: [#18](https://github.com/AY2021S1-CS2103T-W15-1/tp/pull/18)
    - Added implementation details of the `delete` feature, including a sequence diagram and an activity diagram: [#78](https://github.com/AY2021S1-CS2103T-W15-1/tp/pull/78)
  - Added "Appendix: Effort" section: [#163](https://github.com/AY2021S1-CS2103T-W15-1/tp/pull/163)
  
- **Community**:
  - PRs reviewed with non-trivial review comments: [#71](https://github.com/AY2021S1-CS2103T-W15-1/tp/pull/71), [#168](https://github.com/AY2021S1-CS2103T-W15-1/tp/pull/168)
  - Reported bugs and suggestions for other teams in the class (examples: [1](https://github.com/AY2021S1-CS2103T-W16-3/tp/issues/236), [2](https://github.com/AY2021S1-CS2103T-W16-3/tp/issues/237))
