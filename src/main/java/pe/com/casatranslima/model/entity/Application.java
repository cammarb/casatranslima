package pe.com.casatranslima.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "applications")
public class Application {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "applicant_dni", nullable = false)
    private String applicant_dni;

    @Column(name = "applicant_name_dni", nullable = false)
    private String applicant_name_dni;

    @Column(name = "applicant_name", nullable = false)
    private String applicant_name;

    @Column(name = "applicant_age", nullable = false)
    private Integer applicant_age;

    @Column(name = "applicant_email", nullable = false)
    private String applicant_email;

    @Column(name = "applicant_phone", nullable = false)
    private String applicant_phone;

    @Column(name = "status", nullable = true)
    private String status;

    @ManyToOne
	@JoinColumn(name = "house_id")
	private House house;

    public House getHouse() {
        return house;
    }



    public void setHouse(House house) {
        this.house = house;
    }

    @Column(name = "house_name")
	private String house_name;

    public Application() {
    }

    

    public Application(String applicant_dni, String applicant_name_dni, String applicant_name, Integer applicant_age,
            String applicant_email, String applicant_phone, String status, String house_name) {
                super();
        this.applicant_dni = applicant_dni;
        this.applicant_name_dni = applicant_name_dni;
        this.applicant_name = applicant_name;
        this.applicant_age = applicant_age;
        this.applicant_email = applicant_email;
        this.applicant_phone = applicant_phone;
        this.status = status;
        this.house_name = house_name;
    }

    public String getApplicant_name_dni() {
        return applicant_name_dni;
    }

    public void setApplicant_name_dni(String applicant_name_dni) {
        this.applicant_name_dni = applicant_name_dni;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApplicant_name() {
        return applicant_name;
    }

    public void setApplicant_name(String applicant_name) {
        this.applicant_name = applicant_name;
    }
    public String getApplicant_dni() {
        return applicant_dni;
    }

    public void setApplicant_dni(String applicant_dni) {
        this.applicant_dni = applicant_dni;
    }

    public Integer getApplicant_age() {
        return applicant_age;
    }

    public void setApplicant_age(Integer applicant_age) {
        this.applicant_age = applicant_age;
    }

    public String getApplicant_email() {
        return applicant_email;
    }

    public void setApplicant_email(String applicant_email) {
        this.applicant_email = applicant_email;
    }

    public String getApplicant_phone() {
        return applicant_phone;
    }

    public void setApplicant_phone(String applicant_phone) {
        this.applicant_phone = applicant_phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getHouse_name() {
        return house_name;
    }

    public void setHouse_name(String house_name) {
        this.house_name = house_name;
    }

    public void setHouse_name(House house) {
        house_name = house.getName();
    }
}
