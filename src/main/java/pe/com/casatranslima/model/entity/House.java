package pe.com.casatranslima.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
    private Integer spaces_available;

    @OneToMany(mappedBy = "house", cascade = CascadeType.REMOVE)
	private List<Application> applications;

    public House() {

    }

    public House(String name, String address, String district, String admin, String phone, Integer spaces_available) {
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
    public Integer getSpaces_available() {
        return spaces_available;
    }
    public void setSpaces_available(Integer spaces_available) {
        this.spaces_available = spaces_available;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		House other = (House) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
