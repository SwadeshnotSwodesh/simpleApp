package net.engineeringdigest.journalApp.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
 
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;

//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/journal")
@Document(collection = "users")
@Data
public class User {

    @Id
    private ObjectId id;//to the MongoRepository interface
    
@Indexed(unique=true)
@NonNull
    private String userName;
    

@NonNull
    private String password;


    


    @DBRef//creating a reference to the JournalEntry class...works just like a foreign key in SQL
    private List<JournalEntry>journalEntries=new ArrayList<>();//creating a list of journal entries for each user

   

     

    
     
    
}

