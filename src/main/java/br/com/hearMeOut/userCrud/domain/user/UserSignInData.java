package br.com.hearMeOut.userCrud.domain.user;

import br.com.hearMeOut.userCrud.domain.address.AdressSignInData;

public record UserSignInData(
        String name,
        String cpf,
        String email,
        String password,
        AdressSignInData address,
        Gender gender


) {
}
