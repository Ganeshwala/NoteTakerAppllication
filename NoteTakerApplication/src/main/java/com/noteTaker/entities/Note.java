package com.noteTaker.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notes")
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int noteId;
	@Column(length = 100, name = "note_title")
	private String noteTitle;
	private String noteContent;
	private Date noteCreateDate;
	private Date noteUpdateDate;

	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	public String getNoteTitle() {
		return noteTitle;
	}

	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}

	public String getNoteContent() {
		return noteContent;
	}

	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}

	public Date getNoteCreateDate() {
		return noteCreateDate;
	}

	public void setNoteCreateDate(Date noteCreateDate) {
		this.noteCreateDate = noteCreateDate;
	}

	public Date getNoteUpdateDate() {
		return noteUpdateDate;
	}

	public void setNoteUpdateDate(Date noteUpdateDate) {
		this.noteUpdateDate = noteUpdateDate;
	}

	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Note(int noteId, String noteTitle, String noteContent, Date noteCreateDate, Date noteUpdateDate) {
		super();
		this.noteId = noteId;
		this.noteTitle = noteTitle;
		this.noteContent = noteContent;
		this.noteCreateDate = noteCreateDate;
		this.noteUpdateDate = noteUpdateDate;
	}

	@Override
	public String toString() {
		return "Note [noteId=" + noteId + ", noteTitle=" + noteTitle + ", noteContent=" + noteContent
				+ ", noteCreateDate=" + noteCreateDate + ", noteUpdateDate=" + noteUpdateDate + "]";
	}

}
