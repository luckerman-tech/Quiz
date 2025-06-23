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
            text = "Какой процесс позволяет растениям получать энергию от солнца?",
            options = listOf("Дыхание", "Фотосинтез", "Испарение", "Опыление"),
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
            text = "Кто написал сказку \"Айболит\"?",
            options = listOf("Константин Паустовский", "Лев Толстой", "Иван Тургенев", "Корней Чуковский"),
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
            text = "Какой инструмент называют \"королём музыки\"?",
            options = listOf("Барабаны", "Скрипка", "Фортепиано", "Флейта"),
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
            text = "Какой оператор проверяет \"НЕ равно\" в Python?",
            options = listOf("=", "==", "!=", "<>"),
            correctAnswerIndex = 2,
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
            text = "Какой химический элемент обозначается символом \"Sn\"?",
            options = listOf("Серебро", "Олово", "Сера", "Скандий"),
            correctAnswerIndex = 1,
            difficulty = "medium"
        ),
        Question(
            id = 22,
            text = "В каком году человек впервые ступил на Луну?",
            options = listOf("1965", "1969", "1972", "1981"),
            correctAnswerIndex = 1,
            difficulty = "medium"
        ),
        Question(
            id = 23,
            text = "Какой фильм получил первый \"Оскар\" за лучшую картину в 1929 году?",
            options = listOf("Крылья", "Унесённые ветром", "Касабланка", "Метрополис"),
            correctAnswerIndex = 0,
            difficulty = "medium"
        ),
        Question(
            id = 24,
            text = "Какое озеро является самым глубоким в мире?",
            options = listOf("Виктория", "Танганьика", "Байкал", "Каспийское море"),
            correctAnswerIndex = 2,
            difficulty = "medium"
        ),
        Question(
            id = 25,
            text = "Как называется первый искусственный спутник Земли?",
            options = listOf("Восток-1", "Hubble", "Apollo 11", "Спутник-1"),
            correctAnswerIndex = 3,
            difficulty = "medium"
        ),
        Question(
            id = 26,
            text = "Кто автор \"Мастера и Маргариты\"?",
            options = listOf("Фёдор Достоевский", "Лев Толстой", "Михаил Булгаков", "Александр Пушкин"),
            correctAnswerIndex = 2,
            difficulty = "medium"
        ),
        Question(
            id = 27,
            text = "Какой группе принадлежит альбом \"The Dark Side of the Moon\"?",
            options = listOf("The Beatles", "Led Zeppelin", "Queen", "Pink Floyd"),
            correctAnswerIndex = 3,
            difficulty = "medium"
        ),
        Question(
            id = 28,
            text = "В каком году прошли первые Олимпийские игры современности?",
            options = listOf("1892", "1896", "1900", "1912"),
            correctAnswerIndex = 1,
            difficulty = "medium"
        ),
        Question(
            id = 29,
            text = "Сколько костей в теле взрослого человека?",
            options = listOf("162", "206", "388", "436"),
            correctAnswerIndex = 1,
            difficulty = "medium"
        ),
        Question(
            id = 30,
            text = "Кто написал картину \"Крик\"?",
            options = listOf("Ван Гог", "Эдвард Мунк", "Пабло Пикассо", "Сальвадор Дали"),
            correctAnswerIndex = 1,
            difficulty = "medium"
        ),
        Question(
            id = 31,
            text = "Как называется частица, переносящая свет?",
            options = listOf("Фотон", "Электрон", "Протон", "Нейтрон"),
            correctAnswerIndex = 0,
            difficulty = "medium"
        ),
        Question(
            id = 32,
            text = "Какой объект в Солнечной системе имеет самые крупные кольца?",
            options = listOf("Юпитер", "Уран", "Сатурн", "Нептун"),
            correctAnswerIndex = 2,
            difficulty = "medium"
        ),
        Question(
            id = 33,
            text = "Какая криптовалюта появилась первой?",
            options = listOf("Ethereum", "Ripple", "Bitcoin", "Litecoin"),
            correctAnswerIndex = 2,
            difficulty = "medium"
        ),
        Question(
            id = 34,
            text = "Какой витамин вырабатывается в коже под действием солнца?",
            options = listOf("Витамин A", "Витамин C", "Витамин B12", "Витамин D"),
            correctAnswerIndex = 3,
            difficulty = "medium"
        ),
        Question(
            id = 35,
            text = "Сколько официальных языков в ООН?",
            options = listOf("4", "6", "8", "10"),
            correctAnswerIndex = 1,
            difficulty = "medium"
        ),
        Question(
            id = 36,
            text = "Из какой страны суп \"Том-ям\"?",
            options = listOf("Китай", "Япония", "Таиланд", "Индия"),
            correctAnswerIndex = 2,
            difficulty = "medium"
        ),
        Question(
            id = 37,
            text = "Кто был вторым президентом США?",
            options = listOf("Томас Джефферсон", "Джордж Вашингтон", "Джон Адамс", "Джеймс Мэдисон"),
            correctAnswerIndex = 2,
            difficulty = "medium"
        ),
        Question(
            id = 38,
            text = "В какой серии игр главным героем является Лара Крофт?",
            options = listOf("Tomb Raider", "Assassin’s Creed", "Uncharted", "Resident Evil"),
            correctAnswerIndex = 0,
            difficulty = "medium"
        ),
        Question(
            id = 39,
            text = "Какая компания выпускает процессоры Ryzen?",
            options = listOf("AMD", "Intel", "NVIDIA", "Qualcomm"),
            correctAnswerIndex = 0,
            difficulty = "medium"
        ),
        Question(
            id = 40,
            text = "Какой мессенджер принадлежит компании Meta (Facebook)?",
            options = listOf("Telegram", "Signal", "Viber", "WhatsApp"),
            correctAnswerIndex = 3,
            difficulty = "medium"
        ),
        Question(
            id = 41,
            text = "Какой элемент имеет атомный номер 82?",
            options = listOf("Железо", "Ртуть", "Свинец", "Висмут"),
            correctAnswerIndex = 2,
            difficulty = "hard"
        ),
        Question(
            id = 42,
            text = "Какая частица отвечает за перенос слабого ядерного взаимодействия?",
            options = listOf("Глюон", "W-бозон", "Фотон", "Хиггс-бозон"),
            correctAnswerIndex = 1,
            difficulty = "hard"
        ),
        Question(
            id = 43,
            text = "Кто написал картину \"Герника\"?",
            options = listOf("Пабло Пикассо", "Сальвадор Дали", "Винсент Ван Гог", "Анри Матисс"),
            correctAnswerIndex = 0,
            difficulty = "hard"
        ),
        Question(
            id = 44,
            text = "Какая единственная картина Леонардо да Винчи находится в Восточном полушарии?",
            options = listOf("Мона Лиза", "Тайная вечеря", "Спаситель мира", "Дама с горностаем"),
            correctAnswerIndex = 2,
            difficulty = "hard"
        ),
        Question(
            id = 45,
            text = "Какое государство имеет анклав внутри анклава?",
            options = listOf("Сан-Марино", "Индия", "Ватикан", "Лесото"),
            correctAnswerIndex = 1,
            difficulty = "hard"
        ),
        Question(
            id = 46,
            text = "Какой пролив разделяет Евразию и Северную Америку?",
            options = listOf("Гибралтарский", "Берингов", "Магелланов", "Дрейка"),
            correctAnswerIndex = 1,
            difficulty = "hard"
        ),
        Question(
            id = 47,
            text = "Кто был последним императором Византии?",
            options = listOf("Константин XI Палеолог", "Юстиниан I", "Далмаций Младший", "Феодосий II"),
            correctAnswerIndex = 0,
            difficulty = "hard"
        ),
        Question(
            id = 48,
            text = "Какой древний язык до сих пор не расшифрован полностью, несмотря на найденные в 2023 году новые таблички?",
            options = listOf("Шумерская клинопись", "Древнеэламский", "Иберское письмо", "Линейное письмо А"),
            correctAnswerIndex = 3,
            difficulty = "hard"
        ),
        Question(
            id = 49,
            text = "Какой язык программирования создал Гвидо ван Россум?",
            options = listOf("Java", "C++", "Ruby", "Python"),
            correctAnswerIndex = 3,
            difficulty = "hard"
        ),
        Question(
            id = 50,
            text = "Какой принцип квантовых вычислений позволяет кубитам находиться в суперпозиции 0 и 1 одновременно?",
            options = listOf("Когерентность", "Телепортация", "Энтропийная запутанность", "Туннельный эффект"),
            correctAnswerIndex = 0,
            difficulty = "hard"
        ),
        Question(
            id = 51,
            text = "Какая игра считается первой в жанре battle royale?",
            options = listOf("Fortnite", "PlayerUnknown’s Battlegrounds", "Apex Legends", "Call of Duty: Warzone"),
            correctAnswerIndex = 1,
            difficulty = "hard"
        ),
        Question(
            id = 52,
            text = "Какой алгоритм в игровых движках оптимизирует рендеринг, отсекая невидимые игроку объекты?",
            options = listOf("Ray marching", "Frustum culling", "Voxel streaming", "Tessellation"),
            correctAnswerIndex = 1,
            difficulty = "hard"
        ),
        Question(
            id = 53,
            text = "Какой фильм получил 11 Оскаров в 2004 году?",
            options = listOf("Властелин колец: Возвращение короля", "Властелин колец: Две крепости", "Троя", "Человек-паук 2"),
            correctAnswerIndex = 0,
            difficulty = "hard"
        ),
        Question(
            id = 54,
            text = "Кто режиссировал \"Криминальное чтиво\"?",
            options = listOf("Мартин Скорсезе", "Дэвид Финчер", "Квентин Тарантино", "Кристофер Нолан"),
            correctAnswerIndex = 2,
            difficulty = "hard"
        ),
        Question(
            id = 55,
            text = "Какой эксперимент доказал, что люди склонны подчиняться авторитету даже вопреки морали?",
            options = listOf("Стэнфордский тюремный", "Зефирный тест", "Мильгрэма", "Кукольный Бандуры"),
            correctAnswerIndex = 2,
            difficulty = "hard"
        ),
        Question(
            id = 56,
            text = "Кто ввёл термин \"когнитивный диссонанс\"",
            options = listOf("Зигмунд Фрейд", "Карл Юнг", "Абрахам Маслоу", "Леон Фестингер"),
            correctAnswerIndex = 3,
            difficulty = "hard"
        ),
        Question(
            id = 57,
            text = "Какой объект во Вселенной самый холодный?",
            options = listOf("Плутон", "Туманность Бумеранг", "Тритон", "Планета OGLE-2005-BLG-390L b"),
            correctAnswerIndex = 1,
            difficulty = "hard"
        ),
        Question(
            id = 58,
            text = "Сколько спутников у Юпитера?",
            options = listOf("16", "50", "95", "120"),
            correctAnswerIndex = 2,
            difficulty = "hard"
        ),
        Question(
            id = 59,
            text = "Какой альбом группы The Beatles считается первым в жанре прогрессив-рок?",
            options = listOf("Help!", "Abbey Road", "Sgt. Pepper’s Lonely Hearts Club Band", "Revolver"),
            correctAnswerIndex = 2,
            difficulty = "hard"
        ),
        Question(
            id = 60,
            text = "Кто написал симфонию \"Из Нового Света\"?",
            options = listOf("Дворжак", "Барток", "Берлиоз", "Штраус"),
            correctAnswerIndex = 0,
            difficulty = "hard"
        )
    )

    fun getQuestions(difficulty: String): List<Question> {
        return allQuestions.filter { it.difficulty == difficulty }
    }
}