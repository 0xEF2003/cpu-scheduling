package no.ntnu.stud.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Process {

    private int id;
    private int arrivalTime;
    private int burstTime;
    private int priority;

    @Override
    public String toString() {
        return "Process{" +
            "id=" + id +
            ", arrivalTime=" + arrivalTime +
            ", burstTime=" + burstTime +
            ", priority=" + priority +
            '}';
    }
}
