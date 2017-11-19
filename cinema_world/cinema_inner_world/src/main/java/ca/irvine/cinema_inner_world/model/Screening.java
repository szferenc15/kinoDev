package ca.irvine.cinema_inner_world.model;

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
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Screening {
    // START OF DEFAULT COLUMNS

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(columnDefinition = "BOOLEAN NOT NULL DEFAULT TRUE")
    private boolean twoDimensional;

    @Column(columnDefinition = "BOOLEAN NOT NULL DEFAULT FALSE")
    private boolean threeDimensional;

    @Column(columnDefinition = "BOOLEAN NOT NULL DEFAULT FALSE")
    private boolean fourDimensional;

    @Column(columnDefinition = "BOOLEAN NOT NULL DEFAULT FALSE")
    private boolean imax;

    @Column(columnDefinition = "VARCHAR2(30) NOT NULL")
    private String language;

    @Column(columnDefinition = "BOOLEAN NOT NULL DEFAULT TRUE")
    private boolean synchron;

    @Column(columnDefinition = "BOOLEAN NOT NULL DEFAULT FALSE")
    private boolean inscriptive;

    @Future
    private Date screenDay;

    @NotNull()
    private Time screenTime;

    // END OF DEFAULT COLUMNS

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cinema_id")
    private Cinema cinemaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room roomId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "film_title")
    private Film filmTitle;

    @OneToMany(
        mappedBy = "screeningId",
        cascade = CascadeType.ALL, 
        orphanRemoval = true
    )
    private List<Booking> bookings = new ArrayList<>();

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }
}