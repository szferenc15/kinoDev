package ca.irvine.cinema_world.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Time;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Screening {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema_name", referencedColumnName = "name")
    public Cinema cinemaName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    public Room roomId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "film_title")
    public Film filmTitle;

    @OneToMany(
        mappedBy = "screeningId",
        cascade = CascadeType.ALL, 
        orphanRemoval = true
    )
    public List<Booking> bookings = new ArrayList<>();

    public boolean twoDimensional;
    public boolean threeDimensional;
    public boolean fourDimensional;
    public boolean imax;
    public String language;
    public boolean inscriptive;
    public boolean synchron;

    public Date screenDay;
    public Time screenTime;
}