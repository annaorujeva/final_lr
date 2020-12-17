package app.controller;

import app.domain.Computer;
import app.exception.UnknownComputerException;
import app.repository.Repository;
import app.service.ComputerService;
import app.service.RoomService;
import app.store.ComputerStore;
import app.store.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RestController {
    public RestController(){}

        @Autowired
        StoreService storeService;

        @Autowired
        RoomService roomService;

        @Autowired
        ComputerService computerService;

        @Autowired
        Repository fileFepository;


    @GetMapping ("/writeoff/{id_pc}")//Готовая ссылка для проверки: http://localhost:8080/writeoff/333
        public ResponseEntity<String> deposite(@PathVariable("id_pc")int id_pc) throws UnknownComputerException {
            storeService.startofwork();
            //computerService.WriteOffPC(id_pc);
            return new ResponseEntity<>("Компьютер списан ", HttpStatus.OK);
        }

}
