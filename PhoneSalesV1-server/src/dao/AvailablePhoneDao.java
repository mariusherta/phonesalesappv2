/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.AvailablePhone;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


public class AvailablePhoneDao {
    EntityManager em;
    
    public AvailablePhoneDao (EntityManager em){
        this.em = em;
    }
    
    public List<AvailablePhone> getAllAvailablePhones(){
        String sql = "SELECT a FROM availablephone a";
        TypedQuery<AvailablePhone> query = em.createQuery(sql, AvailablePhone.class);
        
        List<AvailablePhone> availablePhones = query.getResultList();
        return availablePhones;
    }
    
    public boolean addNewPhoneModel(AvailablePhone availablePhone){
        boolean rez = false;
        List<AvailablePhone> availablePhones = getAllAvailablePhones();
        if(availablePhones.isEmpty()){
            em.persist(availablePhone);
            rez = true;
        }else {
            for(AvailablePhone availablePhone1 : availablePhones){
                if(availablePhone1.getMaker().equals(availablePhone.getMaker()) && availablePhone1.getModel().equals(availablePhone.getModel())){
                    return rez;
                }else{
                    em.persist(availablePhone);
                    rez = true;
                }
            }
        }
        
        return rez;
    }
    
}
