package com.example.clients;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class RestTemplateExample {

  static void main() {
    RestTemplate restTemplate = new RestTemplate();

    Todo todo = restTemplate.getForObject(
        "https://jsonplaceholder.typicode.com/todos/1",
        Todo.class);

    System.out.println(todo);


    Todo[] todos = restTemplate.getForObject(
        "https://jsonplaceholder.typicode.com/todos",
        Todo[].class);

    ResponseEntity<Todo[]> forEntity = restTemplate.getForEntity(
        "https://jsonplaceholder.typicode.com/todos",
        Todo[].class);

    Todo[] body = forEntity.getBody();



    Arrays.stream(todos).forEach(System.out::println);


    Todo newTodo = new Todo(1, 0, "Buy groceries", false);

    Todo created = restTemplate.postForObject(
        "https://jsonplaceholder.typicode.com/todos",
        newTodo,
        Todo.class);
  }
}
