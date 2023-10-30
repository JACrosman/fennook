package com.fennook.fennookmono.nook.controller;

import com.fennook.fennookmono.nook.data.Nook;
import com.fennook.fennookmono.nook.dto.SaveNookRequest;
import com.fennook.fennookmono.nook.service.NookService;
import com.fennook.fennookmono.user.data.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/api/v1/nooks")
@RequiredArgsConstructor
public class NookController {
    private final NookService nookService;

    @GetMapping()
    public ResponseEntity<List<Nook>> getAll(@AuthenticationPrincipal User userDetails) {
        return ResponseEntity.ok(nookService.getAll(userDetails.getId()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nook> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(nookService.getById(id));
    }

    @PostMapping()
    public ResponseEntity<Nook> create(@Valid @RequestBody SaveNookRequest nook, @AuthenticationPrincipal User userDetails) {
        return ResponseEntity.ok(nookService.save(nook, userDetails.getId()));
    }

    @PutMapping()
    public ResponseEntity<Nook> update(@Valid @RequestBody SaveNookRequest nook, @AuthenticationPrincipal User userDetails) {
        return ResponseEntity.ok(nookService.save(nook, userDetails.getId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        nookService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
