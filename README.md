# prj

# Компоненты сервиса

1. QASlavePBot - бот, осуществляющий взаимодействие с участниками, находится в чате участников.
2. QASlaveOBot - бот, осуществляющий взаимодействие с оргами, находится в чате оргов.
3. QAMasterBot - бот, осуществляющий взаимодействие с главным организатором, общается с ним отдельно.
4. Backend - обрабатывает запросы от ботов и взаимодействует с базой данных.
5. BD - no comments, пока содержит таблицы:
   * Две таблицы participant_chats и org_chats, где хранятся chat_id всех чатов, доступных для QASlavePBot и QASlaveOBot соответственно.
   * Таблица current_events(event_id, participant_chat_id, org_chat_id) - для каждого мероприятия хранятся id чатов участников и оргов.
   * unanswered_questions(event_id, message_id, text) - все заданные вопросы, на которые пока не было ответа
   
# Процесс работы сервиса

1. QASlavePBot добавляется в чат с участниками. В этот момент он отправляет в бэк json с chat_id, который заносится в соответствующую базу данных.
2. Аналогично для QASlaveOBot.
3. Главный орг пишет в QAMasterBot ссылки на два чата. Бот отправляет их в бэк и там проверяется, доступны ли такие чаты для QASlavePBot и QASlaveOBot в соответствующих таблицах.
Если они доступны, бэк создает запись в current_events и говорит в QAMasterBot что всё хорошо, что бот передает организатору.
4. QASlavePBot ждет сообщений с пометкой \question. Как только он получает такое, он отправляет json {participant_chat_id, message_id, text} в бэк. Там этот запрос проверяется 
на релевантность (есть ли такой чат в эвентах) и:
   * заносится в unanswered_questions
   * отправляется в виде {org_chat_id, text} в QASlaveOBot.
5. QASlaveOBot при получении этого json пишет текст вопроса в чат.
6. Параллельно QASlaveOBot слушает, не ответил ли кто-то в его чатах на опубликованные им запросы. Как только он видит message, в котором в качестве reply стоит его сообщение,
он формирует json {org_chat_id, reply_text} и отправляет его в бэк.
7. Бэк находит вопрос (в таблице unanswered_questions), на который был дан этот ответ и отправляет json {chat_id, message_id, reply_text} в QASlavePBot.
8. QASlavePBot пишет это сообщение в чат в виде reply на сообщение с message_id (которое являестя первоначальным вопросом).