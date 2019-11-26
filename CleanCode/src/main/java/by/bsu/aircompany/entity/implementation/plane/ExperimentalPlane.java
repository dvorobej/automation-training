package by.bsu.aircompany.entity.implementation.plane;

import by.bsu.aircompany.enums.ClassificationLevel;
import by.bsu.aircompany.entity.Plane;
import by.bsu.aircompany.enums.ExperimentalType;

import java.util.Objects;

public class ExperimentalPlane extends Plane {

    private ExperimentalType type;
    private ClassificationLevel classificationLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalType type, ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.type = type;
        this.classificationLevel = classificationLevel;
    }

    public ClassificationLevel getClassificationLevel() {
        return classificationLevel;
    }

    public void setClassificationLevel(ClassificationLevel classificationLevel) {
        this.classificationLevel = classificationLevel;
    }

    public ExperimentalType getType() {
        return type;
    }

    public void setType(ExperimentalType experimentalType) {
        this.type = experimentalType;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", type=" + type +
                        ", classificationLevel=" + classificationLevel +
                        '}');
    }
}
