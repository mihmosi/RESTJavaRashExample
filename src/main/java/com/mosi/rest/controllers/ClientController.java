package com.mosi.rest.controllers;

import com.mosi.rest.model.Client;
import com.mosi.rest.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    // здесь мы обозначаем, что данный метод обрабатывает POST запросы на адрес /clients
    @PostMapping(value = "/clients")
    public ResponseEntity<?> create(@RequestBody Client client) { // значение этого параметра подставляется
        // из тела запроса Об этом говорит аннотация  @RequestBody.
        clientService.create(client); // Внутри тела метода мы вызываем метод create у ранее созданного сервиса и
        // передаем ему принятого в параметрах контроллера клиента

        /*ResponseEntity — специальный класс для возврата ответов. С помощью него
        мы сможем в дальнейшем вернуть клиенту HTTP статус код*/
        return new ResponseEntity<>(HttpStatus.CREATED);
        // После чего возвращаем статус 201 Created, создав новый объект
        // ResponseEntity и передав в него нужное значение енума HttpStatus.

    }

    /*@GetMapping(value = "/clients") — все аналогично аннотации
    @PostMapping, только теперь мы обрабатываем GET запросы.*/
    @GetMapping(value = "/clients")
    public ResponseEntity<List<Client>> read() {
        final List<Client> clients = clientService.readAll();

        return clients != null && !clients.isEmpty()
                ? new ResponseEntity<>(clients, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /*Из нового, у нас тут появилась переменная пути. Переменная, которая
    определена в URI. value = "/clients/{id}". Мы указали ее в фигурных
    скобках. А в параметрах метода принимаем её в качестве int переменной,
     с помощью аннотации @PathVariable(name = "id"). */
    @GetMapping(value = "/clients/{id}")
    public ResponseEntity<Client> read(@PathVariable(name = "id") Long id) {
        final Client client = clientService.read(id);

        return client != null
                ? new ResponseEntity<>(client, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/clients/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody Client client) {
        final boolean updated = clientService.update(client, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/clients/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        final boolean deleted = clientService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
