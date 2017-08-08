/**
 * 
 */
package main;

/**
 * @author Cuong Ba
 *
 */
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import models.PageData;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Document doc;
        
        String url = "http://suckhoe.vnexpress.net/tin-tuc/suc-khoe/qua-tai-nguoi-sot-xuat-huyet-benh-vien-dung-hoi-truong-lam-phong-kham-3623883.html";
        PageData data = new PageData();
        
        try {
            doc = Jsoup.connect(url).get();
            String title = doc.title();
            String content = "";
            ArrayList<String> comments = new ArrayList<String>();
            
            // Get Intro text
            Elements short_intro = doc.select("#left_calculator .short_intro");
            for(Element e : short_intro) {
            		content = content + e.text();
            	}
            content = content + "\n\n";
            
            // Get Detail text in article
            Elements details = doc.select("#left_calculator p.Normal");
            for(Element e : details) {
            		content = content + e.text() + "\n";
            }
            
            // Get Comments
            Elements comment_items = doc.select("#list_comment div.comment_item p.content_more");
            for(Element comment_item : comment_items) {
		    		comments.add(comment_item.text());
		    }
            
            data.setTitle(title);
            data.setContent(content);
            data.setComments(comments);
            
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Title: \n" + data.getTitle());
        System.out.println("Content: \n" + data.getContent());
        if(data.getComments().size() > 0) {
        		for(String comment : data.getComments()) {
        			System.out.println("Comment: " + comment);
        		}
        }
	}

}
