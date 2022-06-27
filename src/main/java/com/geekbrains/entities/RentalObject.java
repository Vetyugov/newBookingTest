package com.geekbrains.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "rental_objects")
@Data
@NoArgsConstructor
public class RentalObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "address")
    private String address;

    @Column(name = "numbers_of_rooms")
    private Integer numbersOfRooms;

    @Column(name = "square_meters")
    private Integer squareMeters;

    @Column(name = "price_per_night")
    private BigDecimal pricePerNight;

    @Column(name = "is_free")
    private Boolean isFree;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public RentalObject(Long id, String title, BigDecimal pricePerNight, Boolean isFree) {
        this.id = id;
        this.title = title;
        this.pricePerNight = pricePerNight;
        this.isFree = isFree;
    }
}
