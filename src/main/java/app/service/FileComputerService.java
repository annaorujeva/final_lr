package app.service;

import app.domain.*;
import app.exception.*;
import app.repository.*;
import app.store.ComputerStore;
import app.store.RoomStore;
import org.springframework.beans.factory.annotation.Autowired;

public class FileComputerService implements ComputerService {

    public FileComputerService() {
    }

    @Autowired
    Repository fileRepository;
    public void setFr(Repository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public void WriteOffPC(int id) throws UnknownComputerException, UnknownRoomException {
        Computer computer = null;
        Room room = null;
        for (Computer comp : ComputerStore.allcomputers) {
            if ((comp.getId() == id) & (comp.getStatus().equals("work"))) {
                computer = comp;
                break;
            }
        }
        for (Room rm:RoomStore.allrooms){
            if((rm.getId()==computer.getRoom())){
                room = rm;
                break;
            }
        }
        if (computer == null) {
            throw new UnknownComputerException();
        }
        if (room == null){
            throw new UnknownRoomException();
        }
        computer.setStatus("writeoff");
        computer.setWriteoff_date(room.getNext_inventory_date());
        room.getPlace(computer.getId_place()).setStatus("free");
        fileRepository.write(computer);
        fileRepository.write(room);
    }

    @Override
    public void ChangePCPlace(int id_pc, int place_id_to) throws UnknownComputerException, UnknownPlace, NoPlaceException {
        Computer computer = null;
        Room room = null;
            for (Computer comp : ComputerStore.allcomputers) {
                if (comp.getId() == id_pc) {
                    computer = comp;
                    break;
                }
            }
            for (Room rm:RoomStore.allrooms){
                if((rm.getId()==computer.getRoom())){
                    room = rm;
                    break;
                }
            }
            if (computer == null) {
                throw new UnknownComputerException();
            }
            if(room.getPlace(place_id_to).equals("used")|(room.getPlaces_in_room().size()>=20)){
                throw new NoPlaceException();
            }
            Place new_place = new Place(place_id_to);
            room.getPlaces_in_room().add(new_place);
            room.getPlace(computer.getId_place()).setStatus("free");
            computer.setId_place(place_id_to);
            room.getPlace(place_id_to).setStatus("used");
            fileRepository.write(computer);
            fileRepository.write(room);
     }
}

