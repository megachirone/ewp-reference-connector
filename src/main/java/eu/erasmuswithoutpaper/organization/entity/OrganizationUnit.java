
package eu.erasmuswithoutpaper.organization.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({
    @NamedQuery(name = OrganizationUnit.findByOrganizationUnitCode, query = "SELECT o FROM OrganizationUnit o WHERE o.organizationUnitCode = :organizationUnitCode")
})
public class OrganizationUnit implements Serializable{
    
    private static final String PREFIX = "eu.erasmuswithoutpaper.organization.entity.OrganizationUnit.";
    public static final String findByOrganizationUnitCode = PREFIX + "byOrganizationUnitCode";

    @Id
    @GeneratedValue(generator="system-uuid")
    String id;
    
    private String organizationUnitCode;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval=true)
    @JoinTable(name = "OU_OTHER_ID")
    private List<IdentificationItem> otherId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval=true)
    @JoinTable(name = "ORGANIZATION_UNIT_NAME")
    private List<LanguageItem> name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval=true)
    @JoinTable(name = "ORG_UNIT_ORG_UNIT")
    private List<OrganizationUnit> organizationUnits;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "STREET_ADDRESS")
    private FlexibleAddress streetAddress;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "MAILING_ADDRESS")
    private FlexibleAddress mailingAddress;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval=true)
    @JoinTable(name = "OU_WEBSITE_URL")
    private List<LanguageItem> websiteUrl;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval=true)
    @JoinTable(name = "OU_FACTSHEET_URL")
    private List<LanguageItem> factsheetUrl;
    
    private String logoUrl;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getOrganizationUnitCode() {
        return organizationUnitCode;
    }

    public void setOrganizationUnitCode(String organizationUnitCode) {
        this.organizationUnitCode = organizationUnitCode;
    }

    public List<IdentificationItem> getOtherId() {
        return otherId;
    }

    public void setOtherId(List<IdentificationItem> otherId) {
        this.otherId = otherId;
    }

    public List<LanguageItem> getName() {
        return name;
    }

    public void setName(List<LanguageItem> name) {
        this.name = name;
    }

    public List<OrganizationUnit> getOrganizationUnits() {
        return organizationUnits;
    }

    public void setOrganizationUnits(List<OrganizationUnit> organizationUnits) {
        this.organizationUnits = organizationUnits;
    }

    public FlexibleAddress getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(FlexibleAddress streetAddress) {
        this.streetAddress = streetAddress;
    }

    public FlexibleAddress getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(FlexibleAddress mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public List<LanguageItem> getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(List<LanguageItem> websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public List<LanguageItem> getFactsheetUrl() {
        return factsheetUrl;
    }

    public void setFactsheetUrl(List<LanguageItem> factsheetUrl) {
        this.factsheetUrl = factsheetUrl;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrganizationUnit other = (OrganizationUnit) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
