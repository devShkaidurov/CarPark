Запросы для автомобиля:

<code>GET /api/car/{carId}</code> - Возвращает подробную информацию по уникальному номеру автомобиля 
<code>POST /api/car</code> - Создает экземпляр автомобиля. Принимает JSON: { buildDate: Date }
<code>PUT /api/car/{carId}</code> - Назначает машине, соответствующей идентификатору carId, нового владельца. Принимает JSON - индентификатор нового владельца: { customerId: number }
<code>DELETE /api/car/{carId}</code> - Удаляет (открепляет) машину !от владельца!

Запросы для владельца:
<code>GET /api/customer/{customerId}/cars</code> - Возвращает список машин, содержащихся у конкретного владельца
<code>POST /api/customer</code> - Создает экземпляр владельца. Принимает JSON: { fio: string, phoneNumber: string, email: string, dealerId: number }. В случае, если владелец без дилера: {fio: string, phoneNumber: string, email: string }
<code>PUT /api/customer/{customerId}</code> - Назначает владельцу customerId дилера, переданного в теле запроса. Принимает JSON: { dealerId: number }
<code>DELETE /api/customer/{customerId}</code> - Удаляет (открепляет) владельца !от дилера!

Запросы для дилера:
<code>GET /api/dealer/{dealerId}/cars</code> - Возвращает список машин, обслуживающихся у конкретного дилера
<code>GET /api/dealer/{dealerId}/customer</code> - Возвращает список клиентов, обслуживающихся у конкретного дилера
<code>POST /api/dealer</code> - Создает экземпляр дилера. Принимает JSON: { name: string, email: string, agentFIO: string }


