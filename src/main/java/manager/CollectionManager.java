package manager;

import lombok.Getter;
import lombok.Setter;
import models.Address;
import models.Organization;

import java.util.Date;
import java.util.List;
import java.util.TreeSet;

@Getter
@Setter
public class CollectionManager {
    private TreeSet<Organization> collection = new TreeSet<Organization>();
    public static final Date initializationTime = new Date();

    public void add(Organization o) {
        collection.add(o);
    }

    // update by id
    public void update(long id, Organization o) {
        collection.stream().filter(organization -> organization.getId() == id).forEach(organization -> {
            organization.setName(o.getName());
            organization.setCoordinates(o.getCoordinates());
            organization.setCreationDate(o.getCreationDate());
            organization.setAnnualTurnover(o.getAnnualTurnover());
            organization.setFullName(o.getFullName());
            organization.setEmployeesCount(o.getEmployeesCount());
            organization.setType(o.getType());
            organization.setPostalAddress(o.getPostalAddress());
        });
    }

    public void removeById(long id) {
        collection.removeIf(o -> o.getId() == id);
    }

    public void clear() {
        collection.clear();
    }

    public String minByFullName() {
        return collection.stream().map(Organization::getFullName).min(String::compareTo).toString();
    }

    public void addIfMin(Organization o) {
        if (collection.isEmpty() || collection.first().compareTo(o) > 0) {
            collection.add(o);
        }
    }

    public List<Organization> filterContainsName(String name) {
        return collection.stream().filter(o -> o.getName().contains(name)).toList();
    }

    public List<Organization> filterLessThanPostalAddress(Address postalAddress) {
        return collection.stream().filter(o -> o.getPostalAddress().compareTo(postalAddress) < 0).toList();
    }

    public void removeGreater(Organization o) {
        collection.removeIf(organization -> organization.compareTo(o) > 0);
    }

    public void removeLower(Organization o) {
        collection.removeIf(organization -> organization.compareTo(o) < 0);
    }

    public Organization getById(long id) {
        return collection.stream().filter(o -> o.getId() == id).findFirst().orElse(null);
    }
}
