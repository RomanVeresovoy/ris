/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techsessionbean;

import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author User-PC
 */
@Stateless
public class TechSessionBean implements TechSessionBeanLocal {

    @PersistenceContext(unitName = "Lab3-ejbPU")
    private EntityManager em;

    @Override
    public String findPrice(String price1, String price2) {
        String returnval = "";
        Integer pr1 = new Integer(price1);
        Integer pr2 = new Integer(price2);
        int input = pr1.intValue();
        int input1 = pr2.intValue();
        ArrayList<Tech> list = new ArrayList();
        list.add(em.find(Tech.class, 1));
        list.add(em.find(Tech.class, 2));
        list.add(em.find(Tech.class, 3));

        for (Tech o : list) {
            System.out.println("look----------------------------------------------------  " + o.getModel() + "  " + o.getPrice());
            System.out.println(list.toString());
            if (o.getPrice() >= input && o.getPrice() <= input1) {
                returnval += "Цена: " + o.getPrice() + " Модель " + o.getModel() + " Категория " + o.getCategoty();
            }
        }
        return returnval;
    }
    
    @Override
    public String deleteTech(Integer id) {
        Query query = em.createNativeQuery("DELETE FROM Tech WHERE id=" + id);
        int number = query.executeUpdate();
        if (number == 0) {
            return "Нет такого ИД";
        } else {
            return "Успех";
        }
    }
}
