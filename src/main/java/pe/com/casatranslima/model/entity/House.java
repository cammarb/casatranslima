package pe.com.casatranslima.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "houses")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "house_name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "district")
    private String district;

    @Column(name = "admin")
    private String admin;

    @Column(name = "phone")
    private String phone;

    @Column(name = "spaces_available")
    private Long spaces_available;

    public House() {

    }

    public House(String name, String address, String district, String admin, String phone, Long spaces_available) {
        super();
        this.name = name;
        this.address = address;
        this.district = district;
        this.admin = admin;
        this.phone = phone;
        this.spaces_available = spaces_available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Long getSpaces_available() {
        return spaces_available;
    }
    public void setSpaces_available(Long spaces_available) {
        this.spaces_available = spaces_available;
    }
}
