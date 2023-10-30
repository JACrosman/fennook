package com.fennook.fennookmono.nook.service;

import com.fennook.common.errors.ResourceNotFoundException;
import com.fennook.fennookmono.nook.data.Nook;
import com.fennook.fennookmono.nook.dto.SaveNookRequest;
import com.fennook.fennookmono.nook.repository.NookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NookServiceImpl implements NookService {
    private final NookRepository nookRepository;

    @Override
    public List<Nook> getAll(UUID userId) {
        return nookRepository.findAllByOwnerId(userId);
    }

    @Override
    public Nook getById(UUID id) {
        return nookRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public Nook save(SaveNookRequest nookRequest, UUID userId) {
        Nook nook = nookRequest.getId() != null ? nookRepository.findById(nookRequest.getId()).orElse(new Nook(userId)) : new Nook(userId);

        nook.setName(nookRequest.getName());
        nook.setDescription((nookRequest.getDescription()));

        return nookRepository.save(nook);
    }

    @Override
    public void delete(UUID id) {
        nookRepository.deleteById(id);
    }
}
