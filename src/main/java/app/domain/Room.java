package app.domain;

import app.store.RoomStore;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

@Component
public class Room {
    private int id;
    private String last_inventory_date;
    private String next_inventory_date;
    private int count_equipment = 0;
    ArrayList<Computer> computers_in_room = new ArrayList<Computer>();
    ArrayList<Computer> writeoffpc_in_room = new ArrayList<Computer>();
    ArrayList<Place> places_in_room = new ArrayList<>();

    public Room(int id, String last_inventory_date, String next_inventory_date) {
        this.id = id;
        this.last_inventory_date = last_inventory_date;
        this.next_inventory_date = next_inventory_date;
    }

    public Room() {
    }

    public ArrayList<Computer> getComputersInRoom(){
        return computers_in_room;
    }
    public ArrayList<Computer> getWriteOffPCInRoom(){
        return writeoffpc_in_room;
    }


    public ArrayList<Place> getPlaces_in_room() {
        return places_in_room;
    }
    public Room getbyid(int id_room){
        for (Room rm: RoomStore.allrooms){
            if (rm.getId()==id_room) return rm;
        }
        return null;
    }

    public Place getPlace(int id_place){
        for(Place place:places_in_room){
            if (place.getId_place()==id_place)
                return place;
        }
        return null;
    }

    public int getLastIdPlace(){
        return getPlaces_in_room().get(getPlaces_in_room().size()-1).getId_place();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLast_inventory_date() {
        return last_inventory_date;
    }

    public void setLast_inventory_date(String last_inventory_date) {
        this.last_inventory_date = last_inventory_date;
    }

    public String getNext_inventory_date() {
        return next_inventory_date;
    }

    public void setNext_inventory_date(String next_inventory_date) {
        this.next_inventory_date = next_inventory_date;
    }

    public int getCount_equipment() {
        return count_equipment;
    }

    public void setCount_equipment(int count_equipment) {
        this.count_equipment = count_equipment;
    }
}
