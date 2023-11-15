1. При выборке task по дате/интервале дат, по статусу выполнения, необходимо выполнять запросы согласно следующих паттернов:
   http://localhost:8080/api/tasks?date=yyyy.MM.dd&status=boolean,
   http://localhost:8080/api/tasks?date=yyyy.MM.dd-yyyy.MM.dd&status=boolean,
   например: http://localhost:8080/api/tasks?date=2020.01.01&status=true
             http://localhost:8080/api/tasks?date=2020.01.01-2020.01.07&status=false.
