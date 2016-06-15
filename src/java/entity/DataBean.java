package entity;

import javax.ejb.TransactionAttribute;
import static javax.ejb.TransactionAttributeType.REQUIRES_NEW;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.SystemException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 *
 * @author David Jennings
 */
@ManagedBean(name = "formbean")
@RequestScoped
public class DataBean {

    /**
     * Creates a new instance of DataBean
     */
    public DataBean() {
        
    }

    DataBean(String firstName,
            String middleName,
            String lastName,
            String birthDay,
            String birthMonth,
            String birthYear,
            String unit,
            String street,
            String city,
            String state,
            String zipCode) {

        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.unit = unit;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
    @PersistenceContext
    EntityManager em ;
    
   

    private String result;
    private String firstName;
    private String middleName;
    private String lastName;
    private String birthDay;
    private String birthMonth;
    private String birthYear;
    private String unit;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    
    @TransactionAttribute(REQUIRES_NEW)
    public void persist() throws SystemException {
     
        em.persist(new DataBean(this.firstName, this.middleName, this.lastName, this.birthDay, this.birthMonth, this.birthYear, this.unit, this.street, this.city, this.state, this.zipCode));
        


    }

    /**
     * @return the firstName
     */
    public String getFirstName() {

        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the middleName
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * @param middleName the middleName to set
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the birthDay
     */
    public String getBirthDay() {
        return birthDay;
    }

    /**
     * @param birthDay the birthDay to set
     */
    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    /**
     * @return the birthMonth
     */
    public String getBirthMonth() {
        return birthMonth;
    }

    /**
     * @param birthMonth the birthMonth to set
     */
    public void setBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
    }

    /**
     * @return the birthYear
     */
    public String getBirthYear() {
        return birthYear;
    }

    /**
     * @param birthYear the birthYear to set
     */
    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    /**
     * @return the unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * @param unit the unit to set
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * @param zipCode the zipCode to set
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * @return the result
     */
    public String getResult() {
        return result;
    }

    /**
     */
    public void setResult() {

        WebTarget webTarget;
        Client client;
        String BASE_URI = "http://localhost:8080/DataForm/webresources/";
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("generic");
        WebTarget resource = webTarget;
        result = resource.request(javax.ws.rs.core.MediaType.TEXT_HTML).get(String.class);

    }

}
