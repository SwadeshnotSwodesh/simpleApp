package net.engineeringdigest.journalApp.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.repository.JournalEntryRepository;

@Component
public class JournalEntryService {//service section is always for Business logic
    @Autowired
    private JournalEntryRepository journalEntryRepository;//dependency injection
    
    
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


    public void deleteById(ObjectId id)
    {
        journalEntryRepository.deleteById(id);
    }


    //controller--->service--->repository 
}
