package app.domain;

import org.springframework.stereotype.Component;

@Component
public class Place {
    private int id_place;
    private String status;
    public Place(){
    }
    public Place(int id_place, String status){
        this.id_place = id_place;
        this.status = status;
    }
    public Place(int id_place){
        this.id_place=id_place;
    }

    public int getId_place() {
        return id_place;
    }

    public void setId_place(int id_place) {
        this.id_place = id_place;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
