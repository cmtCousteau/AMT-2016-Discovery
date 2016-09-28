/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.services;

import demo.model.Student;

/**
 *
 * @author marco
 */
public class StudentsManager {
    
    public Student getStudent(){
        return new Student("Simon", "Oulevay");
    }
}
