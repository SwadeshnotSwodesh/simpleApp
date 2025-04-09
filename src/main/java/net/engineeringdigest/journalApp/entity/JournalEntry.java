package net.engineeringdigest.journalApp.entity;

import java.time.LocalDateTime;
 

import org.bson.types.ObjectId;
 
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;
import lombok.NoArgsConstructor;

//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/journal")
@Document(collection = "journal_entries")
@Data
@NoArgsConstructor
public class JournalEntry {

    @Id
    private ObjectId id;//to the MongoRepository interface
    
@NonNull
    private String title;
    


    private String content;


    private LocalDateTime date; //from the Java 8 Date and Time API

   

     

    
     
    
}
