package model;

/**
 * Represents a client.
 *
 * @author renantdesouza.
 * @since 03/08/2016.
 */
public class Client implements Model {

    private String id;
    private String name;
    private String companyName;
    private String cnpj;
    private String email;
    private String socialApplication;
    private Integer telephone;
    private Integer mobilephone;

    public Client() {
    }

    @Override
    public String getId() {
        return null;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSocialApplication() {
        return socialApplication;
    }

    public void setSocialApplication(String socialApplication) {
        this.socialApplication = socialApplication;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public Integer getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(Integer mobilephone) {
        this.mobilephone = mobilephone;
    }

}
