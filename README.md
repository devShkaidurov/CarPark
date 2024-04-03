<h2>Первое задание</h2>

Запросы для автомобиля:
<ol>
<li><code>GET /api/car/{carId}</code> - Возвращает подробную информацию по уникальному номеру автомобиля</li>
<li><code>POST /api/car</code> - Создает экземпляр автомобиля. Принимает JSON: { buildDate: Date }</li>
<li><code>PUT /api/car/{carId}</code> - Назначает машине, соответствующей идентификатору carId, нового владельца. Принимает JSON - индентификатор нового владельца: { customerId: number }</li>
<li><code>DELETE /api/car/{carId}</code> - Удаляет (открепляет) машину !от владельца!</li>
</ol>

Запросы для владельца:
<ol>
<li><code>GET /api/customer/{customerId}/cars</code> - Возвращает список машин, содержащихся у конкретного владельца</li>
<li><code>POST /api/customer</code> - Создает экземпляр владельца. Принимает JSON: { fio: string, phoneNumber: string, email: string, dealerId: number }. В случае, если владелец без дилера: {fio: string, phoneNumber: string, email: string }</li>
<li><code>PUT /api/customer/{customerId}</code> - Назначает владельцу customerId дилера, переданного в теле запроса. Принимает JSON: { dealerId: number }</li>
<li><code>DELETE /api/customer/{customerId}</code> - Удаляет (открепляет) владельца !от дилера!</li>
</ol>

Запросы для дилера:
<ol>
<li><code>GET /api/dealer/{dealerId}/cars</code> - Возвращает список машин, обслуживающихся у конкретного дилера</li>
<li><code>GET /api/dealer/{dealerId}/customer</code> - Возвращает список клиентов, обслуживающихся у конкретного дилера</li>
<li><code>POST /api/dealer</code> - Создает экземпляр дилера. Принимает JSON: { name: string, email: string, agentFIO: string }</li>
</ol>


<h2>Второе задание</h2>
Вначале попытался реализовать через сторонние библиотеки, однако это не принесло должного результата (хотя какой-никакой результат там был). Вследствие чего было решено писать парсер вручную. Учтены все требования, размер загружаемого файла ограничен 64МБ в конфиге приложения. Результат для nmea.log - 145.714 километров

