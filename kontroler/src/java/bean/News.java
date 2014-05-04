/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 * Holding single news
 * @author Maciej
 */
public class News {
    int id;
    String author = "Test";
    String date = "1990-03-03";
    String kategoria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    String content;
    String title;
    
    public News(String lcontent, String lauthor, String ltitle, String ldata){
        content = lcontent;
        author  = lauthor;
        title = lauthor;
        date = ldata;
    }
    public News(){
        
    }
    public String getKategoria() {
        return kategoria;
    }
    
    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }
  

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
}
