package sample;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.time.LocalDate;

public class Task {

    private final StringProperty title;
    private final StringProperty text;
    private final ObjectProperty<LocalDate> date;
    private final StringProperty priority;


    public Task() {
        this(null, null, null );
    }

    public Task(String title, String text,String priority) {
        this.title = new SimpleStringProperty(title);
        this.text = new SimpleStringProperty(text);
        this.date = new SimpleObjectProperty<LocalDate>();
        this.priority = new SimpleStringProperty(priority);
    }

    public String getPriority() {

        return priority.get();
    }

    public void setPriority(String priority) {
        this.priority.set(priority);
    }

    public StringProperty firstTableProperty() {
        return title;
    }

    public String getTitle() {
        return title.get();
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public LocalDate getDate() {
        return date.get();
    }

    public void setDate(LocalDate date) {
        this.date.set(date);
    }

    public String getText() {
        return text.get();
    }

    public void setText(String text) {
        this.text.set(text);
    }


}
