package net.engineeringdigest.journalApp.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.JournalEntryRepository;

@Component
public class JournalEntryService {//service section is always for Business logic
    @Autowired
    private JournalEntryRepository journalEntryRepository;//dependency injection

    @Autowired
    private UserService userService;
    
    
    @Transactional
    public void saveEntry(JournalEntry journalEntry, String userName){
    try{
        User user=userService.findByUserName(userName);
        journalEntry.setDate(LocalDateTime.now());
        JournalEntry saved=journalEntryRepository.save(journalEntry);//.save from the interface
        user.getJournalEntries().add(saved);
        //user.setUserName(null);//to avoid circular reference in JSON
        userService.saveEntry(user);
    }catch(Exception e)
    {
         System.out.println(e);
         throw new RuntimeException("An error occurred while saving the journal entry: ", e);
    }
}
     

    public void saveEntry(JournalEntry journalEntry)
    {
        journalEntryRepository.save(journalEntry);//.save from the interface
    }

    public List<JournalEntry>getAll()
    {
        return journalEntryRepository.findAll();//.findAll from the interface
    }


    public Optional<JournalEntry>findById(ObjectId id)//Optonal is a container object which may or may not contain a non-null value and we cannot directly return value from it
    {
        return journalEntryRepository.findById(id);
    }


    public void deleteById(ObjectId id, String userName)
    {
        User user=userService.findByUserName(userName);
        user.getJournalEntries().removeIf(x->x.getId().equals(id));
        userService.saveEntry(user);
        journalEntryRepository.deleteById(id);
    }


    //controller--->service--->repository 
}
