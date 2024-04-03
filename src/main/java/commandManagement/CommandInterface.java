package commandManagement;

import javax.xml.bind.JAXBException;

public interface CommandInterface {
    void execute(String[] args) throws JAXBException;
}
