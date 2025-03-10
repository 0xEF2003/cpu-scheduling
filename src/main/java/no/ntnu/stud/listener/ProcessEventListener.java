package no.ntnu.stud.listener;

import no.ntnu.stud.entity.Process;
import no.ntnu.stud.enums.ProcessEventEnum;

public abstract class ProcessEventListener {
    public abstract void update(ProcessEventEnum event, Process process);
}
