package br.com.authentication.domain.model;

public interface CryptographyService {
    String encrypt(String value);
    String decrypt(String value);
}
