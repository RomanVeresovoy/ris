/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techsessionbean;

import javax.ejb.Local;

/**
 *
 * @author User-PC
 */
@Local
public interface TechSessionBeanLocal {
    String findPrice(String price1, String price2);
    String deleteTech(Integer id);
}
