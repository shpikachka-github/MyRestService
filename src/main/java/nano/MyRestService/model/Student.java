package nano.MyRestService.model;

import java.time.LocalDate;

public class Student {

    private Long id;
    private String fullName;
    private LocalDate dateOfBirth;

    public Student(Long id, String fullName, LocalDate dateOfBirth) {
        super();
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBalance() {
        return dateOfBirth;
    }

    public void setBalance(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
