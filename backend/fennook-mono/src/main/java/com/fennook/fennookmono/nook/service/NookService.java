package com.fennook.fennookmono.nook.service;

import com.fennook.fennookmono.nook.data.Nook;
import com.fennook.fennookmono.nook.dto.SaveNookRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface NookService {
    List<Nook> getAll(UUID userId);

    Nook getById(UUID id);

    Nook save(SaveNookRequest nook, UUID userId);

    void delete(UUID id);
}
