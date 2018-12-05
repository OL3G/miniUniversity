# miniUniversity

Учителя добавлены в бд заранее. 

| ID   |  NAME |
| ------------- | ------------- |
| 1  | Igor |
| 2  | Egor  |
| 3  | Vlad  |
| 4  | Vladimir |

Рабочий сценарий:  
1) post запрос на http://localhost:8080/group/add  
 header content-type application/json  
 Body { "group": "2303", "students": [{"name" : "Alex", "age": "18"}, {"name": "Oleg", "age": "19"}]}  
 // Добавления группы 2303 из двух студентов Олега и Алекса.  
 
2) post запрос на http://localhost:8080/group/add  
header content-type application/json  
Body { "group": "2304", "students": [{"name" : "Artem", "age": "19"}, {"name": "Anna", "age": "18"}]}  
// Добавления группы 2304 из двух студентов Артема и Ани.  

3) post запрос на http://localhost:8080/teacher/addGroup  
header content-type application/json  
Body {"teacher": "Igor", "group": "2303"}  
// Добавление учителю Игорю группы 2303  

4) post запрос на http://localhost:8080/teacher/addGroup  
header content-type application/json  
Body {"teacher": "Igor", "group": "2304"}  
// Добавление учителю Игорю группы 2304  

5) post запрос на http://localhost:8080/teacher/groups  
header content-type application/json  
Body {"teacher": "Igor"}  
// Вывод всех групп учителя Игоря  

6) post запрос на http://localhost:8080/group/allStudents  
header content-type application/json  
Body {"group": "2304"}  
// Вывод всех студентов группы 2304  

7) post запрос на http://localhost:8080/teacher/students  
header content-type application/json  
Body {"teacher": "Igor"}  
// Вывод всех студентов учителя Игоря  
