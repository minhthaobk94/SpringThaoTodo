package com.thaontm.demo.demoThaoTodo.model;

import lombok.AllArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "todo")
@AllArgsConstructor
public class Todo {

	public Todo() {
	}

	public Todo(String title, Category category) {
		this.title = title;
		this.category = category;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "cat_id")
    private Category category;

    @Column(name = "done")
	private boolean done;

    public Todo(String title) {
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}
}
