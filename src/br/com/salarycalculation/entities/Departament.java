package br.com.salarycalculation.entities;

public class Departament {
    private String departmentName;

    public Departament(){

    }

    public Departament(String name) {
        this.departmentName = name;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setName(String name) {
        this.departmentName = name;
    }
}
