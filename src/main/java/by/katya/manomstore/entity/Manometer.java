package by.katya.manomstore.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Data
@Table (name  = "manometers")
@AllArgsConstructor
@NoArgsConstructor
public class Manometer implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private ManometerType manometerType;

    private String specification;

    private int price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ManometerType getManometerType() {
        return manometerType;
    }

    public void setManometerType(ManometerType manometerType) {
        this.manometerType = manometerType;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manometer manometer = (Manometer) o;
        return id == manometer.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}









//    String [] rangeOfSizes = {"40", "50", "63", "80", "100", "150", "160", "250"};
//    private int limit;
//    private List<String> caseDiameter = Arrays.asList(rangeOfSizes);
//    private int accuracyClass;
//    private TypeOfThread typeOfThread;
//    private Position position;
//    public enum TypeOfThread {
//        metric,
//        inch
//    }
//
//    public enum Position {
//        axial,
//        radial
//    }






