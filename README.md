# xajkirvheznicovhxpuh

## Project: task-management-system

***Данное руководство подразумевается для описания сервиса, и для дальнейшего запуска.***

- [Описание сервиса](#about-service)
* [Технологий](#technologies)
+ [Установка и запуск проекта на вашей стороне](#installation)


## About service

Разработка Системы Управления Задачами
Описание задачи:
Вам необходимо разработать простую систему управления задачами (Task Management System) с использованием Java. Система должна обеспечивать создание,
редактирование, удаление и просмотр задач. Каждая задача должна содержать заголовок, описание, статус (например, "в ожидании", "в процессе", "завершено") 
и приоритет (например, "высокий", "средний", "низкий"), а также автора задачи и исполнителя. Реализовать необходимо только API.


###End-Points - внутри swagger все описание.

Сыылка на swagger:  http://localhost:8000/swagger-ui/index.html


## Technologies

#### Java version: 17

#### Но у меня было jdk-21 версий

###### id 'java'

###### id 'org.springframework.boot' version '3.2.1'

###### id 'io.spring.dependency-management' version '1.1.4'

###### Тесты: JUnit

###### Архитектура: RestApi

###### DB: MySQL

###### Docker - чтобы все не конфигурировать и устанавливать
###### Думаю у разработчиков по большей вероятности есть Docker

###### Lombok, Spring Data, Spring WEB, Spring, Swagger, 

###### Mapper: Можно было использовать MapStruct, предпочел написать все руками.

###### Старался придерживаться принципов проектирования и ООП, но применять это было очень мало вариантов в связи с размером проекта

##### Gradle: 8.5



## Installation

### Перейдем к установке, самого сервиса

#### №1. Создать директорию для теста сервиса
#### №2. Скопировать мой репозиторий с GitHub по ссылке по команде `git clone ` + ссылка репозиторий, в терминале, в папке который вы создали
#### №3. После всего копирования кода, открыть его в IDEA приназдначеных для Java и Spring, для запуска сервиса
#### №5. Далее создать отделльный файл скопировать туда  docker-compose.yaml, в файле и именно где файл открыть `power shell`.
#### №6. Далее внутри терминала в папке исполнить команду `docker compose up -d`.
#### №7. После установки образов `docker`, и запуска контейнеров, убедиться что контейнеры запущены, если внутри контейнера ошибка просто перезапустите только self-generated-container
#### №7.1. Если контейнеры не запущены, то перезапустить контейнеры если не сработало, обратно перейти к 4 ому шагу :)
#### №9. Далее внутри IDEA запустить сам проект :)
#### №10. Поздравляю вы запустили проект на своей стороне:)

### Папка postman: внутри файл со всеми запросами на сервер
#### Сервис по порту 9000, ссылка: `http://localhost:8000`

##### Примечание: nobeksultan в git ветке это я точнее GitHub аккаунт.






