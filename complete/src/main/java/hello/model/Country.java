package hello.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the countries database table.
 * 
 */
@Entity
@JsonIgnoreProperties({"region","locations"})
@Table(name="countries")
@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;
	private String countryId;
	private String countryName;
	private BigDecimal regionId;
	private Region region;
	private List<Location> locations;

	public Country() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="COUNTRY_ID")
	public String getCountryId() {
		return this.countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}


	@Column(name="COUNTRY_NAME")
	public String getCountryName() {
		return this.countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}


	@Column(name="REGION_ID")
	public BigDecimal getRegionId() {
		return this.regionId;
	}

	public void setRegionId(BigDecimal regionId) {
		this.regionId = regionId;
	}


	//bi-directional many-to-one association to Region
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="REGION_ID",insertable = false, updatable = false)
	public Region getRegion() {
		return this.region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}


	//bi-directional many-to-one association to Location
	@OneToMany(mappedBy="country")
	public List<Location> getLocations() {
		return this.locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	public Location addLocation(Location location) {
		getLocations().add(location);
		location.setCountry(this);

		return location;
	}

	public Location removeLocation(Location location) {
		getLocations().remove(location);
		location.setCountry(null);

		return location;
	}

}