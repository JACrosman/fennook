package com.fennook.fennookmono.nook.data;

import com.fennook.common.Auditable;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "nooks")
@EntityListeners(AuditingEntityListener.class)
public class Nook extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String description;
    private String imageId;
    private UUID ownerId;

    public Nook(UUID ownerId) {
        this.ownerId = ownerId;
    }
}
