package commandManagement;


import com.fasterxml.jackson.core.JsonProcessingException;

public interface CommandInterface {
    void execute(String[] args) throws JsonProcessingException;
}
