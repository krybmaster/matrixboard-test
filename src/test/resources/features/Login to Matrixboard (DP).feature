#language: ru

Функционал: Вход в систему MatrixBoard
  Описываем вход в систему. Позитивный и негативный
  Сценарий: Вход в систему позитивный
    Пусть в БД найден пользователь с ролью "user"
    Также открыта страница входа в приложение 'http://at.pflb.ru/matrixboard2'
    И пользователь вводит в поле "имя пользователя" значение для роли "user"
    И пользователь вводит в поле "пароль" значение для роли "user"
    И нажимает кнопку "отправить"
    Тогда открылась главная страница
    Также на главной странице в правом верхнем углу видно имя пользователя "user"