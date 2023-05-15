package br.com.baldissystem.homeapp.model;

public class GenericMessages {

    private GenericMessages() {
        throw new IllegalStateException("Utility class");
    }

    public static final String SAVED = "Salvo com sucesso.";
    public static final String PERSON_NOT_FOUND = "Pessoa não encontrada.";
    public static final String WELCOME = "Bem vindo(a) ";
    public static final String WRONG_PASSWORD = "Senha incorreta.";
    public static final String USER_NOT_FOUND = "Usuário não encontrado.";

}
