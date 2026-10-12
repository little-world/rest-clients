package com.example.clients;

public record Todo(
    int userId,
    int id,
    String title,
    boolean completed) {}



