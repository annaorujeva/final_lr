package app.domain;

import app.store.ComputerStore;
import org.springframework.stereotype.Component;

@Component
public class Computer {
    private int id;
    private int id_room;
    private int id_place;
    private String status;
    private String writeoff_date;

    public Computer() {
    }

    public Computer(int id, int id_room, int id_place, String status) {
        this.id = id;
        this.id_room = id_room;
        this.id_place = id_place;
        this.status = status;
        this.writeoff_date = null;
    }
    public Computer getbyid(int id_pc){
        for (Computer computer: ComputerStore.allcomputers){
            if (computer.getId()==id_pc) return computer;
        }
        return null;
    }

    public int getId_place() {
        return id_place;
    }

    public void setId_place(int id_place) {
        this.id_place = id_place;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRoom(int id_room) {
        this.id_room = id_room;
    }


    public void setWriteoff_date(String writeoff_date) {
        this.writeoff_date = writeoff_date;
    }


    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getRoom() {
        return id_room;
    }


    public String getWriteoff_date() {
        return writeoff_date;
    }


    public String getStatus() {
        return status;
    }
}
