package app;

import app.repository.*;
import app.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Repository getRepository(){
        return new FileRepository();
    }

    @Bean
    public ComputerService getComputerService(){
        return new FileComputerService();
    }

    @Bean
    public RoomService getRoomService(){return new FileRoomService();}


}
