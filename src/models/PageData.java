/**
 * 
 */
package models;

import java.util.ArrayList;

/**
 * @author Cuong Ba
 *
 */
public class PageData {
	private String title;
	private String content;
	private ArrayList<String> comments;

	public PageData(String title, String content, ArrayList<String> comments) {
		super();
		this.title = title;
		this.content = content;
		this.comments = comments;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public PageData() {
		super();
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public ArrayList<String> getComments() {
		return comments;
	}
	public void setComments(ArrayList<String> comments) {
		this.comments = comments;
	}
	
	
	
}
