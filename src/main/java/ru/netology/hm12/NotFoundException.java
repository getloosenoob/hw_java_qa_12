package ru.netology.hm12;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String id) {
        super("Element with id: " + id + " not found");
    }
}