package co.edu.poli.ces3.demo.dao;

import java.util.Date;

public class Student {
    //1. definir variables
    //2. encapsulamiento, modificador de acceso (public, proivate)
    //3. get y set -> me permiten obtener los valores de las variables o modificarlos
    //4. crear constructor para inicializar el objeto

    private Integer id;
    private String name;
    private String lastName;
    private Date birthDay;
    private String mail;
    private int level;
    private boolean isMarried;

    public Student() {}

    //4
    public Student(String name, String lastName, Date birthDay, String mail, int level, boolean isMarried) {
        this.name = name;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.mail = mail;
        this.level = level;
        this.isMarried = isMarried;
    }

    public Student(Integer id, String name, String lastName, Date birthDay, String mail, int level, boolean isMarried) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.mail = mail;
        this.level = level;
        this.isMarried = isMarried;
    }

    //ser public, tipo de dato de la variable, nombre del metodo
    public Integer getId() {
        return id;
    }

    //asignador -> no va a devolver nada(void)
    public void setId(Integer id) {
      this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean getIsMarried() {
        return isMarried;
    }

    public void setIsMarried(boolean married) {
        isMarried = married;
    }

    @Override
    public String toString() {
        return this.name + " " + this.lastName;
        //return super.toString();
    }
}
