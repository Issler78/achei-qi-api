package br.com.issler.acheiQI.database.models;

import br.com.issler.acheiQI.enums.itemCategoryEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "items")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemEntity {
    @GeneratedValue(strategy = GenerationType.UUID)
    @Id
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = true)
    private String description;

    @Column(nullable = false, unique = true, name = "image_url")
    private String imageUrl;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private itemCategoryEnum category;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;
}
