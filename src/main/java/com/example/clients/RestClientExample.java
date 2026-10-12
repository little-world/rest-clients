package com.example.clients;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

import java.util.List;

class RestClientExample {

  static void main() {
  RestClient restClient = RestClient.create();

  Todo todo = restClient.get()
      .uri("https://jsonplaceholder.typicode.com/todos/1")
      .retrieve()
      .body(Todo.class);


  List<Todo> todos = restClient.get()
      .uri("https://jsonplaceholder.typicode.com/todos")
      .retrieve()
      .body(new ParameterizedTypeReference<List<Todo>>() {
      });

todos.forEach(System.out::println);


  Todo newTodo = new Todo(1, 0, "Buy groceries", false);

  Todo created = restClient.post()
      .uri("https://jsonplaceholder.typicode.com/todos")
      .contentType(MediaType.APPLICATION_JSON)
      .body(newTodo)
      .retrieve()
      .body(Todo.class);
  }
}