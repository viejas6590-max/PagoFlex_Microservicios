package com.pagoflex.usuarios.client;

import com.pagoflex.usuarios.dto.RolDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class RolClient {

    private final WebClient webClient;

    public RolClient(
            @Value("${roles.service.url}") String rolesUrl) {

        this.webClient = WebClient.builder()
                .baseUrl(rolesUrl)
                .build();
    }

    public List<RolDto> listar() {

        return webClient.get()
                .uri("/api/roles")
                .retrieve()
                .bodyToFlux(RolDto.class)
                .collectList()
                .block();
    }

    public RolDto obtener(Long id) {

        return webClient.get()
                .uri("/api/roles/{id}", id)
                .retrieve()
                .bodyToMono(RolDto.class)
                .block();
    }
}
