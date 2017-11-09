package ca.irvine.cinema_world.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Reservation { // TODO
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int id;
    @Id
    public int user_id;
    @Id
    public int screen_id;
    public int numberOfReservation;
}