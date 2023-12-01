package com.backEnd.matheus.dto;

import com.backEnd.matheus.enuns.UserRole;

public record CadastroDTO(String login, String password, UserRole role) {
}
