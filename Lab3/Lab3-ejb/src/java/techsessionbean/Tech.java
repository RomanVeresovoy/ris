/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techsessionbean;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User-PC
 */
@Entity
@Table(name = "TECH")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tech.findAll", query = "SELECT t FROM Tech t")
    , @NamedQuery(name = "Tech.findById", query = "SELECT t FROM Tech t WHERE t.id = :id")
    , @NamedQuery(name = "Tech.findByCategoty", query = "SELECT t FROM Tech t WHERE t.categoty = :categoty")
    , @NamedQuery(name = "Tech.findByModel", query = "SELECT t FROM Tech t WHERE t.model = :model")
    , @NamedQuery(name = "Tech.findByPrice", query = "SELECT t FROM Tech t WHERE t.price = :price")
    , @NamedQuery(name = "Tech.findByNal", query = "SELECT t FROM Tech t WHERE t.nal = :nal")})
public class Tech implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 45)
    @Column(name = "CATEGOTY")
    private String categoty;
    @Size(max = 45)
    @Column(name = "MODEL")
    private String model;
    @Column(name = "PRICE")
    private Integer price;
    @Size(max = 45)
    @Column(name = "NAL")
    private String nal;

    public Tech() {
    }

    public Tech(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoty() {
        return categoty;
    }

    public void setCategoty(String categoty) {
        this.categoty = categoty;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getNal() {
        return nal;
    }

    public void setNal(String nal) {
        this.nal = nal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tech)) {
            return false;
        }
        Tech other = (Tech) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "techsessionbean.Tech[ id=" + id + " ]";
    }
    
}
