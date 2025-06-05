package com.example.quiz.data

import com.example.quiz.data.models.Question

object QuestionsRepository {
    val allQuestions: List<Question> = listOf(
        Question(
            id = 1,
            text = "Какая планета ближе всего к Солнцу?",
            options = listOf("Меркурий", "Венера", "Земля", "Марс"),
            correctAnswerIndex = 0,
            difficulty = "easy"
        ),
        Question(
            id = 2,
            text = "Сколько костей в теле взрослого человека?",
            options = listOf("162", "206", "388", "436"),
            correctAnswerIndex = 1,
            difficulty = "easy"
        ),
        Question(
            id = 3,
            text = "Что измеряет термометр?",
            options = listOf("Давление", "Влажность", "Температуру", "Время"),
            correctAnswerIndex = 2,
            difficulty = "easy"
        ),
        Question(
            id = 4,
            text = "Самое большое животное на Земле?",
            options = listOf("Слон", "Белый медведь", "Синий кит", "Жираф"),
            correctAnswerIndex = 2,
            difficulty = "easy"
        ),
        Question(
            id = 5,
            text = "Какое животное называют «кораблём пустыни»?",
            options = listOf("Лошадь", "Верблюд", "Лама", "Осёл"),
            correctAnswerIndex = 1,
            difficulty = "easy"
        ),
        Question(
            id = 6,
            text = "Сколько ног у паука?",
            options = listOf("6", "8", "10", "12"),
            correctAnswerIndex = 1,
            difficulty = "easy"
        ),
        Question(
            id = 7,
            text = "Кто написал «Ромео и Джульетту»?",
            options = listOf("Чарльз Диккенс", "Уильям Шекспир", "Лев Толстой", "Марк Твен"),
            correctAnswerIndex = 1,
            difficulty = "easy"
        ),
        Question(
            id = 8,
            text = "Главный герой книги «Приключения Тома Сойера»?",
            options = listOf("Гекльберри Финн", "Питер Пэн", "Том Сойер", "Оливер Твист"),
            correctAnswerIndex = 2,
            difficulty = "easy"
        ),
        Question(
            id = 9,
            text = "Сколько лет спала Спящая красавица?",
            options = listOf("40", "60", "80", "100"),
            correctAnswerIndex = 3,
            difficulty = "easy"
        ),
        Question(
            id = 10,
            text = "Кто нарисовал «Мону Лизу»?",
            options = listOf("Винсент Ван Гог", "Пабло Пикассо", "Леонардо да Винчи", "Сальвадор Дали"),
            correctAnswerIndex = 2,
            difficulty = "easy"
        ),
        Question(
            id = 11,
            text = "Какой инструмент имеет 88 клавиш?",
            options = listOf("Гитара", "Скрипка", "Фортепиано", "Арфа"),
            correctAnswerIndex = 2,
            difficulty = "easy"
        ),
        Question(
            id = 12,
            text = "Сколько цветов у радуги?",
            options = listOf("6", "7", "8", "9"),
            correctAnswerIndex = 1,
            difficulty = "easy"
        ),
        Question(
            id = 13,
            text = "Какой язык программирования официальный для Android?",
            options = listOf("Java", "Python", "C++", "Kotlin"),
            correctAnswerIndex = 3,
            difficulty = "easy"
        ),
        Question(
            id = 14,
            text = "Что означает аббревиатура «IT»?",
            options = listOf("Интернет-технологии", "Интеллектуальные технологии", "Информационные технологии", "Инновационные технологии"),
            correctAnswerIndex = 2,
            difficulty = "easy"
        ),
        Question(
            id = 15,
            text = "Как называется «мозг» компьютера?",
            options = listOf("Жесткий диск", "Процессор", "Оперативная память", "Видеокарта"),
            correctAnswerIndex = 1,
            difficulty = "easy"
        ),
        Question(
            id = 16,
            text = "Какая компания создала операционную систему Windows?",
            options = listOf("Apple", "Google", "Microsoft", "IBM"),
            correctAnswerIndex = 2,
            difficulty = "easy"
        ),
        Question(
            id = 17,
            text = "Как называется популярный язык программирования, названный в честь змеи?",
            options = listOf("Java", "C++", "Python", "Pascal"),
            correctAnswerIndex = 2,
            difficulty = "easy"
        ),
        Question(
            id = 18,
            text = "Что такое «браузер»?",
            options = listOf("Игра", "Программа для просмотра сайтов", "Вирус", "Графический редактор"),
            correctAnswerIndex = 1,
            difficulty = "easy"
        ),
        Question(
            id = 19,
            text = "Как называется устройство для беспроводного интернета?",
            options = listOf("Роутер", "Модем", "Сканер", "Флешка"),
            correctAnswerIndex = 0,
            difficulty = "easy"
        ),
        Question(
            id = 20,
            text = "Какая кнопка на клавиатуре удаляет символ слева от курсора?",
            options = listOf("Delete", "Backspace", "Enter", "Shift"),
            correctAnswerIndex = 1,
            difficulty = "easy"
        ),
        Question(
            id = 21,
            text = "mrfrufnr",
            options = listOf("m", "e", "d", "i"),
            correctAnswerIndex = 1,
            difficulty = "medium"
        ),
        Question(
            id = 22,
            text = "dff",
            options = listOf("u", "m", "h", "a"),
            correctAnswerIndex = 1,
            difficulty = "medium"
        ),
        Question(
            id = 23,
            text = "hfdffdk",
            options = listOf("r", "d", "e", "r"),
            correctAnswerIndex = 1,
            difficulty = "hard"
        ),
    )

    fun getQuestions(difficulty: String): List<Question> {
        return allQuestions.filter { it.difficulty == difficulty }
    }
}