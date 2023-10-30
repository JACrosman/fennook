package com.fennook.fennookmono.nook.repository;

import com.fennook.fennookmono.nook.data.Nook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface NookRepository extends JpaRepository<Nook, UUID> {
    List<Nook> findAllByOwnerId(UUID ownerId);
}
