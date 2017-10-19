package com.thaontm.demo.demoThaoTodo.model;

import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "category")
@AllArgsConstructor
public class Category {
	public Category() {
	}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "category")
    private Set<Todo> todos;

    public Category(String title) {
        this.title = title;
    }

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Todo> getTodos() {
		return todos;
	}

	public void setTodos(Set<Todo> todos) {
		this.todos = todos;
	}
}
