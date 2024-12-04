package edu.hugo.DAWI_CL2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmCategory {
    @Id
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;
    @Id
    private Integer categoryId;
    private Date lastUpdate;

}
